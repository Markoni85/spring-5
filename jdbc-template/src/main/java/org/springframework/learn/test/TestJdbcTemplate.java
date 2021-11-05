package org.springframework.learn.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.learn.config.EmbeddedJdbcConfig;
import org.springframework.learn.dao.SingerDao;
/**
 * 
 * @author mmarinkovic
 *
 */
public class TestJdbcTemplate {

	@Test
	public void TestDao() {
		
		GenericApplicationContext ctx = new AnnotationConfigApplicationContext(EmbeddedJdbcConfig.class);
		
		assertNotNull(ctx);
		
		SingerDao singerDao = ctx.getBean(SingerDao.class);
		
		assertNotNull(singerDao);

		String singerName = singerDao.findFullNameById(1L);
		
		assertEquals(singerName, "John Mayer");
		
		ctx.close();
	}
}
