package mss.iss.net.user.jdbc;

import mss.iss.net.user.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PersonJdbcDao {

  @Autowired
  JdbcTemplate jdbcTemplate;

  class PersonRowMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {

      return new Person(rs.getInt("id"),
          rs.getString("name"),
          rs.getString("location"),
          rs.getString("birth_date"));
    }

  }

  /**
   * select * from person;
   *
   * @return Person List
   */
  public List<Person> findAll() {
    return jdbcTemplate.query("select * from person", new PersonRowMapper());
  }

  public Person findById(int id) {
    return jdbcTemplate.queryForObject("select * from person where id=?"
        , new Object[]{id}
        , new BeanPropertyRowMapper<>(Person.class));
  }

  public int insert(Person person) {
    return jdbcTemplate.update("insert into person (id, name, location, birth_date) values(?,?,?,?)"
        , new Object[]{person.getId(), person.getName(), person.getLocation(), person.getBirthDate()});
  }

  public int update(Person person) {
    return jdbcTemplate.update("update person set name=?, location=?, birth_date=? where id=?"
        , new Object[]{person.getName(), person.getLocation(), person.getBirthDate(), person.getId()});
  }
}
