package org.aquiles.endpoints.doctor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Doctor {

  private String id;
  private String name;
  private String phone;
  private String email;


  private Doctor(String id, String name, String phone, String email) {
    this.id = id;
    this.name = name;
    this.phone = phone;
    this.email = email;
  }

  public Doctor(String name, String phone, String email) {
    this(null, name, phone, email);
  }
}
