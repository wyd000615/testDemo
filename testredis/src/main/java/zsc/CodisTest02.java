package zsc;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class CodisTest02 {

	public static void main(String[] args) throws Exception{
		JedisPool pool = null;
        JedisPoolConfig config = new JedisPoolConfig();
        //最大连接数
        config.setMaxTotal(500);
        //最大空闲连接数
        config.setMaxIdle(10);
        //每次释放连接的最大数目
        config.setNumTestsPerEvictionRun(1024);
        //释放连接的扫描间隔（毫秒）
        config.setTimeBetweenEvictionRunsMillis(30000);
        //连接最小空闲时间
        config.setMinEvictableIdleTimeMillis(1800000);
        //连接空闲多久后释放, 当空闲时间>该值 且 空闲连接>最大空闲连接数 时直接释放
        config.setSoftMinEvictableIdleTimeMillis(10000);
        //获取连接时的最大等待毫秒数,小于零:阻塞不确定的时间,默认-1
        config.setMaxWaitMillis(5000);
        //在获取连接的时候检查有效性, 默认false
        config.setTestOnBorrow(false);
        //在空闲时检查有效性, 默认false
        config.setTestWhileIdle(true);
        //连接耗尽时是否阻塞, false报异常,ture阻塞直到超时, 默认true
        config.setBlockWhenExhausted(false);

        //10s超長時間
        pool = new JedisPool(config, "10.124.1.11", 6679, 10000);
        pool.getResource();
        Jedis je = pool.getResource();
        //je.set("test_wyd_codis","test_wyd_codis");
       // System.out.println("----------" + je.get("SUNI_PR_0007"));
        //Thread.sleep(5000);
       // System.out.println(je.get("test_wyd_codis"));
        /*   je.del("SUNI_PR_0007");
            je.del("SUNI_PR_0007_ENDNUM");
            je.set("SUNI_PR_0007","0");
            je.set("SUNI_PR_0007_ENDNUM", "0");*/
               // je.set("LLL_0000","20");
           // je.set("1234_1234","20");
           System.out.println(  je.get("1234_1234"));
	}

}
