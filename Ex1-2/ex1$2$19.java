/**
 * Created by pu on 2015/7/28.
 */
// parse transaction
public class ex1$2$19 {
    private final String name;
    private final int day;
    private final int month;
    private final int year;
    private final double money;
    public ex1$2$19(String transaction){
        String[] fileds=transaction.split(" ");
        String[] date=fileds[1].split("/");
        name=fileds[0];
        money=Double.parseDouble(fileds[2]);
        day=Integer.parseInt(date[0]);
        month=Integer.parseInt(date[1]);
        year=Integer.parseInt(date[2]);
    }
    public boolean equals(Object a){
        if(this==a)
            return true;
        if(a==null)
            return false;
        if(this.getClass()==a.getClass()){
            ex1$2$19 that=(ex1$2$19)a;
            if(that.name.equals(that.name))   //Don't use this.name==that.name
                return true;
        }
        return false;
    }
}
