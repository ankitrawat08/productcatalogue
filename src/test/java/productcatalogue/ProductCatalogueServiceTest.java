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
		product = new Product("shoes", prodName, "adidas is a good shoebrand");
		productCatalogueService.addProduct(product);
	}

	@Test()
	public void testAddProductWithInvalidProductDescription() throws ProductCatalogueException {
		String prodDescription = "a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a";
		thrown.expect(ProductCatalogueException.class);
		thrown.expectMessage(startsWith("Length of the description cannot exceed 200 words"));
		product = new Product("shoes", "adidas", prodDescription);
		productCatalogueService.addProduct(product);
	}

	@Test()
	public void testAddProductWithInvalidProductId() throws ProductCatalogueException {
		thrown.expect(ProductCatalogueException.class);
		thrown.expectMessage(startsWith("Product id cannot be null/empty."));
		product = new Product("", "adidas", "adidas is a good shoe brand");
		productCatalogueService.addProduct(product);
	}

}
