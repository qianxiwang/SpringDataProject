package com.imooc.repository;

import com.imooc.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

/**
 * Created by Administrator on 2017/11/30.
 */
public class EmployeeJpaSpecificationExectorRepositoryTest {

    private ApplicationContext ctx = null;
    private EmployeeJpaSpecificationExectorRepository employeeJpaSpecificationExectorRepository = null;

    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeJpaSpecificationExectorRepository = ctx.getBean(EmployeeJpaSpecificationExectorRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        ctx = null;
        System.out.println("tearDown");
    }

    /**
     * 1.分页
     * 2.排序
     * 3.查询条件:age > 50
     */
    @Test
    public void testQuery(){
        Sort.Order order = new Sort.Order(Sort.Direction.DESC,"id");
        Sort sort =new Sort(order);

        //page:index是从0开始的 ，
        PageRequest pageable =new PageRequest(0,5,sort);

        /**
         * root:就是我们要查询的类型
         * query:就是查询条件
         * cb:构建Predicate
         */
        Specification<Employee> specification = new Specification<Employee>() {
            public Predicate toPredicate(Root<Employee> root,
                                         CriteriaQuery<?> query,
                                         CriteriaBuilder cb) {
                //root (employee (age))
                Path path = root.get("age");
                return  cb.gt(path,50);
            }
        };

        Page<Employee> page =  employeeJpaSpecificationExectorRepository.findAll(specification,pageable);

        System.out.println("查询的总页数：" + page.getTotalPages());
        System.out.println("查询的总记录数：" + page.getTotalElements());
        System.out.println("查询的当前第几页：" + (page.getNumber() + 1));
        System.out.println("查询的当前页面的集合：" + page.getContent());
        System.out.println("查询的当前页面的记录数：" + page.getNumberOfElements());
    }



}
