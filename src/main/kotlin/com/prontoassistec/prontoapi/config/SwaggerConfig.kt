package com.prontoassistec.prontoapi.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.PathSelectors.regex
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2


@Configuration
@EnableSwagger2
class SwaggerConfig {

    @Bean
    fun productApi(): Docket? {
        return Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .build()
            .apiInfo(metaInfo())
    }

    private fun metaInfo(): ApiInfo? {
        return ApiInfo(
            "Pronto API REST",
            "API REST de controle de serviços.",
            "1.0",
            "Terms of Service",
            Contact(
                "José Mauro de Souza", "https://pronto-api.herokuapp.com",
                "jmauroprofessor@gmail.com"
            ),
            "Apache License Version 2.0",
            "https://www.apache.org/licesen.html", ArrayList()
        )
    }

}