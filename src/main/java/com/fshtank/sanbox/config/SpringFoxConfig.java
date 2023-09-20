package com.fshtank.sanbox.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SpringFoxConfig  implements WebMvcConfigurer {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.fshtank"))
                .paths(PathSelectors.any())
                .paths(PathSelectors.ant("/sandbox/**"))
                .build()
                .apiInfo(this.apiDetails());
    }

    /**
     *
     * @return
     */
    private ApiInfo apiDetails() {
        ApiInfo apiInfo = new ApiInfo(
                "Ofertas-Brazil"
                , "Offers for Trey of Fish"
                , "1.0"
                , "FSHTANK Public"
                , new springfox.documentation.service.Contact("Fishing Tools Team", "https://github.com/fshtank/sandbox", "fshtank@gmail.com")
                , "API License: Public"
                , "https://github.com/fshtank/"
                , Collections.emptyList());

        return apiInfo;
    }


    /**
     * Description: Swagger Tutorials / Blogs tell this below section is ONLY for a context not-SpringBoot; which is erroneous.
     *              swagger-ui.html is NOT found unless this section is included.
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry
                .addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
