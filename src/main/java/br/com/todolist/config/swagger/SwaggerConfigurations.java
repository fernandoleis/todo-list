package br.com.todolist.config.swagger;

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
public class SwaggerConfigurations {
    //    @Bean
//    public Docket todoListApi(){
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("br.com.todolist"))
//                .paths(PathSelectors.ant("/**"))
//                .build()
//                .ignoredParameterTypes(User.class)
//                .globalOperationParameters(
//                        Arrays.asList(
//                                new ParameterBuilder()
//                                        .name("API Todo List")
//                                        .description("Documentação da API que armazena e atualiza tarefas")
//                                        .modelRef(new ModelRef("string"))
//                                        .parameterType("header")
//                                        .required(false)
//                                        .build()));
//    }
    @Bean
    public Docket todoListApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.todolist"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API Todo List")
                .description("Documentação da API que armazena e atualiza tarefas")
                .version(" Version API 1.0")
                .contact(new Contact("Fernando Leis", "", "fernandoleis@gmail.com"))
                .build();
    }
}

