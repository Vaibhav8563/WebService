package consumer_ws;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import crud_soap.ws.model.Product;
import crud_soap.ws.service.ProductService;

import java.net.URL;
import java.util.List;

public class ConsumerWS {

	public static void main(String[] args) throws Exception {

		// URL for the WSDL of your ProductService
		URL url = new URL("http://localhost:8081/ws/product?wsdl");

		// QName for the service (namespace and service name)
		QName qname = new QName("http://service.ws.crud_soap/", "ProductServiceImplService");

		// Create the service object
		Service service = Service.create(url, qname);

		// Get the port (proxy) for ProductService
		ProductService productService = service.getPort(ProductService.class);

		// 1. Get all products
		List<Product> products = productService.getAllProduct();
		System.out.println("List of Products: " + products);

		// 2. Get product by ID
		Product product = productService.getProduct(1);
		System.out.println("Product with ID 1: " + product);

		// 3. Create a new product
		Product newProduct = new Product(5, "Smartwatch", 15000.75);
		String createResponse = productService.createProduct(newProduct);
		System.out.println(createResponse);

		// 4. Update product with ID 1
		Product updatedProduct = new Product(1, "Updated Smartphone", 55000.50);
		String updateResponse = productService.updateProduct(updatedProduct);
		System.out.println(updateResponse);

		// 5. Delete product with ID 2
		String deleteResponse = productService.deleteProduct(2);
		System.out.println(deleteResponse);
	}
}
