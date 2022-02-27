/*Implement and apply Strategy Design pattern for simple Shopping Cart where three payment strategies are used such as Credit Card, PayPal, 
BitCoin. Create the interface for strategy pattern and give concrete implementation for payment.*/

import java.util.Scanner;

interface PaymentProcessor {

    void pay(int amount);//interface method pay

}

public class Main {
  public static void main(String[] args) {
    int c,amt=0;
    Order order;
    Scanner sc = new Scanner(System.in);
    while(true) {
      System.out.println();
      System.out.println("**** SHOPPING PAYMENT METHOD ****");
      Setw.right("1.Credit Card", 23, ' ');
      System.out.println("\n");
      Setw.right("2.PayPal", 21, ' ');
      System.out.println("\n");
      Setw.right("3.Bitcoin", 21, ' ');
      System.out.println("\n");
      Setw.right("4.Exit", 20, ' ');
      
      System.out.println("\n---------------------------------------");
      System.out.print("\n\nEnter the Choice -> ");
      c=sc.nextInt();
      System.out.println("---------------------------------------");
      if(c==1||c==2||c==3) {
         System.out.print("\nEnter amount to Transfer :: ₹ ");
         amt = sc.nextInt();//taking amt from user
         System.out.println("---------------------------------------");
      }

      
      switch(c) {
       case 1://for input c ==1
          order = new Order(amt, new CreditCard());//creating obj of order class
          order.process();//calling process method of order class
         break;
         
       case 2://for input c == 2
          order = new Order(amt, new PayPal());//creating obj of order class
          order.process();//calling process method of order class
         break;
         
       case 3://for input c == 3
          order = new Order(amt, new BitCoin());//creating obj of order class
          order.process();//calling process method of order class
         break;
         
       case 4:
         System.out.println("\nThank you For Shopping !!!! ");
         System.out.println("----------------------------------------------------------");
         return;
         
      default:
        System.out.println("Invalid Payment Mode !!!");// default
        System.out.println("----------------------------------------------------------");
       }
    }
  }
}

class CreditCard implements PaymentProcessor {
    Scanner sc =new Scanner (System.in);
    String name,ExpDate;
    double CardNo, CVV;

    CreditCard(){ 
      super();
      System.out.print("\tCard holder Name :: ");
      this.name =sc.nextLine();
      System.out.print("\tCard Number :: ");
      this.CardNo =sc.nextDouble();
      System.out.print("\tCVV :: ");
      this.CVV =sc.nextDouble();
      System.out.print("\tCard Expire Date :: ");
      this.ExpDate =sc.next();
      System.out.println("----------------------------------------------------------");
    }
    
    @Override 
    public void pay(int amount) {   
      System.out.println("----------------------------------------------------------");
        System.out.println("Paying through CreditCard payment: Charging ₹ " + amount);
        System.out.println("----------------------------------------------------------");
    }
    

}

class PayPal implements PaymentProcessor {
  Scanner sc =new Scanner (System.in);
    String Email, pwd;

  PayPal(){
    super();
    System.out.print("\tEmail :: ");
      this.Email =sc.nextLine();
    System.out.print("\tPassword :: ");
      this.pwd =sc.nextLine();
    System.out.println("----------------------------------------------------------");
    System.out.println("\nChecking Internet Connection........");  
     }
     
  @Override
   public void pay(int amount) {  
    System.out.println("----------------------------------------------------------");
    System.out.println("Paying through PayPal payment: Charging ₹ " + amount);
    System.out.println("----------------------------------------------------------");
    }

  }

class BitCoin implements PaymentProcessor {
  Scanner sc =new Scanner (System.in);
  String add;
     
  BitCoin(){
       super();
       System.out.print("\nEnter Transaction 'Destination Address' :: ");
       add= sc.next();
       
     }
  
  @Override
  public void pay(int amount) {   
      System.out.println("----------------------------------------------------------");
        System.out.println("Paying through BitCoin payment: Charging ₹ " + amount);
        System.out.println("----------------------------------------------------------");
    }

}

class Order {

  private final PaymentProcessor paymentProcessor;
  private final int amount;
     

  public Order(int amount, PaymentProcessor paymentProcessor) {
       this.amount = amount;
       this.paymentProcessor = paymentProcessor;
     }
     
  
  public void process() {
       paymentProcessor.pay(amount);
     }

}

