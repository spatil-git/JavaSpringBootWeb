## SOAP Webservice using Spring.
#Steps:
1. Define the service contract using the request and response XML.
2. Define the XSD to validate the request and response XMLs.
3. Use XSD in the request and response XML for validation.
4. Use JAXB to form the XML data using the above xsd.
5. Create the Soap Endpoint and the method to handle the request for the particular XML and the namespace.
6. Create the Web Services configuration class and also enable the WS using the appropriate annotations.
7. Create the Dispatcher Servlet and hook into the Spring using the beans "SpringWSConfiguration".
8. Create WSDL from the xsd.
9. Import wsdl4j in the POM File to generate the WSDL definition.
10. Browse to "http://localhost:8080/ws/employees.wsdl" using wizdler Chrome plugin.
11. Send the HTTP POST Request with "text/xml" as the "Content-Type" and the SOAP Envelope as :
```
<Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
    <Body>
        <GetEmployeeDetailsReq xmlns="http://javaspringdemo.com/employees">
            <id>1</id>
        </GetEmployeeDetailsReq>
    </Body>
</Envelope>
