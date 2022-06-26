package kodlamaio.northwind.core.utilities.results;

public class ErrorResult extends Result{
    public ErrorResult()/*işlem sonucu başarızı ve mesaj vermek istemiyor*/{
        super(false);
    }
    public ErrorResult(String message)/*işlem sonucu başarısız ve mesaj vermek istiyor*/{
        super(false,message);
    }
}
