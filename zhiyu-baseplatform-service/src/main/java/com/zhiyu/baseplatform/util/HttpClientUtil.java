package com.zhiyu.baseplatform.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;


public class HttpClientUtil {

	private static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

	private static PoolingHttpClientConnectionManager clientConnectionManager=null;
	private static CloseableHttpClient httpClient=null;
	private final static Object syncLock = new Object();
	private static RequestConfig config = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD_STRICT).build();

	static {
	    Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
	            .register("https", SSLConnectionSocketFactory.getSocketFactory())
	            .register("http", PlainConnectionSocketFactory.getSocketFactory())
	            .build();
	    clientConnectionManager =new PoolingHttpClientConnectionManager(socketFactoryRegistry);
	    clientConnectionManager.setMaxTotal(50);
	    clientConnectionManager.setDefaultMaxPerRoute(25);
	}

    private static CloseableHttpClient getHttpClient(){
        if(httpClient == null){
            synchronized (syncLock){
                if(httpClient == null){
                    httpClient =HttpClients.custom().setConnectionManager(clientConnectionManager).setDefaultRequestConfig(config).build();
                }
            }
        }
        return httpClient;
    }

	public static String doJsonPost(String url, Map<String, String> params) {
		try {

			CloseableHttpClient httpClient = getHttpClient();
	        String result = "";

	        try {
		        HttpPost httpRequst = new HttpPost(url);//创建HttpPost对象

		        String paramsJson = (new ObjectMapper()).writeValueAsString(params);
				httpRequst.setEntity(new StringEntity(paramsJson, Consts.UTF_8));
				httpRequst.setHeader("Accept", "application/json");
	            httpRequst.setHeader("Accept-Charset", "UFT-8");
	            httpRequst.setHeader("Content-Type", "application/json; charset=UTF-8");

	            CloseableHttpResponse httpResponse = httpClient.execute(httpRequst);
	            if(httpResponse.getStatusLine().getStatusCode() == 200)
	            {
	                HttpEntity httpEntity = httpResponse.getEntity();
	                result = EntityUtils.toString(httpEntity);//取出应答字符串
	            }
	        } catch (UnsupportedEncodingException e) {
	        	logger.error(e.getMessage());
	            result = e.getMessage().toString();
	        }
	        catch (ClientProtocolException e) {
	        	logger.error(e.getMessage());
	            result = e.getMessage().toString();
	        }
	        catch (IOException e) {
	        	logger.error(e.getMessage());
	            result = e.getMessage().toString();
	        }
	        return result;
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace(System.out);
		}
		return "";
	}

	public static String doHttpPost(String url, Map<String, String> params) {

		CloseableHttpClient httpClient = getHttpClient();
		HttpPost post = new HttpPost(url);
		post.setHeader("Accept-Charset", "utf-8");
		post.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		for (Entry<String, String> entry : params.entrySet()) {
			nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
		}

		CloseableHttpResponse httpResponse = null;
		try {
			post.setEntity(new UrlEncodedFormEntity(nvps, Consts.UTF_8));

			httpResponse = httpClient.execute(post);
            if(httpResponse.getStatusLine().getStatusCode() == 200) {
                HttpEntity httpEntity = httpResponse.getEntity();
                return EntityUtils.toString(httpEntity);//取出应答字符串
            }
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace(System.out);
		} finally {
			try {
				if (httpResponse != null) {
					httpResponse.close();
				}
			} catch (Exception e) {
				logger.error(e.getMessage());
				e.printStackTrace(System.out);
			}
		}

		return "";
	}

	public static String get(String url, Map<String, String> params) {
		try {
			CloseableHttpClient httpClient = getHttpClient();
			HttpGet httpGet = new HttpGet(url);
			httpGet.setHeader("Accept-Charset", "utf-8");
			httpGet.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			for (Entry<String, String> entry : params.entrySet()) {
				nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
			}

			CloseableHttpResponse httpResponse = null;
			try {
				// 设置参数
				httpGet.setURI(new URI(httpGet.getURI().toString() + "?" + EntityUtils.toString(new UrlEncodedFormEntity(nvps))));
	            // 发送请求
				httpResponse = httpClient.execute(httpGet);
	            if(httpResponse.getStatusLine().getStatusCode() == 200) {
	                HttpEntity httpEntity = httpResponse.getEntity();
	                return EntityUtils.toString(httpEntity);//取出应答字符串
	            }
			} catch (Exception e) {
				logger.error(e.getMessage());
				e.printStackTrace(System.out);
			} finally {
				try {
					if (httpResponse != null) {
						httpResponse.close();
					}
				} catch (Exception e) {
					logger.error(e.getMessage());
					e.printStackTrace(System.out);
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return "";
	}

	public static InputStream downloadFile(String url, Map<String, String> params) {

		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Content-Type", "application/octet-stream");
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		for (Entry<String, String> entry : params.entrySet()) {
			nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
		}

		CloseableHttpResponse httpResponse = null;
		try {
			// 设置参数
			httpGet.setURI(new URI(httpGet.getURI().toString() + "?" + EntityUtils.toString(new UrlEncodedFormEntity(nvps))));
            // 发送请求
			httpResponse = httpClient.execute(httpGet);
            if(httpResponse.getStatusLine().getStatusCode() == 200) {
                HttpEntity httpEntity = httpResponse.getEntity();
                return httpEntity.getContent();
            }
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace(System.out);
		} finally {
			try {
				if (httpResponse != null) {
					httpResponse.close();
				}
			} catch (Exception e) {
				logger.error(e.getMessage());
				e.printStackTrace(System.out);
			}
		}

		return null;
	}
}
