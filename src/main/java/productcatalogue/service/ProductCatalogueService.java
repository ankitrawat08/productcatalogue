package productcatalogue.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import productcatalogue.bean.Product;
import productcatalogue.exception.ProductCatalogueException;
import productcatalogue.repository.ProductCatalogueRepository;

@Service
public class ProductCatalogueService {

	@Autowired
	ProductCatalogueRepository productCatalogueRepository;

	List<Product> products = new ArrayList<>(
			Arrays.asList(new Product("shoes", "adidas", 10, 350, "Black", "adidas is a good shoe brand"),
					new Product("electronics", "computer", 19, 800, null, "apple is a good computer electronic brand"),
					new Product("clothes", "armani", 40, 150, "Yellow", "armani is a good clothing brand")));

	public List<Product> getAllProducts() {
		return products;
		// return (List<Product>) productCatalogueRepository.findAll();

	}

	public void addProduct(Product product) throws ProductCatalogueException {
		if (validateProduct(product))
			productCatalogueRepository.save(product);
	}

	public void editProduct(String id, Product product) throws ProductCatalogueException {
		if (validateId(id) && validateProduct(product))
			productCatalogueRepository.save(product);
	}

	public void deleteProduct(String id) throws ProductCatalogueException {
		if (validateId(id))
			productCatalogueRepository.deleteById(id);
	}

	public Product fetchProduct(String id) throws ProductCatalogueException {
		if (validateId(id))
			return productCatalogueRepository.findById(id).orElseGet(Product::new);
		return null;
	}

	private boolean validateProduct(Product product) throws ProductCatalogueException {
		if (product.getDescription() == null || wordCount(product.getDescription()) > 200) {
			throw new ProductCatalogueException("Length of the description cannot exceed 200 words");
		} else if (product.getName() == null || product.getName().length() > 100) {
			throw new ProductCatalogueException("Product name should not exceed 100 characters");
		} else if (product.getSize() <= 0) {
			throw new ProductCatalogueException("Product size cannot be 0 or negative");
		} else if (product.getWeight() <= 0) {
			throw new ProductCatalogueException("Product weight cannot be 0 or negative");
		} else
			return validateId(product.id);
	}

	private boolean validateId(String id) throws ProductCatalogueException {
		if (id == null || id.isEmpty()) {
			throw new ProductCatalogueException("Product id cannot be null/empty.");
		} else
			return true;
	}

	private int wordCount(String description) {
		int out = 0, in = 1;
		int i = 0, wordsCount = 0, state = out;
		while (i < description.length()) {
			if (description.charAt(i) == ' ' || description.charAt(i) == '\n' || description.charAt(i) == '\t') {
				state = out;
			} else if (state == out) {
				state = in;
				++wordsCount;
			}
			++i;
		}
		return wordsCount;
	}

}
