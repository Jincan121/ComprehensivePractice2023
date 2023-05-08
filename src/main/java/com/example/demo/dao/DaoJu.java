package com.example.demo.dao;

import com.example.demo.classes.Ju;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

public class DaoJu {
    private JdbcTemplate jdbcTemplate;
    public DaoJu() {
        DriverManagerDataSource ds=new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://175.178.213.250:3306/ChuCi");
        ds.setUsername("manager1");
        ds.setPassword("xbpcL8tTCCFPSdfR");

        jdbcTemplate=new JdbcTemplate();
        jdbcTemplate.setDataSource(ds);
    }

    public List<Ju> selectTableByRand(){
        String sql = "select * from ju order by rand() limit 1";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Ju.class));
    }
}
