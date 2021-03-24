package dev;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class RedissionDemo {
    public static void main(String[] args) {

        Config config = new Config();
        config.useSingleServer().setAddress("redis://192.168.94.131:6379");
        //config.useSingleServer().setPassword("redis1234");

        final RedissonClient client = Redisson.create(config);
        RLock lock = client.getLock("1675468581666");
        RLock lock1 = client.getLock("lock1");
        RLock lock2 = client.getLock("lock2");

        try{
            //lock.lock();
            lock1.lock();
            lock2.lock();

            System.out.println("加锁===start=");
            Thread.sleep(10000L);
            System.out.println("加锁===end=");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally{
            lock.unlock();
            lock1.unlock();

            lock2.unlock();

        }
    }
}
