package com.example.demo.dao;

import com.example.demo.classes.MyUser;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

public class DaoUser {
    private JdbcTemplate jdbcTemplate;
    public DaoUser() {
        DriverManagerDataSource ds=new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://175.178.213.250:3306/ChuCi");
        ds.setUsername("manager1");
        ds.setPassword("xbpcL8tTCCFPSdfR");

        jdbcTemplate=new JdbcTemplate();
        jdbcTemplate.setDataSource(ds);
    }
    public int insertTable(String UID,String username,String password,String email){
        String sql = "insert into User(UID,username,password,email) values(?,?,?,?)";
        return jdbcTemplate.update(sql,new Object[]{UID,username,password,email});
    }

    public List<MyUser> selectTableByUID(String UID){
        String sql = "select * from User where UID='"+UID+"'";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(MyUser.class));
    }
    public List<MyUser> selectTableByEmail(String email){
        String sql = "select * from User where email='"+email+"'";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(MyUser.class));
    }
}
