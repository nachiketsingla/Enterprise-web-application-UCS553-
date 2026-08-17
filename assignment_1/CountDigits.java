/*
 * Name: Nachiket Singla
 * Roll No: 1024170077
 */public class CountDigits {
    public static void main(String[] args) {
        int num=345289;
        int count=0;
        while(num!=0)
        {
            num/=10;
            ++count;
        }
        System.out.println("Number of digits:"+count);
    }
    
}
