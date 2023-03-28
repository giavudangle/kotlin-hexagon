package com.vudang.kotlin.hexagon.adapter.config

import org.axonframework.queryhandling.DefaultQueryGateway
import org.axonframework.queryhandling.SimpleQueryBus
import org.springframework.stereotype.Component

@Component
class AxonQueryBusGateway(simpleQueryBus: SimpleQueryBus) :
  DefaultQueryGateway(builder().queryBus(simpleQueryBus))
