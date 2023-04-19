package hexagon.infrastructure

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.kotlin.hexagon"]) open class Application {}

fun main(args: Array<String>) {
  runApplication<Application>(*args)
}
