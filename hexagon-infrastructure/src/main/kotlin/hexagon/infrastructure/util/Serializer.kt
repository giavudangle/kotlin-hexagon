package hexagon.infrastructure.util

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.MapperFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import hexagon.adapter.exception.SerializingException
import hexagon.adapter.service.SerializerInterface
import java.text.DateFormat
import org.springframework.stereotype.Component

@Component
class Serializer : SerializerInterface {
  companion object {
    fun byJackson(): ObjectMapper {
      return JsonMapper.builder()
        .addModule(KotlinModule())
        .addModule(JavaTimeModule())
        .enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS)
        .enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)
        .enable(DeserializationFeature.USE_LONG_FOR_INTS)
        .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
        .disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        .configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true)
        .build()
    }

    fun byGson(): Gson {
      return GsonBuilder()
        .enableComplexMapKeySerialization()
        .setDateFormat(DateFormat.LONG)
        .create()
    }
  }

  @Throws(SerializingException::class)
  override fun <T> serialize(data: T): Array<Byte> {
    //        return byJackson().writeValueAsBytes(data).toTypedArray()
    TODO("Not implemented yet")
  }

  @Throws(SerializingException::class)
  override fun <T> deserialize(payload: Array<Byte>, clazz: Class<T>): T {
    //        return byJackson().readValue<T>(payload.toByteArray(),clazz)
    TODO("Not implemented yet")
  }
}
