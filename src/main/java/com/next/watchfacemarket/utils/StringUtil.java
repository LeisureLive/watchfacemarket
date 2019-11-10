package com.next.watchfacemarket.utils;

import com.google.common.collect.Maps;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @Author: Jie.He, Leisurehejie@sina.com
 * @Date: 2019/11/10 3:13 下午
 */
public class StringUtil {

    public static final String EMPTY_STRING = "";
    public static final String UNKNOW_STRING_EN = "undefined";
    public static final String ENC_UTF8 = "UTF-8";
    public static final Charset UTF_8 = StandardCharsets.UTF_8;

    private static final String UNKNOW_STRING_ZH_CN = "不限";
    private static final Map<String, String> cityMap = Maps.newHashMap();

    static {
        cityMap.put("延边朝鲜族自治州", "延边");
        cityMap.put("黔西南布依族苗族自治州", "黔西南");
        cityMap.put("那曲地区", "那区");
        cityMap.put("阿坝藏族羌族自治州", "阿坝");
        cityMap.put("红河哈尼族彝族自治州", "红河");
        cityMap.put("延边朝鲜族自治州", "延边");
        cityMap.put("黔西南布依族苗族自治州", "黔西南");
        cityMap.put("白沙黎族自治县", "白沙");
        cityMap.put("西双版纳傣族自治州", "西双版纳");
        cityMap.put("迪庆藏族自治州", "迪庆");
        cityMap.put("临夏回族自治州", "临夏州");
        cityMap.put("凉山彝族自治州", "凉山");
        cityMap.put("琼中黎族苗族自治县", "琼中");
        cityMap.put("锡林郭勒盟", "锡林郭勒");
        cityMap.put("文山壮族苗族自治州", "文山州");
        cityMap.put("巴音郭楞蒙古自治州", "巴音郭楞");
        cityMap.put("香港特别行政区", "香港");
        cityMap.put("澳门特别行政区", "澳门");
        cityMap.put("海西蒙古族藏族自治州", "海西");
        cityMap.put("黄南藏族自治州", "黄南");
        cityMap.put("德宏傣族景颇族自治州", "德宏");
        cityMap.put("大兴安岭地区", "大兴安岭");
        cityMap.put("昌吉回族自治州", "昌吉州");
        cityMap.put("楚雄彝族自治州", "楚雄州");
        cityMap.put("伊犁哈萨克自治州", "伊犁");
        cityMap.put("吐鲁番地区", "吐鲁番");
        cityMap.put("博尔塔拉蒙古自治州", "博尔塔拉");
        cityMap.put("黔东南苗族侗族自治州", "黔东南");
        cityMap.put("保亭黎族苗族自治县", "保亭");
        cityMap.put("陵水黎族自治县", "陵水");
        cityMap.put("克孜勒苏柯尔克孜自治州", "克孜勒苏");
        cityMap.put("果洛藏族自治州", "果洛");
        cityMap.put("乐东黎族自治县", "乐东");
        cityMap.put("陵水黎族自治县", "陵水");
        cityMap.put("湘西土家族苗族自治州", "湘西");
        cityMap.put("大理白族自治州", "大理州");
        cityMap.put("怒江傈僳族自治州", "怒江");
        cityMap.put("玉树藏族自治州", "玉树");
    }

    /**
     * isNullOrEmpty.
     */
    public static boolean isNullOrEmpty(String str) {
        if (str == null) {
            return true;
        }
        String checkString = str.trim().toLowerCase();
        return checkString.equals(EMPTY_STRING) || checkString.equals("null")
                || checkString.equals("(null)") || checkString.equals(UNKNOW_STRING_EN)
                || checkString.equals(UNKNOW_STRING_ZH_CN);
    }

    /**
     * notNullOrEmpty.
     */
    public static boolean notNullOrEmpty(String str) {
        return !isNullOrEmpty(str);
    }

    /**
     * notNullString.
     */
    public static String notNullString(String str) {
        if (str == null) {
            return EMPTY_STRING;
        }
        return str;
    }

    /**
     * if the string is null or empty, return undefined.
     */
    public static String safeStringEn(String str) {
        if (isNullOrEmpty(str)) {
            return UNKNOW_STRING_EN;
        } else {
            return str;
        }
    }

    /**
     * safeStringEmpty.
     */
    public static String safeStringEmpty(String str) {
        if (isNullOrEmpty(str)) {
            return EMPTY_STRING;
        } else {
            return str;
        }
    }

    /**
     * notNull.
     */
    public static String notNull(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    /**
     * newGuid.
     */
    public static String newGuid() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    /**
     * Replace the 市 in the end of city.
     */
    public static String formatCity(String city) {

        if (cityMap.containsKey(city)) {
            return cityMap.get(city);
        }

        if (city.endsWith("市")) {
            return city.substring(0, city.lastIndexOf("市"));
        }

        return city;
    }

    /**
     * 获取int参数，若输入字符串为null或不能转为int，则返回设定的默认值.
     *
     * @param str      输入字符串
     * @param defaults 默认值
     * @return int参数
     */
    public static int convertInt(String str, int defaults) {
        if (str == null) {
            return defaults;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            return defaults;
        }
    }

    /**
     * 获取long型参数，若输入字符串为null或不能转为long，则返回设定的默认值.
     *
     * @param str      输入字符串
     * @param defaults 默认值
     * @return long参数
     */
    public static long convertLong(String str, long defaults) {
        if (str == null) {
            return defaults;
        }
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            return defaults;
        }
    }

