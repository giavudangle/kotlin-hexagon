package hexagon.infrastructure

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@SpringBootApplication(scanBasePackages = ["hexagon"])
open class Application {}

fun main(args: Array<String>) {
  runApplication<Application>(*args)
}
