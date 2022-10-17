
package assignment1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Fraction t1 = new Fraction(1,2);
        Fraction t2 = new Fraction(3,4);
        Fraction t= t1.add(t2);
        Fraction tt = t2.add(t1);
        Fraction ttt = t.add(tt);
        Fraction tttt= ttt.add(tt);
        Scanner sc = new Scanner(System.in);
        Fraction tx = new Fraction(sc.nextInt(),sc.nextInt());
    }
}