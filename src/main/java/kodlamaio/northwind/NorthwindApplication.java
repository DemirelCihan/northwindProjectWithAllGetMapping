package kodlamaio.northwind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2/*swagger ı başlatan anatasyon*/
public class NorthwindApplication {

	public static void main(String[] args) {
		SpringApplication.run(NorthwindApplication.class, args);
	}

	@Bean/*uygulamalar başladığı anda spring boot Bean i gördüğü zaman bunu belleğe yerleştirir.
	 Proje içerisinde controller ları ve onların içerisinde Request Handler ları bulup
	 bunların tamamını dökümantasyon haline döndürecektir*/
	public Docket api() /*uygulama içerisindeki apileri bulup onları test edebileceğimiz bir
	noktaya taşımız olur.l*/{
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("kodlamaio.northwind"))/*Burada yapılan işlem kodlamaio.northwind
				i gez ve içeride bulduğun apileri dökümantasyona yaz komutudur.*/
				.build();

	}

}
