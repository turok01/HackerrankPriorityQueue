package com.Igor;
import java.util.*;

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
    public List<Student> getStudents(List<String> events){
        int served = 0;
        Comparator<Student> studentComparator = new StudentCgpaComparator().
                thenComparing(new StudentNameComparator().
                        thenComparing(new StudentIdComparator()));
        PriorityQueue<Student> studentPriorityQueue = new PriorityQueue<Student>(events.size(),
                studentComparator);
        for(String event : events){
            if(event.equals("SERVED")) served++;
            //else
                //event.
        }
        return studentPriorityQueue;
    }
}
public class Main {
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

