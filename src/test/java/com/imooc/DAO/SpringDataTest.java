package com.imooc.DAO;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

import javax.sql.DataSource;

/**
 * Created by Administrator on 2017/11/29.
 */
public class SpringDataTest {
    private ApplicationContext ctx = null;
    private StudentDAO studentDAO = null;

    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void testEntityManagerFactory(){

    }

}
