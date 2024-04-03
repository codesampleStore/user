package mss.iss.net.user.repository;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import mss.iss.net.user.entity.Person;
import org.springframework.stereotype.Repository;

// Repository
// Transaction
@Repository
@Transactional
public class PersonJpaRepository {

  // connect to the database
  @PersistenceContext
  public EntityManager entityManager;

  public Person findById(int id) {
    return entityManager.find(Person.class, id);
  }

  public Person update(Person person) {
    return entityManager.merge(person);
  }

  public Person insert(Person person) {
    return entityManager.merge(person);
  }

  public void deleteById(int id) {
    entityManager.remove(findById(id));
  }

  // JPQL query
  public java.util.List<Person> findAll() {
     TypedQuery<Person> namedQuery
         = entityManager.createNamedQuery("find_all_persons", Person.class);
     return namedQuery.getResultList();
  }
}
