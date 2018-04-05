package com.appdev.debsourav.childtracker;

/**
 * Created by Deb Sourav on 3/29/2018.
 */

public class Call {
    private String phNumber, callType, callDate, callDuration;

    public Call() {
    }

    public Call(String phNumber, String callType, String callDate, String callDuration) {
        this.phNumber = phNumber;
        this.callType = callType;
        this.callDate = callDate;
        this.callDuration = callDuration;
    }

    public String getPhNumber() {
        return phNumber;
    }

    public void setPhNumber(String phNumber) {
        this.phNumber = phNumber;
    }

    public String getCallType() {
        return callType;
    }

    public void setCallType(String callType) {
        this.callType = callType;
    }

    public String getCallDate() {
        return callDate;
    }

    public void setCallDate(String callDate) {
        this.callDate = callDate;
    }

    public String getCallDuration() {
        return callDuration;
    }

    public void setCallDuration(String callDuration) {
        this.callDuration = callDuration;
    }
}
