package selenium.except;


public class Caller {


    public static void main(String[] args)  {
        Noted noted= new Noted("padshil");
        try {
            noted.giveException(2, 4);
        }
        catch (Noted noted1){
         noted1.printStackTrace();

        }

        Unnoted unnoted= new Unnoted("bin bataye gira dia");
        unnoted.giveException(2,4);

    }
}
