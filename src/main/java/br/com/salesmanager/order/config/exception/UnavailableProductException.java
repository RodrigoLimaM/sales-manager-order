package br.com.salesmanager.order.config.exception;

public class UnavailableProductException extends RuntimeException {

    public UnavailableProductException(){
        super("Unavailable quantity");
    }
}
