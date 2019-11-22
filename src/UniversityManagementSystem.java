/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
import java.sql.*;

public class UniversityManagementSystem {


    public static void main(String[] args) {
        System.out.println("Welcome to University Management System!\n");
        while(true){

            System.out.println("Select [1] login, [2] sign in");
            int x; int y;
            Scanner sc=new Scanner(System.in);
            x=sc.nextInt();
            if(x==1){
                System.out.println("Please select your role [1] Student, [2] Lecturer");
                y=sc.nextInt();
                if(y==1){Student stu=new Student(); stu.showstudent();}
                else if(y==2){Lecturer lec=new Lecturer(); lec.showLecturer();}

            }
            else if(x==2){
                System.out.println("Please select your role [1] Student, [2] Lecturer");
                y=sc.nextInt();
                if(y==1){Student stu=new Student(); stu.regStudent();}
                else if(y==2){Lecturer lec=new Lecturer(); lec.regLecturer();}
            }
            System.out.println("\n\n");
        }

    }

}
