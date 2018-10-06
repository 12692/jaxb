package com.jaxb.demo;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.bo.Employee;
import com.jaxb.context.ContextCreator;

public class JAXBExample {

    private static final String FILE_NAME = "/tmp/jaxb-emp.xml";

    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.setId(1);
        emp.setAge(25);
        emp.setName("Anil");
        emp.setGender("Male");
        emp.setRole("Developer");
        emp.setPassword("sensitive");

        // Marshalling
        jaxbObjectToXML(emp);
        
        // UnMarshalling
        Employee empFromFile = jaxbXMLToObject();
        System.out.println(empFromFile.toString());
    }


    private static Employee jaxbXMLToObject() {
        try {
            JAXBContext context = ContextCreator.getJaxbContext();
        	Unmarshaller un = context.createUnmarshaller();
            Employee emp = (Employee) un.unmarshal(new File(FILE_NAME));
            return emp;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    
    private static void jaxbObjectToXML(Object obj) {

        try {
        	JAXBContext context = ContextCreator.getJaxbContext();
            Marshaller m = context.createMarshaller();
            //for pretty-print XML in JAXB
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

              // Write to File
            m.marshal(obj, new File(FILE_NAME));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}
