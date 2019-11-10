package com.next.watchfacemarket.utils;

import com.alibaba.fastjson.*;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: Jie.He, Leisurehejie@sina.com
 * @Date: 2019/11/10 2:17 下午
 */
public class JSONUtil {

    public static JSONObject transformFromMap(Map<String, ? extends Object> map)
            throws JSONException {
        JSONObject object = new JSONObject();
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            object.put(entry.getKey(), entry.getValue());
        }
        return object;
    }

    public static JSONArray transformFromList(List<? extends Object> list) {
        JSONArray array = new JSONArray();
        for (Object item : list) {
            array.add(item);
        }
        return array;
    }

    public static List<Object> toList(JSONArray jsonArray) throws JSONException {
        List<Object> list = new ArrayList<Object>();
        for (int i = 0; i < jsonArray.size(); i++) {
            list.add(jsonArray.get(i));
        }
        return list;
    }

    public static JSONArray copyJSONArray(JSONArray sourceArray) throws JSONException {
        String content = sourceArray.toString();
        JSONArray newArray = JSON.parseArray(content);
        return newArray;
    }

    public static JSONObject copyJSONObject(JSONObject sourceObject) throws JSONException {
        String content = sourceObject.toString();
        JSONObject newObject = JSON.parseObject(content);
        return newObject;
    }

    /**
     * insert an jsonobject into a jsonarray in a given position
     */
    public static void insertJSONObject(JSONArray sourceArray,
                                        JSONObject newObject, int position) throws JSONException {
        sourceArray.add(position, newObject);
    }

    /**
     * reverse an JSONArray
     */
    public static void reverseJSONArray(JSONArray sourceArray)
            throws JSONException {
        int length = sourceArray.size();
        for (int i = 0; i < length / 2; i++) {
            JSONObject tmpObject = sourceArray.getJSONObject(i);
            sourceArray.set(i, sourceArray.getJSONObject(length - 1 - i));
            sourceArray.set(length - 1 - i, tmpObject);
        }
    }

    public static String optString(JSONObject object, String key) {
        return optString(object, key, "");
    }

    public static String optString(JSONObject object, String key, String optStr) {
        return object.containsKey(key) ? object.getString(key) : optStr;
    }

    public static JSONArray optArray(JSONObject object, String key) {
        return optArray(object, key, new JSONArray());
    }

    public static JSONArray optArray(JSONObject object, String key, JSONArray array) {
        return object.containsKey(key) ? object.getJSONArray(key) : array;
    }

    public static int optInteger(JSONObject object, String key) {
        return optInteger(object, key, 0);
    }

    public static int optInteger(JSONObject object, String key, int value) {
        return object.containsKey(key) ? object.getIntValue(key) : value;
    }

    public static double optDouble(JSONObject object, String key) {
        return optDouble(object, key, 0.0);
    }

    public static double optDouble(JSONObject object, String key, double value) {
        return object.containsKey(key) ? object.getDoubleValue(key) : value;
    }

    public static JSONObject optObject(JSONObject object, String key, JSONObject value) {
        return object.containsKey(key) ? object.getJSONObject(key) : value;
    }

    public static JSONObject optObject(JSONObject object, String key) {
        return optObject(object, key, new JSONObject());
    }

    public static final <T> String toJSONString(T t) {
        return JSON.toJSONString(t, SerializerFeature.DisableCircularReferenceDetect);
    }

    /**
     * Return json str with default value for string and default value for list.
     */
    public static <T> String toJsonStringWithDefault(T t) {
        return JSON.toJSONString(t, SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteNullStringAsEmpty);
    }

    public static final <T> String toJSONStringWithClassName(T t) {
        return JSON.toJSONString(t, SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteClassName);
    }

    public static final <T> List<T> arrayFromJSONString(String jsonString,
                                                        Class<T> clazz) {
        return JSON.parseArray(jsonString, clazz);
    }

    public static final <T> T objectFromJSONString(String jsonString,
                                                   Class<T> clazz) {
        return JSON.parseObject(jsonString, clazz);
    }

    public static final <T> T objectFromJSONString(String jsonString,
                                                   TypeReference<? extends T> type) {
        return JSON.parseObject(jsonString, type);
    }

    public static final <T> T toJavaObject(JSON json, Class<T> clazz) {
        return JSON.toJavaObject(json, clazz);
    }

    public static final <T> JSONArray toJSONArray(T t) {
        return (JSONArray) JSON.toJSON(t);
    }

    public static final <T> JSONObject toJSONObject(T t) {
        return (JSONObject) JSON.toJSON(t);
    }
}
