package org.springframework.learn.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.learn.config.AppConfig;
import org.springframework.learn.dao.SingerDao;
import org.springframework.learn.model.Album;
import org.springframework.learn.model.Singer;

/**
 * 
 * @author mmarinkovic
 *
 */
public class TestMappingSqlQuery {

	private GenericApplicationContext ctx;
	private SingerDao singerDao;

	@Before
	public void setup() {
		try {
			ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		assertNotNull(ctx);
		singerDao = ctx.getBean(SingerDao.class);
		assertNotNull(singerDao);
	}

	@Test
	public void TestDao() {
		List<Singer> singers = singerDao.findAll();
		assertTrue(singers.size() == 3);
		singers.forEach(singer -> {
			System.out.println(singer);
			if (singer.getAlbums() != null) {
				for (Album album : singer.getAlbums()) {
					System.out.println("\t--> " + album);
				}
			}
		});
		ctx.close();
	}
	
	@After
	public void tearDown() {
		ctx.close();
	}
}
