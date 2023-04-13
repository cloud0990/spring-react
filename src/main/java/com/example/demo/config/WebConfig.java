package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.*;

@SuppressWarnings("deprecation")
@Configuration
@ComponentScan("com.example.demo")
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter implements WebMvcConfigurer {

    @Value("${global.fileStorePath}")
    private String filePath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        System.out.println("-------------------------------------------------------------");
        System.out.println(filePath);

        registry.addResourceHandler("/upload/**")
                .addResourceLocations("file://" + filePath);
        //.setCachePeriod(BROWSER_CACHE_CONTROL)
        //.resourceChain(true)
        //.addResolver(new PathResourceResolver());

        super.addResourceHandlers(registry);
    }

    /*@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/", "/api/test");
    }*/

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods(
                        HttpMethod.GET.name(),
                        HttpMethod.POST.name(),
                        HttpMethod.PUT.name(),
                        HttpMethod.DELETE.name()
                        //HttpMethod.HEAD.name()
                );

        super.addCorsMappings(registry);
    }

}