package kodlamaio.northwind.core.utilities.results;

public class DateResult<T> /*<T> ile herhangi bir tipte veriyi generic bir
şekilde döndermemiz mümkün hale gelmiş oluyor.*/extends Result {
    /*Burada yapacağımız işlemlerda success ve message bilgisinin yanı sıra
    * bir de data bilgisi döndermemiz gerekmektedir*/

    private T data;
    public DateResult(T data ,boolean success, String message) {
        super(success, message);/*burada kullandığımız super sınıfı base classdaki(Result class) constructor ları
        çalıştırmamızı sağlamış oluyor(this kullanılırsa kullanıldığı sınıfa ait constructor lar kullanılır.super kullanışırsa
        base class ın constructor ları kullanılır.)*/
       this.data = data;

    }

    public DateResult(T data,boolean success){
        super(success);
        this.data = data;
    }

    /*data yı dışarıdan da okuyabilmek için getter yazabiliriz.*/

    public T getData(){
        return this.data;
    }

}
