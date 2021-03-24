package yh;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class CodisTest {
	 
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
        pool = new JedisPool(config, "10.161.50.96", 9000, 10000); 
         
        int i = 0; 
        while(i < 1) {
        	int j = 0;
        	while(j<60) {
        		Conn c = new CodisTest.Conn(pool);
        		c.start();
        		j++;
        	}
        	i++;
        	Thread.sleep(700);
        }
        Jedis je = pool.getResource();
        System.out.println("----------" + je.get("test_codis2"));
        Thread.sleep(5000);
        System.out.println(je.get("test_codis2"));

	}
	static class Conn extends Thread{
		private JedisPool jedisPool ;
		public Conn(JedisPool pool) {
			this.jedisPool = pool;
		}
		
		public void returnResource(Jedis jedis) {
		    try {
		        if(jedisPool != null) {
		        	jedisPool.returnResource(jedis);
		        } else {
		        	jedisPool.returnResource(jedis);
		        }
		    } catch (Throwable t) {
		        if(jedisPool != null) {
		        	jedisPool.returnBrokenResource(jedis);
		        } else {
		        	jedisPool.returnBrokenResource(jedis);
		        }
		    }
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			Jedis jedis = null;
			String name = Thread.currentThread().getName();
			try {
				jedis = jedisPool.getResource();
				long l = jedis.incr("test_codis2");

				if(name.contains("T11")) {
					long l2 = jedis.decr("test_codis2");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(name + "   " + e.getMessage());
			}finally {
				
				returnResource(jedis);
			}
		}
		
	}
}
