package com.vudang.kotlin.hexagon.adapter.service

interface Serializer {
  fun <T> serialize(data: T): Array<Byte>
  fun <T> deserialize(payload: Array<Byte>, clazz: Class<T>): T
}
