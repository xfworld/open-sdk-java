package com.gat.open.sdk;


import com.gat.open.sdk.api.*;
import com.gat.open.sdk.constant.GATOpenConstant;
import com.gat.open.sdk.model.*;
import com.gat.open.sdk.model.request.*;
import com.gat.open.sdk.model.response.Employee;
import com.gat.open.sdk.model.response.EnterpriseAccount;
import com.gat.open.sdk.model.response.LimitStatus;
import com.gat.open.sdk.model.response.PointStatus;
import com.gat.open.sdk.service.GATTokenService;
import com.gat.open.sdk.util.CallUtil;
import com.gat.open.sdk.util.RetrofitFactory;
import com.gat.open.sdk.util.SignUtil;
import com.gat.open.sdk.util.UrlBuildUtil;
import retrofit2.Call;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xin.hua
 * @date 2017/7/18
 */
public class GATOpen {

    private RetrofitFactory retrofitFactory;

    public GATOpen(String appId, String appSecret) {
        GATOpenConstant.init(appId, appSecret);
        retrofitFactory = RetrofitFactory.getInstance();
    }

    public GATOpen(String appId, String appSecret, String baseUrl) {
        GATOpenConstant.init(appId, appSecret, baseUrl);
        retrofitFactory = RetrofitFactory.getInstance();

    }

    /**
     * 设置网络连接读取超时时间
     *
     * @param connectTimeOut 链接超时时间
     * @param readTimeOut    写入超时时间
     * @param writeTimeOut   读取超时时间
     * @param debugHttpLog   是否打印记录debug日志
     */
    public void config(long connectTimeOut, long readTimeOut, long writeTimeOut, boolean debugHttpLog) {
        retrofitFactory.config(connectTimeOut, readTimeOut, writeTimeOut, debugHttpLog);
    }

    // ==== token ====

    /**
     * 获取token
     *
     * @return 返回access_token
     */
    public ApiResponse<Token> createToken() {
        TokenApi tokenApi = retrofitFactory.getApi(TokenApi.class);
        Call<ApiResponse<Token>> call = tokenApi.createToken(GATOpenConstant.appId);
        return CallUtil.execute(call);
    }

    /**
     * 查询token状态
     *
     * @param accessToken access_token
     * @return token状态
     */
    public ApiResponse<Token> getTokenInfo(String accessToken) {
        TokenApi tokenApi = retrofitFactory.getApi(TokenApi.class);
        Call<ApiResponse<Token>> call = tokenApi.getTokenInfo(accessToken, GATOpenConstant.appId);
        return CallUtil.execute(call);
    }

    // ==== 企业接口 =====

    /**
     * 企业积分发放
     *
     * @param pointAssign 积分发放
     * @return 交易号
     */
    public ApiResponse<String> pointAssign(PointAssign pointAssign) {
        EnterpriseApi enterpriseApi = retrofitFactory.getApi(EnterpriseApi.class);
        Call<ApiResponse<String>> call = enterpriseApi.pointAssign(pointAssign.getEnterpriseCode(),
                pointAssign.getCorpCode(), pointAssign.getAccountOpenid(), pointAssign.getAmount(),
                pointAssign.getReason(), pointAssign.getExternalCode());
        return CallUtil.execute(call);
    }

    /**
     * 企业积分回收
     *
     * @param pointRecycle 积分回收
     * @return 交易号
     */
    public ApiResponse<String> pointRecycle(PointRecycle pointRecycle) {
        EnterpriseApi enterpriseApi = retrofitFactory.getApi(EnterpriseApi.class);
        Call<ApiResponse<String>> call = enterpriseApi.pointRecycle(pointRecycle.getEnterpriseCode(),
                pointRecycle.getCorpCode(), pointRecycle.getAmount(), pointRecycle.getReason(),
                pointRecycle.getExternalCode());
        return CallUtil.execute(call);
    }

