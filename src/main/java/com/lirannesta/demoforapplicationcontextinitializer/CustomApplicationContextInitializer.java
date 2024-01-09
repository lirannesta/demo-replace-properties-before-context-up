package com.lirannesta.demoforapplicationcontextinitializer;

import org.springframework.boot.env.OriginTrackedMapPropertySource;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class CustomApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        // Override properties here
        // For example:
        MutablePropertySources propertySources = applicationContext.getEnvironment().getPropertySources();
        List<String> replacablePropertyNames = new ArrayList<>();
        for (PropertySource<?> propertySource : propertySources) {
            String propertySourceName = propertySource.getName();
            if (propertySourceName.contains("application.properties")) {
                OriginTrackedMapPropertySource propertySourceResolved = (OriginTrackedMapPropertySource) propertySource;

                Arrays.stream(propertySourceResolved.getPropertyNames()).toList().forEach(propertyName -> {
                            Object property = propertySourceResolved.getProperty(propertyName);
                            if (property instanceof String) {
                                if (((String) property).contains("EXAMPLE:")) {
                                    replacablePropertyNames.add(propertyName);
                                }
                            }
                        }
                );
            }
        }

        // Create a new PropertySource with some properties
        Properties properties = new Properties();
        replacablePropertyNames.forEach(propertyName -> {
            properties.put(propertyName, "REPLACED!!!");
        });

        PropertiesPropertySource propertySource = new PropertiesPropertySource("epmCustomPropertySource", properties);
        // Add the PropertySource to MutablePropertySources
        propertySources.addFirst(propertySource);


        System.out.println(propertySources);
    }
}
