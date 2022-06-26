package kodlamaio.northwind.core.utilities.results;

public class SuccessResult extends Result{
    public SuccessResult()/*işlem sonucu başaralı ama mesaj vermek istemiyor*/{
        super(true);
    }
    public SuccessResult(String message)/*işlem sonucu başarılı ve mesaj vermek istiyor*/{
        super(true,message);
    }
}
