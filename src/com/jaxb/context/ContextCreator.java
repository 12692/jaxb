package com.jaxb.context;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import com.bo.Employee;

public class ContextCreator {
	public static JAXBContext getJaxbContext(){
		JAXBContext context = null;
		try {
			context = JAXBContext.newInstance(
					new Class[] {
							Employee.class
					});
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return context;
	}
}