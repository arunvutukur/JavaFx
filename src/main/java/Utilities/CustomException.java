package Utilities;

public class CustomException extends Exception {

    public  CustomException(String errorMessage, Throwable err){
        super(errorMessage,err);
    }

    public  CustomException(String errorMessage){
        super(errorMessage);
    }

}
