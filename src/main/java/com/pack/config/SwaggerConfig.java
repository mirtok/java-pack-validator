package com.pack.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    //是否开启swagger，正式环境一般是需要关闭的
    private final boolean enableSwagger = true;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            //是否开启 (true 开启  false隐藏。生产环境建议隐藏)
            .enable(enableSwagger)
            .pathMapping("/")
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.pack.controller"))
            .paths(PathSelectors.any())
            .build().apiInfo(new ApiInfoBuilder()
                //设置文档标题(API名称)
                .title("SpringBoot整合Swagger")
                //文档描述
                .description("SpringBoot整合Swagger，详细信息......")
                //版本号
                .version("1.0.0")
                //联系信息
                .contact(new Contact("啊啊啊啊","www.lxit365.com","2528308183@qq.com"))
                .build());
    }
}
