package com.example.penguintestdemo;

import com.alibaba.fastjson.JSONObject;
import com.efounder.api.jersey.client.RestClient;
import com.efounder.api.jersey.model.RequestParam;
import com.efounder.eai.service.ParameterManager;
import jakarta.ws.rs.core.MediaType;

import java.util.HashMap;
import java.util.Map;

/**
 * 前台调用后台接口
 * @author penguin
 * @date 2023/2/21 16:33
 */
public class interfaceCall {
    /**
     * 前台调用后台接口
     * jersey 依赖
     * @throws Exception
     */
    public void interCall() throws Exception {
        RequestParam requestParams = new RequestParam();
        Map<String,String> headers = new HashMap<>();
        String str = "{\n" +
                "  \"fGuid\":\"555545\",\n" +
                "  \"name\":\"测试1\",\n" +
                "  \"spaceAdmin\":\"aaa,ccc\",\n" +
                "  \"spaceBh\":\"0001\",\n" +
                "  \"spaceJs\":\"1\",\n" +
                "  \"spaceMx\":\"1\",\n" +
                "  \"createBy\":\"pt\",\n" +
                "  \"updateBy\":\"pt\"\n" +
                "}";
        headers.put("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsInBhc3N3b3JkIjotOTQ1Nzk3NjA2LCJleHAiOjE4NTYzNDQ0MTR9.9FhLvknOA-u8trJwjM8RJXGJBo5pgpxjrAG0PwcXOas");
        headers.put("Content-Type", "application/json");
        /*String path = (String) context.get(FilterConstants.API_REQUEST_PATH);
        String url = ApiRouteConfig.getBackTokenUrl(path);*/
        String url = ParameterManager.getDefault().getSystemParam("callUrl");
        requestParams.setRequestUrl("http://localhost:8080/api/v1/spaces/saveSpace");
        requestParams.setRequestEntity(str);
        requestParams.setHeadParams(headers);
        requestParams.setReturnType(JSONObject.class);
        requestParams.setAcceptMediaType(MediaType.APPLICATION_JSON);
        requestParams.setRequestMediaType(MediaType.APPLICATION_JSON);
        RestClient.post(requestParams);
    }
}
