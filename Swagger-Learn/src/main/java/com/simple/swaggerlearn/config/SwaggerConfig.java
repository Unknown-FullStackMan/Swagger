package com.simple.swaggerlearn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author Simple
 * @data 2021/3/28 11:22
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {


    //配置了swagger的Docket 的 bean 实例
    @Bean
    public Docket docket(Environment environment){

        // 设置要显示的Swagger环境
        Profiles profiles = Profiles.of("dev", "test");
        // 通过 environment.acceptsProfiles(profiles) 判断是否处在自己设定的环境当中
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("simple")
                .enable(true)
                .select()
                // RequestHandlerSelectors, 配置要扫描的包
                // basePackage(): 指定要扫描的包
                // any(): 扫描全部
                // none(): 都不扫描
                // withClassAnnotation : 扫描类上的注解, 参数是一个注解的反射对象
                // 例如：withClassAnnotation(RestController.class) 只扫描类上有@RestController的生成文档
                // withMethodAnnotation: 扫描方法上的注解, 参数是一个注解的反射对象
                .apis(RequestHandlerSelectors.basePackage("com.simple.swaggerlearn.controller"))
                // paths(): 过滤什么路径
                //.paths(PathSelectors.ant("/simeple/**"))
                .build()
                ;
    }

    //配置 swagger 信息 = apiInfo
    private ApiInfo apiInfo(){
        Contact contact = new Contact("Simple","Simple's URl","2419316154@qq.com");
        return new ApiInfo("Simple‘s Swagger Documentation",
                "自定义 Swagger Api Documentation",
                "1.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }


    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }
    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }
    @Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("C");
    }

}
