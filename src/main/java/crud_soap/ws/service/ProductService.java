package crud_soap.ws.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import crud_soap.ws.model.Product;

@WebService
public interface ProductService {

	@WebMethod
	String createProduct(Product product);

	@WebMethod
	Product getProduct(int id);

	@WebMethod
	List<Product> getAllProduct();

	@WebMethod
	String updateProduct(Product product);

	@WebMethod
	String deleteProduct(int id);

}
