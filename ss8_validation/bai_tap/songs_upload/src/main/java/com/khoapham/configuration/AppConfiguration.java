package com.khoapham.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@PropertySource("classpath:song_upload.properties")
public class AppConfiguration extends WebMvcConfigurerAdapter {

    @Value("${upload-file}")
    private String fileUpload;

    //Cấu hình upload file
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/songs/**")
                .addResourceLocations("file:" + fileUpload);

    }

//    @Bean(name = "multipartResolver")
//    public CommonsMultipartResolver getResolver() throws IOException {
//        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
//        resolver.setMaxUploadSizePerFile(52428800);
//        return resolver;
//    }
}
