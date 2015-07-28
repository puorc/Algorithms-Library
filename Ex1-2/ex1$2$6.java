/**
 * Created by pu on 2015/7/28.
 */
// circular rotation
public class ex1$2$6 {
    public static boolean isRotation(String s1,String s2){
        return (s1.length()==s2.length())&&((s2+s2).indexOf(s1)!=-1);
    }
}
