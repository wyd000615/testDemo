package dev;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class TestJedisPool {
    @Test
    public void test(){
        RedisPool redisPool = new RedisPool();
        JedisPool jedisPool = redisPool.getJedisPool();
        JedisPool jedisPool1 = redisPool.getJedisPool();
        System.out.println(jedisPool);
        System.out.println(jedisPool1);
        System.out.println(jedisPool==jedisPool1);
        Jedis jedis = jedisPool.getResource();
        jedis.auth("1qaz2wsx");
        jedis.set("w","wyd");

    }

}
