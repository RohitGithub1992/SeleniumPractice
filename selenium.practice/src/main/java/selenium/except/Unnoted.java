package selenium.except;

public class Unnoted extends RuntimeException{

 String  a;
    public Unnoted(String message) {
        super(message);
        this.a=message;
    }


    public void giveException(int i, int y) throws Unnoted {
        if (i== y){
            System.out.println("im fine");
        }
        else {
            throw new Unnoted(a);
        }
    }
}
