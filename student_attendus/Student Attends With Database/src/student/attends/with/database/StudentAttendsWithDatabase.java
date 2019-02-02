/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.attends.with.database;


import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Ahmed Raza
 */
public class StudentAttendsWithDatabase 
{
   public static void main(String[] args) throws IOException
            {
                
             int a;
               xampp xp=new xampp();
               a=xp.startzamp();
               System.out.println(a);
                
                LoginForm login=new  LoginForm();
               login.lf();
                    
            }
    
}

//////////////////////////////////////////////////////
////////////////////////////////////////////////////
/////////////////////////////////////////////////////


class LoginForm  implements ActionListener 
{
	
	JFrame jf;
	Container c;
	JButton cancel;
	JButton login;
	JTextField unjtf; //User Name J Text Field
	JPasswordField pasjtf; // Password J Text Field
	public void lf()  
	{
                    jf=new JFrame("Student Attendance");
                    jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
                    jf.setVisible(true);
                    jf.setBounds(400,200,400,400);
                    jf.setLayout(null); //for Cancel layout of java enviroment
                    c= jf.getContentPane();



                    JLabel unlab=new JLabel("User Name");
                    c.add(unlab);
                    unlab.setBounds(100,50,200,30);



                     unjtf=new JTextField();
                    c.add(unjtf);
                    unjtf.setBounds(100,80,200,30);


                    JLabel paslab=new JLabel("Password");
                    c.add(paslab);
                    paslab.setBounds(100,110,200,30);



                     pasjtf=new JPasswordField();
                    c.add(pasjtf);
                    pasjtf.setBounds(100,140,200,30);



                     login=new JButton("LOG IN");
                    c.add(login);
                    login.setBounds(100,190,200,30);

                    login.addActionListener(this);


                     cancel=new JButton("Exit");
                    c.add(cancel);
                    cancel.setBounds(100,240,200,30);

                    cancel.addActionListener(this);


}
public void actionPerformed(ActionEvent e)  
        
            {
                    if(e.getSource()==login)
                        
                                {
                                 String un="admin",pas="11223344";
                                 String username=unjtf.getText();
                                 String password=pasjtf.getText();
                                 
                                        if(username.equals(un) && pas.equals(password))
                                                {
                                                     JLabel wellcom=new JLabel("wellcom user how may I help you");
                                                     c.add(wellcom);
                                                     jf.setVisible(false);
                                                     wellcom.setBounds(100,300,200,30);
                                                               
                                                                 TestConnection tc=new  TestConnection();
                                                                 tc.Dansc();

                                                }
                                        
                                        else
                                            
                                                {
                                                        JLabel wrong=new JLabel("Incrooccet password or user name");
                                                        c.add(wrong);
                                                        wrong.setBounds(100,300,200,30);

                                                }


                                }

                    if(e.getSource()==cancel)
                    {
                    System.exit(1);
                    }

}
}
//////////////////////////////////////////
///////////////////////////////////////////////
/////////////////////////////////////////////////

//////////////////////////////////////////////////
//////////////connection test////////////////////////////////////
//////////////////////////////////////////////////

