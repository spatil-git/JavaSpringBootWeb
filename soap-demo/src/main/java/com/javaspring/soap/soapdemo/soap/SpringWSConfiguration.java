package com.javaspring.soap.soapdemo.soap;


import org.springframework.boot.web.servlet.RegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

/**
 * This class adds the configuration for the Spring WS.
 */
// Enable the WebServices.
@EnableWs
// Mark for the configuration.
@Configuration
public class SpringWSConfiguration {
    // Message dispatcher servlet.
    // Request -> Dispatcher Servlet <-> ControllerEndpoint.
    /* use bean to inject the DispatcherServlet configuration into the Spring Framework */
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setTransformWsdlLocations(true);
        servlet.setApplicationContext(context);
        return new ServletRegistrationBean(servlet, "/ws/*");
    }

    @Bean(name = "employees")
    public DefaultWsdl11Definition wsdlDef(XsdSchema schema) {
        DefaultWsdl11Definition def = new DefaultWsdl11Definition();
        def.setPortTypeName("EmployeePort");
        def.setTargetNamespace("http://javaspringdemo.com/employees");
        def.setSchema(schema);
        def.setLocationUri("/ws");
        return def;
    }
    @Bean
    public XsdSchema employeeSchema() {
        return new SimpleXsdSchema(new ClassPathResource("employee-details.xsd"));
    }
}
