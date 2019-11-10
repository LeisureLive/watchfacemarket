package com.next.watchfacemarket.dto.po.record;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Jie.He, Leisurehejie@sina.com
 * @Date: 2019/11/10 12:56 下午
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserPayRecordPo {

    private Integer id;

    private String uid;

    private Integer appId;

    private String packageName;

    private Double price;

    private String orderId;

    private String expireAt;

    private Integer status;

    private String createTime;

    private String updateTime;
}
