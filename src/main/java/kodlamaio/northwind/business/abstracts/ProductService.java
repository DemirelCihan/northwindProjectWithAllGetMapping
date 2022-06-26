package kodlamaio.northwind.business.abstracts;

import kodlamaio.northwind.core.utilities.results.DateResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductService {

    DateResult<List<Product>> getAll();//product listesi dönderilmektedir.

    DateResult<List<Product>> getAllSorted();/*datayı istenilen şarta göre sıralanması için*/

    DateResult<List<Product>> getAll(int pageNo, int pageSize);/*sayfalama yapmak için(ürünleri belirtilen sayfalardan
    listeleme yaparak ilerler)*//*hangi sayfa ve bir sayfada kaç tane data var*/
    Result add(Product product);

    DateResult<Product> getByProductName(String productName);

    DateResult<Product> getByProductNameAndCategoryId(String productName,int categoryId);

    DateResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId);

  // DateResult<List<Product>> getByCategoryIdIn(List<Integer>  categories);

    DateResult<List<Product>>  getByProductNameContains(String productName);

    DateResult<List<Product>> getByProductNameStartsWith(String productName);
    /*belirtilen harf veya kelime ile başlayan ürünleri listeleyecektir.*/

    DateResult<List<Product>> getByNameAndCategory(String productName,int categoryId);


}
