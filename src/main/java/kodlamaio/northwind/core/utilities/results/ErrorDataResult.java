package kodlamaio.northwind.core.utilities.results;

public class ErrorDataResult <T> extends DateResult {
    public ErrorDataResult(T data, String message) {
        super(data, false, message);
    }

    public ErrorDataResult(T data) {/*sadece data ve success bilgisinin döndürmek için*/
        super(data, false);
    }

    public ErrorDataResult(String message) {/*sadece message durumunu döndermek istersek*/
        super(null, false, message);
    }

    public ErrorDataResult() {
        super(null, false);
    }
}