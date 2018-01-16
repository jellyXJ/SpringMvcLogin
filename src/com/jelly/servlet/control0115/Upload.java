package com.jelly.servlet.control0115;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

@Controller
public class Upload {
    @PostMapping("/upload")
    public String upload(HttpServletRequest request) throws IOException {

        //获取当前时间--上传前的时间
        long startTime =System.currentTimeMillis();
        //将当前上下文初始化给CommonsMultipartResolver(多部分解析器)
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        //检查form是否多部分表单上传   enctype="multipart/form-data"
        if(commonsMultipartResolver.isMultipart(request)){
            //将request变成多部分request---强转
            MultipartHttpServletRequest multipartHttpServletRequest =(MultipartHttpServletRequest)request;
            //获取multipartHttpServletRequest中所有的文件名---返回值-迭代器
           Iterator iterator= multipartHttpServletRequest.getFileNames();
           //循环遍历迭代器
            while (iterator.hasNext()){
                //循环遍历所有文件
                MultipartFile multipartFile =multipartHttpServletRequest.getFile(iterator.next().toString());
                if(multipartFile!=null){
                    //文件名不为空将文件上传、、
                    //文件路径
                    String path="E:/jelly/"+multipartFile.getOriginalFilename();
                    //上传
                    multipartFile.transferTo(new File(path));

                }
            }


        }
        long  endTime=System.currentTimeMillis();
        System.out.println("方法的运行时间："+String.valueOf(endTime-startTime)+"ms");
        //返回上传成功页面
        return "uploadSuccess";
    }
}
