package com.sourav.spring.test.repository;

import com.sourav.spring.test.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Student student) {
        String sql = "insert into student (rollNumber, " +
                "name, marks, age, gender) values" +
                "(?,?,?,?,?)";
        int rowsCount = jdbcTemplate.update(sql,
                student.getRollNumber(),
                student.getName(), student.getMarks(),
                student.getAge(), student.getGender());
        System.out.println(rowsCount + " rows inserted");
    }

    public List<Student> findAll() {
        String sql = "select * from student";
        RowMapper<Student> mapper =  (rs, rowNum) -> {
                Student s1 = new Student();
                s1.setName(rs.getString("name"));
                s1.setRollNumber(rs.getInt("rollNumber"));
                s1.setMarks(rs.getInt("marks"));
                s1.setAge(rs.getInt("age"));
                s1.setGender(rs.getString("gender"));
                return s1;
        };
        return jdbcTemplate.query(sql, mapper);
    }

}
