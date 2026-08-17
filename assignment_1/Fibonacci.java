/*
 * Name: Nachiket Singla
 * Roll No: 1024170077
 */
public class Fibonacci {
    
    public static void main(String[] args)
    {
        int n=10,secondTerm=1,firstTerm=0;
        System.out.println("Fibonacci Series till "+n+"terms:");
        for(int i=0;i<=n;i++)
        {
            System.out.println(firstTerm+",");

            int nextTerm=firstTerm+secondTerm;
            firstTerm=secondTerm;
            secondTerm=nextTerm;
        }
    }
}
