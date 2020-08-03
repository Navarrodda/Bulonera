package bulonera.skz.exceptions;

public class ExistingUser extends Throwable{
    public ExistingUser(String message){
        super(message);
    }
}
