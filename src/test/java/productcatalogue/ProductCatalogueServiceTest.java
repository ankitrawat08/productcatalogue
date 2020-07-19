package productcatalogue;

import static org.hamcrest.CoreMatchers.startsWith;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import productcatalogue.bean.Product;
import productcatalogue.exception.ProductCatalogueException;
import productcatalogue.service.ProductCatalogueService;

public class ProductCatalogueServiceTest {

	ProductCatalogueService productCatalogueService;
	Product product;

	@Before
	public void setup() {
		productCatalogueService = new ProductCatalogueService();
		// product = new Product("shoes", "adidas", "adidas is a good brand");
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test()
	public void testAddProductWithInvalidProductName() throws ProductCatalogueException {
		String prodName = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		thrown.expect(ProductCatalogueException.class);
		thrown.expectMessage(startsWith("Product name should not exceed 100 characters"));
		product = new Product("shoes", prodName, 10, 500, "Black", "adidas is a good shoe brand");
		productCatalogueService.addProduct(product);
	}

	@Test()
	public void testAddProductWithEmptyProductName() throws ProductCatalogueException {
		thrown.expect(ProductCatalogueException.class);
		thrown.expectMessage(startsWith("Product name should not exceed 100 characters"));
		product = new Product("shoes", null, 10, 500, "Black", "adidas is a good shoe brand");
		productCatalogueService.addProduct(product);
	}

	@Test()
	public void testAddProductWithInvalidProductDescription() throws ProductCatalogueException {
		String prodDescription = "a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a";
		thrown.expect(ProductCatalogueException.class);
		thrown.expectMessage(startsWith("Length of the description cannot exceed 200 words"));
		product = new Product("shoes", "adidas", 10, 500, "Black", prodDescription);
		productCatalogueService.addProduct(product);
	}

	@Test()
	public void testAddProductWithEmptyProductDescription() throws ProductCatalogueException {
		thrown.expect(ProductCatalogueException.class);
		thrown.expectMessage(startsWith("Length of the description cannot exceed 200 words"));
		product = new Product("shoes", "adidas", 10, 500, "Black", null);
		productCatalogueService.addProduct(product);
	}

	@Test()
	public void testAddProductWithInvalidProductId() throws ProductCatalogueException {
		thrown.expect(ProductCatalogueException.class);
		thrown.expectMessage(startsWith("Product id cannot be null/empty."));
		product = new Product("", "adidas", 10, 500, "Black", "adidas is a good shoe brand");
		productCatalogueService.addProduct(product);
	}

	@Test()
	public void testAddProductWithEmptyProductId() throws ProductCatalogueException {
		thrown.expect(ProductCatalogueException.class);
		thrown.expectMessage(startsWith("Product id cannot be null/empty."));
		product = new Product(null, "adidas", 10, 500, "Black", "adidas is a good shoe brand");
		productCatalogueService.addProduct(product);
	}

	@Test()
	public void testAddProductWithInvalidProductSize() throws ProductCatalogueException {
		thrown.expect(ProductCatalogueException.class);
		thrown.expectMessage(startsWith("Product size cannot be 0 or negative"));
		product = new Product("shoes", "adidas", 0, 500, "Black", "adidas is a good shoe brand");
		productCatalogueService.addProduct(product);
	}

	@Test()
	public void testAddProductWithInvalidProductWeight() throws ProductCatalogueException {
		thrown.expect(ProductCatalogueException.class);
		thrown.expectMessage(startsWith("Product weight cannot be 0 or negative"));
		product = new Product("shoes", "adidas", 10, 0, "Black", "adidas is a good shoe brand");
		productCatalogueService.addProduct(product);
	}

}
