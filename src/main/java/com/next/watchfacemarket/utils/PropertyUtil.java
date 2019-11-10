package com.next.watchfacemarket.utils;

import com.next.watchfacemarket.config.FatalException;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * @Author: Jie.He, Leisurehejie@sina.com
 * @Date: 2019/11/10 3:24 下午
 */
public class PropertyUtil {

    /**
     * 读取指定路径的配置文件，不依赖spring管理.
     *
     * @param path 配置文件路径
     * @return 配置信息
     */
    public static Properties getConfig(String path) {
        Properties props = null;
        try {
            props = new Properties();
            InputStream in = PropertyUtil.class.getResourceAsStream(path);
            BufferedReader bf = new BufferedReader(new InputStreamReader(in));
            props.load(bf);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new FatalException("获取配置失败,path =" + path, e);
        }
        return props;
    }
}
