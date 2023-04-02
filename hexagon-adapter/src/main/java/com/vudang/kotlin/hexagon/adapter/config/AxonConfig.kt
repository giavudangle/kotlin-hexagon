package com.vudang.kotlin.hexagon.adapter.config

import org.axonframework.common.jpa.EntityManagerProvider
import org.axonframework.common.transaction.TransactionManager
import org.axonframework.eventsourcing.eventstore.EventStore
import org.axonframework.eventsourcing.eventstore.jpa.JpaEventStorageEngine
import org.axonframework.serialization.Serializer
import org.axonframework.serialization.json.JacksonSerializer
import org.axonframework.serialization.upcasting.event.SingleEventUpcaster
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import java.sql.SQLException
import javax.sql.DataSource


@Configuration
open class AxonConfig {

  @Bean
  @Primary
  open fun jacksonSerializer(): Serializer {
    return JacksonSerializer.defaultSerializer()
  }

  @Bean
  @Throws(SQLException::class)
  open fun eventStorageEngine(
    eventSerializer: Serializer?,
    snapshotSerializer: Serializer?,
    dataSource: DataSource?,
    upCaster: SingleEventUpcaster?,
    entityManagerProvider: EntityManagerProvider?,
    transactionManager: TransactionManager?
  ): JpaEventStorageEngine? {
    return JpaEventStorageEngine.builder()
      .eventSerializer(eventSerializer)
      .snapshotSerializer(snapshotSerializer)
      .dataSource(dataSource)
      .entityManagerProvider(entityManagerProvider)
      .transactionManager(transactionManager)
      .upcasterChain(upCaster)
      .build()
  }
}
