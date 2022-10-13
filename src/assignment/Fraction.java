package assignment;

public class Fraction {
    int tuSo;
    int mauSo;

    public Fraction() {
    }

    public Fraction(int tuSo, int mauSo) {
        this.tuSo = tuSo;
        this.mauSo = mauSo;
        this.rutGon();
    }

    public int getTuSo() {
        return tuSo;
    }

    public void setTuSo(int tuSo) {
        this.tuSo = tuSo;
    }

    public int getMauSo() {
        return mauSo;
    }

    public void setMauSo(int mauSo) {
        this.mauSo = mauSo;
    }

    public void inPhanSo(){
        System.out.println(getTuSo()+"/"+getMauSo());
    }

    public void rutGon(){
        int ucln = 1;
        for(int i=Math.abs(getTuSo());i>1;i--){
            if(tuSo%i==0 && mauSo%i==0){
                ucln = i;
                break;
            }
        }
        setTuSo(tuSo/ucln);
        setMauSo(mauSo/ucln);
    }

    public void nghichDao(){
        int tmp = getTuSo();
        if(tmp != 0){
            setTuSo(mauSo);
            setMauSo(tmp);
        }
    }

    public Fraction add(Fraction f){
        Fraction t = new Fraction();
        t.setMauSo(this.getMauSo()*f.getMauSo());
        t.setTuSo(this.getTuSo()*f.getMauSo() + this.getMauSo()* f.getTuSo());
        t.rutGon();
        return t;
    }

    public Fraction sub(Fraction f){
        int ts = this.getTuSo()*f.getMauSo() -this.getMauSo()*f.getTuSo();
        int ms = this.getMauSo()*f.getMauSo();
        Fraction sb = new Fraction(ts,ms);
        return sb;
    }

    public Fraction mul(Fraction f){
        return new Fraction(this.getTuSo()*f.getTuSo(),this.getMauSo()*f.getMauSo());
    }

    public Fraction div(Fraction f){
        f.nghichDao();
        return this.mul(f);
    }
}