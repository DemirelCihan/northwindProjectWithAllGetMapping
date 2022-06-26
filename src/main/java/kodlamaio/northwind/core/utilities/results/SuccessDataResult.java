package kodlamaio.northwind.core.utilities.results;

public class SuccessDataResult <T> extends DateResult{
    public SuccessDataResult(T data, String message) {
        super(data, true,message);
    }
    public SuccessDataResult( T data){/*sadece data ve success bilgisinin döndürmek için*/
        super(data,true);
    }
    public SuccessDataResult( String message) {/*sadece message durumunu döndermek istersek*/
        super(null, true,message);
    }
    public SuccessDataResult() {
        super(null, true);
    }

    /*Kullanıcılara yaptığımız çeşitli alternatifler ile sistemin kolaylığını sağlamış oluyoruz
    *  Yapılam işlemler ve yazılan kodlar ile kullanıcıdan data ve message bilgileri alınabilir.
    * sadece Data bilgisi alınabilr.Sadece message bilgisi alınabilir.Yada hiçbir bilgi alınmaz true/false bilgisi
    * dönderilmiş olur*/
}
