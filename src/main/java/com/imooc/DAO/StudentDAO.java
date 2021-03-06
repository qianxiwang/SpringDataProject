package com.imooc.DAO;

import com.imooc.domain.Student;

import java.util.List;

/**
 * StudentDAO访问接口
 */
public interface StudentDAO {
    /**
     * 查询所有的学生
     * @return 所有学生
     */
    public List<Student> query();

    /**
     * 添加一个学生
     * @param student
     */
    public void save(Student student);
}
