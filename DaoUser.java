package com.example.demo.dao;

import com.example.demo.classes.Follow;
import com.example.demo.classes.MyUser;
import com.example.demo.classes.Poetry;
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
    public int insertUser(String UID,String username,String password,String email){
        String sql = "insert into User(UID,username,password,email) values(?,?,?,?)";
        return jdbcTemplate.update(sql,new Object[]{UID,username,password,email});
    }

    public int modify(String UID, String username,String password){
        String sql= "update User set username="+username+",password="+password+" where UId="+UID;
        return jdbcTemplate.update(sql);
    }

    public int insertTRecommend(String UID){
        String sql = "insert into recommend(UID,zhuTi,renWu,tiCai,xieJing,diDian,shuQing,shiLing,jieRi,huaNiao,xvanJi) values(?,?,?,?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql,new Object[]{UID,"0","0","0","0","0","0","0","0","0","0"});
    }

    public List<MyUser> selectTableByUID(String UID){
        String sql = "select * from User where UID='"+UID+"'";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(MyUser.class));
    }
    public List<MyUser> selectTableByEmail(String email){
        String sql = "select * from User where email='"+email+"'";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(MyUser.class));
    }

    public String findUsernameByID(String uid){
        String sql="select username from User where UID= "+uid;
        return jdbcTemplate.queryForObject(sql,String.class);
    }

    public int follow(String following,String followed){
        String sql = "insert into follow(following,followed) values(?,?)";
        return jdbcTemplate.update(sql,new Object[]{following,followed});
    }

    public int cancelFollow(String following,String followed){
        String sql = "delete from follow where following="+following+" and followed="+followed;
        return jdbcTemplate.update(sql);
    }

    public List<Follow> searchFollowByUID(String uid){
        String sql = "SELECT follow.following,follow.followed,User.username as followedname FROM follow,User " +
                "where User.UID=follow.followed and follow.following="+uid;
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Follow.class));
    }

    public int collection(String UID,String id){
        String sql = "insert into collection(UID,id) values(?,?)";
        return jdbcTemplate.update(sql,new Object[]{UID,id});
    }

    public int cancelCollection(String UID,String id){
        String sql = "delete from collection where UID="+UID+" and id="+id;
        return jdbcTemplate.update(sql);
    }

    public List<Poetry> searchCollectionByUID(String UID){
        String sql = "select * from poetry where id in (select id from collection where UID= "+UID+")";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Poetry.class));
    }
}
