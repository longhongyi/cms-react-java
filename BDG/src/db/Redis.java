package db;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import java.util.*;
public class Redis {
    protected Jedis jedis;
    public Redis(){
        jedis=new Jedis(Config.REDIS_HOST,6379);
        jedis.auth(Config.REDIS_PASS);
        Map<String,String> tools=new HashMap<String,String>();
        tools.put("open","door");
        jedis.hmset("水果",tools);
        List<String> friut=jedis.hmget("水果","5块钱","open","close");
        System.out.println(friut);
    }
}
