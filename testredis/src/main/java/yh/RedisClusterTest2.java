package yh;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.*;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class RedisClusterTest2 {
    private static JedisCluster jedis;
 static{
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
     //jedis = new JedisCluster(hostAndPortsSet, jedisPoolConfig);

     //jedis.auth("1qaz2wsx");
    }

    public static void main(String[] args) throws IOException {
        //jedis.auth("1qaz2wsx");
        if(jedis.exists("GUO_PR_0009")){
            System.out.println("GUO_PR_0009 --- 已存在");
            String str =jedis.get("GUO_PR_0009");
            System.out.println(str);
        }else{
            System.out.println("GUO_PR_0009 ---新增");
            jedis.incr("GUO_PR_0009");
        }
       // jedis.close();
        //jedis.c

    /*    if(jedis.exists("VOPI_PR_0009")){
            System.out.println("VOPI_PR_0009 --- 已存在");
            String str =jedis.get("VOPI_PR_0009");
            System.out.println(str);
        }else{
            System.out.println("VOPI_PR_0009 ---新增");
            jedis.set("VOPI_PR_0009","1");
        }
        // 月底
        if(jedis.exists("VOPI_PR_0009_ENDNUM")){
            System.out.println("VOPI_PR_0009_ENDNUM --- 已存在");
            String str =jedis.get("VOPI_PR_0009_ENDNUM");
            System.out.println(str);
        }else{
            System.out.println("VOPI_PR_0009_ENDNUM ---新增");
            jedis.set("VOPI_PR_0009_ENDNUM","1");
        }
        */

   /*     Boolean exists = jedis.exists("zu");
        if(!exists){
            System.out.println("插入x的键值对："+jedis.set("zu","wyd"));

        }else{
            System.out.println("获取x的键值对"+jedis.get("zu"));

        }*/
/*   //jedis.set("num","1");
        jedis.incr("num");
        jedis.incrBy("num",8);
        jedis.decr("num");
        System.out.println(jedis.get("num"));
        //System.out.println("获取x的键值对"+jedis.get("u"));
        TreeSet<String> keys = new TreeSet<String>();
        Map<String, JedisPool> clusterNodes = jedis.getClusterNodes();
        for (String k:clusterNodes.keySet() ) {
            JedisPool jp = clusterNodes.get(k);
            Jedis connection = jp.getResource();
            keys.addAll(connection.keys("0"));
        }
        System.out.println("-----------------");
        for (String kk : keys) {
            System.out.println("k="+kk);
        }*/
    }

}