class TestConnection  implements ActionListener
{
    JFrame jf;
    JLabel  l1,l2,l3,l4;
    JButton b1,b2;
    void Dansc()
    {
       
        jf=new JFrame("Attendus");
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.setBounds(400,200,400,400);
        jf.setLayout(null);
        Container c= jf.getContentPane();
        b1=new JButton("OKAY");
        c.add(b1);
        b1.setBounds(100,200,180,30);
        b1.addActionListener(this);
        b2=new JButton("RETRY");
        c.add(b2);
        b2.setBounds(100,240,180,30);
        b2.addActionListener(this);
        
                try
                    {
                      
                        Class.forName("com.mysql.jdbc.Driver");
                        System.out.println("Driver loded Succesfully ");
                        l1=new JLabel(" Driver loded Succesfully ");
                        c.add(l1);
                        l1.setBounds(100,50,200,30);
                    }
                          
                catch(ClassNotFoundException e)
                   {
                       String message;
                        message=e.getMessage();
                        System.out.println("Mysql Driver For java NotFound" );
                        l1=new JLabel(" Mysql Driver For java NotFound ");
                        c.add(l1);
                        l1.setBounds(100,50,200,30);
                         l2=new JLabel(message);
                        c.add(l2);
                        l2.setBounds(50,120,300,30);
                   }

                 try
                   {
                       Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "");
                       System.out.print("connection is okay ");
                        l1=new JLabel("Connection Has Build To Mysql ");
                        c.add(l1);
                        l1.setBounds(90,100,200,30);
                   }
                catch(Exception f)
                    {
                        String message;
                        message=f.getMessage();
                        System.out.println("sql exception"+f.getMessage());
                        l1=new JLabel("can not build connection to Data Base start Mysql ");
                        c.add(l1);
                        l1.setBounds(50,100,300,30);
                        
                        l2=new JLabel(message);
                        c.add(l2);
                        l2.setBounds(50,120,300,30);
                    }    
    }

    public void actionPerformed(ActionEvent z)  
		{
                        if(z.getSource()==b1)
                            {
                                 jf.setVisible(false);
                                   SelectClass sc=new SelectClass();
                                   sc.sclass();
                            }
                        
                        if(z.getSource()==b2)
                            {
                                 jf.setVisible(false);
                            TestConnection tc=new TestConnection();
                            tc.Dansc();
                            }
                }
    
}

////////////////////////////////////
////////////////////////main menu/////////////////////////////////////////////////////////////////////////////////////////// 
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////
class SelectClass implements ActionListener
{
        JFrame jf;
        JLabel  l1;
        JButton b1,b2,b3,b4; 
            void sclass()
            {
                jf=new JFrame("SELECT");
                jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
                jf.setVisible(true);
                jf.setBounds(400,200,400,400);
                jf.setLayout(null);
                Container c= jf.getContentPane();
                l1=new JLabel(" Chosse Any options ");
                c.add(l1);
                l1.setBounds(100,50,180,20);
                
                        b1=new JButton("Create New Class");
                        c.add(b1);
                        b1.setBounds(100,100,180,30);
                        b1.addActionListener(this);
                        b2=new JButton("Take Attedus ");
                        c.add(b2);
                        b2.setBounds(100,150,180,30);
                        b2.addActionListener(this);
                        b3=new JButton(" Search  ");
                        c.add(b3);
                        b3.setBounds(100,200,180,30);
                        b3.addActionListener(this);
                        b4=new JButton("EXIT");
                        c.add(b4);
                        b4.setBounds(100,250,180,30);
                        b4.addActionListener(this);
        
            }
            
