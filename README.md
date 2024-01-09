# demo-replace-properties-before-context-up
Demonstrate how to replace application.properties values, before context fully loads, thus allowing to add another layer of manipulation

## Description
This code uses ApplicationContextInitializer<ConfigurableApplicationContext> to replace values in application.properties before the context is fully loaded.

Please notice CustomApplicationContextInitializer class which performs the replacement of the values.
In this demo, it searches for a property with a value containing the string "EXAMPLE:", and replaces it.

The property is defined in application.properties file.

A bean that consumes the property is named "SomeBean" and it demonstrates the replacement by printing the value of the property (the replaced one) to the console.