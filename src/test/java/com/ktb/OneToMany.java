package com.ktb;


import com.ktb.model.onetomany.A;
import com.ktb.model.onetomany.B;
import com.ktb.model.onetomany.Department;
import com.ktb.model.onetomany.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Test;
import java.util.ArrayList;


public class OneToMany {
    @Test
    public void Test(){
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        //2. 根据服务注册类创建一个元数据资源集，同时构建元数据并生成应用一般唯一的的session工厂
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        /****上面是配置准备，下面开始我们的数据库操作******/
        Session session = sessionFactory.openSession();//从会话工厂获取一个session
        session.getTransaction().begin();

        Department department = new Department();
        department.setDepartmentName("Sales");


        Employee emp1 = new Employee("Nina", "Mayers", "111");
        Employee emp2 = new Employee("Tony", "Almeida", "222");

        department.setEmployees(new ArrayList<Employee>());
        department.getEmployees().add(emp1);
        department.getEmployees().add(emp2);

        session.save(department);

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void TestA(){
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        //2. 根据服务注册类创建一个元数据资源集，同时构建元数据并生成应用一般唯一的的session工厂
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.openSession();//从会话工厂获取一个session
        session.getTransaction().begin();

        B b= new B();
        A a = new A();
        a.bs.add(b);
        session.save(a);


        session.getTransaction().commit();
        session.close();
    }
}
