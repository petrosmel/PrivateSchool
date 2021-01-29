/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privateschool;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Desktop
 */
public class CourseCombinationClass {

    private Course course = new Course();
    private List<Trainer> trainers = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
    private List<Assigment> assigment = new ArrayList<>();

    public CourseCombinationClass() {
    }

    public CourseCombinationClass(Course course, List<Trainer> trainers, List<Assigment> assigment) {
        this.assigment = assigment;
        this.course = course;
        this.trainers = trainers;
    }

    public CourseCombinationClass(Course course, List<Trainer> trainers, List<Assigment> assigment, List<Student> student) {
        this(course, trainers, assigment);
        this.students = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Trainer> getTrainers() {
        return trainers;
    }

    public void setTrainers(List<Trainer> trainers) {
        this.trainers = trainers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Assigment> getAssigment() {
        return assigment;
    }

    public void setAssigment(List<Assigment> assigment) {
        this.assigment = assigment;
    }

    @Override
    public String toString() {
        return "CourseCombinationClass{" + "course=" + course + ", trainers=" + trainers + ", students=" + students + ", assigment=" + assigment + '}';
    }

}
