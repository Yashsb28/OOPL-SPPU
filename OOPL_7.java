/*Implement a generic program using collection class to count the number of elements in the collection that have a specific property such as even numbers,
odd numbers, prime numbers and palindromes.*/

import java.util.*;
import java.lang.*;

public class Main {
    static int count = 0;
    static Scanner scan = new Scanner(System.in);

    static void integer(){
        int n, element, choice;
        ArrayList <Integer> arrayList = new ArrayList<Integer>();
        System.out.println("Enter the number of elements: ");
        n = scan.nextInt();
        for(int i = 0; i < n; i++){
            System.out.println("Enter the element " + (i+1) +": " );
            element = scan.nextInt();
            arrayList.add(element);
        }
        System.out.println("Elements are: " + arrayList);
        do {
            System.out.println("\nSelect the operation You want to perform: ");
            System.out.println("1. Odd or Even");
            System.out.println("2. Prime or Not");
            System.out.println("3. Main menu");
        System.out.print("Choice -> ");
        choice = scan.nextInt();
        Iterator<Integer> iterator = arrayList.iterator();

        while(iterator.hasNext()){
            check(choice, (int)iterator.next());
        }
        if(choice == 1){
            System.out.println();
            System.out.println("The count of even number: " + count);
            System.out.println("The count odd number: " + (arrayList.size()-count));
            System.out.println();
        }if(choice == 2){
            System.out.println();
            System.out.println("The count of prime number: " + count);
            System.out.println("The count of non-prime number: " + (arrayList.size()-count));
            System.out.println();
        }if(choice == 3){
          main(null);
        }
        } while (choice != 3);

    }

    static void string(){
        String word;
        int n, choice;
        ArrayList <String> stringList = new ArrayList<String>();
        System.out.println("Enter the number of elements: ");
        n = scan.nextInt();

        for(int i = 0; i < n; i++){
            System.out.println("Enter the element " + (i+1) +": ");
            word = scan.next();
            stringList.add(word);
        }
        System.out.println();

        Iterator<String> iterator = stringList.iterator();
        System.out.println("Elements are: " + stringList);
        System.out.println("Select the operation You want to perform: ");
        System.out.println("2.1 Palindrome");
        choice = scan.nextInt();

        while(iterator.hasNext()){
            string_Check(choice, (String)iterator.next());
        }
        System.out.println();
    }

    static void string_Check(int choice, String word){
        switch(choice){
            case 1:
                palindrome(word);
                break;

            default:
                System.out.println("Enter a valid choice.");
                break;
        }
    }

    static void palindrome(String word){
        StringBuilder s1 = new StringBuilder(word);
        System.out.println();
        if(word.equals(s1.reverse().toString())){
            System.out.println("The "+ word +" String is Palindrome.");
        }else{
            System.out.println("The "+ word +" String is Not Palindrome.");
        }
    }

    static void check(int choice, int x){
        switch(choice){
            case 1:
                System.out.println();
                even_odd(x);
                break;

            case 2:
                System.out.println();
                prime(x);
                break;
            
            case 3:
                main(null);

            default:
                System.out.println();
                System.out.println("Select correct choice");
                break;
        }
    }
    static void even_odd(int x){
        if(x%2==0){
            System.out.print(x + " is a Even Number.");
            count++;
        }else{
            System.out.print(x + " is Odd Number.");
        }
    }

    static void prime(int x){
        boolean isPrime = true;
        for(int i = 2; i < x; i++){
            if(x % i == 0) {
                isPrime = false;
                break;
            }
        }
        if(isPrime){
            if(x == 1){
                System.out.println(x +" is nor prime nor a composite number.");
            }else{
                count++;
                System.out.println(x +" is prime number.");
            }
        }else{
            System.out.println(x +" is not a prime number");
        }
    }

    public static void main(String[] args) {
        int choice;
        Scanner scan = new Scanner(System.in);
        do {
        System.out.print("*********************");
        System.out.print("\n\tGENERICS MENU\n");
        System.out.print("*********************");
        System.out.println("\nSelect your choice:");
        System.out.println("1.Integer");
        System.out.println("2.String");
        System.out.println("3.Exit Program");
        System.out.print("Choice -> ");
        choice = scan.nextInt();
        System.out.println();

        switch (choice){
            case 1 :
                integer();
                break;

            case 2 :
                string();
                break;

            case 3 :
                System.exit(0);
                break;

            default:
                System.out.println("Invalid choice.");
                break;
        }
        } while (choice != 3);
    }
}
