package com.base.wang.util;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResponseUtil {

	public static void responseJson(HttpServletResponse response, int status, Object data) {
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Methods", "*");
			response.setContentType("application/json;charset=UTF-8");
			response.setStatus(status);

			response.getWriter().write(JsonUtil.toJsonString(data));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
