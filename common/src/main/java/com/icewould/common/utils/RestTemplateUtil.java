package com.icewould.common.utils;
 
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName: RestTemplateUtil
 *
 * @Description: http请求传输类
 * @author cy
 */
@Component
public class RestTemplateUtil {
 
    private static class SingleTonHolder{
 
        private static RestTemplate restTemplate = new RestTemplate();
    }
 
    private RestTemplateUtil() {}
 
    /**
     * 单例实例
     * @return
     */
    public static RestTemplate getInstance(){
 
        return SingleTonHolder.restTemplate;
    }
 
    /**
     * post请求 不加密
     * @param requestUrl 访问连接
     * @param data 传输参数json
     * @return
     */
    public static String post(String requestUrl, String data ){
        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Content-Type","application/json; charset=utf-8");
 
            HttpEntity<String> httpEntity = new HttpEntity<>(data, httpHeaders);
            return RestTemplateUtil.getInstance().postForObject(requestUrl,httpEntity,String.class);
        } catch (Exception e) {
        	e.printStackTrace();
            return "请求失败";
        }
    }
    
    /**
     * post请求 不加密
     * @param requestUrl 访问连接
     * @param data 传输参数json
     * @return
     */
    public static byte[] postGetBuffer(String requestUrl, String data ){
        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Content-Type","application/json; charset=utf-8");
 
            HttpEntity<String> httpEntity = new HttpEntity<>(data, httpHeaders);
            return RestTemplateUtil.getInstance().postForObject(requestUrl,httpEntity,byte[].class);
        } catch (Exception e) {
        	e.printStackTrace();
            return null ;
        }
    }
 
    /**
     * get根据url获取对象
     */
    public static String get(String url) {
        try {
            return RestTemplateUtil.getInstance().getForObject(url, String.class, new Object[] {});
        } catch (RestClientException e) {
            e.printStackTrace();
            return "请求失败";
        }
    }
}