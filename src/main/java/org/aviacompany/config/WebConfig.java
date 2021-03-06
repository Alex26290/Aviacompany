package org.aviacompany.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
//соответствует mvcAnnotationDriven(приложение работающее с аннотациями Спринг MVC)
@EnableWebMvc
//где нужно искать компоненты
@ComponentScan(basePackages = {"org.aviacompany"})
//реализация диспетчер-сервлета
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:/login");
    }

//Добавляет поддержку обработчиков, без этого метода обработчики не будут инициализированы
    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setContentType("text/html;charset=UTF-8");
        viewResolver.setCache(false);
        return viewResolver;
    }

//    @Override
//    public final void addResourceHandlers(final ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/resources/**") // http адрес по которому будет получен ресурс
//                .addResourceLocations("/resources/"); // путь до папки где будет лежать ресурс
//    }

}