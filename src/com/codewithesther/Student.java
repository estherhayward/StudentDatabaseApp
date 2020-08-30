package com.codewithesther;

import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private int year;
    private String courses = "";
    private static int costOfCourse = 600;
    private double tuitionBalance = 0;
    private String studentID;
    private static int id = 1000;


    public Student () {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter first name: ");
        this.firstName = in.nextLine();
        System.out.print("Enter last name: ");
        this.lastName = in.nextLine();
        System.out.println("1 - 1st year\n2 - 2nd year\n3 - 3rd year\n4 - 4th year\nEnter year:");
        this.year = in.nextInt();

        setStudentID();
    }

    private void setStudentID() {
        id++;
        this.studentID = this.year + "" + this.id;
    }

    public void enrollInCourse() {
        Scanner in = new Scanner(System.in);

        do {
            System.out.print("Enter the course name you want to enroll in. Type q to finish: ");
            String course = in.nextLine();
            if (!course.equals("q")) {
                this.courses+= "\n  " + course;
                this.tuitionBalance+= this.costOfCourse;
            } else {
                break;
            }
        } while (true);
    }

    public void payTuition() {
        viewTuitionBalance();

        Scanner in = new Scanner(System.in);
        double paymentAmount;

        do {
            System.out.print("Enter payment amount: €");
            paymentAmount = in.nextDouble();
            if ((this.tuitionBalance - paymentAmount) < 0) {
                System.out.println("The entered amount is too much. Only €" + this.tuitionBalance + " is required.");
            }
        } while ((this.tuitionBalance - paymentAmount) < 0);

        this.tuitionBalance-= paymentAmount;
        System.out.println("Your payment of €" + paymentAmount + " is succesful");

        viewTuitionBalance();
    }

    public String getCourses() {
        return this.courses;
    }

    public void viewTuitionBalance() {
        System.out.println("Your tuition balance is: €" + this.tuitionBalance);
    }

    public String getStudentID() {
        return this.studentID;
    }

    public String showInfo() {
        return "Name: " + this.firstName + " " + this.lastName +
                "\nYear: " + this.year +
                "\nID: " + this.id +
                "\nEnrolled courses: " + this.courses +
                "\nTuition balance: €" + this.tuitionBalance;
    }
}
