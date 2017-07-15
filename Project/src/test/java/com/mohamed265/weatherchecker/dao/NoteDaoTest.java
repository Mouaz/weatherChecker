package com.mohamed265.weatherchecker.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.mohamed265.weatherchecker.entity.Note;
import com.mohamed265.weatherchecker.entity.User;
import com.mohamed265.weatherchecker.util.DateFactory;

@ContextConfiguration("/test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class NoteDaoTest {

	@Autowired
	private NoteDao noteDao;

	@Autowired
	private UserDao userDao;

	@Test
	public void t01_addnote() throws Exception {

		Note note = new Note();
		note.setDate(DateFactory.getDate());
		note.setText("nice");

		User user = new User();
		user.setName("name");
		user.setPassword("password");
		user.setEmail("email");
		user.setIsAdmin(false);
		userDao.save(user);

		note.setUser(user);

		noteDao.save(note);

		Assert.assertNotNull(note.getId());
	}

	@Test 
	public void t02_duplicateWeatherDayDate() throws Exception {
		Note note = new Note();
		note.setDate(DateFactory.getDate());
		note.setText("nice");

		User user = new User();
		user.setName("name");
		user.setPassword("password");
		user.setEmail("email");
		user.setIsAdmin(false);
		userDao.save(user);

		note.setUser(user);

		noteDao.save(note);

		List<Note> list = noteDao.getAllNoteByDate(DateFactory.getDate());
		Assert.assertTrue(list.size() == 1);
	}

	@Test
	@Transactional
	public void t03_get_user_notes() throws Exception {

		Note note = new Note();
		note.setDate(DateFactory.getDate());
		note.setText("nice");

		User user = new User();
		user.setName("name");
		user.setPassword("password");
		user.setEmail("email");
		user.setIsAdmin(false);
		userDao.save(user);

		note.setUser(user);

		noteDao.save(note);

		List<Note> list = noteDao.getAllNotesByUser(user.getId());
		Assert.assertTrue(list.size() == 1);
	}

}