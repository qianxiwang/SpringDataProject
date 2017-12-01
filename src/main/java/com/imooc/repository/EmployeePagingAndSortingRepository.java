package com.imooc.repository;

import com.imooc.domain.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Administrator on 2017/11/30.
 */
public interface EmployeePagingAndSortingRepository  extends PagingAndSortingRepository<Employee,Integer>{
}
