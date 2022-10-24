package session3;

public class Main {
    public static void main(String[] args){
        try {
            int a = 10;
            int b = 0;
            if(a > 5) {
                throw new Exception("Nhap lai");
            }
            int c = a / b;
            System.out.println("c = " + c);
        } catch (ArithmeticException e){
            System.out.println(e.getMessage());
        } catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            //dù có catch hay k thì cũng chạy qua đây.....
        }
    }
}
