package yh;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class RedisClusterTest1 {
    private static JedisCluster jedis;
    @Before
    public void test11(){
        // 添加集群的服务节点Set集合
        Set<HostAndPort> hostAndPortsSet = new HashSet<HostAndPort>();
        // 添加节点
        hostAndPortsSet.add(new HostAndPort("10.161.50.86", 9000));
        hostAndPortsSet.add(new HostAndPort("10.161.50.86", 9001));
        hostAndPortsSet.add(new HostAndPort("10.161.50.86", 9002));
        hostAndPortsSet.add(new HostAndPort("10.161.50.86", 9003));
        hostAndPortsSet.add(new HostAndPort("10.161.50.86", 9004));
        hostAndPortsSet.add(new HostAndPort("10.161.50.86", 9005));



        // Jedis连接池配置
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 最大空闲连接数, 默认8个
        jedisPoolConfig.setMaxIdle(100);
        // 最大连接数, 默认8个
        jedisPoolConfig.setMaxTotal(500);
        //最小空闲连接数, 默认0
        jedisPoolConfig.setMinIdle(0);
        // 获取连接时的最大等待毫秒数(如果设置为阻塞时BlockWhenExhausted),如果超时就抛异常, 小于零:阻塞不确定的时间,  默认-1
        jedisPoolConfig.setMaxWaitMillis(2000); // 设置2秒
        //对拿到的connection进行validateObject校验
        jedisPoolConfig.setTestOnBorrow(true);
        //jedis = new JedisCluster(hostAndPortsSet, jedisPoolConfig);
        jedis = new JedisCluster(hostAndPortsSet,5000,3000,10,"1qaz2wsx", jedisPoolConfig);
        //jedis.auth("1qaz2wsx");
    }
    @Test
    public void test1(){
        //jedis.auth("1qaz2wsx");

        System.out.println("新增<'username','wukong'>的键值对："+jedis.set("username", "xiaohai"));
    }
    @Test
    public void test2() throws IOException {
        //jedis.auth("1qaz2wsx");
        Boolean exists = jedis.exists("x");
        if(!exists){
            System.out.println("插入x的键值对："+jedis.set("x","wyd"));

        }else{
            System.out.println("获取x的键值对"+jedis.get("x"));

        }
        jedis.close();

    }
}
