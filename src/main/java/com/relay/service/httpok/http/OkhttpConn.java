package com.relay.service.httpok.http;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by huyue on 2017/10/12.
 * Okhttp3连接网络获取数据
 */
public class OkhttpConn {

    private OkHttpClient okHttpClient;

    public OkhttpConn(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    /**
     * 获取网页HTML
     * @param Url
     * @return
     * @throws IOException
     */
    public String OkhttpParseToString(String Url) {

        Request request = new Request.Builder().url(Url).build();

        Response response = null;

        String result = null;

        try {
            response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                result = response.body().string();
            }else{
                throw new IOException("服务器端错误: " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
             if(response!=null){
                 response.close();
             }
        }

        return result;
    }

    /**
     * 获取字节数组
     * @param Url
     * @return
     * @throws IOException
     */
    public byte[] OkhttpParseToByte(String Url) {

        Request request = new Request.Builder().url(Url).build();

        Response response = null;

        byte[] result = null;

        try {
            response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                result = response.body().bytes();
            }else{
                throw new IOException("服务器端错误: " + response);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(response!=null){
                response.close();
            }
        }
        return result;
    }

    /**
     * 获取字节流
     * @param Url
     * @return
     * @throws IOException
     */
    public InputStream OkhttpParseTobyteStream(String Url) {

        Request request = new Request.Builder().url(Url).build();

        Response response = null;

        InputStream result = null;

        try {
            response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                result = response.body().byteStream();
            }else{
                throw new IOException("服务器端错误: " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(response!=null){
                response.close();
            }
        }

        return result;
    }

    public int getResponseCode(String Url) {
        Request request = new Request.Builder().url(Url).build();
        Response response = null;
        int code = 404;
        try {
            response = okHttpClient.newCall(request).execute();
            code = response.code();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(response!=null){
                response.close();
            }
        }
        return code;
    }
}
