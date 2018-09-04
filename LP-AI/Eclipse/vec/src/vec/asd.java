package vec;


import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.Vector;

public class asd
{
    public static void main(String args[])
    {
        int ch;
        int opt;
       
        Scanner sc=new Scanner(System.in);
       
        do
        {
            System.out.println("\n\tMENU:\n");
            System.out.println("1.vector:\n");
            System.out.println("2.Array list\n");
            //System.out.println("3.stack:\n");
            //System.out.println("4.Queue:\n");
            System.out.println("\n\tEnter your choice:-");
            ch=sc.nextInt();
           
            switch(ch)
            {
            case 1:
                    Vector<String> vec= new Vector<String>(2);
                   
                    vec.addElement("ajinkya");
                    vec.addElement("Hinal");
                    vec.addElement("Mayur");
                    vec.addElement("aditya");
                   
                     System.out.println("Size is: "+vec.size());
                     System.out.println("Default capacity increment is: "+vec.capacity());
                    
                     vec.addElement("fruit1");
                     vec.addElement("fruit2");
                     vec.addElement("fruit3");
                    
                     System.out.println("Size after addition: "+vec.size());
                     System.out.println("Capacity after increment is: "+vec.capacity());
                    
                     Enumeration en = vec.elements();
                     System.out.println("\nElements are:");
                     while(en.hasMoreElements())
                         System.out.print(en.nextElement() + " ");
                     break;
                    
             case 2:
                 ArrayList<Integer> a=new ArrayList<Integer>();
                 a.add(7);
                 a.add(17);
                 a.add(72);
                 a.add(77);
                //2 a.add(70);
                 
                 System.out.println("The actual List:-"+a);
                 a.remove(17);
                 System.out.println("After removing list is:-"+a);
                 break;
                    
            }
            System.out.println("\nDo you want to continue(1/0):-");
            opt=sc.nextInt();
           
        }while(opt==1);
    }
}