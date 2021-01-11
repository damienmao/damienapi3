package cryptoapi.exception;


public class NotFoundCurrencyException extends Exception{


    private static final long serialVersionUID = 4609030179107721949L;

    public NotFoundCurrencyException (String message){
        super(message);
    }
}
