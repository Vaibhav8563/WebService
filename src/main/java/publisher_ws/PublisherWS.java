package publisher_ws;


import javax.xml.ws.Endpoint;

import crud_soap.ws.service.ProductServiceImpl;

public class PublisherWS {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8081/ws/product", new ProductServiceImpl());
		
        System.out.println("SOAP Publisher WebService is running........");

	}

}
