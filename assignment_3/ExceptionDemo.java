public class ExceptionDemo{
    public static void main(String[] args)
    {
        //1.ArthmeticExceptioin
        try{
            int a=10;
            int b=0;
            System.out.println(a/b);
        }
        catch(ArithmeticException e){
            System.out.println("ArthmeticExceptioin: cannot divide by 0");
        }
        //2. NUllpointerexception
        try{
            String str=null;
            System.out.println(str.length());
        }
        catch(NullPointerException e)
        {
            System.out.println("NullPointerException:String is null");
        }
        // 3.arrayindexout of order 
        try{
            int[] arr={10,20,30};
            System.out.println(arr[5]);
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("ArrayIndexOutOfBoundsException: invalid array index");
        }
        // 4.NumberFormatException
        try{
            String s="abc";
            int num=Integer.parseInt(s);
            System.out.println(num);
        }catch(NumberFormatException e)
        {
            System.out.println("numberformatexception:Invalid number format");
        }


    }
}