package com.next.watchfacemarket.dto.po.market;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Jie.He, Leisurehejie@sina.com
 * @Date: 2019/11/10 12:33 下午
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppPo {

    private Integer id;

    private String appName;

    private String packageName;

    private String logoUrl;

    private Integer developerId;

    private String tags;

    private boolean needPay;

    private Double price;

    /**
     * 几级以上的prim会员可以免费下载.
     */
    private int needPrimRank;

    private String summary;

    private String description;

    private Integer downloadCount;

    private Integer collectCount;

    private String createTime;

    private String updateTime;

}
