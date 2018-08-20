package com.lw.utils;


import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 文件上传 工具类 By:long
 */
public class UploadUtil {

    public static String upload(MultipartFile file, String path){
        if(!file.isEmpty()) {
            try {
                //上传文件名
                String filename = file.getOriginalFilename();
                File filepath = new File(path,filename);
                //判断路径是否存在，如果不存在就创建一个
                if (!filepath.getParentFile().exists()) {
                    filepath.getParentFile().mkdirs();
                }
                //将上传文件保存到一个目标文件当中
                file.transferTo(new File(path + File.separator + filename));
                return path + File.separator + filename;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}

