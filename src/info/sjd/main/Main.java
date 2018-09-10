package info.sjd.main;

import java.nio.file.Path;

import info.sjd.file.WriterXML;
import info.sjd.parser.ProductParser;
import info.sjd.product.Product;
import info.sjd.services.RegService;
import info.sjd.users.User;

public class Main {
	private static ProductParser parser = new ProductParser();
	private static Product product = new Product();
	private static WriterXML writer = new WriterXML();
	private static String link;
	private static Path xmlPath;
	private static User user;
	
	public static void main(String[] args) {
		/*link = "https://www.amazon.com/LG-gram-Thin-Light-Laptop/dp/B078WRSHV4/ref=sr_1_82_sspa";
		xmlPath = Paths.get("data/product.xml");
				
		product = parser.getProductWithInfo(link);		
		writer.writeProductToXml(product, xmlPath.toString());		
		System.out.println("Parsing done! - data/product.xml");		
		FilePrint.printFileToConsole(xmlPath);*/
		
		user = new User("Nikola", "nikolaTesla@supermail.com", "NikTes987654");
		RegService.regUserOnAmazon(user);
	}
}
