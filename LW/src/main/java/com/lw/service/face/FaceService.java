package com.lw.service.face;

import com.alibaba.fastjson.JSON;
import com.lw.utils.HttpUtil;
import com.lw.utils.Img2Base64Util;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2018/7/11.
 */
@Service
public class FaceService {

    private static final String charset="utf-8";
    private static final int connectTimeout=5000;
    private static final int readTimeout=5000;

    /**
     * 活体校验
     * @param imgPath
     * @return
     */
    public Map<String,Object> test(String imgPath){
        String token=getToken();
        String url="https://aip.baidubce.com/rest/2.0/face/v3/faceverify?access_token="+token;
        Map<String, String> params=new HashMap<String, String>();
        Map<String, String> map=new HashMap<String, String>();
        String image=getImgBase64(imgPath);
        map.put("image",image);
        map.put("image_type","BASE64");
        List<Object> list=new ArrayList<Object>();
        list.add(map);
        params.put("", JSON.toJSONString(list));
        try {
            String result= HttpUtil.doPost(url,params,charset,connectTimeout,readTimeout);
            Map<String,Object> resultMap=JSON.parseObject(result);
            return resultMap;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    /**
     * 获取access_token  30天有效  可每次调用
     * @return
     */
    public String getToken(){
        String url="https://aip.baidubce.com/oauth/2.0/token";
        Map<String, String> params=new HashMap<String, String>();
        params.put("grant_type","client_credentials");
        params.put("client_id","yyTbTwKGeRoFcFQ0obqz8Lj5");
        params.put("client_secret","T31bweqrvR9GxGwYqdrGfArgvRXtec7h");
        String token="24.01cf35ebef948f1f7bc2b28713d124b7.2592000.1533803108.282335-11512604";
        /*try {
            String resultStr=HttpUtil.doPost(url,params,charset,connectTimeout,readTimeout);
            Map<String,Object> result= JSON.parseObject(resultStr);
            token=result.get("access_token").toString();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        return token;
    }

    /**
     * 人脸注册
     * 用于向人脸库中新增用户，及组内用户的人脸图片，
     * 典型应用场景：构建您的人脸库，如会员人脸注册，已有用户补全人脸信息等。
     * @param faceToken
     */
    public void addUser(String faceToken){
        boolean boo=isExist(faceToken);
        if(boo){//已存在
            return;
        }
        String token = getToken();
        String url="https://aip.baidubce.com/rest/2.0/face/v3/faceset/user/add?access_token="+token;
        Map<String, String> params=new HashMap<String, String>();
        params.put("image",faceToken);
        params.put("image_type","FACE_TOKEN");
        params.put("group_id","my_companion");
        String userId = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        Random ra = new Random();
        Integer number = ra.nextInt(10000);
        params.put("user_id","ZX_"+userId+String.valueOf(number));
        try {
            String resultStr=HttpUtil.doPost(url,params,charset,connectTimeout,readTimeout);
            Map<String,Object> result= JSON.parseObject(resultStr);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 人脸搜索
     * @param faceToken
     * @return
     */
    public Map<String,Object> faceSearch(String faceToken){
        String token = getToken();
        String url="https://aip.baidubce.com/rest/2.0/face/v3/search?access_token="+token;
        Map<String, String> params=new HashMap<String, String>();
        params.put("image",faceToken);
        params.put("image_type","FACE_TOKEN");
        params.put("group_id_list","my_companion");
        try {
            String resultStr=HttpUtil.doPost(url,params,charset,connectTimeout,readTimeout);
            Map<String,Object> result= JSON.parseObject(resultStr);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 校验用户是否存在
     * @param faceToken
     * @return
     */
    public boolean isExist(String faceToken){
        Map<String,Object> data = faceSearch(faceToken);
        if(data==null){
            return false;
        }
        Map<String,Object> result = (Map<String,Object>)data.get("result");
        if(result==null){
            return false;
        }
        List list=(List) result.get("user_list");
        if(list==null||list.size()==0){
            return false;
        }

        Float score=0f;
        for(int i=0;i<list.size();i++){
            Map<String,Object> map = (Map<String,Object>)list.get(0);
            Float f = Float.valueOf(String.valueOf(map.get("score")));
            if(f.floatValue()>score.floatValue()){
                score=f;
            }
        }
        Float basicsScore=80f;
        if(score.floatValue()>=basicsScore.floatValue()){
            return true;
        }
        return false;
    }

    public String getImgBase64(String imgPath){
        String imgbese= Img2Base64Util.getImgStr(imgPath);
        return imgbese;
    }

    public static void main(String[] args){
        //test();
        //System.out.println(getImgBase64());
    }
}
