package org.aquiles.endpoints.doctor;


import io.javalin.http.Context;
import org.aquiles.config.Database;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;


public class DoctorEndpointsTests {

  private final DoctorController controller;
  private final Context context = mock(Context.class);

  public DoctorEndpointsTests() {
    controller = new DoctorController();
  }

//  @BeforeAll
//  public static void init() {
//    Database.getDatabase().getCollection("doctors").drop();
//  }

  @Test
  public void createDoctor() {
    // NullPointerException thrown due to mockito bug. Info at: https://javalin.io/tutorials/mockito-testing
    Doctor doctor = new Doctor("Lucas", "999111222", "test@mail.com");
    when(context.bodyAsClass(Doctor.class)).thenReturn(doctor);
    controller.createDoctor(context);

    verify(context).status(HttpStatus.CREATED_201);
  }
}
