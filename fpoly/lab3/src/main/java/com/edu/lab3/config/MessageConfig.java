package com.edu.lab3.config;

import java.util.Locale;

import org.hibernate.validator.spi.messageinterpolation.LocaleResolver;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class MessageConfig implements WebMvcConfigurer {
    @Bean("messageSource")
    public MessageSource getMessageSource() {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setDefaultEncoding("utf-8");
        ms.setBasenames("classpath:i18n/messages", "classpath:i18n/global");
        return ms;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        registry.addInterceptor(lci)
                .addPathPatterns("/**")
                .excludePathPatterns("/images/**");
    }

    @Bean("localeResolver")
    public CookieLocaleResolver getLocaleResolver() {
        CookieLocaleResolver cookie = new CookieLocaleResolver();
        cookie.setDefaultLocale(new Locale("vi"));
        cookie.setCookiePath("/");
        cookie.setCookieMaxAge(10 * 24 * 60 * 60);
        return cookie;
    }
}
