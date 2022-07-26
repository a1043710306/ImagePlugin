package com.aabbcc.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.StringTokenizer;


public class CommandUtils {
   private static CommandUtils commandUtils=new CommandUtils();
   private static int SUCCESSFUL=0;
   private static int UNSUCCESSFUL=-1;
   private CommandUtils(){

   }

   public static CommandUtils getInstance(){
       return commandUtils;
   }

   public  Process exec(String cmd) throws IOException {
       return createProcess(cmd,null);
   }

   public Process exec(String cmd,File dir) throws IOException {
       return createProcess(cmd,dir);
   }
   private  Process createProcess(String cmd,File dir) throws IOException {
       StringTokenizer st = new StringTokenizer(cmd);
       String[] cmdarray = new String[st.countTokens()];
       for (int i = 0; st.hasMoreTokens(); i++)
           cmdarray[i] = st.nextToken();
        ProcessBuilder processBuilder=new ProcessBuilder(cmdarray);
        processBuilder.directory(dir);
        processBuilder.redirectInput(ProcessBuilder.Redirect.PIPE);
        processBuilder.redirectOutput(ProcessBuilder.Redirect.PIPE);
        processBuilder.redirectError(ProcessBuilder.Redirect.PIPE);
        return processBuilder.start();
   }

    public byte[] execAndWaitResult(String exec,File dir) throws IOException, InterruptedException {
        Process p=createProcess(exec,dir);
       return waitResult(p);
    }

    private byte[] waitResult(Process p) throws IOException, InterruptedException {
       p.waitFor();
        if(p.exitValue()==SUCCESSFUL){
            byte[] buff=getResult(p.getInputStream());
            p.destroy();
            return buff;
        }else {
            byte[] buff=getResult(p.getErrorStream());
            p.destroy();
            return buff;
        }
    }


    public byte[] getResult(InputStream inputStream) throws IOException {
        int available=inputStream.available();
        if(available>0){
            byte[] buff=new byte[available];
            inputStream.read(buff);
            return buff;
        }
        return new byte[0];
    }

    public byte[] execAndWaitResult(String exec) throws IOException, InterruptedException {
        Process p=createProcess(exec,null);
        return waitResult(p);
    }


    public int execAndWait(String cmd,File dir) throws IOException, InterruptedException {
       Process process=createProcess(cmd,dir);
       process.waitFor();
       return process.exitValue();
    }

    public int execAndWait(String cmd) throws IOException, InterruptedException {
        Process process=createProcess(cmd,null);
        process.waitFor();
        return process.exitValue();
    }


    public static void main(String args[]) throws IOException, InterruptedException {
       byte[] result=CommandUtils.getInstance().execAndWaitResult("java ");
       System.out.println(new String(result, Charset.forName("gbk")));

    }
}
