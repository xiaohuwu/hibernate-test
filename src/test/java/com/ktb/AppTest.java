package com.ktb;

import static org.junit.Assert.assertTrue;

import com.ktb.model.*;
import com.sun.javafx.tk.Toolkit;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.junit.Test;

import java.util.*;

/**
 * Unit test for simple App.
 *
 * 通过hibernate来进行插入操作的时候，不管是一对多、一对一还是多对多，
 * 都只需要记住一点，在哪个实体类声明了外键，就由哪个类来维护关系
 * 在保存数据时，总是先保存的是没有维护关联关系的那一方的数据，
 * 后保存维护了关联关系的那一方的数据
 */


public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue(){
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        //2. 根据服务注册类创建一个元数据资源集，同时构建元数据并生成应用一般唯一的的session工厂
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        /****上面是配置准备，下面开始我们的数据库操作******/
        Session session = sessionFactory.openSession();//从会话工厂获取一个session

        System.out.println(" /****上面是配置准备，下面开始我们的数据库操作******/");
       /* Student student1 =  session.get(Student.class,8);
        System.out.println("[Student]:"+student1.getRoom().getClassName());*/
        Transaction transaction = session.beginTransaction();//开启一个新的事务
        Student student = new Student();
        ClassRoom room = new ClassRoom();
        room.setClassName("一班121");
        student.setRoom(room);
        student.setAge(20);
        student.setName("xiaohu");
        session.save(student);
        session.close();
        //transaction.commit();
    }

    @Test
    public void testOneToOne(){
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        //2. 根据服务注册类创建一个元数据资源集，同时构建元数据并生成应用一般唯一的的session工厂
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        /****上面是配置准备，下面开始我们的数据库操作******/
        Session session = sessionFactory.openSession();//从会话工厂获取一个session

        /*Person person = new Person();
        person.setName("张三");
        session.save(person);*/
      /*  System.out.println("[person][id]"+person.getId());*/
        Person person = session.get(Person.class,1);
        IDCard idCard = new IDCard();
        idCard.setNo("18589717969");
        idCard.setPerson(person);
        session.save(idCard);
        session.close();
    }

    @Test
    public void testOneToMany(){
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        //2. 根据服务注册类创建一个元数据资源集，同时构建元数据并生成应用一般唯一的的session工厂
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        /****上面是配置准备，下面开始我们的数据库操作******/
        Session session = sessionFactory.openSession();//从会话工厂获取一个session
        Transaction transaction = session.beginTransaction();
       /* ClassRoom classRoom = new ClassRoom();
        classRoom.setClassName("一班");
        session.save(classRoom);

        Student student = new Student();
        student.setName("小虎");
        student.setAge(30);
        student.setRoom(classRoom);
        session.save(student);*/

       /* ClassRoom classRoom = session.get(ClassRoom.class, 19);
        Set<Student> students = classRoom.getStudents();
        for(Student student :students){
            System.out.println("[student]:"+student.toString());
        }
        transaction.commit();*/
        session.close();


    }



    @Test
    public void testManyToMany(){
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        //2. 根据服务注册类创建一个元数据资源集，同时构建元数据并生成应用一般唯一的的session工厂
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        /****上面是配置准备，下面开始我们的数据库操作******/
        Session session = sessionFactory.openSession();//从会话工厂获取一个session

        Transaction transaction = session.beginTransaction();

        /* Teacher teacher = new Teacher();
        teacher.setName("语文");
        session.save(teacher);

        Course course = new Course();
        course.setName("小猪");
        course.addTeacher(teacher);
        session.save(course);*/

       /* List<Course> list = session.createQuery("from Course").list();
        for(Course course1 :list){
            System.out.println(course1.toString());
            Set<Teacher> teachers = course1.getTeachers();
            for(Teacher teacher :teachers){
                System.out.println(teacher.getName());
            }
        }*/

        List<Course> list = session.createQuery("from Course  where name=:name").setParameter("name","小猪").list();
        Course course =  list.get(0);
        System.out.println("[course]:"+course.getTeachers().get(0).toString());

        transaction.commit();
        session.close();
    }

    @Test
    public void createTable(){

        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        Metadata metadata = new MetadataSources(serviceRegistry)
                .buildMetadata();

        new SchemaExport()
                .setOutputFile("db-schema.hibernate5.ddl")
                .create(EnumSet.of(TargetType.SCRIPT), metadata);

        metadata.buildSessionFactory().close();
    }


}
