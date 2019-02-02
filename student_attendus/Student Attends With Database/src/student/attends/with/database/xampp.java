/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.attends.with.database;

import java.io.IOException;

/**
 *
 * @author ahmed
 */
public class xampp 
{
    int startzamp() 
            
    {
                  try{
                  Process process = Runtime.getRuntime().exec("C:\\xampp\\xampp_start.exe");
                  Process process1 = Runtime.getRuntime().exec("C:\\xampp\\mysql\\bin\\mysqld.exe");
                  return 1;
                  }
                  catch(Exception x)
                  {
                  String s;
                  s=x.getMessage();
                  System.out.println(s);
                  return 0;
                  
                  }
                 
                          
              
    }
}
