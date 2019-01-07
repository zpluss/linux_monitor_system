package com.ihzsr.monitor.jar.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.*;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class HttpClientUtils
{
    private static Logger LOGGER = LoggerFactory.getLogger(HttpClientUtils.class);
    private static PoolingHttpClientConnectionManager cm = null;

    static 
    {
        LayeredConnectionSocketFactory sslsf = null;
        try {
            sslsf = new SSLConnectionSocketFactory(SSLContext.getDefault());
        } catch (NoSuchAlgorithmException e) {
            LOGGER.error("创建SSL连接失败");
        }
        Registry<ConnectionSocketFactory> socketFactoryRegistry = null;
        if (sslsf != null)
        {
            socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("https", sslsf)
                    .register("http", new PlainConnectionSocketFactory())
                    .build();
        }
        if (socketFactoryRegistry != null)
        {
            cm =new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        }
        cm.setMaxTotal(20);//多线程调用注意配置，根据线程数设定
        cm.setDefaultMaxPerRoute(20);//多线程调用注意配置，根据线程数设定
    }

    private static CloseableHttpClient getHttpClient() 
    {
        return HttpClients.custom()
                .setConnectionManager(cm)
                .build();
    }

    public static String doGet(String url)
    {
        CloseableHttpClient client=HttpClientUtils.getHttpClient();
        // 发送get请求
        HttpGet request = null;
        CloseableHttpResponse response=null;
        // 设置请求和传输超时时间
        try
        {
            request=new HttpGet(url);
            LOGGER.info("execution get request,url:"+request.getURI());
            response=client.execute(request);

            HttpEntity entity=response.getEntity();
            if(entity!=null)
            {
                String result=EntityUtils.toString(entity);
                int statusCode=response.getStatusLine().getStatusCode();
                LOGGER.info("response status code:"+statusCode);
                LOGGER.info("response contect:"+result);
                if(statusCode== HttpStatus.SC_OK)
                {
                    return result;
                }else
                {
                    return statusCode+"";
                }
            }
            return null;
        }catch (IOException e)
        {
            LOGGER.error("the httpclent request failed");
            return null;
        }finally
        {
            if(response!=null)
            {
                try
                {
                    EntityUtils.consume(response.getEntity());
                    response.close();
                }catch (IOException e)
                {
                    LOGGER.error("the response close failed");
                }
            }
        }

        /*RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(20000)//数据传输过程中数据包之间间隔的最大时间
                .setConnectTimeout(20000)//连接建立时间，三次握手完成时间
                .setExpectContinueEnabled(true)//重点参数 
                .setConnectionRequestTimeout(10000)
                .setStaleConnectionCheckEnabled(true)//重点参数，在请求之前校验链接是否有效
                .build();
        request.setConfig(requestConfig);
        try {
            response = client.execute(request);
            if(response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                System.out.println("请求失败");
                return  null;

            }
            HttpEntity resEntity =  response.getEntity();
            if(resEntity==null){
                return  null;
            }
            result=EntityUtils.toString(resEntity, "UTF-8");
            return result;
        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
            return null;
        } catch (ClientProtocolException e) {
            System.out.println(e.getMessage());
            return null;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }finally
        {
            if (response != null)
            {
                try
                {
                    //此处调优重点，多线程模式下可提高性能。
                    EntityUtils.consume(response.getEntity());//此处高能，通过源码分析，由EntityUtils是否回收HttpEntity

                    response.close();
                } catch (IOException e)
                {
                    System.out.println("关闭response失败:" + e);
                }
            }
        }*/
    }
}