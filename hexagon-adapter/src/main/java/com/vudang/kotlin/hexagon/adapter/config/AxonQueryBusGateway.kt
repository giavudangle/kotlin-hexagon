package com.vudang.kotlin.hexagon.adapter.config

import org.axonframework.queryhandling.DefaultQueryGateway
import org.axonframework.queryhandling.SimpleQueryBus

class AxonQueryBusGateway(simpleQueryBus: SimpleQueryBus) :
  DefaultQueryGateway(builder().queryBus(simpleQueryBus))
