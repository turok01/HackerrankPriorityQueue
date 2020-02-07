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
    public Student(int id, String name, double cgpa){
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
class StudentCgpaDescendingComparator implements Comparator<Student>{
    public int compare(Student s1, Student s2){
        if(s1.cgpa<s2.cgpa)
            return 1;
        else
        if(s1.cgpa>s2.cgpa)
            return -1;
        else
            return 0;
    }
}
class StudentNameComparator implements Comparator<Student>{
    public int compare(Student s1, Student s2){
        return s1.name.compareTo(s2.name);
    }
}
class StudentNameDescendingComparator implements Comparator<Student>{
    public int compare(Student s1, Student s2){
        return s2.name.compareTo(s1.name);
    }
}
class StudentIdComparator implements Comparator<Student>{
    public int compare(Student s1, Student s2){
        return s1.id - s2.id;
    }
}
class StudentIdDescendingComparator implements Comparator<Student>{
    public int compare(Student s1, Student s2){
        return s2.id - s1.id;
    }
}
class Priorities{
    public List<Student> getStudents(List<String> events){
        int served = 0;
        Comparator<Student> studentComparator = new StudentCgpaComparator();
        Comparator<Student> studentDescendingComparator = new StudentCgpaDescendingComparator().
                thenComparing(new StudentNameComparator().
                        thenComparing(new StudentIdComparator()));
        PriorityQueue<Student> studentPriorityQueue = new PriorityQueue<Student>(events.size(),
                studentDescendingComparator);
        for(String event : events){
            Scanner sc = new Scanner(event);
            StringTokenizer st = new StringTokenizer( event," ");
            String servedToken = st.nextToken();
            String name;
            int id;
            double cgpa;
            if(servedToken.equals("SERVED")) {
                if(studentPriorityQueue.size()!=0)
                    studentPriorityQueue.poll();
            }
            else{
                name = st.nextToken();
                cgpa = Double.parseDouble(st.nextToken());
                id = Integer.parseInt(st.nextToken());
                studentPriorityQueue.add(new Student(id, name, cgpa));
            }
        }
        List <Student> studentList = new ArrayList<Student>(studentPriorityQueue.size());
        while(!studentPriorityQueue.isEmpty())
            studentList.add(studentPriorityQueue.poll());
        return studentList;
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

