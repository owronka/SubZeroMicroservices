package com.axxessio.axx2cld.login.controller;

import java.io.IOException;


import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class CreateDataAtBeginning {

	public static void createData() throws IOException {
		OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, "[{\"name\": \"Peter\",\"salt\": \"adadad\",\"passwordHash\": \"1234\"},{\"name\": \"Jupp\",\"salt\": \"adadad\",\"passwordHash\": \"1234\"},{\"name\": \"Steve\",\"salt\": \"adadad\",\"passwordHash\":\"1234\"},{\"name\": \"Marie\",\"salt\": \"adadad\",\"passwordHash\": \"1234\"}]");
		Request request = new Request.Builder()
		  .url("http://localhost:8001/srvc/login/saveAccounts")
		  .post(body)
		  .addHeader("content-type", "application/json")
		  .addHeader("cache-control", "no-cache")
		  .addHeader("postman-token", "84ce7009-bcaf-04c1-90d1-4b55882884c3")
		  .build();

		Response response = client.newCall(request).execute();
	}
	
	
}
