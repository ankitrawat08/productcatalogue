package productcatalogue.repository;

import org.springframework.data.repository.CrudRepository;

import productcatalogue.bean.Product;

public interface ProductCatalogueRepository extends CrudRepository<Product, String> {

}
