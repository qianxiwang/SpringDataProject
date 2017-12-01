package com.imooc.DAO;

import com.imooc.domain.Student;
import com.imooc.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;

/**
 * StudentDAO访问接口实现类：通过最原始的jdbc的方式操作
 */
public class StudentDAOImpl implements StudentDAO {
    public List<Student> query() {

        List<Student> students = new ArrayList<Student>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql ="select id,name,age from student";
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement= connection.prepareStatement(sql);
            resultSet =  preparedStatement.executeQuery();

            Student student = null;
            while (resultSet.next()){
                int id  = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");

                student = new Student();
                student.setAge(id);
                student.setName(name);
                student.setAge(age);

                students.add(student);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(resultSet,preparedStatement,connection);
        }

        return students;
    }

    public void save(Student student) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql ="insert into student(name,age) values(?,?)";
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setInt(2,student.getAge());
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(resultSet,preparedStatement,connection);
        }
    }
}
