package training;

import java.io.File;

import snippet.JAXBDemoBean;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;



public class JAXBDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JAXBDemoBean am=new JAXBDemoBean();
		am.setPwd("sdsd");
		am.setUname("kk");
		
		
		//File f=new File("D:\\test2.xml");
		JAXBContext ctx;
		try {
			ctx = JAXBContext.newInstance(JAXBDemoBean.class);
			//Unmarshaller m1=ctx.createUnmarshaller(); //XML to Object
			//XMLTest t=(XMLTest)m1.unmarshal(f);
			Marshaller m= ctx.createMarshaller(); //Object to XML
	        // Set the Marshaller media type to JSON or XML
	
	        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(am, System.out);
			m.marshal(am, new File("d:\\test.xml"));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}