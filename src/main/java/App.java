import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.Collections;

public class App{
  public static void main(String[] args){
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response)->{
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("cities", City.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/", (request, reponse) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      City city = new City(request.queryParams("city"));
      model.put("cities", City.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/cities/:id", (request, response)->{
      Map<String, Object> model = new HashMap<String, Object>();
      City currentCity = City.find(Integer.parseInt(request.params(":id")));
      model.put("city", currentCity);
      model.put("jobs", currentCity.getJobs());
      model.put("template", "templates/city.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/cities/:id", (request, response)->{
      Map<String, Object> model = new HashMap<String, Object>();
      Job newJob = new Job(request.queryParams("title"), request.queryParams("discription"), request.queryParams("contact"));
      City currentCity = City.find(Integer.parseInt(request.params(":id")));
      currentCity.addJobs(newJob);
      model.put("city", currentCity);
      model.put("jobs", currentCity.getJobs());
      model.put("template", "templates/city.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/jobs/:id", (request, response)->{
      Map<String, Object> model = new HashMap<String, Object>();
      Job currentJob = Job.find(Integer.parseInt(request.params(":id")));
      model.put("job", currentJob);
      model.put("template", "templates/job.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
