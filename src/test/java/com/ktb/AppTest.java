package com.ktb;

import static org.junit.Assert.assertTrue;

import com.ktb.model.ClassRoom;
import com.ktb.model.Student;
import com.ktb.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Test;

/**
 * Unit test for simple App.
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
}
