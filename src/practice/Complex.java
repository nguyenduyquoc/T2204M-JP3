package practice;

public class Complex {
    private double realPart;
    private double imaginaryPart;

    public Complex() {
        realPart = 0;
        imaginaryPart = 0;
    }

    public Complex(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public double getRealPart() {
        return realPart;
    }

    public void setRealPart(double realPart) {
        this.realPart = realPart;
    }

    public double getImaginaryPart() {
        return imaginaryPart;
    }

    public void setImaginaryPart(double imaginaryPart) {
        this.imaginaryPart = imaginaryPart;
    }
    public String toString(){
        if (getImaginaryPart() == 0) return getRealPart() +" + 0i";
        if (getRealPart() == 0) return getImaginaryPart() + "i";
        if (getImaginaryPart() < 0) return getRealPart() + " - " + (-getImaginaryPart()) + "i";
        return this.getRealPart() + "+" + this.getImaginaryPart() + "i";
    }

    public Complex add(Complex cl) {
        Complex c = new Complex();
        c.setRealPart(this.getRealPart() + cl.getRealPart());
        c.setImaginaryPart(this.getImaginaryPart() + cl.getImaginaryPart());
        return c;
    }

    public Complex subtract(Complex cl) {
        Complex c = new Complex();
        c.setRealPart(this.getRealPart() - cl.getRealPart());
        c.setImaginaryPart(this.getImaginaryPart() - cl.getImaginaryPart());
        return c;
    }

    public Complex multiply(Complex cl) {
        Complex c = new Complex();
        c.setRealPart(this.getRealPart() * cl.getRealPart() - this.getImaginaryPart() * cl.getImaginaryPart());
        c.setImaginaryPart(this.getRealPart() * cl.getImaginaryPart() + this.getImaginaryPart() * cl.getRealPart());
        return  c;

    }
    public Complex divide(Complex cl) throws Exception{
        if (cl.getRealPart() == 0 && cl.getImaginaryPart() == 0) throw new Exception("Cannot zero!");
        Complex c = new Complex();
        c.setRealPart((this.getRealPart() * cl.getRealPart() + this.getImaginaryPart() * cl.getImaginaryPart()) /
                (cl.getRealPart() * cl.getRealPart() + cl.getImaginaryPart() * cl.getImaginaryPart()));
        c.setImaginaryPart((this.getImaginaryPart()*cl.getRealPart() - this.getRealPart()*cl.getImaginaryPart()) /
                (cl.getRealPart()*cl.getRealPart() + cl.getImaginaryPart()*cl.getImaginaryPart()));
        return c;

    }
}
