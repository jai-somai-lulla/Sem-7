/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication19;

//import java.sql.Date;
import java.util.Comparator;

/**
 *
 * @author groot
 */
public class issue{
        String UID,Title,Description,Subject,Status,IID;
        int rating;
        //Date Date;
        String Date;
        public issue()
        {}
        
        
        public issue(String UID,String Title,String Description,String Subject,String IID,int rating,String Status,String Date){
            this.UID=UID;
            this.IID=IID;
            this.Title=Title;
            this.Description=Description;
            this.rating=rating;
            this.Subject=Subject;
            this.Status=Status;
            this.Date=Date;
        }
        public String get_title(){
            return Title;
        }
       public String get_description(){
            return Description;
        }
       public String get_subject(){
            return Subject;
        }
       public String get_date(){
            return Date;
        }
       public int get_rating(){
            return rating;
        }
       public String get_status(){
            return Status;
        }
       public static Comparator<issue> ratingComparatoraesc = new Comparator<issue>() {

	public int compare(issue s1, issue s2) {
	   int r1 = s1.get_rating();
	   int r2 = s2.get_rating();

	   //ascending order
           return r1-r2;
	   //descending order
           //return r2-r1;
       }};
        public static Comparator<issue> ratingComparatordesc = new Comparator<issue>() {

	public int compare(issue s1, issue s2) {
	   int r1 = s1.get_rating();
	   int r2 = s2.get_rating();

	   //ascending order
           //return r1-r2;
	   //descending order
           return r2-r1;
       }};
        
//        public static Comparator<issue> dateComparatordesc = new Comparator<issue>() {
//
//	public int compare(issue s1, issue s2) {
//	   Date r1 = s1.get_date();
//	   Date r2 = s2.get_date();
//
//	   //ascending order
//           //return r1-r2;
//	   //descending order
//           return r2.compareTo(r1);
//       }};
//         public static Comparator<issue> dateComparatoraesc = new Comparator<issue>() {
//
//	public int compare(issue s1, issue s2) {
//	   Date r1 = s1.get_date();
//	   Date r2 = s2.get_date();
//
//	   //ascending order
//           //return r1-r2;
//	   //descending order
//           return r1.compareTo(r2);
//       }};
    }