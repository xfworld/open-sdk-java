package com.gat.open.sdk;

import com.gat.open.sdk.model.ApiResponse;
import com.gat.open.sdk.model.Token;
import junit.framework.TestCase;
import org.junit.Assert;

import java.io.UnsupportedEncodingException;

/**
 * @author Stanley Shen
 * @version 1.0.0
 * @date 2018/5/2 15:47
 */
public class ApiTest extends TestCase {

    GATOpen gatOpen = new GATOpen("20110667", "a9d2cc6a4e8f58b50b8314644bdcc829", "https://openapi.guanaitong.cc");

    public void testCreateToken() {
        ApiResponse<Token> token = gatOpen.createToken();
        Assert.assertNotNull(token);
        Assert.assertNotNull(token.getData().getAccessToken());
        System.out.println("token = " + token.getData().getAccessToken());
    }

    public void testLoginByCorpCode() {
        ApiResponse<String> result = gatOpen.loginByCorpCode(null, "H002");
        Assert.assertNotNull(result);
        System.out.println("result = " + result.getData());
    }

    public void testLoginUrl() throws UnsupportedEncodingException {
        ApiResponse<String> result = gatOpen.loginByCorpCode(null, "H002");
        Assert.assertNotNull(result);
        String url = gatOpen.loginUrl(result.getData(), null);
        Assert.assertNotNull(url);
        System.out.println("url = " + url);
    }

}
