import java.util.List;
import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;


public class CityTest{
  @Test
  public void City_instanctiatesCorrectly_true(){
    City testCity = new City("Portland");
    assertEquals(true, testCity instanceof City);
  }
  @Test
  public void City_returnCityName_Portland(){
    City testCity = new City("Portland");
    assertEquals("Portland", testCity.getName());
  }
  @Test
  public void City_returnAllInstancesOfCity_true(){
    City firstCity = new City("Portland");
    City secondCity = new City("Hillsboro");
    assertEquals(true, City.all().contains(firstCity));
    assertEquals(true, City.all().contains(secondCity));
  }
  @Test
  public void clear_returnsAllCityFormListSize_0(){
    City firstCity = new City("Portland");
    City secondCity = new City("Hillsboro");
    City.clear();
    assertEquals(0, City.all().size());
  }
  @Test
  public void formList_returnsAllCityFormListSize_1(){
    City firstCity = new City("Portland");
    assertEquals(1, City.all().size());
  }

  @Test
  public void addJobs_addsJobtoList() {
    City firstCity = new City("Portland");
    Job testJob = new Job("Jr. Web Developer","Develop web pages with supervision.", "billG@microsoft.com");
    firstCity.addJobs(testJob);
    assertEquals(1, firstCity.getJobs().size());
  }

  @After
  public void tearDown() {
    City.clear();
  }

}
