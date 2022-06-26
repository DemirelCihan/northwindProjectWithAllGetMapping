package kodlamaio.northwind.api.controllers;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DateResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*BU KODLAR İLE DIŞ DÜNYAYA İLE BAĞLANTI SAĞLANIR*/

/*bu kod blokları içerisine yazılan her kodu ister android olsun ister ios olsun
* kullanabilecektir.*/

@RestController //controller oldugunu sınıfa iletildi spring ile.
@RequestMapping("/api/products")//birden fazla controller oldugunu varsayarsak bunların
//ayrımını yapacak
public class ProductsController {//api isimlendirme kuralı isimlendirme çoğul olur.ProductsController şeklinde olur

    /*spring arka planda ProductManager p = new ProductManager daki new lenmiş
    p yi altta yazılan ProductService e atıyor*/
    private ProductService productService;
    @Autowired
    public ProductsController(ProductService productService) {

        this.productService = productService;
    }


    @GetMapping("/getall")//bizden bir veri istenildiği zaman bunu GetMapping ile sağlarız
    public DateResult <List<Product>> getAll() {
        return this.productService.getAll();
    }

    @PostMapping("/add")/*kullanıcı tarafından bir gönderi gönderilmektedir.*/
    public Result add(@RequestBody Product product){
        return this.productService.add(product);
    }
    /*@PostMapping ile kullanıcı tarafından girilen bir veriyi database e yazmamıza olanak tanır.
    * @RequestBody ile ise Product a bir veri girmemizi sağlar.Gireceğimiz veriyi Product içerisinde'categoryId,id,productName,qantitiyPerUnit... 'gibi
    * alanları gezip uygun olan verileri uygun olan yerlere yazmıs oluyoruz. */
    /*@RequestBody bizim projede yazdığımız 'categoryId,id,productName,qantitiyPerUnit... 'gibi
    alanları Product içerisinde arayıp onları içerisinde map ediyor arka planda */

    @GetMapping("/getByProductName")
    public DateResult<Product>getByProductName(@RequestParam String productName){
        /*@RequestParam : yapılan isteğin(istek= String productName) parametrelerine bak orada productName i
        * oku ve atamasını yapıp productName e onu atamış olacak.*/
        return this.productService.getByProductName(productName);

    }
@GetMapping("/getByProductNameAndCategoryId")
   public DateResult<Product>
   getByProductNameAndCategoryId(@RequestParam  String productName, @RequestParam int categoryId){
        return this.productService.getByProductNameAndCategoryId(productName,categoryId);
    }

    @GetMapping("/getByProductNameContains")
    public     DateResult<List<Product>>  getByProductNameContains(@RequestParam String productName){
        return this.productService.getByProductNameContains(productName);
        /*bu yazılan api ile bir ürün arandığında içierisinde istenilen kelimeleri yazmamız yeterli
        * istenilen filtrelemeler yapıldıgında cıkacak olan sonuc result olarak bize dönderilecektir.*/
    }

@GetMapping("/getAllByPage")
    DateResult<List<Product>> getAll(int pageNo, int pageSize){
        return this.productService.getAll(pageNo,pageSize);
}

@GetMapping("/getAllDesc")
public DateResult<List<Product>> getAllSorted(){
        return this.productService.getAllSorted();
}

@GetMapping("/getByProductNameOrCategoryId")
         DateResult<List<Product>>
getByProductNameOrCategoryId(@RequestParam String productName, @RequestParam int categoryId){
        return this.productService.getByProductNameOrCategoryId( productName, categoryId);
}

/*@GetMapping("/getByCategoryIdIn")
         DateResult<List<Product>> getByCategoryIdIn(@RequestParam List<Integer>  categories){
        return this.productService.getByCategoryIdIn(categories);
}*/

@GetMapping("/getByProductNameStartsWith")
 DateResult<List<Product>> getByProductNameStartsWith(@RequestParam String productName){
        return this.productService.getByProductNameStartsWith(productName);
}

@GetMapping("/getByNameAndCategory")
 DateResult<List<Product>> getByNameAndCategory(@RequestParam String productName,@RequestParam int categoryId){
        return this.productService.getByNameAndCategory(productName,categoryId);
}











}