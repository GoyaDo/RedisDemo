package com.elevengeek.goya.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * jedis快速入门
 *
 * @author cj
 * @create 2020-02-19-18:39
 */
public class JedisTest {

    @Test
    public void test(){
        //获取连接
        Jedis jedis = new Jedis("localhost",6379);
        //操作
        jedis.set("username","goya");
        //关闭连接
        jedis.close();
    }

    /**
     * Jedis连接池对象
     */
    @Test
    public void test1(){
        //创建配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(50);
        config.setMaxIdle(10);

        //创建Jedis连接池对象
        JedisPool jedisPool = new JedisPool(config,"127.0.0.1",6379);
        //获取连接
        Jedis jedis = jedisPool.getResource();
        //使用
        jedis.set("hehe","haha");
        //归还到连接池中
        jedis.close();
    }
}
