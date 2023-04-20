package com.example.demo.serve;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class FileDownload {
    public static void fileDownload(HttpServletRequest request, HttpServletResponse response) throws Exception{
        try {
            File file = new File("D:/带学课程/大三下综合实践/Project/LogicServer/src/main/resources/jpg/1.jpg");
            BufferedInputStream bis = null;
            OutputStream os = null;
            FileInputStream fileInputStream = null;
            response.setCharacterEncoding("utf-8");
            //文件类型标识
            response.setContentType("application/image/jpeg");
            //文件名称设置
            response.setHeader("Content-Disposition", "attachment; filename=1.jpg");
            try {
                fileInputStream = new FileInputStream(file);
                byte[] buff = new byte[1024];
                bis = new BufferedInputStream(fileInputStream);
                os = response.getOutputStream();

                int i = bis.read(buff);
                while (i != -1) {
                    os.write(buff, 0, buff.length);
                    i = bis.read(buff);
                    os.flush();
                }
                os.flush();
                os.close();
//                return SimpleResult.ok("导出成功",os);
            } catch (IOException e) {
                e.printStackTrace();
//                return SimpleResult.fail("导出失败",null);
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                        fileInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
//                        return SimpleResult.fail("导出失败",null);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
