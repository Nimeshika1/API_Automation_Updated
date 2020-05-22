package com.sysco.api_automation.api.requests.functions;

import com.jayway.restassured.response.Response;
import com.sysco.api_automation.api.common.URIs;
import com.sysco.api_automation.api.util.HeadersUtil;
import com.sysco.api_automation.api.util.RequestUtil;
import com.syscolab.qe.core.api.restassured.RestUtil;
import com.syscolab.qe.core.api.util.RequestMethods;
import com.sysco.api_automation.api.common.URIs.*;

import java.util.Map;

public class Project {

    public static Response getEmployeeProjects() {
        RequestUtil.setRequestBaseUrls();
        return RequestUtil.send(HeadersUtil.getBasicHeaders(RequestUtil.getToken()), "", URIs.employeeListUrl, RequestMethods.GET.toString(), null);

    }
    public static Response getEmployeeProjects(String uri) {
        RequestUtil.setRequestBaseUrls();
        return RequestUtil.send(HeadersUtil.getBasicHeaders(RequestUtil.getToken()), null, uri, RequestMethods.GET.toString(), null);

    }

}


