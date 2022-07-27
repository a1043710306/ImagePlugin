package com.aabbcc.utils;


import com.aabbcc.Resp.ImageResp;
import com.aabbcc.api.API;
import com.aabbcc.pojo.Elements;
import com.aabbcc.pojo.EpicResp;
import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PicUtils {
    public static File getPicPath(String aira2c, String outDir, int r18)  {
        //final String cmd="D:\\aria2\\aria2c.exe %s  -d D:\\aria2\\pic  -o %s";
        String cmd=String.format("%s %s  -d %s  -o %s",aira2c,"%s",outDir,"%s");
        //final String url="https://api.lolicon.app/setu/v2";
        String url=String.format(API.loliconApi,r18);
        ImageResp resp=HttpUtils2.httpByGet(url,ImageResp.class,true);

        if(resp.getData().size()!=0){
            String ext=resp.getData().get(0).getExt();
            String urld=resp.getData().get(0).getUrls().getOriginal();
            String fileName=String.format("%s.%s",System.nanoTime()+"p",ext);
            String dw=String.format(cmd,urld,fileName);
            try {
                CommandUtils.getInstance().execAndWait(dw);
                return Paths.get(outDir,fileName).toFile();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    public static String getGamePush(){
        String url="https://store-site-backend-static-ipv4.ak.epicgames.com/freeGamesPromotions?locale=zh-CN&country=CN&allowCountries=CN";
        String resp=HttpUtils2.httpByGet(url,String.class,false);
        StringBuilder stringBuilder=new StringBuilder();
        EpicResp epicResp=JSONObject.parseObject(resp,EpicResp.class);
        List<Elements> elementsList=epicResp.getData().getCatalog().getSearchStore().getElements();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        for(int i=0;i<1&&i<elementsList.size();i++) {
            Elements elements=elementsList.get(i);
            String game_title=elements.getTitle();
            //String game_description=elements.getDescription();
            String game_seller=elements.getSeller().getName();
            String game_originalprice=elements.getPrice().getTotalPrice().getFmtPrice().getOriginalPrice();
            String game_discountPrice=elements.getPrice().getTotalPrice().getFmtPrice().getDiscountPrice();
            String endTime;
            if(elements.getPrice().getLineOffers().size()>0&&
                    elements.getPrice().getLineOffers().get(0).getAppliedRules().size()>0){
                Date date=elements.getPrice().getLineOffers().get(0).getAppliedRules().get(0).getEndDate();
                endTime =simpleDateFormat.format(date);
            }else {
                endTime="未知的结束时间";
            }

            String result = "每周EPIC免费游戏\n免费游戏名:" + game_title +"\n 游戏卖家:"+game_seller+"\n 结束时间:"+endTime;
            stringBuilder.append(result);

        }
        return stringBuilder.toString();
    }

    public static boolean isSend(String str){
        if(str.indexOf(")")!=-1&&str.indexOf("-")!=-1)
            return true;
        return false;
    }


    public static void main(String args[]){
       //System.out.println(getPicPath("D:\\aria2\\aria2c.exe","D:\\aria2\\pic",2));
       System.out.println(getGamePush());
    }
}
