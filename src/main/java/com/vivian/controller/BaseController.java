package com.vivian.controller;

import com.vivian.jsonModel.ResponseBean;
import com.vivian.tools.JsonTools;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class BaseController {

    @Autowired
    protected HttpServletRequest request;

    private static final long serialVersionUID = 1L;


    public String onFailed(int code, String msg) {
        ResponseBean responseBean = new ResponseBean();
        responseBean.setCode(code);
        responseBean.setMessage(msg);
        return JsonTools.getJsonString(responseBean);
    }

    public String onSuccess(List<?> list) {
        ResponseBean responseBean = new ResponseBean();
        responseBean.setCode(200);
        responseBean.setData(list);
        return JsonTools.getJsonString(responseBean);
    }

    public String onSuccess(String desc) {
        ResponseBean responseBean = new ResponseBean();
        responseBean.setCode(200);
        responseBean.setMessage(desc);
        return JsonTools.getJsonString(responseBean);

    }

    public String onSuccess(Object object) {
        ResponseBean responseBean = new ResponseBean();
        responseBean.setCode(200);
        responseBean.setData(object);
        return JsonTools.getJsonString(responseBean);
    }
}
