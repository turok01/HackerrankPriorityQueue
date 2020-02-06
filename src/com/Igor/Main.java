package com.Igor;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
/*
 * Create the Student and Priorities classes here.
 */
class Student{
    int id;
    String name;
    double cgpa;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }
    public void Student(int id, String name, double cgpa){
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
}
class StudentCgpaComparator implements Comparator<Student>{
    public int compare(Student s1, Student s2){
        if(s1.cgpa<s2.cgpa)
            return -1;
        else
            if(s1.cgpa>s2.cgpa)
                return 1;
            else
                return 0;
    }
}
class StudentNameComparator implements Comparator<Student>{
    public int compare(Student s1, Student s2){
        return s1.name.compareTo(s2.name);
    }
}
class StudentIdComparator implements Comparator<Student>{
    public int compare(Student s1, Student s2){
        return s1.id - s2.id;
    }
}
class Priorities{

}
public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}

