package com.yunqi.cloudenglish.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @描述:
 * @版权: Copyright (c) 2018
 * @创建人 Jesse Xue
 * @创建时间 14:01 2018/5/15
 * @版本 v1.0
 */
@Configuration
@EnableSwagger2
@EnableAspectJAutoProxy
public class WebConfig extends WebMvcConfigurerAdapter{

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        AntPathMatcher pathMatcher=new AntPathMatcher();
        //路径不区分大小写
        pathMatcher.setCaseSensitive(false);
        configurer.setPathMatcher(pathMatcher);
    }
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .globalOperationParameters(setToken())
                .apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.yunqi.cloudenglish.controller"))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false);
    }

    /**
     * swagger 请求路径
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("English On Cloud")
                //.description("")
                .termsOfServiceUrl("http://localhost:8808/swagger-ui.html")
                .contact(new Contact("Jesse","https://blog.csdn.net/weixin_38809962/article/category/7452264","xueyunfei@eyee.com")).version("1.0").build();
    }

    /**
     * swagger时设置token参数
     * @return
     */
    private List<Parameter> setToken() {
        ParameterBuilder tokenPar=new ParameterBuilder();
        List<Parameter> pars=new ArrayList<>();
        tokenPar.name("Authorization").description("token")
                .modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(tokenPar.build());
        return pars;
    }
}
