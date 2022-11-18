package com.aabbcc.utils;


import com.aabbcc.Resp.ImageResp;
import com.aabbcc.api.API;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PicUtils {
    private static Gson gson= new GsonBuilder().create();
//    public static File getPicPath(String aira2c, String outDir, int r18)  {
//        //final String cmd="D:\\aria2\\aria2c.exe %s  -d D:\\aria2\\pic  -o %s";
//        String cmd=String.format("%s %s  -d %s  -o %s",aira2c,"%s",outDir,"%s");
//        //final String url="https://api.lolicon.app/setu/v2";
//        String url=String.format(API.loliconApi,r18);
//        ImageResp resp=HttpUtils2.httpByGet(url,ImageResp.class,true);
//
//        if(resp.getData().size()!=0){
//            String ext=resp.getData().get(0).getExt();
//            String urld=resp.getData().get(0).getUrls().getOriginal();
//            String fileName=String.format("%s.%s",System.nanoTime()+"p",ext);
//            String dw=String.format(cmd,urld,fileName);
//            try {
//                CommandUtils.getInstance().execAndWait(dw);
//                return Paths.get(outDir,fileName).toFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        return null;
//    }


    public static File getPicPath(String outDir, int r18)  {
        //final String cmd="D:\\aria2\\aria2c.exe %s  -d D:\\aria2\\pic  -o %s";

        //final String url="https://api.lolicon.app/setu/v2";
        //String url=String.format(API.loliconApi,r18);
        //ImageResp resp=HttpUtils2.httpByGet(url,ImageResp.class,true);
        ImageResp resp=getPicDwn(r18);
        if(resp.getData().size()!=0){
            String ext=resp.getData().get(0).getExt();
            String urld=resp.getData().get(0).getUrls().getOriginal();
            String fileName=String.format("%s.%s",System.nanoTime()+"p",ext);

            Path path = Paths.get(outDir, fileName);
            String cmd=String.format("curl -L %s  -o %s",urld, path.toString());

            String dw=String.format(cmd,urld,fileName);
            try {
                CommandUtils.getInstance().execAndWait(dw);
                return path.toFile();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    public static ImageResp getPicDwn(int r18){
        String url=String.format(API.loliconApi,r18);
        String cmd=String.format("curl %s",url);
        try {
           byte [] respdata=CommandUtils.getInstance().execAndWaitResult(cmd);
           String resp=new String(respdata);
           System.out.printf("resp: %S",resp);
           return gson.fromJson(resp,ImageResp.class);
        }catch (IOException e){
            e.printStackTrace();
        } catch (InterruptedException e) {
           e.printStackTrace();
        }
        return null;
    }


    public static void main(String args[]){
      // System.out.println(getPicPath("D:\\aria2\\aria2c.exe","D:\\aria2\\pic",2));
    }
}
