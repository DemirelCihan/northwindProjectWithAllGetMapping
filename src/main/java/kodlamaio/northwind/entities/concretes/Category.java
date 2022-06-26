package kodlamaio.northwind.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="categories") //vertabanı ile ilişkilendirme table kullanılır.
@Entity//bunun bir veritabanı tablosu olduğunu anlatmak için bu kullanılır
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","products"})/*istenilen bir obje nesne aramasında
loob a girmemek için bu kullanılır. */
public class Category {
    @Id
    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "category_name")
    private String categoryName;

    @OneToMany(mappedBy = "category")
    private List<Product> products;/*burada yaptığımız işlem ile one to many ilişkisiyle ana tablodan diğer
    tabloya geçiş sağlarız. Eğer bire bir bir ilişki sağlamak isteseydşik one to one ilişkisi kullanmamız
    geerekecekti*/
    /*tam tersi olsaydı eğer products tan categoriye gelmek isteseydik fazla oldugu için products,
    * many to one ilişkisi kurulacaktı.*/

}

/*ilişkilendirme türleri;
* one to many : ana tabloda bir kere geçer diğer tabloda birden fazla
* one to one : ana tabloda bir kere diğer tabloda da bir kere geçer.*/

