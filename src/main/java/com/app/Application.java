package com.app;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author Administrator
 *
 */
@SpringBootApplication
@EnableSwagger2
public class Application {
	
	
	public static void main(String[] args) throws Exception{
		SpringApplication.run(Application.class, args);
	}

	@RefreshScope
	@RestController
	class MessageRestController {
	
		@Value("${message:Hello default}")
		private String message;
	
		@RequestMapping("/message")
		String getMessage() {
			return this.message;
		}
	}

	@Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
				.select()                
				.apis(RequestHandlerSelectors.basePackage("com.tcs.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}

