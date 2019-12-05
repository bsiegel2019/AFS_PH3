package com.drones.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.drones")
public class DroneWebAppConfig implements WebMvcConfigurer {

	// eqiv: <mvc:resources mapping="/resources/**" location="/resources/" />
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean
	public UrlBasedViewResolver urlBasedViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/views/"); // example was just "/views/" but mine has been this
		resolver.setSuffix(".jsp");
		resolver.setCache(false);
		resolver.setViewClass(JstlView.class);
		return resolver;
	}

//	<bean id="viewResolver"
//			class="org.springframework.web.servlet.view.UrlBasedViewResolver">
//			<property name="viewClass"
//				value="org.springframework.web.servlet.view.JstlView" />
//			<property name="prefix" value="/WEB-INF/views/" />
//			<property name="suffix" value=".jsp" />
//		</bean>

//    TODO remove
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
//        registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(31556926);
//        registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(31556926);
//    }

//    // equivalent for <mvc:default-servlet-handler/> tag
//    @Override
//	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//        configurer.enable();
//    }
//	TODO remove this if not used

}
