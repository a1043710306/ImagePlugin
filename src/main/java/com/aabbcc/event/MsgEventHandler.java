package com.aabbcc.event;

import com.aabbcc.config.ThreadPool;
import com.aabbcc.utils.HttpUtils2;
import com.aabbcc.utils.PicUtils;
import com.alibaba.fastjson.JSONObject;
import kotlin.coroutines.CoroutineContext;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.console.plugin.jvm.JavaPluginScheduler;
import net.mamoe.mirai.contact.Contact;
import net.mamoe.mirai.event.AbstractEvent;
import net.mamoe.mirai.event.EventHandler;
import net.mamoe.mirai.event.ListeningStatus;
import net.mamoe.mirai.event.SimpleListenerHost;
import net.mamoe.mirai.event.events.FriendMessageEvent;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import net.mamoe.mirai.event.events.MessageEvent;
import net.mamoe.mirai.event.events.MessageSyncEvent;
import net.mamoe.mirai.message.data.*;
import net.mamoe.mirai.utils.ExternalResource;
import net.mamoe.mirai.utils.MiraiLogger;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.io.File;
import java.io.IOException;
import java.util.Properties;


/**
 * 消息处理事件
 */
public class MsgEventHandler extends SimpleListenerHost {
    private static Logger log= LoggerFactory.getLogger(HttpUtils2.class);
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
        MsgSend(event);
        forwardGroupMsg(event);
        getEpicMsg(event);
    }

    private void MsgSend(MessageEvent event)  {
       try {
           SingleMessage singleMessage=event.getMessage().get(PlainText.Key);
           String msg=singleMessage.contentToString();
           String cmd=properties.getProperty("cmd");
           if(StringUtils.isEmpty(cmd)){
               cmd="loli";
           }
           if(!msg.equals(cmd)){
               return;
           }
           String aira2=properties.getProperty("aira2");
           String outDir=properties.getProperty("outDir");
           String r18=properties.getProperty("r18","1");
           File file=PicUtils.getPicPath(aira2,outDir,Integer.valueOf(r18));
           ExternalResource externalResource=ExternalResource.Companion.create(file);
           Image image= ExternalResource.uploadAsImage(externalResource, event.getSubject());
           event.getSubject().sendMessage(new MessageChainBuilder().append(image).build());
           externalResource.close();
       }catch (IOException e){
           e.printStackTrace();
       }
    }

    private void forwardGroupMsg(MessageEvent event){
        Contact contact=event.getSubject();
        SingleMessage text=event.getMessage().get(PlainText.Key);
        long qq=event.getSender().getId();
        //2439583838L

        if(qq==2439583838L&& PicUtils.isSend(text.contentToString())){
            log.info("forward fate  msg");
            MessageChainBuilder message=new MessageChainBuilder();
            for(SingleMessage singleMessage:event.getMessage()){
                message.append(singleMessage);
            }
            event.getBot().getGroup(474564587L).sendMessage(message.build());
        }
        return;
    }

    private void getEpicMsg(MessageEvent event){
        SingleMessage singleMessage=event.getMessage().get(PlainText.Key);
        String msg=singleMessage.contentToString();
        if(!msg.equals("epic")){
            return;
        }
        event.getSubject().sendMessage(new MessageChainBuilder().append(PicUtils.getGamePush()).build());
    }

}
