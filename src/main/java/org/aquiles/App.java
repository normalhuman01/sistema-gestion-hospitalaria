package org.aquiles;

import io.javalin.Javalin;
import org.aquiles.endpoints.doctor.DoctorController;

public class App {

  private final DoctorController doctorController;

  public App() {
    doctorController = new DoctorController();
  }

  public void init() {
    Javalin server = Javalin.create().start(7000);
    doctorController(server);
  }

  public void doctorController(Javalin server) {
              // endpoint, metodo al que se va a llamar cuando llames este endpoint
    server.post("doctors/", doctorController::createDoctor);
  }

  public static void main(String[] args) {
    new App().init();
  }
}
