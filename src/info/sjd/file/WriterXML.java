package info.sjd.file;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import info.sjd.exceptions.MyException;
import info.sjd.product.Product;

public class WriterXML {
	
	public void writeProductToXml(Product product, String filePath) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Product.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(product, new File(filePath));
		} catch (JAXBException e) {
			throw new MyException(e.getMessage());
		}
	}
}
