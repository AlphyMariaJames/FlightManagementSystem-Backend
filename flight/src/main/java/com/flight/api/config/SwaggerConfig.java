package com.flight.api.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import org.springframework.kafka.core.DefaultKafkaProducerFactory;

import org.springframework.kafka.core.KafkaTemplate;

import org.springframework.kafka.core.ProducerFactory;

 

import springfox.documentation.builders.ApiInfoBuilder;

import springfox.documentation.builders.RequestHandlerSelectors;

import springfox.documentation.service.ApiInfo;

import springfox.documentation.spi.DocumentationType;

import springfox.documentation.spring.web.plugins.Docket;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

 

import static springfox.documentation.builders.PathSelectors.regex;

 

import java.util.HashMap;

import java.util.Map;

 

import org.apache.kafka.clients.producer.ProducerConfig;

import org.apache.kafka.common.serialization.StringSerializer;

import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

       @Bean
       public Docket postsApi() {

             return new Docket(DocumentationType.SWAGGER_2).groupName("flight-api").apiInfo(apiInfo()).select()
                    .apis(RequestHandlerSelectors.basePackage("com.flight.controller"))
                          .paths(regex("/*.*"))
                          .build();

       }

 

       private ApiInfo apiInfo() {

             return new ApiInfoBuilder().title("flight-management-API").description("flight-management-system")
            		 .termsOfServiceUrl("https://github.com/IIHT-spring")
                     .license("This is licensed to Abc government college").licenseUrl("abc.goverment@gmail.com")
                     .version("1.0").build();

       }

 

       @Bean
       public ProducerFactory<String, Object> producerFactory() {
             Map<String, Object> configs = new HashMap<>();
              configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
              configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
            configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

              return new DefaultKafkaProducerFactory<String, Object>(configs);

       }

 

       @Bean
       public KafkaTemplate<String, Object> kafkaTemplate() {
             return new KafkaTemplate<>(producerFactory());
       }
       
       @Bean
       public RestTemplate restTemplate(RestTemplateBuilder builder) {
           return builder.build();
       }

}