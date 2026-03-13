
package com.mycompany.depi;
/**
 *
 * @author Abdelrahman_Zaki
 */
public class Student {
    private final int id;
    private final String name;
    private double grade;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
    public void displayInfo(){
        System.out.println("ID: " + this.id);
        System.out.println("Name: " + this.name);
        System.out.println("Grade: " + this.grade);
    }
}
