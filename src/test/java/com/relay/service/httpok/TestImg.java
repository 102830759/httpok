package com.relay.service.httpok;

import com.relay.service.httpok.http.OkhttpConn;
import com.relay.service.httpok.http.OkhttpUtil;
import com.relay.service.httpok.util.FileUtils;
import okhttp3.OkHttpClient;

/**
 * @author huyue@hdsxtech.com
 * @date 2018/7/19 17:53
 */
public class TestImg {

    public static void main(String[] ags) {
        OkHttpClient okHttpClient = OkhttpUtil.getInstance();
        OkhttpConn okhttpConn = new OkhttpConn(okHttpClient);
        byte[] data = okhttpConn.OkhttpParseToByte("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1328444097,3944230346&fm=27&gp=0.jpg");
        if (data != null) {
            Boolean flag1 = FileUtils.writeFile("F:\\download\\图片\\美女.jpg", data);
            if(flag1)
                System.out.println("图片下载成功");
            else
                System.out.println("图片下载失败");
        }
    }
}