    /**
     * 企业积分发放操作状态查询
     *
     * @param externalCode 交易号
     * @return 发放状态
     */
    public ApiResponse<PointStatus> pointStatus(String externalCode) {
        EnterpriseApi enterpriseApi = retrofitFactory.getApi(EnterpriseApi.class);
        Call<ApiResponse<PointStatus>> call = enterpriseApi.pointStatus(externalCode);
        return CallUtil.execute(call);
    }

    /**
     * 查询企业资产账户及余额
     *
     * @param accountOpenid  账户ID
     * @param enterpriseCode 公司编码
     * @param type           账户类型
     * @return 企业账户信息
     */
    public ApiResponse<List<EnterpriseAccount>> enterpriseAccount(String accountOpenid, String enterpriseCode, Integer type) {
        EnterpriseApi enterpriseApi = retrofitFactory.getApi(EnterpriseApi.class);
        Call<ApiResponse<List<EnterpriseAccount>>> call = enterpriseApi.enterpriseAccount(accountOpenid, enterpriseCode, type);
        return CallUtil.execute(call);
    }

    /**
     * 企业额度单个发放
     *
     * @param limitAssign 额度发放
     * @return 交易号
     */
    public ApiResponse<String> limitAssign(LimitAssign limitAssign) {
        EnterpriseApi enterpriseApi = retrofitFactory.getApi(EnterpriseApi.class);
        Call<ApiResponse<String>> call = enterpriseApi.limitAssign(limitAssign.getLimitOpenid(),
                limitAssign.getEnterpriseCode(), limitAssign.getCorpCode(), limitAssign.getAmount(),
                limitAssign.getRemark(), limitAssign.getComment(), limitAssign.getExternalCode());
        return CallUtil.execute(call);
    }

    /**
     * 额度发放状态查询
     *
     * @param externalCode 交易号
     * @return 额度发放状态
     */
    public ApiResponse<LimitStatus> limitStatus(String externalCode) {
        EnterpriseApi enterpriseApi = retrofitFactory.getApi(EnterpriseApi.class);
        Call<ApiResponse<LimitStatus>> call = enterpriseApi.limitStatus(externalCode);
        return CallUtil.execute(call);
    }

    /**
     * 企业额度单个回收
     *
     * @param limitRecycle 额度回收
     * @return 交易号
     */
    public ApiResponse<String> limitRecycle(LimitRecycle limitRecycle) {
        EnterpriseApi enterpriseApi = retrofitFactory.getApi(EnterpriseApi.class);
        Call<ApiResponse<String>> call = enterpriseApi.limitRecycle(limitRecycle.getLimitOpenid(), limitRecycle.getEnterpriseCode(), limitRecycle.getCorpCode(), limitRecycle.getAmount(), limitRecycle.getRemark(), limitRecycle.getExternalCode());
        return CallUtil.execute(call);
    }

    // ==== 员工接口  ====

    /**
     * 添加员工
     *
     * @param employeeBO 员工信息
     * @return 工号
     */
    public ApiResponse<String> addEmployee(EmployeeBO employeeBO) {
        EmployeeApi employeeApi = retrofitFactory.getApi(EmployeeApi.class);
        Call<ApiResponse<String>> call = employeeApi.addEmployee(employeeBO.getEnterpriseCode(),
                employeeBO.getCorpCode(), employeeBO.getName(), employeeBO.getGender(), employeeBO.getEmail(),
                employeeBO.getMobile(), employeeBO.getSendInvite(), employeeBO.getRemark(), employeeBO.getDeptCode(),
                employeeBO.getLevel(), employeeBO.getBirthDay(), employeeBO.getEntryDay(), employeeBO.getCardType(),
                employeeBO.getCardNo());
        return CallUtil.execute(call);
    }

