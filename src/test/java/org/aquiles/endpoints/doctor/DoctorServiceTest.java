package org.aquiles.endpoints.doctor;

import org.aquiles.config.Database;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoctorServiceTest {

  private final DoctorService service = new DoctorService();
  private final Doctor doctor = new Doctor("Edu", "925123444", "test@gmail.com");

  @AfterAll
  public static void finish() {
    // FIXME point to test Db
    Database.getDatabase().getCollection("doctors").drop();
  }

  @Test
  public void createDoctor() {
    Doctor saved = this.service.save(this.doctor);
    assertEquals("Edu", saved.getName());
    assertEquals("925123444", saved.getPhone());
  }

  @Test
  public void findDoctorById() {
    Doctor saved = this.service.save(this.doctor);
    Doctor doctor = service.findById(saved.getId());
    assertEquals("Edu", doctor.getName());
  }
}
