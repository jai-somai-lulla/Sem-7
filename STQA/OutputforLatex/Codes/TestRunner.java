/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author groot
 */
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
   public static void main(String[] args) {
      Result result = JUnitCore.runClasses(LoginSuite.class);		
      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }		
      System.out.println("LOGIN ALL TESTS :"+result.wasSuccessful());
      
      
      result = JUnitCore.runClasses(SignupSuite.class);
      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }
      System.out.println("SIGNUP ALL TESTS:"+result.wasSuccessful());
      
      
      result = JUnitCore.runClasses(IssueSuite.class);
      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }
      System.out.println("ISSUE ALL TESTS:"+result.wasSuccessful());
   }
}  	