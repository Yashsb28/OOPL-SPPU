/* Using concepts of Object Oriented programming develop solution for any one application
1) Banking solution contains following operations such as 1. Create an account 2.Deposit money
3.Withdraw money 4. Honor daily withdrawal limit 5. Check the balance 6. Display Account
information.
2) Inventory management contains followingoperations such as List of all products 2. Display
individual product information 3. Purchase 4. Shipping 5.Balance stock 6. Loss and Profit
calculation */

import java.util.Scanner;


class Customer { 
  private String customerName;   
  private int customerAge;   
  public void setCustomerName(String customerName){ 
    this.customerName=customerName;  
    }       
  
  public String getCustomerName(){     
    return customerName;   
    }        
  
  public void setCustomerAge(int customerAge){    
    this.customerAge=customerAge;
    }       
  
  public int getCustomerAge(){       
    return customerAge;  
    }
  
} 

abstract class Account {  
  protected double balance; 
  protected int accountId;  
  protected String accountType; 
  protected Customer custobj;  
  
   void setBalance(double balance){    
    this.balance=balance;   
    }        
   
   double getBalance(){  
    return balance;  
    }        
   
   void setAccountId(int accountId){ 
    this.accountId=accountId;   
    }       
   
   int getAccountId(){      
    return accountId; 
    }       
   
   void setAccountType(String accountType){     
    this.accountType=accountType;  
    }   
   
   String getAccountType(){    
    return accountType; 
    }  
   
   void setCustomerObject(Customer custobj){     
    this.custobj=custobj; 
    }       
   
   Customer getCustomerObject(){    
    return custobj;    
    }
   
  public abstract boolean withdraw(double amount); 
  
} 

//SAVING ACCOUNT CLASS
class SavingsAccount extends Account{  
   
   private double minimumBalance;       
   public void setMinimumBalance(double minimumBalance){ 
     this.minimumBalance=minimumBalance;    
     }    
   
   public double getMinimumBalance(){      
     return minimumBalance;  
     }  

   public boolean withdraw(double amount){
     
     if((balance-amount)>minimumBalance){ 
            
       balance-=amount;          
       return true;       
       }         
     else        
       return false; 
     }
   }  


class Bank {     
  public static Scanner sc=new Scanner(System.in);  
  public SavingsAccount a=new SavingsAccount();   
  public Customer c=new Customer();        
  
  public SavingsAccount createAccount(){  
    sc.nextLine();      
    
    System.out.print("Enter your name: ");    
    String customername=sc.nextLine();    
    c.setCustomerName(customername);  
    
    System.out.print("Enter your age: ");     
    int customerage=sc.nextInt();         
    if(customerage<18){
      do{              
        System.out.print("Minimum age should be 18 to create an account.\nPlease enter valid age: ");      
        customerage=sc.nextInt();   
        }while(customerage<18); 
      }                  
    c.setCustomerAge(customerage); 
    
    a.setCustomerObject(c);
    
    System.out.print("Enter your account Id: ");   
    int accountid=sc.nextInt(); 
    a.setAccountId(accountid); 
    
    System.out.print("Enter your account type: ");   
    String accounttype=sc.next();      
    a.setAccountType(accounttype); 
    
    System.out.print("Enter balance: ");         
    double balance=sc.nextDouble();
    a.setBalance(balance);
    
    System.out.print("Enter minimum balance: ");        
    double minbalance=sc.nextDouble(); 
    a.setMinimumBalance(minbalance); 
    
                  
    return a;                    
    } 
  
  
   void getWithdrawAmount(){     
    System.out.print("Enter the amount you want to withdraw: ");           
    double amount=sc.nextDouble();          
    if(amount>20000){           
      System.out.println("Withdrawal failed. Maximum limit of withdrawal in one transaction is Rs.20000.");       
      }     
    else{  
      if(a.withdraw(amount)==true){ 
        System.out.println("Withdrawal successful. Balance is: "+a.getBalance());  
        }             
      else              
        System.out.println("Sorry!!! Not enough balance"); 
      }         
    }         
   
   public void depositAmount(double amount){      
     double bal=a.getBalance()+amount;            
     a.setBalance(bal);          
     System.out.println("Amount deposited successfully. Balance is: "+a.getBalance());  
     }     
   
   public void checkBalance(){   
       System.out.println("Balance is: "+a.getBalance());     
       }              
   public void displayAccountInformation(){   
     System.out.println("Welcome "+c.getCustomerName()+"! Following are your account details:");
     //display name of customer
     System.out.println("Age :"+c.getCustomerAge());    
     System.out.println("Account Id: "+a.getAccountId());      
     System.out.println("Account Type: "+a.getAccountType()); 
     System.out.println("Balance: "+a.getBalance());       
     System.out.println("Minimum balance: "+a.getMinimumBalance());    
     } 
 }

 
 
 

 public class Main{
   public static void main(String[] args){   
     Scanner sc=new Scanner(System.in);  
     SavingsAccount a;
     Bank bm=new Bank(); 
    
     do{       
       
      System.out.print("*************************");
      System.out.print("\n\tBANK MANAGEMENT\n");
      System.out.print("*************************");
       System.out.println("\n\t1.Create Account\n\t2.Display Account\n\t3.Check Balance"
          + "\n\t4.Deposit Amount\n\t5.Withdraw Amount\n\t6.Exit"); 
      System.out.println("------------------------");              
       System.out.print("Enter your choice: ");       
       int choice=sc.nextInt();             
       System.out.println("");   
       switch(choice)     
       {             
       case 1:
         a=bm.createAccount();    
         System.out.println("=================================================");
         break;                         
       case 2:
         bm.displayAccountInformation();  
         System.out.println("=================================================");
         break;                            
       case 3:
         bm.checkBalance();      
         System.out.println("=================================================");
         break;                                             
       case 4:
         System.out.print("Enter the amount you want to deposit: ");  
         double amount=sc.nextDouble();                      
         bm.depositAmount(amount);       
         System.out.println("=================================================");
         break;                                               
       case 5:
         bm.getWithdrawAmount();          
         System.out.println("=================================================");
         break;
       case 6:
         System.out.println("=================================================");
         return ; 
       default:
         System.out.println("INVALID INPUT !!");
         System.out.println("=================================================");
         break;                                       
       }   
            
       }while(true);     
     }
 }

