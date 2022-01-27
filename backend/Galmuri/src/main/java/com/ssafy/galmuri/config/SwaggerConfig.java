package com.ssafy.galmuri.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		//api 정보 설정
		final ApiInfo apiInfo = new ApiInfoBuilder()
				.title("Galmuri API")
				.description("<h3>갈무리에서 사용되는 RestApi에 대한 문서를 제공한다.</h3>")
				.contact(new Contact("SSAFY", "", "cdh6006@gmail.com"))
				.build();

		//문서화를 위한 객체 생성
		return new Docket(DocumentationType.SWAGGER_2)		//스웨거 타입으로 문서화
				.apiInfo(apiInfo) 							// 위에서 설정한 정보를 통해 문서화
				.select()									// ApiSelectorBuilder를 반환하며 상세한 설정 처리
				.apis(RequestHandlerSelectors.basePackage("com.ssafy.galmuri.controller"))//API 문서화할 컨트롤러 패키지 지정
				.paths(PathSelectors.ant("/**/**/**"))	// 위의 패키지의 컨트롤러에서 어떤 url에 매핑된 메소드를 API 문서화 할 지 설정
				.build();									// Docket 객체 생성			
	}
}
