package com.yunqi.cloudenglish.dto;

import com.yunqi.cloudenglish.enums.ResponseMsg;

import java.util.Date;

/**
 * @描述:
 * @版权: Copyright (c) 2018
 * @创建人 Jesse Xue
 * @创建时间 15:22 2018/5/14
 * @版本 v1.0
 */
public class ResponseDto<T> {

    private String msg;
    private T data;
    private Date serverTime;

    public ResponseDto(T data) {
        this.data = data;
        this.serverTime=new Date();
    }

    public ResponseDto(String msg, T data) {

        this.msg = msg;
        this.data = data;
        this.serverTime=new Date();
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Date getServerTime() {
        return this.serverTime;
    }

    public void setServerTime(Date serverTime) {
        this.serverTime = serverTime;
    }

    @Override
    public String toString() {
        return "ResponseDto{" +
                "data=" + data +
                ", serverTime=" + serverTime +
                '}';
    }

    public static <T> ResponseDto<T> ok(){
        return new ResponseDto<T>(ResponseMsg.OK.getMsg(),null);
    }

    public static <T> ResponseDto<T> ok(T data){
        return new ResponseDto<T>(ResponseMsg.OK.getMsg(),data);
    }

    public static <T> ResponseDto<T> badRequest(){
        return new ResponseDto<T>(ResponseMsg.BAD_REQUEST.getMsg(),null);
    }

    public static <T> ResponseDto<T> badRequest(T date){
        return new ResponseDto<T>(ResponseMsg.BAD_REQUEST.getMsg(),date);
    }

    public static <T> ResponseDto<T> notFound() {
        return new ResponseDto<>(ResponseMsg.NOT_FOUND.getMsg(),null);
    }

    public static <T> ResponseDto<T> notFound(T data) {
        return new ResponseDto<>(ResponseMsg.NOT_FOUND.getMsg(),data);
    }

    public static <T> ResponseDto<T> invalidParam() {
        return new ResponseDto<>(ResponseMsg.INVALID_PARAM.getMsg(),null);
    }

    public static <T> ResponseDto<T> invalidParam(T data) {
        return new ResponseDto<>(ResponseMsg.INVALID_PARAM.getMsg(),data);
    }
}