    /**
     * 查询员工
     *
     * @param enterpriseCode 企业编码
     * @param corpCode       工号
     * @return 员工
     */
    public ApiResponse<Employee> getEmployee(String enterpriseCode, String corpCode) {
        EmployeeApi employeeApi = retrofitFactory.getApi(EmployeeApi.class);
        Call<ApiResponse<Employee>> call = employeeApi.getEmployee(enterpriseCode, corpCode);
        return CallUtil.execute(call);
    }

    /**
     * 更新员工
     *
     * @param employeeBO  员工信息
     * @param newCorpcode 新的工号
     * @return 工号
     */
    public ApiResponse<String> updateEmployee(EmployeeBO employeeBO, String newCorpcode) {
        EmployeeApi employeeApi = retrofitFactory.getApi(EmployeeApi.class);
        Call<ApiResponse<String>> call = employeeApi.updateEmployee(employeeBO.getEnterpriseCode(), employeeBO.getCorpCode(),
                employeeBO.getName(), employeeBO.getGender(), employeeBO.getEmail(), employeeBO.getMobile(),
                employeeBO.getRemark(), employeeBO.getDeptCode(), employeeBO.getLevel(), employeeBO.getBirthDay(),
                employeeBO.getEntryDay(), employeeBO.getCardType(), employeeBO.getCardNo(), newCorpcode);
        return CallUtil.execute(call);
    }

    /**
     * 员工离职
     *
     * @param enterpriseCode 公司编码
     * @param corpCode       工号
     * @return 工号
     */
    public ApiResponse<String> resignEmployee(String enterpriseCode, String corpCode) {
        EmployeeApi employeeApi = retrofitFactory.getApi(EmployeeApi.class);
        Call<ApiResponse<String>> call = employeeApi.resignEmployee(enterpriseCode, corpCode);
        return CallUtil.execute(call);
    }

    /**
     * 离职员工复职
     *
     * @param enterpriseCode 公司编号
     * @param corpCode       工号
     * @return result
     */
    public ApiResponse<String> restoreEmployee(String enterpriseCode, String corpCode) {
        EmployeeApi employeeApi = retrofitFactory.getApi(EmployeeApi.class);
        Call<ApiResponse<String>> call = employeeApi.restoreEmployee(enterpriseCode, corpCode);
        return CallUtil.execute(call);
    }

    /**
     * 集团下员工在不同企业调转
     *
     * @param enterpriseCode 公司编号
     * @param corpCode       工号
     * @return result
     */
    public ApiResponse<String> transferEmployee(String corpCode, String enterpriseCode, String newEnterpriseCode) {
        EmployeeApi employeeApi = retrofitFactory.getApi(EmployeeApi.class);
        Call<ApiResponse<String>> call = employeeApi.transferEmployee(enterpriseCode, corpCode, newEnterpriseCode);
        return CallUtil.execute(call);
    }

    /**
     * 批量查询员工
     *
     * @param enterpriseCode 公司编号
     * @param pageIndex      页码
     * @param pageSize       每页数量
     * @return result
     */
    public ApiResponse<BatchModel<Employee>> batchEmployee(String enterpriseCode, Integer pageIndex, Integer pageSize) {
        EmployeeApi employeeApi = retrofitFactory.getApi(EmployeeApi.class);
        Call<ApiResponse<BatchModel<Employee>>> call = employeeApi.batchEmployee(enterpriseCode, pageIndex, pageSize);
        return CallUtil.execute(call);
    }

    /**
     * 查询员工账户
     *
     * @param enterpriseCode 公司编号
     * @param corpCode       工号
     * @return list
     */
    public ApiResponse<List<EmployeeAccount>> accountEmployee(String enterpriseCode, String corpCode) {
        EmployeeApi employeeApi = retrofitFactory.getApi(EmployeeApi.class);
        Call<ApiResponse<List<EmployeeAccount>>> call = employeeApi.accountEmployee(enterpriseCode, corpCode);
        return CallUtil.execute(call);
    }

    // ==== 信任登陆接口 ====

