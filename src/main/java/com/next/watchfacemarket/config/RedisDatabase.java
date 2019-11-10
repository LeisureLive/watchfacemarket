package com.next.watchfacemarket.config;

import com.next.watchfacemarket.log.KayleLog;
import com.next.watchfacemarket.utils.PropertyUtil;
import com.next.watchfacemarket.utils.StringUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Properties;

/**
 * @Author: Jie.He, Leisurehejie@sina.com
 * @Date: 2019/11/10 3:15 下午
 */
public class RedisDatabase {

    private static KayleLog logger = new KayleLog(RedisDatabase.class);

    private static final int TIMEOUT = 5000;

    private static RedisDatabase defaultInstance;

    private String host;

    private JedisPool pool;

    private RedisDatabase(String host, int port, String password) {
        this.host = host;
        if (0 == port && StringUtil.isEmpty(password)) {
            this.pool = new JedisPool(getJedisPoolConfig(), host);
        } else {
            this.pool = new JedisPool(getJedisPoolConfig(), host, port, TIMEOUT, password);
        }
    }

    /**
     * get default redis config.
     *
     * @return RedisDatabase
     */
    public static RedisDatabase getDefault() {
        if (defaultInstance == null) {
            synchronized (RedisDatabase.class) {
                if (defaultInstance == null) {
                    Properties properties = PropertyUtil.getConfig("/redis.properties");
                    String host = properties.getProperty("spring.redis.host");
                    String port = properties.getProperty("spring.redis.port");
                    String password = properties.getProperty("spring.redis.password");
                    defaultInstance = new RedisDatabase(host, Integer.parseInt(port), password);
                    logger.info("redis-host=" + defaultInstance.host);
                }
            }
        }
        return defaultInstance;
    }

    private RedisDatabase() {
        this.pool = new JedisPool(getJedisPoolConfig(), this.host);
    }

    /**
     * Return the redis connection, it must be recycled by use recycleConnection.
     *
     * @return Jedis
     */
    public Jedis getConnection() {
        return pool.getResource();
    }

    /**
     * Recycle redis connection.
     */
    public void recycleConnection(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }

    /**
     * Get common jedis pool config.
     */
    public JedisPoolConfig getJedisPoolConfig() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setBlockWhenExhausted(false);
        config.setMaxTotal(40);
        return config;
    }

}
