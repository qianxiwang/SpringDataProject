package com.imooc.repository;

import com.imooc.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by Administrator on 2017/11/30.
 */
public interface EmployeeJpaSpecificationExectorRepository
        extends JpaRepository<Employee,Integer> ,JpaSpecificationExecutor<Employee>{
}
