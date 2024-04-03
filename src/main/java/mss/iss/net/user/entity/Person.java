package mss.iss.net.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.springframework.context.annotation.Primary;

@Entity
public class Person {
  @Id
  @GeneratedValue
  private int id;
  private String name;
  private String location;
  private String birthDate;

  public Person() {

  }

  public Person(int id, String name, String location, String birthDate) {
    this.id = id;
    this.name = name;
    this.location = location;
    this.birthDate = birthDate;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(String birthDate) {
    this.birthDate = birthDate;
  }

  @Override
  public String toString() {
    return "Person{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", location='" + location + '\'' +
        ", birthDate='" + birthDate + '\'' +
        '}';
  }
}
