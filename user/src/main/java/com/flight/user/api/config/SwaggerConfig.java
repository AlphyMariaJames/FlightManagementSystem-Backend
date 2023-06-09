package com.flight.user.api.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;

import springfox.documentation.builders.RequestHandlerSelectors;

import springfox.documentation.service.ApiInfo;

import springfox.documentation.spi.DocumentationType;

import springfox.documentation.spring.web.plugins.Docket;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("user-api").apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.flight.user.controller"))
				.paths(regex("/*.*")).build();

	}

	private ApiInfo apiInfo() {
                             return new ApiInfoBuilder().title("flight-management-system-API").description("flight-management-system")
                                                         .termsOfServiceUrl("https://github.com/IIHT-spring")
                                                          .license("This is licensed to Abc government college").licenseUrl("abc.goverment@gmail.com")
                                                          .version("1.0").build();

              }

}