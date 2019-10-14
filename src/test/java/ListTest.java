import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jgn.domain.Goods;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:redis.xml")

public class ListTest {
	@Autowired
	RedisTemplate redisTemplate;
	
	
	//添加106个Goods对象到list类型
	@Test
	public void listRedis() {
		List<Goods> list=new ArrayList<Goods>();
		Goods g=new Goods();
		for (int i = 0; i < 106; i++) {
			g.setId(i);
			g.setName("品牌"+i);
			g.setPrice(null);
			g.setBaifen("15%"+i/100);
			list.add(g);
			redisTemplate.opsForList().leftPush("goods_list", list);
		}
		System.out.println("添加106个Goods对象到list类型");
	}
	
	
	// 添加106个Goods对象到zset类型
	@Test
	public void listZset() {
		HashSet<Goods> zset=new HashSet<Goods>();
		Goods g=new Goods();
		for (int i = 0; i < 106; i++) {
			g.setId(i);
			g.setName("品牌"+i);
			g.setPrice(null);
			g.setBaifen("15%"+i/100);
			zset.add(g);
			redisTemplate.opsForZSet().add("goods_zset", zset);
		}
		System.out.println("添加106个Goods对象到zset类型");
	}
	
}
