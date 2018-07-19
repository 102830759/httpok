package com.relay.service.httpok.http;

import okhttp3.OkHttpClient;

/**
 * Created by huyue on 2017/10/12.
 */
public class OkhttpUtil {

    private final static OkHttpClient okHttpClient = new OkHttpClient.Builder().build();

    public static OkHttpClient getInstance() {
        synchronized(OkhttpUtil.class){
            return okHttpClient;
        }
    }
}
