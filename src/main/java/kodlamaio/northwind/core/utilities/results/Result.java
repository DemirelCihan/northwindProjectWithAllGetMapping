package kodlamaio.northwind.core.utilities.results;

public class Result {//super type
    /*Burada yaptığımız işlemler ile veriler ile ilgili işlemler yaptığımızda
bize sonucun true veya false döndüreceğini burada yazacağımız 'message ile
görmüş olacağız'*/
    /*ayrıca burada yazdığımız result data result değildir.Yani kullanıcıya success ve mesaj bilgilerini
    * iletecektir.*/
    private boolean success;
    private String message;

    public Result(boolean success){
this.success = success;
    }
    public Result(boolean success,String message){
this(success);/*do not repeat yourself kuralı gereğince kod içerisinde tekrarlara yer verilmemelidir.
Burada yazdığımız this tek paremetreli olarak yazdığımız constructor ı çağırmış oluyor. */
this.message = message;
    }

    /*dışarıdan erişimi sağlamak için getter kullanacağız*/
    public boolean isSuccess(){
        return this.success;
    }

    public String getMessage(){
        return this.message;
    }
}
