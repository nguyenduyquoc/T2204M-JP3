
package assignment1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Fraction t1 = new Fraction(1,2);
        Fraction t2 = new Fraction(3,4);
        Fraction t= t1.add(t2);
        t.inPhanSo();
        Fraction tt = t2.add(t1);
        tt.inPhanSo();
        Fraction ttt = t.add(tt);
        ttt.inPhanSo();
        Fraction tttt= ttt.add(tt);
        tttt.inPhanSo();
    }
}