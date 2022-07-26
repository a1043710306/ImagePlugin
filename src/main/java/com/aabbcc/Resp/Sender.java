package com.aabbcc.Resp;

public class Sender {
    String memberName,specialTitle,permission;
    Group group;
    long id,joinTimestamp,lastSpeakTimestamp,muteTimeRemaining;


    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getSpecialTitle() {
        return specialTitle;
    }

    public void setSpecialTitle(String specialTitle) {
        this.specialTitle = specialTitle;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getJoinTimestamp() {
        return joinTimestamp;
    }

    public void setJoinTimestamp(long joinTimestamp) {
        this.joinTimestamp = joinTimestamp;
    }

    public long getLastSpeakTimestamp() {
        return lastSpeakTimestamp;
    }

    public void setLastSpeakTimestamp(long lastSpeakTimestamp) {
        this.lastSpeakTimestamp = lastSpeakTimestamp;
    }

    public long getMuteTimeRemaining() {
        return muteTimeRemaining;
    }

    public void setMuteTimeRemaining(long muteTimeRemaining) {
        this.muteTimeRemaining = muteTimeRemaining;
    }
}