             public void actionPerformed(ActionEvent z)  
		{
                        if(z.getSource()==b1)
                            {
                              CreateDataBase ctdb=new CreateDataBase(); 
                              ctdb.cdb();
                              jf.setVisible(false);
                            }
                        
                        if(z.getSource()==b2)
                            {
                        
                           jf.setVisible(false);
                          TakeAttendus tk=new TakeAttendus();
                                   tk.adc();  
                            }
                        
                        if(z.getSource()==b3)
                            {
                                  jf.setVisible(false);
                             search sr=new search();
                                sr.srch();
                            }
                        
                        if(z.getSource()==b4)
                            {
                                  jf.setVisible(false);
                             System.exit(1);
                            }
                }
}
//////////////////////////////////////////////////////////////////////////
/////////////////b1 create Dataase////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////
class CreateDataBase implements ActionListener
{
    JFrame jf;
    JButton b1,b2;
    JTextField jtf;
    JLabel l1,l2;
      Container c;
    void cdb()/// create data class for store student data
    {
        jf=new JFrame("CREATE DATABASE");
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.setBounds(400,200,400,400);
        jf.setLayout(null);
        
        c= jf.getContentPane();
        l1=new JLabel("please Enter The Class Name");
        c.add(l1);
        l1.setBounds(100,50,180,30);
        
        l2=new JLabel("");
        c.add(l2);
        l2.setBounds(50,300,300,30);
        
        jtf=new  JTextField ("");
        c.add(jtf);
        jtf.setBounds(100,100,180,30);

        b1=new JButton("OKAY");
        c.add(b1);
        b1.setBounds(100,150,180,30);
        b1.addActionListener(this);
          
        b2=new JButton("BACK");
        c.add(b2);
        b2.setBounds(100,200,180,30);
        b2.addActionListener(this);
          
    }
    
public void actionPerformed(ActionEvent z)  
    {
        if(z.getSource()==b1)
           {
                     String db=jtf.getText();
                     String d="create database ";
                     String u="use ";
                     u=u+db;
                     d=d+db;
            try
                {
                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "");
                        System.out.print("connection is okay ");
                        Statement statement = connection.createStatement();
                        statement.executeUpdate(d);
                        statement.executeUpdate(u);
                        statement.executeUpdate("create table Student (Roll_NO char(15) primary key, Student_Name varchar(50), total_days smallint  ,  total_present_days smallint  ,  total_absent_days smallint)");
                        jf.setVisible(false);
                        SaveRecord svr=new SaveRecord(); 
                             svr.sr(db);
                      
                }
            catch(Exception f)
                {
                    
                        
                        String message;
                        message=f.getMessage();
                        System.out.println("sql exception"+f.getMessage());
                        jf.setVisible(false);
                        cdb();
                        
                        l2=new JLabel(message);
                        c.add(l2);
                        l2.setBounds(50,300,300,50);
                } 
                     
            }
                    if(z.getSource()==b2)
                    {
                           
                          jf.setVisible(false);
                          SelectClass sc=new SelectClass();
                          sc.sclass();
                    
                    }
                  
    }
} 
//////////////////////////////////////////////////////////////
//////////////////  saved student rcord////////////////////
////////////////////////////////////////////////////////////

class SaveRecord implements ActionListener
{
    JFrame jf;
    JButton b1,b2;
    JTextField jtf1,jtf2,jtf3;
    JLabel l1,l2,l3;
    String db,rollnum,name;
    Container c;
    void sr(String db)
    {
        jf=new JFrame("SAVE RECORDS");
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.setBounds(400,200,400,400);
        jf.setLayout(null);
        
        c= jf.getContentPane();
        l1=new JLabel("       Class Name");
        c.add(l1);
        l1.setBounds(100,20,180,20);
        
        jtf1=new  JTextField (db);
        c.add(jtf1);
        jtf1.setBounds(100,40,180,30);
        
        l2=new JLabel("Enter Roll Number");
        c.add(l2);
        l2.setBounds(100,100,180,20);
        
        jtf2=new  JTextField (rollnum);
        c.add(jtf2);
        jtf2.setBounds(100,120,180,30);
        
        l3=new JLabel("Enter The Name");
        c.add(l3);
        l3.setBounds(100,150,180,20);
        
        jtf3=new  JTextField ("");
        c.add(jtf3);
        jtf3.setBounds(100,170,180,30);

        b1=new JButton("ENTER NEXT RECORD");
        c.add(b1);
        b1.setBounds(100,230,180,40);
        b1.addActionListener(this);
        
        b2=new JButton("FINSISH");
        c.add(b2);
        b2.setBounds(100,290,180,40);
        b2.addActionListener(this);
        
    }
    
    
       public void actionPerformed(ActionEvent z)  
		{
                    
                      if(z.getSource()==b1)
                      {
                            db=jtf1.getText();
                            rollnum=jtf2.getText();
                            name=jtf3.getText();
                            String u="use ";
                            String sql="insert into student "+"(Roll_NO,Student_Name,total_days,total_present_days,total_absent_days) "+"values ('"+rollnum+"','"+name+"',0,0,0)";
                            u=u+db;
                                    try
                                            {
                                                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "");
                                                 System.out.print("connection is okay ");
                                                 Statement statement = connection.createStatement();
                                                 statement.executeUpdate(u);
                                                 statement.executeUpdate(sql);
                                                 jf.setVisible(false);
                                                 sr(db);

                                            }
                                    catch(Exception f)
                                            {
                                                    String message;
                                                    message=f.getMessage();
                                                    System.out.println("sql exception"+f.getMessage());


                                                    l2=new JLabel(message);
                                                    c.add(l2);
                                                    l2.setBounds(50,300,300,50);
                                             } 
                      } 
                      
