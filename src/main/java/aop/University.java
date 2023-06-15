package aop;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class University {
    private List<Student> students = new ArrayList<Student>();

    public void addStudents() {
        Student st = new Student("Pershin", 4, 4.8);
        students.add(st);

        Student st2 = new Student("Bizin", 4, 4.9);
        students.add(st2);

        Student st3 = new Student("Oleynik", 4, 4.2);
        students.add(st3);
    }

    public List<Student> getStudents() {
        System.out.println("Entering 'getStudents'");
        students.get(2);
        System.out.println("Students:");
        System.out.println(students);
        return students;
    }
}
