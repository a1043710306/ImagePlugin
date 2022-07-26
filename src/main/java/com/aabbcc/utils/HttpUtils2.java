package com.aabbcc.utils;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.Iterator;
import java.util.Map;


public class HttpUtils2 {
    private static Logger log= LoggerFactory.getLogger(HttpUtils2.class);
    /**
     *
     * @param url 请求url
     * @param tClass 返回实体类型
     * @param <T>
     * @return
     */
    public static <T> T httpByGet(String url,Class<T> tClass,boolean debug) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/100.0.4896.75 Safari/537.36");
        requestHeaders.add("accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        HttpEntity<T> request = new HttpEntity<>(null, requestHeaders);
        return doRequest(url,request, HttpMethod.GET,tClass,debug);
    }


    public static <T> T httpByPost(String url,String token, Object jsonParams, Class<T> tClass) {
        HttpHeaders requestHeaders = new HttpHeaders();

        HttpEntity<Object> request = new HttpEntity<>(jsonParams, requestHeaders);

        return doRequest(url,request,HttpMethod.POST,tClass);
    }

    public static <T> T httpByPost(String url,String token, Object jsonParams,int ms, Class<T> tClass) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("token",token);
        HttpEntity<Object> request = new HttpEntity<>(jsonParams, requestHeaders);
        return doRequest(url,request,ms,HttpMethod.POST,tClass);
    }

    private static<T> T doRequest(String url,HttpEntity request,HttpMethod method,Class<T> tClass){
        RestTemplate restTemplate = new RestTemplate();
        long startTime=System.currentTimeMillis();
        log.info("request info to {}   request body:[{}] ",url, JSONObject.toJSONString(request.getBody()));
        ResponseEntity<T> resp = restTemplate.exchange(url, method, request, tClass);
        T body = resp.getBody();
        log.info(" in time: {} ms resp:[{}]",System.currentTimeMillis()-startTime,JSONObject.toJSONString(body));
        return body;
    }

    private static<T> T doRequest(String url,HttpEntity request,HttpMethod method,Class<T> tClass,boolean debug){
        RestTemplate restTemplate = new RestTemplate();
        long startTime=System.currentTimeMillis();
        ResponseEntity<T> resp = restTemplate.exchange(url, method, request, tClass);
        T body = resp.getBody();
        if(debug){
            log.info("request info to {}   request body:[{}] ",url, JSONObject.toJSONString(request.getBody()));
            log.info(" in time: {}ms resp:[{}]",System.currentTimeMillis()-startTime,JSONObject.toJSONString(body));
        }
        return body;
    }

    private static<T> T doRequest(String url,HttpEntity request,int ms,HttpMethod method,Class<T> tClass){
        SimpleClientHttpRequestFactory simpleClientHttpRequestFactory=new SimpleClientHttpRequestFactory();
        simpleClientHttpRequestFactory.setConnectTimeout(ms);
        simpleClientHttpRequestFactory.setReadTimeout(ms);
        RestTemplate restTemplate = new RestTemplate(simpleClientHttpRequestFactory);
        long startTime=System.currentTimeMillis();
        log.info("request info to {}    request body:[{}] ",url,JSONObject.toJSONString(request.getBody()));
        ResponseEntity<T> resp = restTemplate.exchange(url, method, request, tClass);
        T body = resp.getBody();
        log.info(" in time:{}ms resp:[{}]",System.currentTimeMillis()-startTime,JSONObject.toJSONString(body));
        return body;
    }

    public static void main(String args[]){

    }
}
