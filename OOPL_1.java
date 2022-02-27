import java.util.*;
import java.util.Scanner; 
import java.lang.Math;//1 (Library)

class Complex{
    float real,imag;
    Complex(){
        real=0;
        imag=0;
    }

    Complex(float r, float i){
        real=r;
        imag=i;
    }
    
    public void Add(Complex c1,Complex c2){
        float treal,timag;
        treal=(c1.real+c2.real);
        timag=(c2.imag+c1.imag);
        char sign;
        sign = (timag > 0) ? '+' : '-';
        
        System.out.printf("\n Sum is : "+ treal + sign + Math.abs(timag) +"i");
    }
    
     public void Subtraction(Complex c1,Complex c2){
        float treal,timag;
        treal=(c1.real-c2.real);
        timag=(c2.imag-c1.imag);
        char sign;
        sign = (timag > 0) ? '+' : '-';
        
        System.out.printf("\n Subtraction is : "+ treal + sign + Math.abs(timag) +"i");
    }
    
     public void Product(Complex c1,Complex c2){
        float treal,timag;
        treal=(c1.real*c2.real);
        timag=(c2.imag*c1.imag);
        char sign;
        sign = (timag > 0) ? '+' : '-';
        
        System.out.printf("\n Product is : "+ treal + sign + Math.abs(timag) +"i");
    }
    
     public void Division(Complex c1,Complex c2){
        float treal,timag;
        treal=((c1.real*c2.real)+(c1.imag*c2.imag))/((c2.real*c2.real)+(c2.imag*c2.imag));
        timag=((c1.imag*c2.real)-(c1.real*c2.imag))/((c2.real*c2.real)+(c2.imag*c2.imag));
        char sign;
        sign = (timag > 0) ? '+' : '-';
        
        System.out.printf("\n Division is : "+ treal + sign + Math.abs(timag) +"i");
    }
}

public class Main{              //2 (Main)=> me onlinegdb me kiya isliye
    public static void main(String[] args) {
        float real,imag;
        Complex c= new Complex();
        Scanner input = new Scanner(System.in); 
        
        System.out.println("Enter 1st complex number : ");
        real= input.nextFloat();   //Float ka f Capital (F)
        imag= input.nextFloat();
        Complex num1 =new Complex(real,imag);
    
        System.out.println("Enter 2nd complex number : ");
        real=input.nextFloat();
        imag=input.nextFloat();
        Complex num2 =new Complex(real,imag);
    
    
    
    
    int ch;
    
    do {
    System.out.println("\n\n1.Addition \n2.Subtraction \n3.Product \n4.Division \n0. Exit");
    System.out.println("Enter Choice : ");
    
    
    ch = input.nextInt();
    switch(ch) {
        
        case  1 : c.Add(num1, num2);
                 break;
        case  2 : c.Subtraction(num1, num2);
                  break;
        case  3 : c.Product(num1, num2);
                  break;
        case  4 : c.Division(num1, num2);
                  break;
        case  0 :System.out.println("Exited....");
                  break;
        default : System.out.println("Invalid !!!");
    }
        
    }while(ch != 0);
    
    }

}

