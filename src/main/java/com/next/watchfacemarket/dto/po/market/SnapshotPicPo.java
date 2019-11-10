package com.next.watchfacemarket.dto.po.market;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Jie.He, Leisurehejie@sina.com
 * @Date: 2019/11/10 12:46 下午
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SnapshotPicPo {

    private Integer id;

    private Integer appId;

    private String picUrl;

    private String createTime;

    private String updateTime;

}