                        if(z.getSource()==b2)
                                {
                                    
                                    
                            db=jtf1.getText();
                            rollnum=jtf2.getText();
                            String name=jtf3.getText();
                            String u="use ";
                            String sql="insert into student "+"(Roll_NO,Student_Name) "+"values ('last','end')";
                             u=u+db;
                                    try
                                            {
                                                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "");
                                                 System.out.print("connection is okay ");
                                                 Statement statement = connection.createStatement();
                                                 statement.executeUpdate(u);
                                                 statement.executeUpdate(sql);
                                                 jf.setVisible(false);
                                                 

                                            }
                                    catch(Exception f)
                                            {
                                                    String message;
                                                    message=f.getMessage();
                                                    System.out.println("sql exception"+f.getMessage());


                                                    l2=new JLabel(message);
                                                    c.add(l2);
                                                    l2.setBounds(50,300,300,50);
                                    
                                    
                                            }
                                  jf.setVisible(false);
                                  SelectClass sc=new SelectClass();
                                           sc.sclass();
                                

                      
                                }                  
               }
}
////////////////////////////////////////////////////////////
///////////////////////////b2 take attendus//////////////////
/////////////////////////////////////////////////////////////

class TakeAttendus implements ActionListener
{
    JFrame jf;
    JButton b1,b2,b3;
    JTextField jtf1,jtf2;
    JLabel l1,l2;
    String db,date;
    String rollnum,studentname,firstrollnum;
    String chkrollnum,chkstudentname;
    String u="use ";
    int chk=1,chk1=1,chk2=1;
    Container c;
    
    
void adc()
{
        jf=new JFrame("Take Attendus");
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.setBounds(400,200,400,400);
        jf.setLayout(null);
        db="";
        c= jf.getContentPane();
        l1=new JLabel("please Enter The Class Name");
        c.add(l1);
        l1.setBounds(100,50,180,30);
        System.out.println(db);
        jtf1=new  JTextField ("");
        c.add(jtf1);
        jtf1.setBounds(100,80,180,30);
        
        
        
        l2=new JLabel("Enter Data like(17_nov_2017)");
        c.add(l2);
        l2.setBounds(100,130,180,30);
        jtf2=new  JTextField ("");
        c.add(jtf2);
        jtf2.setBounds(100,160,180,30);
        
       

        b1=new JButton("OKAY");
        c.add(b1);
        b1.setBounds(100,220,180,50);
        b1.addActionListener(this);
          
       
        
}
    
void WA()
{
  
   
        Statement statement=null;
        jf=new JFrame("Take Attendus");
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.setBounds(400,200,400,400);
        jf.setLayout(null);
        c= jf.getContentPane();
        
        b2=new JButton("Present");
        c.add(b2);
        b2.setBounds(100,150,180,40);
        b2.addActionListener(this);
        b3=new JButton("Absent");
        c.add(b3);
        b3.setBounds(100,200,180,40);
        b3.addActionListener(this);
        
        try
            {
                
               Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "");
               statement = connection.createStatement();
               statement.executeUpdate(u);

            }
        catch(Exception f)
            {
              String message;
              message=f.getMessage();
              System.out.println("sql exception"+f.getMessage()); 
            }
        
        try
        {
              ResultSet resultSet = statement.executeQuery("select Roll_NO,  Student_Name from Student ");
      
        while (resultSet.next())
                {
                 rollnum=resultSet.getString(1);
              
                if(rollnum.contains("last"))
                            {
                             jf.setVisible(false);
                             SelectClass sc=new SelectClass();
                             sc.sclass();
                            }
                    
                 if(chk1==1)
                            {
                           chk1=0;
                           chk=1;

                            studentname=resultSet.getString(2);
                            chkrollnum=rollnum;
                            System.out.println("roll num "+rollnum + "\t" +chkrollnum);
                            
                            l1=new JLabel("Roll Number       =    "+rollnum);
                            c.add(l1);
                            l1.setBounds(80,50,200,20);
                            l2=new JLabel("Student Name   = "+studentname);
                            c.add(l2);
                            l2.setBounds(80,80,200,20);
                            break;
                            } 

                 if(chkrollnum.contains(rollnum) || chk==0)
                            {
                            chk1=1;
                            }
                 }
        }
        catch(Exception x)
        {
            System.out.println(x.getMessage());
        }

}
    
    
    
