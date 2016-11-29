package com.config;

import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.type.filter.RegexPatternTypeFilter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import static com.config.MvcConfig.WebPackage;

@Configuration
@ComponentScan(basePackages = "com", excludeFilters = { @Filter(type = FilterType.CUSTOM, value = WebPackage.class) })
public class MvcConfig extends WebMvcConfigurerAdapter {
	private Logger logger = LoggerFactory.getLogger(RootConfig.class);

	@Bean
	public ViewResolver viewResolver() {
		logger.info("*****************************创建视图解析器*****************************");
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	public static class WebPackage extends RegexPatternTypeFilter {
		public WebPackage() {
			super(Pattern.compile("com\\.server"));
		}
	}
	
	
	  @Override 
	  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) { 
		  configurer.enable();
	  }
	 

}
