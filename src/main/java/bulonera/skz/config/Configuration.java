package bulonera.skz.config;


import bulonera.skz.session.AdminSessionFilter;
import bulonera.skz.session.DeveloperSessionFilter;
import bulonera.skz.session.SessionFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@org.springframework.context.annotation.Configuration
@PropertySource("application.properties")
@EnableScheduling
public class Configuration {

    @Autowired
    private SessionFilter sessionFilter;
    @Autowired
    private AdminSessionFilter adminSessionFilterSessionFilter;
    @Autowired
    private DeveloperSessionFilter developerSessionFilter;

    @Bean
    public FilterRegistrationBean clientFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(sessionFilter);
        registration.addUrlPatterns("/customer/*");
        return registration;
    }

    @Bean
    public FilterRegistrationBean adminFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(adminSessionFilterSessionFilter);
        registration.addUrlPatterns("/admin/*");
        return registration;
    }

    @Bean
    public FilterRegistrationBean developerFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(developerSessionFilter);
        registration.addUrlPatterns("/developer/*");
        return registration;
    }
}