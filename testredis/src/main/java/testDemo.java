import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * 链接redis
 */
public class testDemo {
    private Jedis jedis = null;

    public Jedis getJedis() {
        return jedis;
    }

    public void setJedis(Jedis jedis) {
        this.jedis = jedis;
    }

    @Before
    public void test() {
        //连接本地的 Redis 服务
        //jedis = new Jedis("192.168.94.132", 9000);
        jedis.auth("123456");
        System.out.println("链接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: " + jedis.ping());
    }

    @Test
    public void test1() {

        jedis.set("key", "123");
        System.out.println("插入成功");

    }

    @Test
    public void test2() {

        jedis.lpush("site-list", "Runoob");
        jedis.lpush("site-list", "Google");
        jedis.lpush("site-list", "Taobao");
        // 获取存储的数据并输出
        List<String> list = jedis.lrange("site-list", 0, 2);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("列表项为: " + list.get(i));
        }
        System.out.println("插入成功");

    }

    @Test
    public void test3() {
        //jedis.
        jedis.close();
    }
}
