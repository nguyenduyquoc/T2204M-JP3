package practice;

public class Main {
    public static void main(String[] args) {
       try {
           Complex cl1 = new Complex(3, 5);
           Complex cl2 = new Complex(5,6);
           Complex cl3 = cl1.add(cl2);
           System.out.println(cl3.toString());
           Complex cl4 = cl1.subtract(cl2);
           System.out.println(cl4.toString());
           Complex cl5 = cl1.multiply(cl2);
           System.out.println(cl5.toString());
           Complex cl6 = cl1.divide(cl2);
           System.out.println(cl6.toString());
       } catch (Exception e){
           System.out.println(e.getMessage());
       }


    }
}
