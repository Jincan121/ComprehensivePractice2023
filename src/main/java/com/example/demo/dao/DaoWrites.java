package com.example.demo.dao;

import com.example.demo.classes.Writes;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DaoWrites {
    private JdbcTemplate jdbcTemplate;
    public DaoWrites() {
        DriverManagerDataSource ds=new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://175.178.213.250:3306/ChuCi");
        ds.setUsername("manager1");
        ds.setPassword("xbpcL8tTCCFPSdfR");

        jdbcTemplate=new JdbcTemplate();
        jdbcTemplate.setDataSource(ds);
    }

    public int insertWrites(String UID,String headline,String content){
        //获取时间
        Date ti=new Date();
        //设置时间戳解析格式
        SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format0.format(ti.getTime());

        String sql = "insert into writes(UID,time,headline,content) values(?,?,?,?)";
        return jdbcTemplate.update(sql,new Object[]{UID,time,headline,content});
    }

    public int deleteWrites(String UID,String id){
        String sql = "delete from writes where UID="+UID+" and id="+id;
        return jdbcTemplate.update(sql);
    }

    public List<Writes> selectWritesByUID(String UID){
        String sql = "select * from writes where UID ="+UID+" order by time DESC";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Writes.class));
    }

    public List<Writes> searchWritesAll(){
        String sql = "select * from writes order by time DESC";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Writes.class));
    }

    public List<Writes> searchWritesByFollow(String UID){
        String sql = "select * from writes where UID in (select followed from follow where following="+UID+") order by time DESC";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Writes.class));
    }
}
