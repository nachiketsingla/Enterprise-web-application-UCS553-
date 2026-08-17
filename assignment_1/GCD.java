/*
 * Name: Nachiket Singla
 * Roll No: 1024170077
 */
public class GCD {
    public static void main(String[] args)
    {
        int n1=81, n2=153;
        //Euclidean algorithm
        while(n1!=n2)
        {
            if(n1>n2)
                n1=n1-n2;
            else
                n2=n2-n1;
        }
        /*
        while(n2!=0)
        {int temp=n2;
        n2=n1%n2;
        n1=temp;//n1 is GCD now } */
        System.out.println("GCD is:"+n2);
    }
    
}
