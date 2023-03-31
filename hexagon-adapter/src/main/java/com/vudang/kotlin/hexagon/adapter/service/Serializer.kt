package com.vudang.kotlin.hexagon.adapter.service

import kotlin.reflect.KClass

interface Serializer {
    fun <T> serialize(data : T) : Array<Byte>
    fun <T> deserialize(payload : Array<Byte>, clazz : KClass<Any>) : T
}



