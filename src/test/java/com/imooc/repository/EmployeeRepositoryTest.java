package com.imooc.repository;

import com.imooc.domain.Employee;
import com.imooc.repository.EmployeeRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/30.
 */
public class EmployeeRepositoryTest {

    private ApplicationContext ctx = null;
    private EmployeeRepository employeeRepository = null;

    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeRepository= ctx.getBean(EmployeeRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void testFindByName(){
       Employee employee = employeeRepository.findByName("zhangsan");
       System.out.println("id:"+employee.getId()+ ",name:"+ employee.getName()+",age:"+employee.getAge());
    }

    @Test
    public void testfindByNameStartingWithAndAgeLessThan(){
        List<Employee> employees = employeeRepository.findByNameStartingWithAndAgeLessThan("test",22);

        for(Employee employee:employees){
            System.out.println("id:"+employee.getId()+ ",name:"+ employee.getName()+",age:"+employee.getAge());
        }

    }

    @Test
    public void testfindByNameEndingWithAndAgeLessThan(){
        List<Employee> employees = employeeRepository.findByNameEndingWithAndAgeLessThan("6",23);

        for(Employee employee:employees){
            System.out.println("id:"+employee.getId()+ ",name:"+ employee.getName()+",age:"+employee.getAge());
        }

    }

    @Test
    public void testfindByNameInOrAgeLessThan(){
        List<String> names = new ArrayList<String>();
        names.add("test1");
        names.add("test2");
        names.add("test3");
        List<Employee> employees = employeeRepository.findByNameInOrAgeLessThan(names,22);

        for(Employee employee:employees){
            System.out.println("id:"+employee.getId()+ ",name:"+ employee.getName()+",age:"+employee.getAge());
        }

    }

    @Test
    public void testfindByNameInAndAgeLessThan(){
        List<String> names = new ArrayList<String>();
        names.add("test1");
        names.add("test2");
        names.add("test3");
        List<Employee> employees = employeeRepository.findByNameInAndAgeLessThan(names,22);

        for(Employee employee:employees){
            System.out.println("id:"+employee.getId()+ ",name:"+ employee.getName()+",age:"+employee.getAge());
        }

    }

    @Test
    public void testgetEmployeeByMaxId(){
       Employee employee = employeeRepository.getEmployeeByMaxId();
        System.out.println("id:"+employee.getId()+ ",name:"+ employee.getName()+",age:"+employee.getAge());

    }

    @Test
    public void testqueryParams1(){
        List<Employee> employees = employeeRepository.queryParams1("zhangsan",20);
        for(Employee employee:employees){
            System.out.println("id:"+employee.getId()+ ",name:"+ employee.getName()+",age:"+employee.getAge());
        }
    }

    @Test
    public void testqueryParams2(){
        List<Employee> employees = employeeRepository.queryParams2("zhangsan",20);
        for(Employee employee:employees){
            System.out.println("id:"+employee.getId()+ ",name:"+ employee.getName()+",age:"+employee.getAge());
        }
    }

    @Test
    public void testqueryLike1(){
        List<Employee> employees = employeeRepository.queryLike1("test");
        for(Employee employee:employees){
            System.out.println("id:"+employee.getId()+ ",name:"+ employee.getName()+",age:"+employee.getAge());
        }
    }

    @Test
    public void testqueryLike2(){
        List<Employee> employees = employeeRepository.queryLike2("test1");
        for(Employee employee:employees){
            System.out.println("id:"+employee.getId()+ ",name:"+ employee.getName()+",age:"+employee.getAge());
        }
    }

    @Test
    public void testgetCount(){
        long count = employeeRepository.getCount();
            System.out.println("count:"+count);
    }


}
