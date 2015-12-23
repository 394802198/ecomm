package com.sooeez.ecomm.api.mdd.etx;

import java.io.IOException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class EcommHttp {

	public EcommHttp() {
	}

	public static String postRequest(String url) {
		
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet get = new HttpGet(url);
		CloseableHttpResponse response;
		String json = null;
		try {
			response = client.execute(get);
			json = EntityUtils.toString(response.getEntity(), "UTF-8");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return json;
	}

}
