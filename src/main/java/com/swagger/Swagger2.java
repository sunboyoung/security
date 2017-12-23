package com.swagger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 通过@Configuration注解，表明它是一个配置类
 * @EnableSwagger2开启swagger2。apiINfo()配置一些基本的信息
 * apis()指定扫描的包会生成文档。
 */
@Configuration

@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zms.controller"))//指定controller自动生成对应的controller说明
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("swagger2初集成")
                .description("简单优雅的restful风格，与swagger相比 jar包中自带swagger静态页面")
                .termsOfServiceUrl("https://github.com/sunboyoung/violenceMS")
                .version("1.0")
                .build();
    }
}