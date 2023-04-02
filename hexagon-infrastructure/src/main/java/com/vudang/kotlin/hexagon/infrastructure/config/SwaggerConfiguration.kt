package com.vudang.kotlin.hexagon.infrastructure.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2
import java.util.*


@Configuration
@EnableSwagger2
open class SwaggerConfiguration {
    @Bean
    open fun apiDocket(): Docket? {
        return Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(
                RequestHandlerSelectors
                    .basePackage("com.vudang.kotlin.hexagon")
            )
            .paths(PathSelectors.any())
            .build()
            .apiInfo(getApiInfo())
    }

    private fun getApiInfo(): ApiInfo? {
        return ApiInfo(
            "Hexagon Boot",
            "Hexagon Boot",
            "1.0.0",
            "Terms of Service",
            Contact("Vu Dang", "https://github.com/giavudangle", "danglegiavu@gmail.com"),
            "",
            "",
            Collections.emptyList()
        )
    }
}