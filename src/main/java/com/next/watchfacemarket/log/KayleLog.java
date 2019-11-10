package com.next.watchfacemarket.log;

import com.google.common.util.concurrent.RateLimiter;
import com.next.watchfacemarket.consts.Global;
import org.apache.log4j.Logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Jie.He, Leisurehejie@sina.com
 * @Date: 2019/11/10 1:37 下午
 */
public class KayleLog {

    private static final int LENGTH_200 = 200;

    private static final int LENGTH_1000 = 1000;

    private static ExecutorService executorService = Executors.newSingleThreadExecutor();

    private Logger logger;
    private String receivers;
    private RateLimiter rateLimiter;

    public KayleLog(Class<?> clazz){
        this.logger = Logger.getLogger(clazz);
        this.receivers = Global.EMAIL.ERROR_EMAIL;
    }

    public void debug(Object msg) {
        logger.debug(msg);
    }

    public void debug(String format, Object... args) {
        logger.debug(String.format(format, args));
    }

    public void debug(Object msg, Throwable t) {
        logger.debug(msg, t);
    }

    public void debug(Throwable t, String format, Object... args) {
        String content = String.format(format, args);
        logger.debug(content, t);
    }

    public void info(Object msg) {
        logger.info(msg);
    }

    public void info(String format, Object... args) {
        logger.info(String.format(format, args));
    }

    /**
     * Log and set max length to 200 length.
     *
     * @param format log format string
     * @param args Arguments referenced by the format specifiers in the format string.
     */
    public void infoMax200(String format, Object... args) {
        infoWithMaxLength(format, LENGTH_200, args);
    }

    /**
     * Log and set max length to 1000 length.
     *
     * @param format log format string
     * @param args Arguments referenced by the format specifiers in the format string.
     */
    public void infoMax1k(String format, Object... args) {
        infoWithMaxLength(format, LENGTH_1000, args);
    }

    /**
     * Log and set max length to @param length.
     *
     * @param format log format string
     * @param length max length of log
     * @param args Arguments referenced by the format specifiers in the format string.
     */
    public void infoWithMaxLength(String format, int length, Object... args) {
        String info = String.format(format, args);
        if (info != null && info.length() > length) {
            logger.info(info.substring(0, length));
        } else {
            logger.info(info);
        }
    }

    public void info(Object msg, Throwable t) {
        logger.info(msg, t);
    }

    public void infoWithMaxLength(String msg, int maxLength) {
        if (null != msg && msg.length() > maxLength) {
            logger.info(msg.substring(0, maxLength));
        } else {
            logger.info(msg);
        }
    }

    public void info(Throwable t, String format, Object... args) {
        String content = String.format(format, args);
        logger.info(content, t);
    }

    public void warn(Object msg) {
        logger.warn(msg);
    }

    public void warn(String format, Object... args) {
        logger.warn(String.format(format, args));
    }

    public void warn(Object msg, Throwable t) {
        logger.warn(msg, t);
    }

    public void warn(Throwable t, String format, Object... args) {
        String content = String.format(format, args);
        logger.warn(content, t);
    }

}
