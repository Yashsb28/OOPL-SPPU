import java.util.*;

class publication {   
    private String title;
    private int copies;
    private int price;
    private int total;

    Scanner sc = new Scanner (System.in); 

    public void title (String title) {
      this.title = title;
    }
    public void setcopies (int copies) {
      this.copies = copies;
    }

    public String gettitle() {
      return title;
    }

    public int getTotal() {
      return total;
    }
    public int getCopies() {
      return copies;
    }

    public int getprice() {
      return price;
    }

    void input_pub() {
      //Input Info of Book or Magazine
      System.out.println("Enter Title : ");
      title=sc.next();
      System.out.println("Enter Price : ");
      price=sc.nextInt();
      System.out.println("Enter Copies : ");
      copies=sc.nextInt();
    }

    void display() {
      System.out.println(title+"\t"+price+"\t\t"+copies);
    }

    void sale(int num) {
      if(num <= copies) {
        copies = copies - num;
        total = total + (num * price) ;
        System.out.println("\tORDER SUCCESFUL!!! \n\t You purchased "+num+" copies \n\t AMOUNT PAID = Rs "+(price*num));
      }
      else {
        System.out.println("OUT OF STOCK!!!");
      }
    }

}

class book extends publication {   //Subclass BOOK
    private String author;
    
    void orderCopies(int num) {
      int x= getCopies() + num;
      setcopies(getCopies() + num);
      System.out.println("ORDER SUCCESFUL!!!");
      System.out.println("AVAILABLE COPIES : "+x);
    }

    void input_book() {
      input_pub();
      System.out.println("Enter Author Name : ");
      author=sc.next();
    }

    void display_book() {
      System.out.println("Title \t\tPrice \tCopies \tAuthor");
      display();
      System.out.println("\t"+author);
    }
}

class magazine extends publication {
  private int orderQty;
  private String currentIssue;

  void receiveIssue(String new_issue_date) {
    System.out.println("ENTER NEW COPIES ORDERED : ");
    orderQty = sc.nextInt();

    setcopies(orderQty);

    currentIssue = new_issue_date;
    System.out.println("\tTHE MAGAZINE "+gettitle()+" \n\t with Issue date "+ currentIssue +" Available");
  }

  void input_magazine() {
    input_pub();
    System.out.println("Enter Current Issue Date (dd/mm/yyyy) : ");
    currentIssue = sc.next();
  }

  void display_magazine() {
    System.out.println("Title \t\tPrice \tCopies ");
    display();
    System.out.println("Date :- "+currentIssue);
  }
}

public class Main {
  public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
    book b = new book();
    magazine m = new magazine();

    int counter;
    do {
      System.out.println("+++ PUBLICATION MENU +++"+"\n 1. BOOK SECTION "+
                        "\n2. MAGAZINE SECTION \n3.SALE OF PUBLICATION");
      System.out.println("Choice => ");
      int choice = sc.nextInt();
      int a;

      bb:
      if(choice==1){
        
        do {
          int ch1;
          System.out.print("+++ BOOK SECTION +++\n");
          System.out.print("1. INPUT BOOK \n2.DISPLAY BOOK \n3.SALE COPIES \n4.ORDER NEW COPIES");
          System.out.print("\nChoice : ");
          ch1 = sc.nextInt();
          switch(ch1) {
            case 1 : 
         System.out.println("----------------------------------------------");
              b.input_book();
         System.out.println("----------------------------------------------");
              break;

            case 2 : 
         System.out.println("----------------------------------------------");
              b.display_book();
         System.out.println("----------------------------------------------");
              break;

            case 3 :
        System.out.println("-----------------------------------------------");
              System.out.print("HOW MANY COPIES TO SALE (to customer) : ");
              int n1 = sc.nextInt();
              b.sale(n1);
        System.out.println("-----------------------------------------------");
              break;
            
            case 4 : 
        System.out.println("-----------------------------------------------");
              System.out.print("HOW MANY COPIES TO ORDER : ");
              int n2 = sc.nextInt();
              b.orderCopies(n2);
        System.out.println("-----------------------------------------------");
              break;

            default :
              System.out.println("Invalid");
          }

          System.out.println("1.BOOK SECTION AGAIN \t 2.LEAVE\n");
          System.out.println("Choice => ");
          a=sc.nextInt();
          if(a==0)
              break bb;
        } 
          while(a==1);
        }

        else if (choice == 2) {
          mm : 
          do {
          int ch2;
          System.out.print("+++ MAGAZINE SECTION +++\n");
          System.out.print("1. INPUT MAGAZINE \n2.DISPLAY MAGAZINE \n3.SALE COPIES \n4.RECEIVE ISSUE DATE");
          System.out.print("\nChoice : ");
          ch2 = sc.nextInt();
          switch(ch2) {
            case 1 : 
         System.out.println("----------------------------------------------");
              m.input_magazine();
         System.out.println("----------------------------------------------");
              break;

            case 2 : 
         System.out.println("----------------------------------------------");
              m.display_magazine();
         System.out.println("----------------------------------------------");
              break;

            case 3 :
        System.out.println("-----------------------------------------------");
              System.out.print("HOW MANY COPIES TO SALE (to customer) : ");
              int n3 = sc.nextInt();
              m.sale(n3);
        System.out.println("-----------------------------------------------");
              break;
            
            case 4 : 
        System.out.println("-----------------------------------------------");
              System.out.print("ENTER NEW ISSUE DATE : ");
              String date = sc.next();
              m.receiveIssue(date);
        System.out.println("-----------------------------------------------");
              break;

            default :
              System.out.println("Invalid");
          }

          System.out.println("1.MAGAZINE SECTION AGAIN \t 2.LEAVE\n");
          System.out.println("Choice => ");
          a=sc.nextInt();
          if(a==0)
              break mm;
        } 
          while(a==1);
          }
          else if(choice==3) {
            System.out.println("\n TOTAL SALE AMOUNT= Rs"+(b.getTotal()+m.getTotal()));
          }
          else 
              System.out.println("Invalid !!!");
          System.out.println("1. PUBLICATION \n0. LEAVE");
          counter = sc.nextInt();
        } while(counter != 0);
        sc.close();
      
    
  }
}