public void actionPerformed(ActionEvent z)  
{
                    
  if(z.getSource()==b1)
                      {
                            db=jtf1.getText();
                            date=jtf2.getText();
                            
                           String sql="ALTER TABLE student add ("+date+" varchar(20))";
                           String sql1="UPDATE `student` SET `total_days`=total_days+1;";
                             u=u+db;
                             System.out.println(u);
                             
                                        try
                                            {
                                                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "");
                                                    Statement statement = connection.createStatement();
                                                    statement.executeUpdate(u);
                                                    statement.executeUpdate(sql);
                                                    statement.executeUpdate(sql1);
                                                    jf.setVisible(false);
                                                    WA();

                                            }
                          
                          catch(Exception f)
                                            {
                                                    String message;
                                                    message=f.getMessage();
                                                    System.out.println("sql exception"+f.getMessage());
                                                      jf.setVisible(false);
                                                         TakeAttendus tk=new TakeAttendus();
                                                                  tk.adc(); 

                                                  
                                                    l2=new JLabel(message);
                                                    c.add(l2);
                                                    l2.setBounds(50,300,300,50);
                                             } 
                      } 
                      
  if(z.getSource()==b2)
                       {
                        String sql="UPDATE student set "+date+" ='present' where '"+chkrollnum+"' =  Roll_NO";
                        String sql1="UPDATE `student` SET `total_present_days`=total_present_days+1 where '"+chkrollnum+"' =  Roll_NO ;";
                       

                       try
                                            {
                                                   Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "");
                                                   Statement statement = connection.createStatement();
                                                   statement.executeUpdate(u);
                                                   statement.executeUpdate(sql);
                                                   statement.executeUpdate(sql1);
                                                   jf.setVisible(false);
                                                   WA();
                                               
                                            }
                        
                        catch(Exception f)
                                            {
                                                   String message;
                                                   message=f.getMessage();
                                                   System.out.println("sql exception"+f.getMessage());
                                                   l2=new JLabel(message);
                                                   c.add(l2);
                                                   l2.setBounds(50,300,300,50);
                                             } 
                      } 
                      
                      
   if(z.getSource()==b3)
                        {
                         
                                                String sql="UPDATE student set "+date+" ='Absent' where '"+chkrollnum+"' =  Roll_NO";
                                                String sql1="UPDATE `student` SET `total_absent_days`=total_absent_days+1 where '"+chkrollnum+"' =  Roll_NO ;";
                        
                        try
                                            {
                                                   Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "");
                                                   System.out.print("connection is okay ");
                                                   Statement statement = connection.createStatement();
                                                   statement.executeUpdate(u);
                                                   statement.executeUpdate(sql);
                                                   statement.executeUpdate(sql1);
                                                   jf.setVisible(false);
                                                   WA();
                                              
                                            }
                        
                        catch(Exception f)
                                            {
                                                   String message;
                                                   message=f.getMessage();
                                                   System.out.println("sql exception"+f.getMessage());
                                                   l2=new JLabel(message);
                                                   c.add(l2);
                                                   l2.setBounds(50,300,300,50);
                                             } 
                      }
   
         }
                      
}                  

/////////////////////////////////////////////////////////////
//////////////////complet b2 take attendus///////////////////
////////////////////////////////////////////////////////////
 

class search implements ActionListener 
{
    
       String clas,rno,stdname,td,tpd,tad;
       int tday=1,tpday,taday,at_per;
 
	JFrame jf;
	Container c;
	JButton Search,mainmenu;

