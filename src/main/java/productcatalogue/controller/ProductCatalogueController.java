package productcatalogue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import productcatalogue.bean.Product;
import productcatalogue.exception.ProductCatalogueException;
import productcatalogue.service.ProductCatalogueService;

@RestController
public class ProductCatalogueController {

	@Autowired
	ProductCatalogueService productCatalogueService;

	// get all products
	@RequestMapping("/products")
	public List<Product> getAllProducts() {
		return productCatalogueService.getAllProducts();
	}

	// fetch product
	@RequestMapping(method = RequestMethod.GET, value = "/products/{id}")
	public Product fetchProduct(@PathVariable String id) throws ProductCatalogueException {
		return productCatalogueService.fetchProduct(id);
	}

	// add product
	@RequestMapping(method = RequestMethod.POST, value = "/products")
	public void addProduct(@RequestBody Product product) {
		try {
			productCatalogueService.addProduct(product);
		} catch (ProductCatalogueException e) {
			e.printStackTrace();
		}
	}

	// edit product
	@RequestMapping(method = RequestMethod.PUT, value = "/products/{id}")
	public void editProduct(@RequestBody Product product, @PathVariable String id) {
		try {
			productCatalogueService.editProduct(id, product);
		} catch (ProductCatalogueException e) {
			e.printStackTrace();
		}
	}

	// delete product
	@RequestMapping(method = RequestMethod.DELETE, value = "/products/{id}")
	public void deleteProduct(@PathVariable String id) {
		try {
			productCatalogueService.deleteProduct(id);
		} catch (ProductCatalogueException e) {
			e.printStackTrace();
		}
	}

}
