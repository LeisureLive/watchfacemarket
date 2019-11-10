package com.next.watchfacemarket.dto.po.market;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Jie.He, Leisurehejie@sina.com
 * @Date: 2019/11/10 12:37 下午
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeveloperPo {

    private Integer id;

    private String developerName;

    private String developerEmail;

    private String uid;

    private String createTime;

    private String updateTime;

}
