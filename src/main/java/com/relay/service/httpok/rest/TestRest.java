package com.relay.service.httpok.rest;

import com.relay.service.httpok.http.OkhttpConn;
import com.relay.service.httpok.http.OkhttpUtil;
import okhttp3.OkHttpClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author huyue@hdsxtech.com
 * @date 2018/6/28 13:13
 */

@RestController
@RequestMapping("test")
public class TestRest {


    public void doGet(HttpServletResponse response, String url){

        OkHttpClient okHttpClient = OkhttpUtil.getInstance();
        OkhttpConn okhttpConn = new OkhttpConn(okHttpClient);
        String s = okhttpConn.OkhttpParseToString(url);
        try {
            PrintWriter writer = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
