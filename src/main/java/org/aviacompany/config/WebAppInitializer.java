package org.aviacompany.config;

import org.springframework.core.annotation.Order;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import javax.servlet.Filter;
//Наш дескриптор развёртывания
@Order(1)
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    //перечисление классов с конфигурацией, которые использует наше приложение
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {
                PersistenceConfig.class, CoreConfig.class, SecurityConfig.class
        };
    }
//инициализация диспетчер-сервлета(добавляем класс, который будет соответствовать dispatcher servlet(это классWeb-config))
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    //наш диспетчер-сервлет будет обрабатывать все запрос по дефолтному URL
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{
                new CharacterEncodingFilter("UTF-8", false)
        };
    }

}