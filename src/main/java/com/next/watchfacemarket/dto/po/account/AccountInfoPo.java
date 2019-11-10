package com.next.watchfacemarket.dto.po.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Jie.He, Leisurehejie@sina.com
 * @Date: 2019/11/10 1:07 下午
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountInfoPo {

    private Integer id;

    private String uid;

    private String nickname;

    private String imgUrl;

    private String password;

    private String phone;

    private String email;

    private Integer primRank;

    private String referralCode;

    private String createTime;

    private String updateTime;

}
