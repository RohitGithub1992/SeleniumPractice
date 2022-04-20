package selenium.excceptionPackage;

public class ExceptionExample {

        public static void method1(){

            try {
                System.out.println(10 / 0);
            }
            catch(ArithmeticException e)
            {
                System.out.println("I am new exception");

            }
            method2();
        }
        public static void method2(){
            System.out.println(10/1);
        }

    public static void main(String[] args) {
        method1();
    }

    }

