package org.aquiles.endpoints.doctor;

import com.mongodb.client.MongoCollection;
import org.aquiles.config.Database;
import org.bson.types.ObjectId;

import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class DoctorService implements DoctorRepository {

  private final MongoCollection<Doctor> doctors;

  public DoctorService() {
    doctors = Database.getDatabase().getCollection("doctors", Doctor.class);
  }

  @Override
  public Doctor save(Doctor entity) {
    entity.setId(new ObjectId().toString());
    doctors.insertOne(entity);
    return doctors.find(eq("_id", entity.getId())).first();
  }

  @Override
  public List<Doctor> saveAll(List<Doctor> entities) {
    return null;
  }

  @Override
  public Doctor findById(String id) {
    return doctors.find(eq("_id", id)).first();
  }

  @Override
  public List<Doctor> findAll() {
    return null;
  }

  @Override
  public void delete(Doctor entity) {

  }

  @Override
  public void deleteAll() {

  }

  @Override
  public void deleteById(String s) {

  }
}
