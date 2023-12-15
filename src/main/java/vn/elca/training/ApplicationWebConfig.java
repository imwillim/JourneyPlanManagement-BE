package vn.elca.training;

import org.h2.server.web.WebServlet;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import vn.elca.training.handler.GlobalExceptionHandler;
import vn.elca.training.repository.PlaceRepository;
import vn.elca.training.repository.CountryRepository;
import vn.elca.training.repository.JourneyRepository;
import vn.elca.training.service.JourneyService;
import vn.elca.training.util.ApplicationMapper;
import vn.elca.training.web.AbstractApplicationController;

/**
 * @author gtn
 *
 */
@SpringBootApplication(scanBasePackages = "vn.elca.training")
@ComponentScan(basePackageClasses = {
        AbstractApplicationController.class,
        ApplicationMapper.class,
        JourneyRepository.class,
        PlaceRepository.class,
        CountryRepository.class,
        JourneyService.class,
        GlobalExceptionHandler.class
})
@PropertySource({"classpath:/application.properties", "classpath:/messages.properties"})
public class ApplicationWebConfig extends SpringBootServletInitializer implements WebMvcConfigurer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ApplicationWebConfig.class);
    }

    @Bean
    public ServletRegistrationBean h2servletRegistration() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
        registrationBean.addUrlMappings("/h2console/*");
        return registrationBean;
    }
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
