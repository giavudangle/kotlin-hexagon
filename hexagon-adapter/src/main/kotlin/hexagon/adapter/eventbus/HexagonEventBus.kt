package hexagon.adapter.eventbus

import hexagon.adapter.event.BaseIntegrationEvent
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.CopyOnWriteArraySet
import java.util.function.Consumer
import org.axonframework.common.Registration
import org.axonframework.eventhandling.EventMessage
import org.axonframework.eventhandling.SimpleEventBus
import org.axonframework.messaging.unitofwork.CurrentUnitOfWork
import org.axonframework.messaging.unitofwork.UnitOfWork
import org.slf4j.Logger
import org.slf4j.LoggerFactory

open class HexagonEventBus(
  private val integrationEventPublisher: IntegrationEventPublisherInterface
) : SimpleEventBus(builder()) {
  companion object {
    val logger: Logger = LoggerFactory.getLogger(HexagonEventBus.javaClass.name)
  }

  private var eventProcessors: MutableSet<Consumer<List<EventMessage<*>>>> = CopyOnWriteArraySet()
  private val eventIds: ConcurrentHashMap<String, Boolean> = ConcurrentHashMap()

  override fun prepareCommit(events: MutableList<out EventMessage<*>>) {
    logger.info("In prepare-commit phase of the current unit of work")
    val domainEvents: List<EventMessage<*>> =
      events.filterIsInstance<DomainEventMessage<*>>().toList()
    if (domainEvents.isNotEmpty()) {
      eventProcessors.forEach { it.accept(domainEvents) }
    }
  }

  override fun afterCommit(events: MutableList<out EventMessage<*>>) {
    logger.info("In after-commit phase of the current unit of work")
    val integrationEvents: List<EventMessage<*>> =
      events.filterIsInstance<IntegrationEventMessage<*>>().toList()
    if (integrationEvents.isNotEmpty()) {
      for (eventMessage: EventMessage<*> in events) {
        if (isCurrentUnitOfWorkStarted() && isRootCurrentUnitOfWork()) {
          val unitOfWork: UnitOfWork<*> = CurrentUnitOfWork.get()
          unitOfWork.onCleanup { eventIds.remove(eventMessage.identifier) }
          if (eventIds.containsKey(eventMessage.identifier)) continue

          integrationEventPublisher.publish(eventMessage.payload as BaseIntegrationEvent)
          eventIds[eventMessage.identifier] = true
        }
      }
    }
  }

  override fun subscribe(eventProcessor: Consumer<List<EventMessage<*>>>): Registration {
    if (eventProcessors.add(eventProcessor)) {
      if (logger.isDebugEnabled)
        logger.debug("EventProcessor {} subscribed successfully", eventProcessor)
    } else {
      logger.info("EventProcessor {} not added because it was already subscribed", eventProcessor)
    }

    return Registration {
      if (eventProcessors.remove(eventProcessor)) {
        logger.debug("EventProcessor {} unsubscribed successfully", eventProcessor)
        return@Registration true
      } else {
        logger.info(
          "EventProcessor {} not removed because it was already unsubscribed",
          eventProcessor
        )
        return@Registration false
      }
    }
  }

  private fun isCurrentUnitOfWorkStarted(): Boolean {
    return CurrentUnitOfWork.isStarted()
  }

  private fun isRootCurrentUnitOfWork(): Boolean {
    return CurrentUnitOfWork.get().isRoot
  }
}
