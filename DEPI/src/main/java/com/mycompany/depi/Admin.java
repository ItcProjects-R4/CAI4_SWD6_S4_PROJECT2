package com.mycompany.depi;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter; 
import java.io.IOException;
import java.util.Scanner;

public class Admin {
    private ArrayList<Student> students;
    private ArrayList<Course> courses;
    
    public Admin() {
        students = new ArrayList<>();
        courses = new ArrayList<>();
        reading();
    }
    
    File stuFile = new File("C:\\Users\\Abdelrahman_Zaki\\Documents\\NetBeansProjects\\DEPI\\src\\main\\java\\com\\mycompany\\depi\\Students.txt");
    File couFile = new File("C:\\Users\\Abdelrahman_Zaki\\Documents\\NetBeansProjects\\DEPI\\src\\main\\java\\com\\mycompany\\depi\\Courses.txt");
    
    
    
    public void reading(){
        try (Scanner in = new Scanner(stuFile)) {
            while (in.hasNextLine()) {
                String str = in.nextLine();
                int id = Integer.parseInt(str);
                String name = in.nextLine();
                str = in.nextLine();
                float grade = Float.parseFloat(str);
                Student s = new Student(id,name);
                s.setGrade(grade);
                students.add(s);
            }
        }catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
        try (Scanner in = new Scanner(couFile)) {
            while (in.hasNextLine()) {
                String code = in.nextLine();
                String name = in.nextLine();
                Course c = new Course(code,name);
                courses.add(c);
            }
        }catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    public void stuWriting(){
        try {
            FileWriter stuWriter = new FileWriter("C:\\Users\\Abdelrahman_Zaki\\Documents\\NetBeansProjects\\DEPI\\src\\main\\java\\com\\mycompany\\depi\\Students.txt");
            for(Student s: students){
                int id = s.getId();
                stuWriter.write(String.valueOf(id)+"\n");
                stuWriter.write(s.getName()+"\n");
                double x = s.getGrade();
                stuWriter.write(String.valueOf(x)+"\n");
            }
            stuWriter.close();
        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    public void couWriting(){
        try {
            FileWriter couWriter = new FileWriter("C:\\Users\\Abdelrahman_Zaki\\Documents\\NetBeansProjects\\DEPI\\src\\main\\java\\com\\mycompany\\depi\\Courses.txt");
            for(Course c: courses){
                couWriter.write(c.getCourseCode()+"\n");
                couWriter.write(c.getCourseName()+"\n");
            }
            couWriter.close();
        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    public boolean addStudent(Student student){
        if(!students.isEmpty()){
        for(Student s : students){
            if(s.getId() == student.getId()){
                return false;
            }
        }
        }
        students.add(student);
        stuWriting();
        return true;
    }
    
    public boolean removeStudent(int id){
        for(int i = 0; i < students.size(); i++){
            if(students.get(i).getId() == id){
                students.remove(i);
                stuWriting();
                return true;
            }
        }

        return false;
    }
    
    public void viewAllStudents(){
        if(students.isEmpty())System.out.println("NO Students found");
        else {
            for(Student s : students){
                s.displayInfo();
                System.out.println("==============================");
            }
        }
    }
    
    public boolean addCourse(Course course){
        for(Course c : courses){
            if(c.getCourseCode().equals(course.getCourseCode())){
                return false;
            }
        }
       courses.add(course);
       couWriting();
       return true;
    }
    
    public void viewAllCourses(){
        if(courses.isEmpty())System.out.println("NO Courses found");
        else{
            for(Course c : courses){
                c.displayCourseInfo();
                System.out.println("==============================");
            }
        }
    }
    
    public boolean setGrade(int id,float grade){
        for(Student s : students){
            if(s.getId() == id){
                int i = students.indexOf(s);
                Student target = students.get(i);
                target.setGrade(grade);
                stuWriting();
                return true;
            }
        }
        return false;
    }
}
