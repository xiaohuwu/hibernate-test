package com.ktb.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="teacher")
public class Teacher
{
    private int id;
    private String name;
    private List<Course> courses;

    public Teacher()
    {
        courses = new ArrayList<Course>();
    }

    public void addCourse(Course course)
    {
        courses.add(course);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    @ManyToMany(mappedBy="teachers")     //　表示由Course那一方来进行维护
    public List<Course> getCourses()
    {
        return courses;
    }
    public void setCourses(List<Course> courses)
    {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
