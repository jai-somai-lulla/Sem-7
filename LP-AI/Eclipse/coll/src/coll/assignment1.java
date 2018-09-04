package coll;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
      
public class assignment1 {
   
    public static void main(String args[])
    {
        int n,ch,ch1;
       
        Scanner scan = new Scanner(System.in);
     
     do
     {
        System.out.println("\n\t\t\t\t\t$ Menu Card $");
        System.out.println(" 1].USE LINKEDLIST");
        System.out.println(" 2].USE STACK");
        System.out.println(" 3].USE QUEUE");
        System.out.println("\t\tEnter Your Choice :-");
        ch=scan.nextInt();
       
        switch(ch)
        {
            case 1 :
                    String[] arr= new String[20];
                    System.out.print("\nEnter the Total No of Data:-");
                    n = scan.nextInt();
   
                    for (int i = 0; i < n; i++)
                    {
                        System.out.println("\nEnter Data  " +(i + 1));
                        arr[i] = scan.next();
                    }
                   
                    List L = new LinkedList();
                    for (int i = 0; i < n; i++)
                    {
                       L.add(arr[i]);
                    }
                    System.out.println("Size :-" + L);
                    break;
       
            case 2 :
                    STACK(scan);    
         
                    break;
       
            case 3 :
                    QUEUE(scan);
               
                    break;                  
        }
          System.out.println("do you want to continue(1/0) To Main page");
          ch1=scan.nextInt();
      }while(ch1!='1');   
    }
   
    public static void STACK(Scanner scan)
    {
        int ch5;
        Stack ST = new Stack();
    do
    {
       
        System.out.println("\t\t\t\t\t\t $ Menu card $ ");
        System.out.println("1] Add into stack");
        System.out.println("2] Pop from stack");
        System.out.println("3] Size of stack");
        System.out.println("4] Search Element");
        System.out.println("Enter the Choice :-");
        int ch3=scan.nextInt();
   
 
        switch(ch3)
        {
            case 1:
                    System.out.print("\n PUSH DATA:-");
                    String S=scan.next();
                    ST.push(S);
                           
                    System.out.println("PRINT DATA:-");
                    System.out.println(ST);
                break;
           
            case 2:
                    System.out.println(ST.pop());
                break;
               
            case 3:
                    System.out.println(ST.size());
                break;
               
            case 4:
                    System.out.println("Enter the Element which you want to Search :-");
                    String S1=scan.next();
                   
                    int pos=ST.search(S1);
                   
                    if(pos==-1)
                    {
                        System.out.println("Data not found !!!");
                    }
                    else
                    {
                        System.out.println("Data Found At Position :-"+pos);
                    }
                   
                break;           
        }   
            System.out.println("do you want to continue(1/0) To Stack");
            ch5=scan.nextInt();   
        }while(ch5==1);              
    }
   
    public static void QUEUE(Scanner scan)
    {
        int ch5;
        Queue<String> q = new LinkedList();
    do
    {
       
        System.out.println("\t\t\t\t\t\t $ Menu card $ ");
        System.out.println("1] Add into Queue");
        System.out.println("2] Pop from Queue");
        System.out.println("3] Size of Queue");
          System.out.println("Enter the Choice :-");
        int ch3=scan.nextInt();
  
        switch(ch3)
        {
            case 1:
                    System.out.print("\n PUSH DATA:-");
                    String S=scan.next();
                    q.add(S);
                           
                    System.out.println("PRINT DATA:-");
                    System.out.println(q);
                break;
           
            case 2:
                    System.out.println(q.remove());
                break;
               
            case 3:
                    System.out.println(q.size());
                break;
             
        }   
            System.out.println("do you want to continue(1/0) To Queue");
            ch5=scan.nextInt();   
        }while(ch5==1);              
    }
}




