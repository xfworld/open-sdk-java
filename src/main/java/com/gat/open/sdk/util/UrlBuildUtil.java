package com.gat.open.sdk.util;

import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * URL拼接工具类
 *
 * @author Stanley Shen
 * @version 1.0.0
 * @date 2018/4/27 14:51
 */
public class UrlBuildUtil {

    /**
     * 拼接URL
     *
     * @param url    请求url
     * @param params 参数
     * @return 拼接后地址
     * @throws UnsupportedEncodingException 编码异常
     */
    public static String build(String url, Map<String, Object> params) throws UnsupportedEncodingException {
        if (params == null || params.isEmpty()) {
            return url;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(url);
        stringBuilder.append("?");
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            if (entry.getValue() != null && StringUtils.isNotBlank(entry.getValue().toString())) {
                stringBuilder.append(entry.getKey());
                stringBuilder.append("=");
                stringBuilder.append(URLEncoder.encode(entry.getValue().toString(), "UTF-8")).append("");
                stringBuilder.append("&");
            }
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

}
