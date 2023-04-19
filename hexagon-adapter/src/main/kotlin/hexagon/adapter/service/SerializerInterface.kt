package hexagon.adapter.service

interface SerializerInterface {
  fun <T> serialize(data: T): Array<Byte>
  fun <T> deserialize(payload: Array<Byte>, clazz: Class<T>): T
}
