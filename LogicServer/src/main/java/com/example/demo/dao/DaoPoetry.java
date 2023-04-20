package com.example.demo.dao;

import com.example.demo.classes.Poetry;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

public class DaoPoetry {
    private JdbcTemplate jdbcTemplate;
    public DaoPoetry() {
        DriverManagerDataSource ds=new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://175.178.213.250:3306/ChuCi");
        ds.setUsername("manager1");
        ds.setPassword("xbpcL8tTCCFPSdfR");

        jdbcTemplate=new JdbcTemplate();
        jdbcTemplate.setDataSource(ds);
    }

    public List<Poetry> selectTableByRand(){
        String sql = "select poetry.id as id,poetry.star as star,poetry.content as content,poetry.name as name,poetry.dynasty " +
                "as dynasty,poetry.tag as tag,poet.name  as poet_name " +
                "from poetry,poet where poetry.id=poet.id order by rand() limit 10";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Poetry.class));
    }
}
