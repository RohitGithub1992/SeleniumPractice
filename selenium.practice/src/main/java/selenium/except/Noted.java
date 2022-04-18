package selenium.except;

public class Noted extends Exception{
    //checked exception

String a;
    public Noted(String a) {
        super(a);
        this.a=a;

    }


    public void giveException(int i, int y) throws Noted {
        if (i== y){
            System.out.println("im fine");
        }
        else {
            throw new Noted(a);
        }
    }


}
