package com.aabbcc.Resp;

import java.util.List;

public class GroupMessageResp {
    int code;
    String msg;
    List<GroupMessage> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<GroupMessage> getData() {
        return data;
    }

    public void setData(List<GroupMessage> data) {
        this.data = data;
    }
}
