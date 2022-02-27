/*Design and develop a context for given case study and implement an interface for Vehicles. Consider the example of vehicles like bicycle, car and bike.
All Vehicles have common functionalities such as Gear Change, Speed up and apply breaks. Make an interface and put all these common functionalities. 
Bicycle, Bike, Car classes should be implemented for all these functionalities in their own class in their own way. */

import java.util.*;

interface vehicle {            //vehicle interface
  void gear_change(int a);    
  void speed_up();
  void apply_brakes();
  void display();

}

class bicycle implements vehicle
{
  int gear,speed;
  
  bicycle()     
  {
    System.out.println("\tBicycle started successfully!!!\n ");
    gear=1;   
    speed=10;   
  }
  
  public void gear_change(int gearex)
  {
    if(gearex<7 && gearex>0)    
    {
      gear=gearex;
      System.out.println("\tGear changed Successfully!!! \n\t Current Gear : "+gear);
    }
    else
      System.out.println("Gear is Out Of Range \n");
  }
  
  public void speed_up()      
  {
    if((speed+5)<50 ) {   
      speed+=5;
      System.out.println("\n\tBicycle speed increased!!! \n\t Current speed : "+speed+" km/hr\n");
    }
    else
      System.out.println("Speed Cannot Be Increased Above 50 Km/hr\n");
  }
  
  public void apply_brakes()    
  {
    Scanner sc=new Scanner(System.in);
    int x;
    System.out.println("1. DECREASE SPEED\n2. STOP BICYCLE\n");
    System.out.print("\tChoice -> ");
    x=sc.nextInt();
    
    if(x==1)
      if((speed-5)>0)     
      {
        speed-=5;     
        System.out.println("Speed Reduced Successfully!!! \n\tCurrent Speed : "+speed+" Km/hr \n");
      }
      else {
        speed=0;
        gear=0;
        System.out.println("Bicycle stopped Successfully!!!\n ");}
        
    if(x==2)      
    {
      speed=0;
      gear=0;
      System.out.println("Bicycle stopped Successfully!!!\n ");
    }
    
  }
  
  public void display()   
  {
    System.out.println("BICYCLE STATUS :- \nSpeed : "+speed +" Km/hr \nGear : "+gear);
  }
}




class car implements vehicle    
{
  int gear,speed;
  
  car()
  {
    System.out.println("\tCar started successfully!!!\n ");
    gear=1;   
    speed=10;   
  }
  public void gear_change(int gearex)
  {
    if(gearex<7 && gearex >0) 
    {
      this.gear=gearex;
      System.out.println("\tGear changed Successfully!! \n\t Current Gear : "+gear);
    }
    else
      System.out.print(" Gear Out Of Range!!! \n");
  }
  
  public void speed_up()
  {
    
    if((speed+20)<150 )     
    {
      speed+=20;
      System.out.println("Car speed increased!!! \n\t Current speed : "+speed+" Km/hr\n");
    }
    else
      System.out.println("Speed Cannot Be Increased Above 150 Km/hr\n");
      
  }
  
  public void apply_brakes()
  {
    Scanner sc=new Scanner(System.in);
    int x;
    System.out.println("1. TO DECREASE SPEED\n2. TO STOP CAR\n");
    System.out.print("\tChoice -> ");
    x=sc.nextInt();
    if(x==1)
      if((speed-20)>0)    
      {
        speed-=20;      
        System.out.println("Speed Reduced Successfully!!! \n\tCurrent Speed : "+speed+" kmhr\n");
      }
      else {
        speed=0;
        gear=0;
        System.out.println("Car stopped Successfully!!!\n ");}
    if(x==2)
    {
      speed=0;
      gear=0;
      System.out.println("Car stopped Successfully!!! \n");
    } 
  }
  
  public void display()   
  {
    System.out.println("CAR STATUS :- \nSpeed : "+speed +" Km/hr \nGear : "+gear);
  }

}

//BIKE CLASS

class bike implements vehicle
{
  int gear,speed;   
  
  bike()
  {
    System.out.println("\tBike started successfully!!! \n");
    gear=1;   
    speed=10; 
  }
  public void gear_change(int gearex)
  {
    if(gearex<6 && gearex>0)    
    {
      gear=gearex;
      System.out.println("\tGear changed Successfully!!! \n\t Current Gear : "+gear);
    }
    else
      System.out.println("Gear out of range!!! \n");
  }
  
  public void speed_up()
  {
    if((speed+20)<100 )   
    {
      speed+=20;
      System.out.println("Bike's speed increased!!! \n\t Current speed : "+speed+" Km/hr.\n");
    }
      else
        System.out.println("Speed Cannot Be Increased Above 100 Km/hr \n");
      
  }
  
  public void apply_brakes()    
  {
    Scanner sc=new Scanner(System.in);
    int x;
    System.out.println("1. TO DECREASE SPEED\n2. TO STOP bike\n");
    System.out.print("\tChoice -> ");
    x=sc.nextInt();
    if(x==1)
      if((speed-20)>0)  
      {
        speed-=20;      
        System.out.println("Speed Reduced Successfull   \n\tCurrent speed : "+speed+ "km/hr\n" );
      }
      else {
        speed=0;
        gear=0;
        System.out.println("Bike stopped Successfully!!! \n");}
    if(x==2)
    {
      speed=0;
      gear=0;
      System.out.println("Bike stopped Successfully!!! \n");
    }
    
  }
  
  public void display()   
  {
    System.out.println("BIKE STATUS :- \nSpeed : "+speed +" Km/hr A\nGear : "+gear);
  }
}

public class Main {

  public static void main(String[] args) {
  
    Scanner sc=new Scanner(System.in);    
    
    vehicle v=null;     
      
    int y;      
    bb:   
    do {
      System.out.println("");
      System.out.print("*********************");
      System.out.print("\n\t    MENU\n");
      System.out.print("*********************\n");
      System.out.print("   SELECT VEHICLE  \n\t 1.BICYCLE \n\t 2.CAR  \n\t 3.BIKE \n\t 4.Exit\n");
      System.out.println("---------------------");
      System.out.print("\nChoice -> ");
       y=sc.nextInt();
       
       System.out.println("=========================================");
       
      if(y==1)    
        v=new bicycle();  
      else if(y==2)
        v= new car();   
      else if(y==3)
        v=new bike(); 
      else if(y==4)
        break bb;   
      else
        System.out.println("INVALID INPUT");
        System.out.println("=========================================");
      
      if(0<y&&y<4) {
      aa:   
        do {
          System.out.print("\t-* VEHICLE MENU *- \n\t1. Speed Up \n\t2. Change gear \n\t3. Apply Brakes  "
            + "\n\t4. Display Vehicle Status \n\t5. Main Menu \n\tChoice -> ");
          int z=sc.nextInt();     
          System.out.println("=========================================");
        switch(z)
        {
        case 1:
          v.speed_up();
          System.out.println("=========================================");
          break;
        case 2:
          System.out.print("which gear you want?   ");
          int a=sc.nextInt();
          v.gear_change(a);
          System.out.println("=========================================");
          break;
          
        case 3:
          v.apply_brakes();
          System.out.println("=========================================");
          break;
        case 4:
          v.display();
          System.out.println("=========================================");
          break;
        case 5:
          break aa;   
        default:
            System.out.println("Invalid Input");
          
        }
        }while(true);
      }
        
      
      
    }while(y!=4); 
  }

}
