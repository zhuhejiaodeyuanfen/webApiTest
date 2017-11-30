package com.vivian;

import com.alibaba.fastjson.JSONObject;
import com.vivian.tools.JsonTools;

import javax.servlet.http.HttpServlet;
import java.util.List;

public class IHttpServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;


    public String onFailed(String code, String msg) {
        JSONObject result = new JSONObject();
        JSONObject output = new JSONObject();
        result.put("code", code);
        result.put("msg", msg);
        output.put("result", result);
        return output.toJSONString();
    }

    public String onSuccess(List<?> list) {
        ResponseBean responseBean = new ResponseBean();
        responseBean.setCode(100);
        responseBean.setData(list);
        return JsonTools.getJsonString(responseBean);
    }


}
