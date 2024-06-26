package mss.iss.net.user;

import mss.iss.net.user.entity.Person;
import mss.iss.net.user.jdbc.PersonJdbcDao;
import mss.iss.net.user.repository.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	public PersonJpaRepository personJdbcDao;
	//PersonJdbcDao personJdbcDao;

	@Override
	public void run(String... args) throws Exception {
		Person p = new Person( "TOM", "USA", "2020-01-14 11:11:00");

		logger.info("People in DB: {}\n", personJdbcDao.findAll());
		logger.info("User ID 10001: {}\n", personJdbcDao.findById(10001));

		personJdbcDao.deleteById(10001);

		logger.info("Deleted ID 10001\n");
		logger.info("People in DB: {}\n", personJdbcDao.findAll());

		p = personJdbcDao.insert(p);

		logger.info("ADD new person: {}\n", p);

		p = new Person(p.getId(),"TOM TOM", "USA", "2020-01-14 11:11:00");

		logger.info("UPDATE person ID 10005: {}\n", personJdbcDao.update(p));
		logger.info("People in DB: {}\n", personJdbcDao.findAll());
	}

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}
}
