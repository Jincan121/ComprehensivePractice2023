package com.example.demo.controller;

import com.example.demo.serve.FileDownload;
import com.example.demo.serve.UserServe;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/user")
public class UserController {
    UserServe userOperation;
    public UserController() {
        userOperation = new UserServe();
    }

    //解决同源跨域问题
    @CrossOrigin(origins = {"*"})
    @RequestMapping("/login")
    public String login(@RequestParam("UID") String UID,@RequestParam("password") String password) {
        return userOperation.login(UID,password);

        //更新
//        String sql = "update User set username=" + "'ming'," +
//                                              "password=" + "'boy' " +
//                                              " where UID="+"3";
//        jdbcTemplate.update(sql);

        //查询多个
//        String sql = "select * from User";
//        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
//        Iterator<Map<String, Object>> iter=list.listIterator();
//        while(iter.hasNext()){
//            System.out.println(iter.next().get("username"));
//        }

    }

    //解决同源跨域问题
    @CrossOrigin(origins = {"*"})
    @RequestMapping("/register")
    public String register(@RequestParam("UID") String UID, @RequestParam("username") String username,
                           @RequestParam("password") String password,@RequestParam("email") String email) {
        return userOperation.register(UID,username,password,email);
    }

    @GetMapping("/download")
    public void downloadCheck(HttpServletRequest request, HttpServletResponse response) throws Exception {
        FileDownload.fileDownload(request,response);
    }

//    @PostMapping(value = "/uploadFile")
//    public String uploadFile(@RequestPart("assignPath") String assignPath,
//                        @RequestPart("file") MultipartFile file) {
//        try {
//            String path = FileUploadUtils.uploadFile(null, file, assignPath);
//            user.setImg(path);
//            System.err.println(user.toString());
//            //模拟数据入库操作
//            boolean update = true;
//            if (update) return R.ok(path);
//            //数据入库失败应删除文件资源，避免造成服务器压力过大问题
//            FileUploadUtils.deleteFile("更新成功：" + path);
//            return "更新失败";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "内部服务器错误";
//        }
//    }
}



