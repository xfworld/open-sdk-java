package com.gat.open.sdk.api;


import com.gat.open.sdk.annotation.Valid;
import com.gat.open.sdk.annotation.ValidGroup;
import com.gat.open.sdk.constant.GATOpenConstant;
import com.gat.open.sdk.model.ApiResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * 登陆接口
 *
 * @author xin.hua
 * @date 2017/7/19
 */
public interface LoginApi {

    @FormUrlEncoded
    @POST("sso/employee/getAuthCodeByMobile")
    @ValidGroup({@Valid(index = 0, minLen = 1, maxLen = 20),
            @Valid(index = 1, required = true, length = 11, regStr = GATOpenConstant.MOBILE_REGEX)})
    Call<ApiResponse<String>> loginByMobile(@Field("enterprise_code") String enterpriseCode,
                                            @Field("mobile") String mobile);

    @FormUrlEncoded
    @POST("sso/employee/getAuthCodeByCorpCode")
    @ValidGroup({@Valid(index = 0, minLen = 1, maxLen = 20),
            @Valid(index = 1, required = true, minLen = 1, maxLen = 20)})
    Call<ApiResponse<String>> loginByCorpCode(@Field("enterprise_code") String enterpriseCode,
                                              @Field("corp_code") String corpCode);

}
