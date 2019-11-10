package com.next.watchfacemarket.dto.po.market;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Jie.He, Leisurehejie@sina.com
 * @Date: 2019/11/10 12:48 下午
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BannerSetting {

    private Integer id;

    private String showPage;

    private String position;

    private Integer showOrder;

    private String style;

    private Integer appId;

    private String appBackgroundImage;

    private String appName;

    private String appLogoUrl;

    private String bannerId;

    private String createTime;

    private String updateTime;

}