	JTextField classname; //class name
	JTextField rollnum; // primry key
	public void srch()  
	{
                    jf=new JFrame("Search Student Data");
                    jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
                    jf.setVisible(true);
                    jf.setBounds(400,200,700,400);
                    jf.setLayout(null); //for Cancel layout of java enviroment
                    c= jf.getContentPane();
                    
                    
                    
                    JLabel Name=new JLabel("student Name  ==  "+stdname);
                    c.add(Name);
                    Name.setBounds(400,50,200,30);
                    
                    JLabel rolno=new JLabel("Roll NO  ==  "+rno);
                    c.add(rolno);
                    rolno.setBounds(400,80,200,30);
                    
                        JLabel totaldays=new JLabel("Total Days  ==  "+td);
                    c.add(totaldays);
                    totaldays.setBounds(400,110,200,30);
                    
                    
                        JLabel totalpresentdays=new JLabel("Toatl Present Days  ==  "+tpd);
                    c.add(totalpresentdays);
                    totalpresentdays.setBounds(400,140,200,30);
                    
                    
                        JLabel totalabsentdays=new JLabel("Total Absent Days  ==  "+tad);
                    c.add(totalabsentdays);
                   totalabsentdays.setBounds(400,170,200,30);
                    
                   at_per = tpday*100;
                   at_per = at_per/tday;
                   
                    JLabel attendus_percent=new JLabel("percentage of present days  ==  "+at_per+"%");
                    c.add(attendus_percent);
                   attendus_percent.setBounds(400,200,500,30);



                    JLabel clasname=new JLabel("Please Enter The Class Of Student");
                    c.add(clasname);
                    clasname.setBounds(100,50,200,30);
                    classname=new JTextField();
                    c.add(classname);
                    classname.setBounds(100,80,200,30);


                    JLabel rolnum=new JLabel("Please Enter Roll No");
                    c.add(rolnum);
                    rolnum.setBounds(100,120,200,30);
                    rollnum=new JTextField();
                    c.add(rollnum);
                    rollnum.setBounds(100,150,200,30);




                  


                        Search=new JButton("SEARCH");
                        c.add(Search);
                        Search.setBounds(100,200,200,30);
                    Search.addActionListener(this);
         
         
                        mainmenu=new JButton("MAIN MENU");
                        c.add( mainmenu);
                        mainmenu.setBounds(100,240,200,30);
                        mainmenu.addActionListener(this);


}

    
    
    
    
    
    
    
    
    
       public void actionPerformed(ActionEvent z)  
		{
                        if(z.getSource()==Search)
                            {
                                String u="use ";
                                clas="";
                                        
                                        Statement statement=null;
                                        clas=classname.getText();
                                        rno=rollnum.getText();
                                        u=u+clas;
                                        
                                        System.out.println(clas);
                                         System.out.println(rno);
                                          System.out.println(u);
                                        
                                        
                                        
                                         try
            {
                
               Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "");
               statement = connection.createStatement();
               statement.executeUpdate(u);
               
                System.out.println(u); 
               
               
               
               

            }
        catch(Exception f)
            {
              String message;
              message=f.getMessage();
              System.out.println("sql exception"+f.getMessage()); 
            }
        
        try
        {
         
                   ResultSet resultSet = statement.executeQuery("select   Student_Name,total_days,  total_present_days,  total_absent_days  from Student where Roll_NO="+rno+" ");
                    System.out.println(rno); 
      
        while (resultSet.next())
                {
                    
                 stdname=resultSet.getString(1);
                 td=resultSet.getString(2);
                 tday=Integer.parseInt(td=resultSet.getString(2));
                 tpd=resultSet.getString(3);
                 tpday= Integer.parseInt(tpd=resultSet.getString(3));
                 tad=resultSet.getString(4);
                 taday=Integer.parseInt(tad=resultSet.getString(4));
                 System.out.println("Student name       ====> "+stdname); 
                 System.out.println("total days of class   =  "+td);
                 System.out.println("total present days    =  "+tpd);
                 System.out.println("total absent days     =  "+tad);
                       
                }
      
       
        }
        catch(Exception x)
        {
            System.out.println(x.getMessage());
        }
                                        
                                        
                                        
                                        
                                       jf.setVisible(false);
                                        srch();
                         
                          
                            }
                        
                        
                        
                        
                        
                        
                        if(z.getSource()==mainmenu)
                            {
                        
                          jf.setVisible(false);
                                   SelectClass sc=new SelectClass();
                                   sc.sclass();
                            }
                        
                   
                }    
    
    
    
    
    
    
    
    
    
    
}//////////////mainA