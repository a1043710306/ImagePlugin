package com.aabbcc.Resp;



import java.util.List;

public class ImageReq {
    Integer r18;
    Integer num;
    List<Integer> uid;
    String keyword;
    List<String> tag;
    List<String> size;
    String proxy;

    public Integer getR18() {
        return r18;
    }

    public void setR18(Integer r18) {
        this.r18 = r18;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public List<Integer> getUid() {
        return uid;
    }

    public void setUid(List<Integer> uid) {
        this.uid = uid;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public List<String> getTag() {
        return tag;
    }

    public void setTag(List<String> tag) {
        this.tag = tag;
    }

    public List<String> getSize() {
        return size;
    }

    public void setSize(List<String> size) {
        this.size = size;
    }

    public String getProxy() {
        return proxy;
    }

    public void setProxy(String proxy) {
        this.proxy = proxy;
    }
}
