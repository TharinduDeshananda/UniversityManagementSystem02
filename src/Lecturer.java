/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
import java.util.Scanner;
/**
 *
 * @author Tharindu Deshananda
 */
public class Lecturer {
    private String name;
    private String username;
    private String password;
    private int[] courses;
    private int age;

    Lecturer(){}
    Lecturer(String n,String un,String p,int[] arr,int a){
        name=n;
        username=un;
        password=p;
        courses=new int[arr.length];
        for(int x : arr){
            courses[x]=arr[x];

        }
        age=a;
    }

    public void regLecturer(){
        try{
            Scanner sc=new Scanner(System.in);
            System.out.println("Lecturer Registration Form\n");
            System.out.println("Name :");
            name=sc.nextLine();
            System.out.println("User name :");
            username=sc.nextLine();
            System.out.println("Password :");
            password=sc.nextLine();
            System.out.println("Age :");
            age=sc.nextInt();
            String str,str2;
            System.out.println("Select the Courses :\n[1] SENG 11111 - Object Oriented Programming\n[2] SENG 11112 - Introduction To Programming\n[3] SENG 11123 - Project Management");
            str=sc.nextLine();
            str=sc.nextLine();
            str2=str+",";

            String[] strarr=str2.split(",");
            int[] iarr=new int[strarr.length];
            for(int i=0;i<strarr.length;++i){
                iarr[i]=Integer.parseInt(strarr[i]);
            }

            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/umsystem","root","tharindu");
            Statement stm=con.createStatement();

            stm.executeUpdate("insert into lecturer(name,username,password,age) values('"+name+"','"+username+"','"+password+"','"+age+"');");
            for(int i=0;i<iarr.length;++i){
                stm.executeUpdate("insert into course(username,password,cnumber) values('"+username+"','"+password+"','"+iarr[i]+"');");
            }

            String crs[]={"SENG 11111 - Object Oriented programming","SENG 11112 - Introduction to Databases","SENG 11123 - Project Management"};
            System.out.println("You have Successfully registered for the following courses");
            for(int i=0;i<iarr.length;++i){
                System.out.println(crs[i]);
            }

            con.close();
        }catch(Exception e){System.out.println(e);}

    }


    public void showLecturer(){
        System.out.println("Lecturer login form");
        Scanner sc=new Scanner(System.in);
        System.out.println("User Name :");
        String uname=sc.nextLine();
        System.out.println("Password :");
        String pword=sc.nextLine();

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/umsystem","root","tharindu");
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery("select * from lecturer where username='"+uname+"' and password='"+pword+"'");
            if(!rs.next()){System.out.println("You are not registered");  return;}
            System.out.println("Hi!\n"+rs.getString("name"));
            System.out.println("You have successfully registered for following courses.. ");
            rs=stm.executeQuery("select cnumber from course where username='"+uname+"' and password='"+pword+"'");
            String[] crs={"Object Oriented Programming","Introduction to Databases","Project Management"};
            while(rs.next()){
                System.out.println(crs[rs.getInt("cnumber")-1]);

            }
            con.close();
        }catch(Exception e){System.out.println(e);}



    }

}
