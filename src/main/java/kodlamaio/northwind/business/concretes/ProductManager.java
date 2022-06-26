package kodlamaio.northwind.business.concretes;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DateResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.ProductDao;
import kodlamaio.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//bu class projede servis görevi görecek şeklinde ayarlanır.Springe iletir.

public class ProductManager implements ProductService {

    private ProductDao productDao;/*soyut bir sınıf yaratıyoruz*/

    @Autowired //autowired spring'ten gelir.Projede ProductDoa ya karşılık gelen bir sınıf olup olmadığını kontrol eder
    /*@Autowired ile yukarıda olustuulan soyut interfacei kullanabiliyoruz*/
    public ProductManager(ProductDao productDao) /*constructed injection işlemi yapılmaktadır.*/ {
        this.productDao = productDao;
    }

    @Override
    public DateResult<List<Product> > getAll() {
        return new SuccessDataResult<List<Product>>
                ( this.productDao.findAll(),"Data listelendi");
/*verilen işlemi return yaptığımızda SuccessDataResult da data =this.productDao.findAll(), durumu success = true
* ve message ise "Data listelendi" şeklinde verilmiştir. */


    }

    @Override
    public DateResult<List<Product>> getAllSorted() {
        Sort sort =Sort.by(Sort.Direction.DESC,"productName");/*DESC büyükten küçüğe sıralama yapar*/
/*Burada properties olarak belirttiğimiz alan bizim sıralamanın hangi alana göre yapılacağını bildirir.*/
        return new SuccessDataResult<List<Product>>
                (this.productDao.findAll(sort),"Başarılı");
    }

    @Override
    public DateResult<List<Product>> getAll(int pageNo, int pageSize) {
        /*Burada findAll un "pageable yapsını kullanmaktayız."*/

        Pageable pageable = PageRequest.of(pageNo-1,pageSize);/*Pageable nesnesini PageRequest.of ile olusututup pageavble dönderiyoruz
        *//*ayrıca burada pageNo-1 dememizin sebebi arka planda indexlenme 0 dan başladığı için
        örneğin 1 numaralı sayfayı pageSize 10 olacak şekilde istersek sıralama 11 den başlar.Bunu engellemek için
        pageNo-1 kullanılır.*/
        return new SuccessDataResult<List<Product>>
        (this.productDao.findAll(pageable).getContent(),"Başarılı");
        /*getContent ile bize page türünden bir veri dödereceğinde biz bunu
        * List<Product> olarak döndermek için .getContent kullanırız.*/
    }

    @Override
    public Result add(Product product) {
        this.productDao.save(product);/*save metodu ile ekleme ve güncellemelri hızlı bir şekilde yapabiliriz.*/
        return new SuccessResult("Ürün eklendi");
        /*ekleme operasyonu için altyapımız hazır*/
    }

    @Override
    public DateResult<Product> getByProductName(String productName) {
        return new SuccessDataResult<Product>
                ( this.productDao.getByProductName(productName),"Data listelendi");
    }

    @Override
    public DateResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
      //bussiness codes write here
        return new SuccessDataResult<Product>
                ( this.productDao.getByProductNameAndCategory_CategoryId(productName,categoryId),"Data listelendi");
    }

    @Override
    public DateResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>
                ( this.productDao.getByProductNameOrCategory_CategoryId(productName,categoryId),"Data listelendi");
    }

    /*@Override
    public DateResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
        return new SuccessDataResult<List<Product>>
                ( this.productDao.getByCategoryIdIn(categories),"Data listelendi");
    }*/

    @Override
    public DateResult<List<Product>> getByProductNameContains(String productName) {
        return new SuccessDataResult<List<Product>>
                ( this.productDao.getByProductNameContains(productName),"Data listelendi");
    }

    @Override
    public DateResult<List<Product>> getByProductNameStartsWith(String productName) {
        return new SuccessDataResult<List<Product>>
                ( this.productDao.getByProductNameStartsWith(productName),"Data listelendi");
    }

    @Override
    public DateResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>
                ( this.productDao.getByNameAndCategory(productName,categoryId),"Data listelendi");
    }
}
