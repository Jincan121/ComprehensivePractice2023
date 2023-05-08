package com.example.demo.dao;

import com.example.demo.classes.Poetry;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

public class DaoGame {
    private JdbcTemplate jdbcTemplate;
    public DaoGame() {
        DriverManagerDataSource ds=new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://175.178.213.250:3306/ChuCi");
        ds.setUsername("manager1");
        ds.setPassword("xbpcL8tTCCFPSdfR");

        jdbcTemplate=new JdbcTemplate();
        jdbcTemplate.setDataSource(ds);
    }
    public List<Poetry> searchContentExist(String content){
        String sql = "select * from poetry where content like '%"+content+"%' limit 1";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Poetry.class));
    }

    public List<Poetry> searchPoetContentExist(String content,String poet){
        String sql = "select * from poetry where content like '%"+content+"%' and poet_name='"+poet+"' limit 1";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Poetry.class));
    }

    public Integer getContent(String uid){
        String sql = "select FengHuaXueYue from User where UID ="+uid;
        return jdbcTemplate.queryForObject(sql,Integer.class);
    }

    public Integer setContent(String uid,Integer content){
        String sql = "update User set FengHuaXueYue ="+content+" where UID ="+uid;
        return jdbcTemplate.update(sql);
    }

    public Integer getPoet(String uid){
        String sql = "select LibaiDuSuLiqing from User where UID ="+uid;
        return jdbcTemplate.queryForObject(sql,Integer.class);
    }

    public Integer setPoet(String uid,Integer user){
        String sql = "update User set LibaiDuSuLiqing ="+user+" where UID ="+uid;
        return jdbcTemplate.update(sql);
    }

}
