package selenium.test;

public class JevanKarna {

    public static String a="fdsfsdf";


    public String b= "rohit";

    //variable types

    /*
    local = anything defined inside { } is called as local variable
    global = public static String a="fdsfsdf";
    instance = sticks with class object
     */


    public static void tatGhe(){
      String a= "jsdbfjsdnf";
    }

    public static void gff(){

    }

    public static void main(String[] args) {
        JevanKarna jevanKarna= new JevanKarna();

        System.out.println(jevanKarna.b);
        jevanKarna.b= "ravindra";
        System.out.println(jevanKarna.b);

        JevanKarna jevanKarna1= new JevanKarna();
        System.out.println(jevanKarna1.b);


    }
}
