package com.aabbcc.Resp;



import java.util.List;
public class ImAgeInfo {
    long pid;
    long p;
    long uid;
    String title;
    String author;
    boolean r18;
    int width;
    int height;
    List<String> tags;
    String ext;
    long uploadDate;
    UrlsInfo urls;

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public long getP() {
        return p;
    }

    public void setP(long p) {
        this.p = p;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isR18() {
        return r18;
    }

    public void setR18(boolean r18) {
        this.r18 = r18;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public long getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(long uploadDate) {
        this.uploadDate = uploadDate;
    }

    public UrlsInfo getUrls() {
        return urls;
    }

    public void setUrls(UrlsInfo urls) {
        this.urls = urls;
    }
}
