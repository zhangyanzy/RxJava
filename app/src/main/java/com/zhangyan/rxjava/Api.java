package com.zhangyan.rxjava;

import com.zhangyan.rxjava.bean.LoginRequest;
import com.zhangyan.rxjava.bean.LoginResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;

/**
 * Created by zhangYan on 2018/1/16.
 */

public interface Api {
    @GET("")
    Observable<LoginResponse> login(@Body LoginRequest request);

}
