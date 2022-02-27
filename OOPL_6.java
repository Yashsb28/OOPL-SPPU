/*Implement a program to handle arithmetic exception, Array index out of bounds. The user enters two numbers Num1 and Num2. 
The division of Num1 and Num2 is displayed.  If Num1 and Num2 were not integers, they would throw a number format exception.
If Num2 were zero the program would throw an arithmetic exception and display the exception.*/

import java.util.*;
class Main
{
  public static void main(String args[])
    {
      Scanner scr=new Scanner(System.in);
      int num1,num2,q;
      
      try {
            System.out.println("\nEnter the value of first integer : ");
            num1=Integer.parseInt(scr.next());
            System.out.println("\nEnter the value of second integer : ");
            num2=Integer.parseInt(scr.next());
            
            q=num1/num2;
            System.out.println("\nQuotient is : "+q);
          }
      catch(NumberFormatException e) {
            System.out.println(e);
          }
      catch(ArithmeticException e) {
            System.out.println(e);
          }
    }
}
