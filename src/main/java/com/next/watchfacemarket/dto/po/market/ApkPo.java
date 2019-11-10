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
public class ApkPo {

    private Integer id;

    private Integer appId;

    private String packageName;

    private Integer versionCode;

    private String versionName;

    private Integer fileSize;

    private String apkMd5;

    private String apkSign;

    private String cpu;

    private String changeLog;

    private Integer status;

    private Integer grayPercent;

    private String downloadUrl;

    private String createTime;

    private String updateTime;

}
