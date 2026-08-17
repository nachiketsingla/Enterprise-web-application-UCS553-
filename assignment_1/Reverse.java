/*
 * Name: Nachiket Singla
 * Roll No: 1024170077
 */public class Reverse {
    public static void main(String[] args) {
        int num=1234567,reversed=0;
        while(num!=0)
        {
            int digit=num%10;
            reversed=reversed*10+digit;
            num/=10;
        }
        System.out.println("Reversed Number:"+reversed);
    }
    
}
