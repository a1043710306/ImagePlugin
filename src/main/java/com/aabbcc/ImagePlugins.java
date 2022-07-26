package com.aabbcc;

import com.aabbcc.event.MsgEventHandler;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.console.plugin.jvm.JavaPlugin;
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescriptionBuilder;
import net.mamoe.mirai.event.GlobalEventChannel;
import net.mamoe.mirai.utils.MiraiLogger;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public final class ImagePlugins extends JavaPlugin {
    public static final ImagePlugins INSTANCE = new ImagePlugins();
    private final MiraiLogger log= getLogger();


    private final Path path= Paths.get(resolveConfigPath("").toString(),"app.properties");

    private Properties properties;

    private ImagePlugins() {
        super(new JvmPluginDescriptionBuilder("com.aabbcc.loli", "0.1.0")
                .name("ImagePlugins")
                .author("枸杞")
                .build());
    }
    {
        if(!path.toFile().isFile()){
            try {
                log.info("Generate the configuration item ");
                File f=path.toFile();
                f.createNewFile();
                writeDefaultProperties(f);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        properties=new Properties();
        try {
            properties.load(new FileInputStream(path.toString()));
            if(properties.get("outDir")==null)
                properties.put("outDir",resolveDataPath("pic").toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void writeDefaultProperties(File f) throws FileNotFoundException {
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append("#aira2c二进制文件 eg D:\\\\aria2\\\\aria2c.exe\n").append("aira2=D:\\\\aria2\\\\aria2c.exe\n")
                .append("#图片下载目录\n").append("outDir=D:\\\\aria2\\\\pic\n")
                .append("# 0 非r18, 1 r18,2 混合模式 \n").append("r18=0\n")
                .append("# 触发指令 默认loli\n").append("cmd=loli");
        PrintStream p=new PrintStream(f);
        p.println(stringBuffer.toString());
        p.close();
    }

    private void printConfig(){
        String aira2=properties.getProperty("aira2");
        String outDir=properties.getProperty("outDir");
        String r18=properties.getProperty("r18","1");
        log.info("loader aira2 "+aira2);
        log.info("loader outDir "+outDir);
        log.info("loader r18 "+r18);
        log.info(" Successfully loaded plugin com.aabbcc.loli ");
    }
    @Override
    public void onEnable() {
        printConfig();
        //Bot bot=Bot.getInstance(Long.valueOf(properties.getProperty("qq")));
        GlobalEventChannel.INSTANCE.registerListenerHost(new MsgEventHandler(getScheduler(),properties));
    }

}