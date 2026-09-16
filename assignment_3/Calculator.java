import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        try{
            System.out.print("Enter first number");
            double num1=Double.parseDouble(sc.nextLine());

            System.out.print("Enter second number:");
            double num2=Double.parseDouble(sc.nextLine());

        System.out.print("Enter Operator(+,-,*/):");
        String Operator=sc.nextLine();

        double result;
        switch (Operator) {
            case "+":
                result=num1+num2;
                break;
        
            case "-":
                result = num1 - num2;
                break;

            case "*":
                result = num1 * num2;
                break;
            case"/":
            if(num2==0)
            {
                throw new ArithmeticException("Division by zero");
            }
            result =num1/num2;
             break;
             default:
                throw new IllegalArgumentException("Invalid operator");

        }
        System.out.println("Result=="+result);
    }
    catch(ArithmeticException e)
    {
        System.out.println("Error:Cannot divide by zero.");
    }
    catch(NumberFormatException e)
    {
        System.out.println(("Error:please enter valid numbers."));
    }
    catch(IllegalArgumentException e)
    {
        System.out.println("Error:Invalid Operator");
    }
    finally{
        sc.close();
        System.out.println("Calculator closed.");
    }
}
}
