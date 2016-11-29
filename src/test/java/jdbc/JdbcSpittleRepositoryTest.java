package jdbc;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.config.RootConfig;
import com.db.SpittleRepository;
import com.domain.Spitter;
import com.domain.Spittle;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class JdbcSpittleRepositoryTest {

	@Autowired
	SpittleRepository spittleRepository;

	private Logger logger=LoggerFactory.getLogger(JdbcSpittleRepositoryTest.class);
	
/*	@Test*/
	public void count() {
		long num=spittleRepository.count();
		logger.info(num+"");
		assertEquals(15, num);
	}

	/*@Test*/
	public void findRecent() {
		// default case
		{
			List<Spittle> recent = spittleRepository.findRecent();
			assertRecent(recent, 10);
		}

		// specific count case
		{
			List<Spittle> recent = spittleRepository.findRecent(5);
			assertRecent(recent, 5);
		}
	}

	/*@Test*/
	public void findOne() {
		Spittle thirteen = spittleRepository.findOne(13);
		assertEquals(13, thirteen.getId().longValue());
		assertEquals("Bonjour from Art!", thirteen.getMessage());
		assertEquals(1332682500000L, thirteen.getPostedTime().getTime());
		assertEquals(4, thirteen.getSpitter().getId().longValue());
		assertEquals("artnames", thirteen.getSpitter().getUsername());
		assertEquals("password", thirteen.getSpitter().getPassword());
		assertEquals("Art Names", thirteen.getSpitter().getFullName());
		assertEquals("art@habuma.com", thirteen.getSpitter().getEmail());
		assertTrue(thirteen.getSpitter().isUpdateByEmail());
	}

	/*@Test*/
	public void findBySpitter() {
		List<Spittle> spittles = spittleRepository.findBySpitterId(4L);
		assertEquals(11, spittles.size());
		for (int i = 0; i < 11; i++) {
			assertEquals(15 - i, spittles.get(i).getId().longValue());
		}
	}

	@Test
	public void save() {
		
		logger.info("保存数据开始");
		
		long count=spittleRepository.count();
		logger.info("Count:"+count);

		Spitter spitter = spittleRepository.findOne(13).getSpitter();
		logger.info("Spitter:"+spitter);
		
		Spittle spittle = new Spittle(null, spitter, "Un Nuevo Spittle from Art", new Date());
		Spittle saved = spittleRepository.save(spittle);
		
		logger.info("Spittle:"+saved);
		count=spittleRepository.count();
		logger.info("Count:"+count);

		Spittle spittleinfo=spittleRepository.findOne(16L);
		logger.info("spittleinfo:"+spittleinfo);
		
		spitter = spittleRepository.findOne(13).getSpitter();
		spitter = spittleRepository.findOne(13).getSpitter();
		spitter = spittleRepository.findOne(13).getSpitter();
		spitter = spittleRepository.findOne(13).getSpitter();
		
		logger.info("Spitter-:"+spitter);
		logger.info("保存数据结束");
	}

	/*@Test*/
	@Transactional
	public void delete() {
		assertEquals(15, spittleRepository.count());
		assertNotNull(spittleRepository.findOne(13));
		spittleRepository.delete(13L);
		assertEquals(14, spittleRepository.count());
		// assertNull(spittleRepository.findOne(13));
	}

	private void assertRecent(List<Spittle> recent, int count) {
		long[] recentIds = new long[] { 3, 2, 1, 15, 14, 13, 12, 11, 10, 9 };
		assertEquals(count, recent.size());
		for (int i = 0; i < count; i++) {
			assertEquals(recentIds[i], recent.get(i).getId().longValue());
		}
	}

	private void assertNewSpittle(Spittle spittle) {
		assertEquals(16, spittle.getId().longValue());
	}

}
