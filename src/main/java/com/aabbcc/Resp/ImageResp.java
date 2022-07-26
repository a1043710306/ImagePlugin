package com.aabbcc.Resp;



import java.util.List;


public class ImageResp {
    String error;
    List<ImAgeInfo> data;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<ImAgeInfo> getData() {
        return data;
    }

    public void setData(List<ImAgeInfo> data) {
        this.data = data;
    }
}
