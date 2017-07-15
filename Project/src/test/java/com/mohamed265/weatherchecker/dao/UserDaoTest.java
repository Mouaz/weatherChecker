package com.mohamed265.weatherchecker.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.mohamed265.weatherchecker.entity.User;

@ContextConfiguration("/test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class UserDaoTest {

	@Autowired
	private UserDao userDao;

	@Test
	public void t01_registerUser() throws Exception {

		User user = new User();
		user.setName("name");
		user.setPassword("password");
		user.setEmail("email");
		user.setIsAdmin(false);

		userDao.save(user);

		Assert.assertNotNull(user.getId());
	}

	@Test(expected = Exception.class)
	public void t02_duplicateUserEmail() throws Exception {

		User user = new User();
		user.setName("name");
		user.setPassword("password");
		user.setEmail("email");
		user.setIsAdmin(false);

		userDao.save(user);

		User user1 = new User();
		user1.setName("name");
		user1.setPassword("password");
		user1.setEmail("email");

		userDao.save(user1);
	}

	@Test
	public void t03_loginTest_worng_password() throws Exception {

		User user = new User();
		user.setName("name");
		user.setPassword("password");
		user.setEmail("email");
		user.setIsAdmin(false);

		userDao.save(user);

		user = userDao.loginByEmail("email", "wrongpassword");

		Assert.assertNull(user);

	}

	@Test
	public void t04_loginTest_worng_email() throws Exception {

		User user = new User();
		user.setName("name");
		user.setPassword("password");
		user.setEmail("email");
		user.setIsAdmin(false);

		userDao.save(user);

		user = userDao.loginByEmail("wrongemail", "password");

		Assert.assertNull(user);

	}

	@Test
	public void t05_loginTest() throws Exception {

		User user = new User();
		user.setName("name");
		user.setPassword("password");
		user.setEmail("email");
		user.setIsAdmin(false);

		userDao.save(user);

		user = userDao.loginByEmail("email", "password");

		Assert.assertNotNull(user);
	}

	@Test
	@Transactional
	public void t06_delete_user_test() throws Exception {

		User user = new User();
		user.setName("name");
		user.setPassword("password");
		user.setEmail("email");
		user.setIsAdmin(false);

		userDao.save(user);

		user = userDao.loginByEmail("email", "password");

		userDao.delete(user);

		user = userDao.getUserById(user.getId());

		Assert.assertNull(user);
	}

}