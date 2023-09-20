/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fshtank.sandbox.config;

import com.fshtank.sanbox.config.SpringFoxConfig;
import com.fshtank.sanbox.model.SboxRequest;
import com.fshtank.sanbox.model.SboxResponse;
import com.fshtank.sanbox.service.SboxService;
import com.fshtank.sanbox.service.impl.SboxServiceImpl;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author sznlf0
 */
@Configuration
@EnableWebMvc
@Import({SpringFoxConfig.class})
@ComponentScan(basePackages = "com.fshtank")

@PropertySources({
        @PropertySource("classpath:application.properties"),
})

public class TestSandboxConfig {

    @Value("${application.name}")
    private String applicationName;

    private String userName="userName";

    private String secret="pwd";


    /*
     * GETTERS and SETTERS
     */
    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
        System.out.println("Starting Application Name: " + this.applicationName);
    }

    @Bean
    public SboxRequest getSanboxWebRequest() {
        return new SboxRequest();
    };

    @Bean
    public SboxService getSbxService () {
        return new SboxServiceImpl();
    }

    @Bean
    public SboxResponse getSanboxWebResponse() {
        return new SboxResponse();
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public HttpHeaders getRestTemplateHeaders() {

        HttpHeaders headers = new HttpHeaders();
        String plainClientCredentials = userName + ":" + secret;
        String base64ClientCredentials = new String(Base64.encodeBase64(plainClientCredentials.getBytes()));
        headers.add("Authorization", "Basic " + base64ClientCredentials);

        return headers;
    }

}