    /**
     * split string by the seperator. two continues seperators will split a string into three part.
     * e.g. split("aaa,,bbb",',') will return {"aaa","","bbb"}
     */
    public static String[] split(String str, char ch) {
        List<String> list = new ArrayList<>();
        for (int index = 0; index <= str.length(); ) {
            int indexOf = str.indexOf(ch, index);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            list.add(str.substring(index, indexOf));
            index = indexOf + 1;
        }
        String[] ss = new String[list.size()];
        return list.toArray(ss);
    }

    /**
     * 分割字符串.
     *
     * @param line      原始字符串
     * @param seperator 分隔符
     * @return 分割结果
     */
    public static String[] split(String line, String seperator) {
        if (line == null || seperator == null || seperator.length() == 0) {
            return null;
        }
        ArrayList<String> list = new ArrayList<>();
        int pos1 = 0;
        int pos2;
        for (; ; ) {
            pos2 = line.indexOf(seperator, pos1);
            if (pos2 < 0) {
                list.add(line.substring(pos1));
                break;
            }
            list.add(line.substring(pos1, pos2));
            pos1 = pos2 + seperator.length();
        }
        // 去掉末尾的空串，和String.split行为保持一致
        for (int i = list.size() - 1; i >= 0 && list.get(i).length() == 0; --i) {
            list.remove(i);
        }
        return list.toArray(new String[0]);
    }

    /**
     * 以第一个分割字符串分割.
     *
     * @param line      原始字符串
     * @param seperator 分隔符
     * @return 分割结果
     */
    public static String[] splitFirst(String line, String seperator) {
        if (line == null || seperator == null || seperator.length() == 0) {
            return null;
        }
        ArrayList<String> list = new ArrayList<>(2);
        int pos1 = 0;
        int pos2 = line.indexOf(seperator, pos1);
        if (pos2 < 0) {
            list.add(line);
        } else {
            list.add(line.substring(pos1, pos2));
            list.add(line.substring(pos2 + 1, line.length()));
        }
        return list.toArray(new String[0]);
    }

    /**
     * 字符串全量替换.
     */
    public static String replaceAll(String str, String src, String dest) {
        if (str == null || src == null || dest == null || src.length() == 0) {
            return str;
        }
        int pos = str.indexOf(src); // 查找第一个替换的位置
        if (pos < 0) {
            return str;
        }
        int capacity = dest.length() > src.length() ? str.length() * 2 : str.length();
        StringBuilder sb = new StringBuilder(capacity);
        int writen = 0;
        for (; pos >= 0; ) {
            sb.append(str, writen, pos); // append 原字符串不需替换部分
            sb.append(dest); // append 新字符串
            writen = pos + src.length(); // 忽略原字符串需要替换部分
            pos = str.indexOf(src, writen); // 查找下一个替换位置
        }
        sb.append(str, writen, str.length()); // 替换剩下的原字符串
        return sb.toString();
    }

    /**
     * isEmpty.
     */
    public static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    /**
     * isNotEmpty.
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * @see java.lang.String#trim()
     */
    public static String trim(String str) {
        if (str == null) {
            return null;
        }
        return str.trim();
    }

    /**
     * removeAll.
     */
    public static String removeAll(String str, String src) {
        return replaceAll(str, src, "");
    }

    /**
     * 拼接字符串.
     */
    public static String concat(String... strs) {
        if (null != strs && strs.length > 0) {
            // 先计算长度
            int len = 0;
            for (String str : strs) {
                if (null != str) {
                    len += str.length();
                }
            }
            if (len > 0) {
                // 一次性申请好容量
                StringBuilder sb = new StringBuilder(len);
                for (String str : strs) {
                    if (str != null) {
                        sb.append(str);
                    }
                }
                return sb.toString();
            }
        }
        return null;
    }

    /**
     * 拼接字符串.
     */
    public static String concat(Object... objects) {
        if (null != objects && objects.length > 0) {
            // 先计算长度
            int len = 0;
            // 收集str，避免重复toString
            List<String> list = new ArrayList<>(objects.length);
            for (Object obj : objects) {
                if (null != obj) {
                    String str = obj.toString();
                    if (isNotEmpty(str)) {
                        len += str.length();
                        list.add(str);
                    }
                }
            }
            if (len > 0) {
                // 一次性申请好容量
                StringBuilder sb = new StringBuilder(len);
                for (String str : list) {
                    sb.append(str);
                }
                return sb.toString();
            }
        }
        return null;
    }

    /**
     * defaultIfEmpty.
     */
    public static String defaultIfEmpty(String str, String defaultStr) {
        if (isNullOrEmpty(str)) {
            return defaultStr;
        }
        return str;
    }

    /**
     * encode string by Base64.
     */
    public static String encodeByBase64(String origin) {
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] strBytes = origin.getBytes(StandardCharsets.UTF_8);
        return encoder.encodeToString(strBytes);
    }

    /**
     * decode string by Base64.
     */
    public static String decodeBase64(String encodedString) {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decodedByteArray = decoder.decode(encodedString);
        return new String(decodedByteArray, StandardCharsets.UTF_8);
    }

    /**
     * decode string by Base64.
     */
    public static String decodeBase64Utf8(String encodedString) {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] bytes = encodedString.getBytes(StandardCharsets.UTF_8);
        byte[] decodedByteArray = decoder.decode(bytes);
        return new String(decodedByteArray, StandardCharsets.UTF_8);
    }

    /**
     * Compare two str and ignore blank before or after.
     */
    public static boolean compareIgnoreBlank(String str1, String str2) {
        if (str1 != null) {
            str1 = str1.trim();
        }
        if (str2 != null) {
            str2 = str2.trim();
        }
        return Objects.equals(str1, str2);
    }

    /**
     * 首字母大写 capitalize("cAt") = "Cat"
     *
     * @param str 原字符串
     * @return 转换后字符串
     */
    public static String capitalize(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

}
