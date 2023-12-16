import io.javalin.Javalin;

import java.util.HashMap;
import java.util.Map;

public class Example {
  public static void main(String[] args) {
    Javalin app = Javalin.create().start(7000);

    Map<String, String> person = new HashMap<>();
    person.put("Name", "Katy");
    person.put("Age", "21");


    app.get("/", ctx -> ctx.json(person));
  }
}
