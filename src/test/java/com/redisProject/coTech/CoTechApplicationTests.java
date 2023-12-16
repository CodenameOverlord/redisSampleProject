package com.redisProject.coTech;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

@SpringBootTest
class CoTechApplicationTests {

	@Test
	void contextLoads() {
	}


	@Test
	void testClearCache(){
		try (Jedis jedis = new Jedis("localhost", 6379)) {
			// Clear all cache entries in the default database (DB 0)
			jedis.flushAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
