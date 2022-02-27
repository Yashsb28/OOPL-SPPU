/* Design a base class shape with two double type values and member functions to input the data and compute_area() for calculating area of figure. 
Derive two classes’ triangle and rectangle. Make compute_area() as abstract function and redefine this function in the derived class to suit their 
requirements. Write a program that accepts dimensions of triangle/rectangle and display calculated area. Implement dynamic binding for given case study.*/

import java.util.*;
abstract class shape {
  
  private double dimen1,dimen2; 
  
  double getDimen1()    
  {
    return dimen1;
  }
  
  double getDimen2()    
  {
    return dimen2;
  }
  
  shape(){};        //default constructor
  
  shape(double a,double b)  //parameterized constructor
  {
    dimen1=a;
    dimen2=b;
  }
  
  abstract double compute_area();   //abstract method to calculate area

  void read()     
  {
    Scanner sc=new Scanner(System.in);
    System.out.print("ENTER  LENGTH :  ");
    dimen1=sc.nextDouble(); 
    System.out.print("ENTER BREADTH :  ");
    dimen2=sc.nextDouble();   
  }
  
}

class triangle extends shape{
  
  double area;    
  
  triangle(){}    //default constructor
  
  triangle(double base, double height)    //parameterized constructor
  {
    super(base,height);   //call to parameterized constructor of shape class
  }
  
   double compute_area()    // method to calculate and return area of 
  {
     area=(getDimen1()*getDimen2())/2;
     return area;
  }
}

class rectangle extends shape {
  
  double area;
  
  rectangle(){}     //default constructor
  
  rectangle (double length, double breadth)   //parameterized constructor
  {
    super(length,breadth);    
  }
  
   double compute_area()      
  {
     area=(getDimen1()*getDimen2());
     return area;
  } 
}

public class Main {
    
  public static void main(String args[])    
  {
    Scanner sc=new Scanner(System.in);  
      
    int x;      
    shape s;    
    do {
        System.out.println("");
        System.out.print("*******************");
        System.out.print("\n\t    MENU\n");
        System.out.print("*******************");
        System.out.print("\n\t1.Triangle\n\t2.Rectangle \n\t3.Exit\n");
        System.out.println("---------------------");
        System.out.print("\n\tChoice ::");
    
      x=sc.nextInt();
      System.out.println();
      switch(x)
      {
      case 1:     //area of triangle by parameterized constructor   
        
        double a,b;
        System.out.print("ENTER BASE OF TRIANGLE:  ");        
        a=sc.nextDouble();  
        System.out.print("ENTER HEIGHT OF TRIANGLE:  ");
        b=sc.nextDouble();  
        
        triangle t= new triangle(a,b);  
      
        s=t;
        System.out.println("AREA OF TRIANGLE IS  :  "+ s.compute_area());   
        //displaying area of triangle
        System.out.println("===================================");
        break;
        
        
      case 2:   //area of rectangle by default constructor
        
        rectangle r= new rectangle();         
      
        s=r;
        s.read(); 
        System.out.println("AREA OF RECTANGLE IS  :  "+ s.compute_area());
        System.out.println("===================================");
        break;
    
        
      case 3:     
        System.out.println("   EXITED SUCCESSFULLY !!!");
        System.out.println("===================================");
        break;
        
        
      default:    
        System.out.println("  INVALID  INPUT !!!");
        System.out.println("===================================");
        
      }
    }while(x!=3); 
    
    sc.close();   
  }
}
