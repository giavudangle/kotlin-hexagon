package com.vudang.kotlin.hexagon.adapter.config

import org.axonframework.commandhandling.SimpleCommandBus
import org.axonframework.commandhandling.gateway.DefaultCommandGateway

class AxonCommandBusGateway(simpleCommandBus: SimpleCommandBus) :
  DefaultCommandGateway(DefaultCommandGateway.builder().commandBus(simpleCommandBus))
