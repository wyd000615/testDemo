package yh;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class RedisTest {
    @Test
    public void test(){
        Jedis jedis = new Jedis("10.161.50.96",9000);
        jedis.get("u");
    }
}
