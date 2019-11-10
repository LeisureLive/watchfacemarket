package com.next.watchfacemarket.dto.po.market;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Jie.He, Leisurehejie@sina.com
 * @Date: 2019/11/10 12:51 下午
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BannerInfo {

    private Integer id;

    private String style;

    private String homepageImage;

    private String bannerDetailImage;

    private String bannerHistoryImage;

    private String title;

    private String subTitle;

    private String description;

    private String titleColor;

    private String subtitleColor;

    private String backgroundColor;

    private String descriptionTextColor;

    private String downloadButtonColor;

    private String appList;

    private String createTime;

    private String updateTime;

}
