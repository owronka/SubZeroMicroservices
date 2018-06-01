package com.axxessio.axx2cld.registration.client;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.http.HttpEntity;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.axxessio.axx2cld.registration.facade.to.UserTO;

/**
 * @author wronka
 *
 */
public class SrvClient {
	private static String URL;

	private static final ObjectMapper mapper = new ObjectMapper();

	private static Logger logger = LoggerFactory.getLogger(SrvClient.class);;

	private CloseableHttpClient httpclient = HttpClients.createDefault();

	private UsernamePasswordCredentials creds;

	/**
	 * @param url
	 *            server url e.g. http://localhost:8080"
	 * @param usr
	 *            server usr, default is 'system'
	 * @param pwd
	 *            server pwd, default is 'system'
	 */
	public SrvClient(String url, String usr, String pwd) {
		URL = url;

		creds = new UsernamePasswordCredentials(usr, pwd);

		logger.info("Setup Registration Service Client on URL [" + url + "]");
	}
	
	public UserTO getAccounts(long version) throws AuthenticationException, IOException {
		CloseableHttpResponse response = null;
		HttpGet httpGet = new HttpGet(URL + "/registration/srv/user?aspects=~account&version=" + version);
		HttpEntity responseBody = null;
		UserTO uto = null;

		httpGet.addHeader(new BasicScheme().authenticate(creds, httpGet, null));
		httpGet.addHeader("Accept", "application/json");
		httpGet.addHeader("Content-Type", "application/x-www-form-urlencoded");

		response = httpclient.execute(httpGet);
		
		if (response.getStatusLine().getStatusCode() == 404) {
			//throw new ApplicationException(ErrorCodes.UNKNOW_USER, "unknown user", response.getStatusLine().getStatusCode());
		}

		responseBody = response.getEntity();

		uto = mapper.readValue(responseBody.getContent(), UserTO.class);

		EntityUtils.consume(responseBody);

		response.close();

		return uto;
	}
}
