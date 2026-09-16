import java.util.Scanner;
class InvalidMarksException extends Exception{
    public InvalidMarksException(String message)
    {
        super(message);
    }
}
public class StudentResult{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        try{
            System.out.print("Enter the no. of subjects");
            int n=sc.nextInt();
            int total=0;

            for(int i=1;i<=n;i++)
            {
                System.out.print("Enter marks for subject"+i+":");
                int marks=sc.nextInt();
                if(marks<0|| marks>100)
                {
                    throw new InvalidMarksException(
                        "Marks must be btw 0 and 100"
                    );
                }
                total+=marks;
            }
                double Percentage=(double)total/n;

                String grade;
                if(Percentage>=90)
                    grade="A";
                else if(Percentage>=80)
                    grade="B";
                else if(Percentage>=70)
                    grade="C";
                else if(Percentage>=60)
                    grade="D";
                else grade="F";
                System.out.println("\nTotal="+total);
                System.out.println("Percentage"+Percentage);
                System.out.println("Grade="+grade);
        }catch(InvalidMarksException e){
            System.out.println("Error:"+e.getMessage());
        }
        sc.close();
    }
    
}
