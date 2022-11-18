package com.aabbcc.event;

import com.aabbcc.utils.PicUtils;
import kotlin.coroutines.CoroutineContext;
import net.mamoe.mirai.console.plugin.jvm.JavaPluginScheduler;
import net.mamoe.mirai.event.EventHandler;
import net.mamoe.mirai.event.SimpleListenerHost;
import net.mamoe.mirai.event.events.FriendMessageEvent;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import net.mamoe.mirai.event.events.MessageEvent;
import net.mamoe.mirai.message.data.*;
import net.mamoe.mirai.utils.ExternalResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Properties;


/**
 * 消息处理事件
 */
public class MsgEventHandler extends SimpleListenerHost {
    private static Logger log= LoggerFactory.getLogger(MsgEventHandler.class);
    final JavaPluginScheduler threadPoolTaskExecutor;
    final Properties properties;

    public MsgEventHandler(JavaPluginScheduler javaPluginScheduler,Properties properties){
        this.properties=properties;
        this.threadPoolTaskExecutor=javaPluginScheduler;
    }
    @Override
    public void handleException( CoroutineContext context,  Throwable exception){
        exception.printStackTrace();
        // 处理事件处理时抛出的异常
    }
    @EventHandler
    public void onMessage(GroupMessageEvent event) throws Exception {
       threadPoolTaskExecutor.async(()->{
           msgProcess(event);
       });
        // 无返回值, 表示一直监听事件.
    }
    @EventHandler
    public void onMessage(FriendMessageEvent event) throws Exception {
        threadPoolTaskExecutor.async(()->{
            msgProcess(event);
        });
        // 无返回值, 表示一直监听事件.
    }

    private void msgProcess(MessageEvent event){
      SingleMessage singleMessage=event.getMessage().get(PlainText.Key);
      if(singleMessage!=null){
          String msg=singleMessage.contentToString();
          String cmd=properties.getProperty("cmd");
          if(cmd==null || "".equals(cmd)){
              cmd="loli";
          }
          cmd=getUtf8String(cmd);
          System.out.println("当前配置色图触发指令为 "+cmd);
          if(msg.equals(cmd)){
              try {
                  MsgSend(event);
              } catch (IOException e) {
                 e.printStackTrace();
              }
          }
      }
    }

    private String getUtf8String(String str)  {
       try {
           return new String(str.getBytes("iso8859-1"), Charset.forName("utf8"));
       }catch (UnsupportedEncodingException e){
           e.printStackTrace();
       }
       return "loli";
    }

    private void MsgSend(MessageEvent event) throws IOException {
       String aira2=properties.getProperty("aira2");
       String outDir=properties.getProperty("outDir");
       String r18=properties.getProperty("r18","1");
       File file=PicUtils.getPicPath(outDir,Integer.valueOf(r18));
       ExternalResource externalResource=ExternalResource.Companion.create(file);
       Image image= ExternalResource.uploadAsImage(externalResource, event.getSubject());
       event.getSubject().sendMessage(new MessageChainBuilder().append(image).build());
       externalResource.close();
    }

}
