package com.lw.controller.face;

import com.lw.data.entity.LibResult;
import com.lw.data.enums.ResultStatusEnum;
import com.lw.service.face.FaceService;
import com.lw.utils.UploadUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


/**
 * Created by 百度人脸识别测试 on 2018/6/29.
 */
@Controller
public class FaceController {

    @Autowired
    private FaceService faceService;

    @RequestMapping(value="/testFace")
    @ResponseBody
    public LibResult testFace(MultipartFile file) throws Exception {

        new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());


        String path = "D:\\testFace";
        String filePath=UploadUtil.upload(file,path);
        Map<String,Object> result=faceService.test(filePath);
        return result!=null
                ?LibResult.returnLibResult(ResultStatusEnum.SUCCESS,result)
                :LibResult.returnError("识别失败");
    }

    @RequestMapping(value="/addUser")
    @ResponseBody
    public LibResult addUser(@RequestBody Map<String,String> map) throws Exception {
        String faceToken=map.get("faceToken");
        if(StringUtils.isBlank(faceToken)){
            return LibResult.returnError("faceToken不能为空");
        }
        faceService.addUser(map.get("faceToken"));
        return LibResult.returnSuccess();
    }

}
