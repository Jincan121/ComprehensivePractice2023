package com.example.demo.dao;

import com.example.demo.classes.Poetry;
import com.example.demo.classes.Recommend;
import com.example.demo.classes.Support;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DaoPoetry {
    private JdbcTemplate jdbcTemplate;

    private Map<String,String>map=new HashMap<String,String>();
    private Map<String,String>map2=new HashMap<String,String>();
    public DaoPoetry() throws FileNotFoundException {
        DriverManagerDataSource ds=new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://175.178.213.250:3306/ChuCi");
        ds.setUsername("manager1");
        ds.setPassword("xbpcL8tTCCFPSdfR");

        jdbcTemplate=new JdbcTemplate();
        jdbcTemplate.setDataSource(ds);

        Scanner scanner = new Scanner(new File("src/main/resources/static/txt/tags2.txt"));

        while (scanner.hasNext()) {
            map.put(scanner.next(),scanner.next());
        }
        scanner.close();

        map2.put("主题","ZhuTi");map2.put("ZhuTi","主题");
        map2.put("人物","RenWu");map2.put("RenWu","人物");
        map2.put("体裁","TiCai");map2.put("TiCai","体裁");
        map2.put("写景","XieJing");map2.put("XieJing","写景");
        map2.put("地点","DiDian");map2.put("DiDian","地点");
        map2.put("抒情","ShuQing");map2.put("ShuQing","抒情");
        map2.put("时令","ShiLing");map2.put("ShiLing","时令");
        map2.put("节日","JieRi");map2.put("JieRi","节日");
        map2.put("花鸟","HuaNiao");map2.put("HuaNiao","花鸟");
        map2.put("选集","XvanJi");map2.put("XvanJi","选集");
    }

    public List<Poetry> selectTableByRand(){
        String sql = "select* from poetry order by rand() limit 10";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Poetry.class));
    }

    public String selectRecommendByUser(String SuperTag){
        SuperTag=map2.get(SuperTag);
        String sql = "select tag from OutTags where SuperTag='"+SuperTag+"' order by rand() limit 1";
        return jdbcTemplate.queryForObject(sql,String.class);
    }

    public List<Poetry> searchContent(String content){
        //内容、诗人名、诗名
        String sql = "SELECT * FROM poetry " +
                "WHERE content LIKE '%"+content+"%' " +
                "OR name like '%"+content+"%'  " +
                "OR poet_name like '%"+content+"%' " +
                "OR tag like '%"+content+"%' " +
                "limit 100";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Poetry.class));
    }

    public List<Poetry> searchByTag(String tag){
        //标签
        String sql = "SELECT * FROM poetry where tag like'%"+tag+"%' order by rand() limit 100";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Poetry.class));
    }

    public List<Poetry> searchID(String id){
        //诗id
        String sql = "SELECT * FROM poetry where id="+id;
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Poetry.class));
    }

    public List<Poetry> searchPoetname(String poetname){
        //诗id
        String sql = "SELECT * FROM poetry where poet_name='"+poetname+"'";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Poetry.class));
    }

    public List<Support> selectSupportByUID(String UID){
        String sql = "select * from support where UID='"+UID+"'";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Support.class));
    }

    public List<Recommend> selectRecommendByUID(String UID){
        String sql = "select * from recommend where UID ="+UID;
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Recommend.class));
    }

    public int insertSupport(String UID,String id){
        String sql = "insert into support(UID,id) values(?,?)";
        return jdbcTemplate.update(sql,new Object[]{UID,id});
    }

    public int cancelSupport(String UID,String id){
        String sql = "delete from support where UID="+UID+" and id="+id;
        return jdbcTemplate.update(sql);
    }

    public String searchTagByID(String id){
        String sql = "select tag from poetry where id="+id;
        return jdbcTemplate.queryForObject(sql, String.class);
    }

    public int recommend(String UID,String tag){
        if(map.get(tag)==null)return -1;

        String str=map2.get(map.get(tag));
        String sql = "select "+str+" from recommend where UID="+UID;
        int count = jdbcTemplate.queryForObject(sql, Integer.class);
        String sql2= "update recommend set "+str+"="+Integer.toString(count+1)+" where UId="+UID;
        return jdbcTemplate.update(sql2);
    }

    public int cancelRecommend(String UID,String tag){
        if(map.get(tag)==null)return -1;

        String str=map2.get(map.get(tag));
        String sql = "select "+str+" from recommend where UID="+UID;
        int count = jdbcTemplate.queryForObject(sql, Integer.class);
        String sql2= "update recommend set "+str+"="+Integer.toString(count-1)+" where UId="+UID;
        return jdbcTemplate.update(sql2);
    }

}
