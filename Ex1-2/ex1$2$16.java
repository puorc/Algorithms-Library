/**
 * Created by pu on 2015/7/28.
 */
// rational implements
public class ex1$2$16 {
    private final int numerator;
    private final int denominator;
    public ex1$2$16(int x,int y){
        if(this.gcd(x,y)==0){
            numerator=x;
            denominator=y;
        }
        else{
            numerator=x/this.gcd(x,y);
            denominator=y/this.gcd(x,y);
        }
    }
    private int gcd(int a,int b){
        if(b==0) return a;
        int r=a%b;
        return gcd(b,r);
    }
    private int lcm(int a,int b){
        return a*b/this.gcd(a,b);
    }
    public int getNumerator(){return numerator;}
    public int getDenominator(){return denominator;}
    public ex1$2$16 plus(ex1$2$16 a){
        int tmp=lcm(this.denominator,a.getDenominator());
        ex1$2$16 result=new ex1$2$16(tmp/denominator*numerator+tmp/a.getDenominator()*a.getNumerator(),tmp);
        return result;
    }
    public ex1$2$16 minus(ex1$2$16 a){
        int tmp=lcm(this.denominator,a.getDenominator());
        ex1$2$16 result=new ex1$2$16(tmp/denominator*numerator-tmp/a.getDenominator()*a.getNumerator(),tmp);
        return result;
    }
    public ex1$2$16 times(ex1$2$16 a){
        ex1$2$16 result=new ex1$2$16(numerator*a.getNumerator(),denominator*a.getDenominator());
        return result;
    }
    public ex1$2$16 divide(ex1$2$16 a){
        ex1$2$16 result=new ex1$2$16(numerator*a.getDenominator(),denominator*a.getNumerator());
        return result;
    }
    public boolean equals(Object a){
        if(this==a)
            return true;
        if(a==null)
            return false;
        if(this.getClass()==a.getClass()){
            ex1$2$16 that=(ex1$2$16)a;
            if(this.numerator==that.getNumerator()&&this.denominator==that.getDenominator())
                return true;
        }
        return false;
    }
    public String toString(){
        return numerator+"/"+denominator;
    }
}
