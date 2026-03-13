package com.mycompany.depi;
import java.util.Scanner;
public class DEPI {
    static Scanner in = new Scanner(System.in);
    
    public static void displayMenu(){
       
        System.out.println("__________Welcome Back__________");
        System.out.println("\n\n1.Add Student\n2.View Students\n3.Add Course\n4.View Courses\n5.Record Grade\n6.Delete Student\n7.EXIT\n");
    }
    
    public static boolean checkAdmin(){
        
        String userName = "", password = "";
        boolean first = true;
        while(true){
            if(!first)System.out.println("Wrong inputs try again");
            
            System.out.print("Username: ");
            userName = in.next();
            System.out.print("Password: ");
            password = in.next();
            first = false;
            if( "Admin".equals(userName)&& "password".equals(password)){
                return true;
            }
        }
    }
    
    public static void addStudent(Admin admin){
        System.out.print("Student ID: ");
        int id = in.nextInt();
        in.nextLine();
        System.out.print("Student Name: ");
        String name = in.nextLine();
        Student s = new Student(id,name);
        if(!admin.addStudent(s)){
            System.out.println("This ID is alrady used!");
            addStudent(admin);
        }
        else System.out.println("\n\nStudent added successfully");
        System.out.println("\n\nPress \"Enter\" to continue ");
        in.nextLine();
        in.nextLine();
    }
    
    public static void viewStudents(Admin admin){
        for(int i = 0 ;i<50;i++)System.out.println("");
        in.nextLine();
        admin.viewAllStudents();
        System.out.println("\n\n\n\nPress \"Enter\" to continue ");
        in.nextLine();
        
    }
    
    public static void addCourse(Admin admin){
        System.out.print("Course Code: ");
        in.nextLine();
        String code = in.nextLine();
        System.out.print("Course Name: ");
        String name = in.nextLine();
        Course c = new Course(code,name);
       if(!admin.addCourse(c)){
            System.out.println("This ID is alrady used!");
            addCourse(admin);
        }
        else System.out.println("Course added successfully");
        System.out.println("\n\nPress \"Enter\" to continue ");
        in.nextLine();
        in.nextLine();
    }
    
    public static void viewCourses(Admin admin){
        for(int i = 0 ;i<50;i++)System.out.println("");
        in.nextLine();
        admin.viewAllCourses();
        System.out.println("\n\n\n\nPress \"Enter\" to continue ");
        in.nextLine();
    }
    
    public static void recordGrade(Admin admin){
        System.out.print("Enter studesnt ID: ");
        int id  = in.nextInt();
        System.out.print("Enter Grade: ");
        float grade = in.nextFloat();
        if(admin.setGrade(id, grade)){
            System.out.println("Grade Recorded Successfully.");
        }
        else System.out.println("Student not found.");
        System.out.println("\n\nPress \"Enter\" to continue ");
        in.nextLine();
        in.nextLine();
    }
    
    public static void deleteStudent(Admin admin){
        System.out.print("Enter Student ID: ");
        int id = in.nextInt();
        System.out.print("You will Remove Student with ID -> " + id + " <- are you sure ? 'Y/N' ");
        char choice = in.next().charAt(0);
        if(choice == 'N'||choice == 'n');
        else if(choice == 'Y'||choice == 'y'){
            boolean authorithed = checkAdmin();
            if(authorithed){
                if(admin.removeStudent(id))
                    System.out.println("Removed Seccessfully");
                else System.out.println("Not found");
            }
            else {
                System.out.println("Access denied !!");
            }
        }
        else System.out.println("\n\nInvalid input ");
        System.out.println("\n\nPress \"Enter\" to continue ");
        in.nextLine();
        in.nextLine();
    }
    
    
    public static void main(String[] args) {
        checkAdmin();
        for(int i = 0;i < 50;i++){
            System.out.println("");
        }
        Admin admin = new Admin();
        while(true){
            displayMenu();
            char choice = in.next().charAt(0);
            switch(choice){
                case '1':addStudent(admin);break;
                case '2':viewStudents(admin);break;
                case '3':addCourse(admin);break;
                case '4':viewCourses(admin);break;
                case '5':recordGrade(admin);break;
                case '6':deleteStudent(admin);break;
                case '7':System.exit(0);break;
                default:break;
            }
        }
        
        
    }
    
}
