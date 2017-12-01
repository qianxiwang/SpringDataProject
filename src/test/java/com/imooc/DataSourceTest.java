package com.imooc;


import com.imooc.DAO.StudentDAO;
import com.imooc.DAO.StudentDAOImpl;
import com.imooc.domain.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.util.List;

public class DataSourceTest {
    private ApplicationContext ctx = null;
    private StudentDAO studentDAO = null;

    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        studentDAO=(StudentDAO)ctx.getBean("studentDAO");
        System.out.println("setup");
    }

    @After
    public void tearDown(){
    ctx = null;
    System.out.println("tearDown");
    }

    @Test
    public void testdatasource() {
        System.out.println("testDataSource");
        DataSource dataSource = (DataSource) ctx.getBean("dataSource");
        Assert.notNull(dataSource);
    }

    @Test
    public void testJdbcTemplate() {
        System.out.println("testDataSource");
        JdbcTemplate jdbcTemplate = (JdbcTemplate)ctx.getBean("jdbcTemplate");
        Assert.notNull(jdbcTemplate);
    }

    @Test
    public void testQuery(){
        List<Student> students = studentDAO.query();
        for(Student student : students){
            System.out.println("id:"+ student.getId()+" name:"+student.getName()+" age:"+student.getAge());
        }
    }

    @Test
    public void testsave(){
        Student student = new Student();
        student.setName("test-spring-jdbc");
        student.setAge(40);

        studentDAO.save(student);
    }
}
