import com.redis.RedisClient
import redis.clients.jedis.Jedis

/**
  * Created by kirankumarbs on 14/2/17.
  */
package object dao {
  //implicit val jedis = JedisDB(new Jedis("epgm-webapp.cloudapp.net"))
  implicit val jedis = JedisDB(new Jedis("localhost"))
  implicit val jedisMock = JedisDBMock()
}
