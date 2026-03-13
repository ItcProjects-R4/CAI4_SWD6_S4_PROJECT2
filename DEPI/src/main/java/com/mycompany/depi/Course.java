package com.mycompany.depi;

/**
 *
 * @author Abdelrahman_Zaki
 */
public class Course {
    private final String courseCode;
    private final String courseName;  

    public Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }
    public void displayCourseInfo(){
        System.out.println("Code: " + this.courseCode);
        System.out.println("Name: " + this.courseName);
    }
}
