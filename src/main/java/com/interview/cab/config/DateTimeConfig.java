package com.interview.cab.config;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;

/**
 * Configuration class for date format configuration
 *
 * @author Krupa N
 */
@Configuration
public class DateTimeConfig {

	@Bean
	public FormattingConversionService conversionService() {
		DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService(false);

		DateTimeFormatterRegistrar registrar = new DateTimeFormatterRegistrar();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(ZoneId.of("UTC"));
		registrar.setDateFormatter(formatter);
		registrar.registerFormatters(conversionService);

		return conversionService;
	}
}