    /**
     * 根据手机号登录
     *
     * @param enterpriseCode 公司编号
     * @param mobile         手机号
     * @return result
     */
    public ApiResponse<String> loginByMobile(String enterpriseCode, String mobile) {
        LoginApi loginApi = retrofitFactory.getApi(LoginApi.class);
        Call<ApiResponse<String>> call = loginApi.loginByMobile(enterpriseCode, mobile);
        return CallUtil.execute(call);
    }

    /**
     * 根据员工工号登录
     *
     * @param corpCode 工号
     * @return
     */
    public ApiResponse<String> loginByCorpCode(String enterpriseCode, String corpCode) {
        LoginApi loginApi = retrofitFactory.getApi(LoginApi.class);
        Call<ApiResponse<String>> call = loginApi.loginByCorpCode(enterpriseCode, corpCode);
        return CallUtil.execute(call);
    }

    // ==== 部门相关接口 ====

    /**
     * @param deptCode
     * @return
     */
    public ApiResponse<Map<String, Object>> getHierarchy(String deptCode) {
        DepartmentApi departmentApi = (DepartmentApi) this.retrofitFactory.getApi(DepartmentApi.class);
        Call<ApiResponse<Map<String, Object>>> call = departmentApi.getHierarchy(deptCode);
        return CallUtil.execute(call);
    }

    public ApiResponse<Department> getDepartment(String deptCode) {
        DepartmentApi departmentApi = (DepartmentApi) this.retrofitFactory.getApi(DepartmentApi.class);
        Call<ApiResponse<Department>> call = departmentApi.getDepartment(deptCode);
        return CallUtil.execute(call);
    }

    public ApiResponse<String> addDepartment(Department department) {
        DepartmentApi departmentApi = (DepartmentApi) this.retrofitFactory.getApi(DepartmentApi.class);
        Call<ApiResponse<String>> call = departmentApi.addDepartment(department.getDept_Code(), department.getParent_code(), department.getName(), department.getStatus());
        return CallUtil.execute(call);
    }

    public ApiResponse<String> updateDepartment(Department department) {
        DepartmentApi departmentApi = (DepartmentApi) this.retrofitFactory.getApi(DepartmentApi.class);
        Call<ApiResponse<String>> call = departmentApi.updateDepartment(department.getDept_Code(), department.getParent_code(), department.getName(), department.getStatus(), department.getManager_code());
        return CallUtil.execute(call);
    }

    public ApiResponse<String> deleteDepartment(String deptCode) {
        DepartmentApi departmentApi = (DepartmentApi) this.retrofitFactory.getApi(DepartmentApi.class);
        Call<ApiResponse<String>> call = departmentApi.deleteDepartment(deptCode);
        return CallUtil.execute(call);
    }

    // ====  帮助接口 ====

    /**
     * 检测 app 接口
     *
     * @param appid
     * @return
     */
    public ApiResponse<String> helperCheck(String appid) {
        HelperApi helperApi = retrofitFactory.getApi(HelperApi.class);
        Call<ApiResponse<String>> call = helperApi.checkApp(appid);
        return CallUtil.execute(call);
    }

    // ====  拼接URL ====

    /**
     * 根据规则拼接URL
     *
     * @param authCode    授权码(必填)
     * @param redirectUrl 重定向地址(非必填)
     * @return 重定向URL
     * @throws UnsupportedEncodingException
     */
    public String loginUrl(String authCode, String redirectUrl) throws UnsupportedEncodingException {
        Map<String, Object> params = new HashMap<String, Object>(4);
        params.put("access_token", GATTokenService.getGatToken());
        params.put("auth_code", authCode);
        params.put("timestamp", System.currentTimeMillis() / 1000);
        params.put("redirect_url", redirectUrl);
        params.put("sign", SignUtil.sign(params));
        params.remove("appsecret");
        return UrlBuildUtil.build(GATOpenConstant.base_url + "/sso/employee/login", params);
    }


}
