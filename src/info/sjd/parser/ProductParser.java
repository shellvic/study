package info.sjd.parser;

import info.sjd.exceptions.MyException;
import info.sjd.product.Product;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ProductParser {
	private List<String> description = new ArrayList<>();
	private Document doc;
	private Elements elements;

	private String parseTitle() {
		elements = doc.select("#productTitle");

		if (elements.isEmpty()) {
			return "not parsed";
		} else {
			return elements.first().text();
		}
	}

	private String parsePrice() {
		elements = doc.select("#priceblock_ourprice");

		if (elements.isEmpty()) {
			return "not parsed";
		} else {
			return elements.first().text();
		}
	}

	private List<String> parseDescription() {
		elements = doc.select("#feature-bullets ul li:not(.aok-hidden)");

		if (elements.isEmpty()) {
			description.add("not parsed");
			return description;
			
		} else {
			for (Element element : elements) {
				description.add(element.text());
			}
			return description;
		}		
	}

	private void parseHtmlData(String url) {
		try {
			doc = Jsoup.connect(url).get();

		} catch (IOException e) {
			throw new MyException("Get data fail");
		}
	}

	public Product getProductWithInfo(String url) {
		Product product = new Product();
		parseHtmlData(url);
		product.setTitle(parseTitle()).setPrice(parsePrice()).setDescription(parseDescription());
		return product;
	}

}
