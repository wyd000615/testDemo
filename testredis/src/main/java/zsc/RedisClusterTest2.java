package zsc;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class RedisClusterTest2 {
    private static JedisCluster jedis;

    static {
        // 添加集群的服务节点Set集合
        Set<HostAndPort> hostAndPortsSet = new HashSet<HostAndPort>();
        // 添加节点
        hostAndPortsSet.add(new HostAndPort("10.124.1.7", 9002));
        hostAndPortsSet.add(new HostAndPort("10.124.1.7", 9003));
        hostAndPortsSet.add(new HostAndPort("10.124.1.7", 9004));
        hostAndPortsSet.add(new HostAndPort("10.124.1.7", 9005));
        hostAndPortsSet.add(new HostAndPort("10.124.1.7", 9006));
        hostAndPortsSet.add(new HostAndPort("10.124.1.7", 9007));


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
        jedis = new JedisCluster(hostAndPortsSet, 5000, 3000, 10, "1qaz2wsx", jedisPoolConfig);
        //jedis = new JedisCluster(hostAndPortsSet, jedisPoolConfig);

        //jedis.auth("1qaz2wsx");
    }

    public static void main(String[] args) throws IOException {
        if(jedis.exists("GUO_PR_0009")){
            System.out.println("GUO_PR_0009 --- 已存在");
            String str =jedis.get("GUO_PR_0009");
            System.out.println(str);
        }else{
            System.out.println("GUO_PR_0009 ---新增");
            jedis.incr("GUO_PR_0009");
        }
    }

}
