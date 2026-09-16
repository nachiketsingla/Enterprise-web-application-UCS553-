public class NestedTryCatch {
    public static void main(String[] args) {
        try{
            System.out.println("outer try blcok started");
            try{
                System.out.println("Inner try block started");

                int [] arr={10,20,30};
                System.out.println(arr[5]);
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                System.out.println("Inner catch: Invalid array index");
            }
            // Exception in outer block 
            int a=10;
            int b=0;
            System.out.println(a/b);
        }
        catch(ArithmeticException e){
            System.out.println("Outer catch:cannot divide by 0");
        }
        System.out.println("Progress continues");
    }
    
}
