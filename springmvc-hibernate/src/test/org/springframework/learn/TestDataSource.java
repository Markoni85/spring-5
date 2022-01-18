package org.springframework.learn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.learn.controller.config.AppConfig;
import org.springframework.learn.model.Album;
import org.springframework.learn.model.Singer;
import org.springframework.learn.service.SingerService;
import org.springframework.learn.service.SingerServiceImpl;

public class TestDataSource {

	private static  Logger logger = LoggerFactory.getLogger(TestDataSource.class);
	
	private GenericApplicationContext ctx;
	private SingerService singerService;

	@Before
	public void setUp() {
		ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		singerService = ctx.getBean("singerService1", SingerService.class);
		assertNotNull(singerService);
	}

	@Test
	public void testFindAll() {
		List<Singer> singers = singerService.getSingers();
		assert(singers.size() > 0);
		listSingersWithAlbum(singers);
	}

	private static void listSingersWithAlbum(List<Singer> singers) {
		logger.info(" ---- Listing singers with instruments:");
		for (Singer singer : singers) {
			logger.info(singer.toString());
			if (singer.getAlbums() != null) {
				for (Album album : singer.getAlbums()) {
					logger.info("\t" + album.toString());
				}
			}
		}
	}
}
