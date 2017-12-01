package com.imooc.repository;

import com.imooc.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/11/30.
 */
public class EmployeeJpaRepositoryTest {
    private ApplicationContext ctx = null;
    private EmployeeJpaRepository employeeJpagRepository = null;

    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeJpagRepository = ctx.getBean(EmployeeJpaRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void testFind(){
        Employee employee = employeeJpagRepository.findOne(99);
        System.out.println("employee："+ employee);

        System.out.println("employee（10）："+ employeeJpagRepository.exists(10));
        System.out.println("employee（102）："+ employeeJpagRepository.exists(102));
    }


}
