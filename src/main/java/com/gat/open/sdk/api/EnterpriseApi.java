package com.gat.open.sdk.api;

import com.gat.open.sdk.annotation.Valid;
import com.gat.open.sdk.annotation.ValidGroup;
import com.gat.open.sdk.model.ApiResponse;
import com.gat.open.sdk.model.response.LimitStatus;
import com.gat.open.sdk.model.response.EnterpriseAccount;
import com.gat.open.sdk.model.response.PointStatus;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.math.BigDecimal;
import java.util.List;

/**
 * 企业接口
 *
 * @author xin.hua
 * @date 2017/7/19
 */
public interface EnterpriseApi {

    @FormUrlEncoded
    @POST("assets/jifen/enterprise/assign/single")
    @ValidGroup({@Valid(index = 0, minLen = 1, maxLen = 20),
            @Valid(index = 1, required = true, minLen = 1, maxLen = 20),
            @Valid(index = 2),
            @Valid(index = 3, required = true, scale = 2, decMin = 0.01, decMax = 99999999.99),
            @Valid(index = 4, required = true, minLen = 1, maxLen = 254),
            @Valid(index = 5, required = true, minLen = 2, maxLen = 22)})
    Call<ApiResponse<String>> pointAssign(@Field("enterprise_code") String enterpriseCode,
                                          @Field("corp_code") String corpCode,
                                          @Field("account_openid") String accountOpenid,
                                          @Field("amount") BigDecimal amount,
                                          @Field("reason") String reason,
                                          @Field("external_code") String externalCode);

    @FormUrlEncoded
    @POST("assets/jifen/enterprise/recycle")
    @ValidGroup({@Valid(index = 0, minLen = 1, maxLen = 20),
            @Valid(index = 1, required = true, minLen = 1, maxLen = 20),
            @Valid(index = 2, required = true, scale = 2, decMin = 0.01, decMax = 99999999.99),
            @Valid(index = 3, required = true, minLen = 1, maxLen = 254),
            @Valid(index = 4, required = true, minLen = 2, maxLen = 22)})
    Call<ApiResponse<String>> pointRecycle(@Field("enterprise_code") String enterpriseCode,
                                           @Field("corp_code") String corpCode,
                                           @Field("amount") BigDecimal amount,
                                           @Field("reason") String reason,
                                           @Field("external_code") String externalCode);

    @FormUrlEncoded
    @POST("assets/jifen/enterprise/assign/status")
    @ValidGroup({@Valid(index = 0, required = true, minLen = 2, maxLen = 22)})
    Call<ApiResponse<PointStatus>> pointStatus(@Field("external_code") String externalCode);

    @FormUrlEncoded
    @POST("assets/account/enterprise/get")
    @ValidGroup({})
    Call<ApiResponse<List<EnterpriseAccount>>> enterpriseAccount(@Field("account_openid") String accountOpenid,
                                                                 @Field("enterprise_code") String enterpriseCode,
                                                                 @Field("type") Integer type);

    @FormUrlEncoded
    @POST("assets/limit/enterprise/assign/single")
    @ValidGroup({@Valid(index = 0, required = true),
            @Valid(index = 1, minLen = 1, maxLen = 20),
            @Valid(index = 2, required = true, minLen = 1, maxLen = 20),
            @Valid(index = 3, required = true, scale = 2, decMin = 0.01, decMax = 99999999.99),
            @Valid(index = 4, minLen = 0, maxLen = 100),
            @Valid(index = 5, minLen = 0, maxLen = 100),
            @Valid(index = 6, required = true, minLen = 2, maxLen = 22)})
    Call<ApiResponse<String>> limitAssign(@Field("limit_openid") String limitOpenid,
                                          @Field("enterprise_code") String enterpriseCode,
                                          @Field("corp_code") String corpCode,
                                          @Field("amount") BigDecimal amount,
                                          @Field("remark") String remark,
                                          @Field("comment") String comment,
                                          @Field("external_code") String externalCode);

    @FormUrlEncoded
    @POST("assets/limit/enterprise/assign/status")
    @ValidGroup({@Valid(index = 0, required = true, minLen = 2, maxLen = 22)})
    Call<ApiResponse<LimitStatus>> limitStatus(@Field("external_code") String externalCode);

    @FormUrlEncoded
    @POST("assets/limit/enterprise/assign/status")
    @ValidGroup({@Valid(index = 0, required = true),
            @Valid(index = 1, required = true, minLen = 1, maxLen = 20),
            @Valid(index = 2, required = true, minLen = 1, maxLen = 20),
            @Valid(index = 3, required = true, scale = 2, decMin = 0.01, decMax = 99999999.99),
            @Valid(index = 4, minLen = 0, maxLen = 100),
            @Valid(index = 5, minLen = 2, maxLen = 24, required = true)})
    Call<ApiResponse<String>> limitRecycle(@Field("limit_openid") String limitOpenid,
                                           @Field("enterprise_code") String enterpriseCode,
                                           @Field("corp_code") String corpCode,
                                           @Field("amount") BigDecimal amount,
                                           @Field("remark") String remark,
                                           @Field("external_code") String externalCode);
}
