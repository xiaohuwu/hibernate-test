package com.ktb.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="course")
public class Course
{
    private int id;
    private String name;
    private List<Teacher> teachers;

    public Course()
    {
        teachers = new ArrayList<>();
    }

    public void addTeacher(Teacher teacher)
    {
        teachers.add(teacher);
    }
    @ManyToMany(cascade = CascadeType.ALL) //　ManyToMany指定多对多的关联关系
    @JoinTable(name="teacher_course", joinColumns={ @JoinColumn(name="course_id")},
            inverseJoinColumns={ @JoinColumn(name = "teacher_id") })//　　因为多对多之间会通过一张中间表来维护两表直接的关系，所以通过 JoinTable 这个注解来声明，name就是指定了中间表的名字，JoinColumns是一个 @JoinColumn类型的数组，表示的是我这方在对方中的外键名称，我方是Course，所以在对方外键的名称就是 rid，inverseJoinColumns也是一个 @JoinColumn类型的数组，表示的是对方在我这放中的外键名称，对方是Teacher，所以在我方外键的名称就是 tid
    public List<Teacher> getTeachers()
    {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers)
    {
        this.teachers = teachers;
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

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teachers=" + teachers +
                '}';
    }
}