package session1;

public class Main {
    public static void main(String[] args){
        //Human h = new Human();     error

        Vietnamese vn1 = new Vietnamese();

        Human h = new Human() {
            @Override
            public void eat() {

            }

            @Override
            public void run() {

            }
        };
    }
}
