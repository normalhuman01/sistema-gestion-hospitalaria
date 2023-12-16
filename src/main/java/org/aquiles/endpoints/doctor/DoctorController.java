package org.aquiles.endpoints.doctor;

import io.javalin.http.Context;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.HttpStatus;

public class DoctorController {

  private static final DoctorRepository service;

  static {
    service = new DoctorService();
  }

  public void createDoctor(Context context) {
    Doctor doctor = service.save(context.bodyAsClass(Doctor.class));

    context
        .status(HttpStatus.CREATED_201)
        .header(HttpHeader.LOCATION.name(), "doctors/" + doctor.getId())
        .json(doctor);

  }

}
