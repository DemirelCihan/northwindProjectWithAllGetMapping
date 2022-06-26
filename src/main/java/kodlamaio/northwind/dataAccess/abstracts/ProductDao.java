package kodlamaio.northwind.dataAccess.abstracts;

import kodlamaio.northwind.core.utilities.results.DateResult;
import kodlamaio.northwind.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product,Integer> {
//JPARepository ile aslında hangi tabloya hangi ID veri tipi ile sorguların hazırlanmazını
    //söylemiş oluyoruz.

Product getByProductName(String productName);/*getBy ile tablolara bakılyor tabloda ilgili kolona
ver işareti verilmektedir.*/
    Product getByProductNameAndCategory_CategoryId(String productName,int categoryId);
    /*and kapısı ile kuruldugundan dolayı iki istekte alındığı takdirde geçerli olacak*/

    List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);
/*Or kapısı ile kurulduğu için iki istekten en az birinin getirlilmesi yeterlidir.*/
/*yaptığımız or kapısı ile ilgili işlemler arka planda şu şekilde ilerlemektedir.
* SELECT * from products where product_name = abc or category_id=1 şeklinde
* bir arama yapmaktadır.*/

    //List<Product> getByCategoryIdIn(List<Integer>  categories);
    /*Burada yaptığımız işlemler ile sql de şu işlemler dönecektir;
    * SELECT * from products where category_id in(1,2,3,4,5) -> category si
    * 1,2,3,4,5 olanları döndermiş olacak.*/

    List<Product> getByProductNameContains(String productName);

    List<Product> getByProductNameStartsWith(String productName);
    /*.... isimle olanları dönderecektir.*/

    @Query("From Product where productName=:productName and category.categoryId=:categoryId")/*-JPQL-  query yazarken veritabanı tablosu kuralları dısında yazıyoruz.
     Query de kullanıdığımız : bizim parametremiz oluyor*/
    List<Product> getByNameAndCategory(String productName,int categoryId);

    /*SELECT * from products where product_name = .... and ategoryId = .....*/
}
