/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gat.open.sdk;

import com.gat.open.sdk.model.ApiResponse;
import com.gat.open.sdk.model.Employee;
import com.gat.open.sdk.model.EmployeeAccount;

import java.util.List;

/**
 * @author xfworld
 * @since create on 2018-07-18.
 **/
public class Main {

    public static void main(String[] args) {
        String appid = "20091267";
        String appsecret = "5c8c22138ef41d57c4f6d70856132f96";

        //所有接口方法均在 GATOpen 中 ，只需实例化GATOpen即可使用。
        GATOpen gatOpen = new GATOpen(appid, appsecret);
//        ApiResponse<Token> token=gatOpen.createToken();
//        System.out.println(token.getData());
        Employee employee = gatOpen.getEmployee("102478275").getData();
        System.out.println(employee);

        ApiResponse<List<EmployeeAccount>> apiResponse = gatOpen.accountEmployee("102478275");
        if(apiResponse!=null&&apiResponse.getData()!=null){
            for(EmployeeAccount account:apiResponse.getData()){
                System.out.println(account.toString());
            }
        }



//        Employee employee = gatOpen.getEmployee("A101").getData();
//        String result = gatOpen.loginByMobile("15629052307").getData();
    }

}
