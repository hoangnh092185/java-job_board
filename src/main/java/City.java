import java.util.List;
import java.util.ArrayList;

public class City{
  private String mCity;
  private static List<City> instances = new ArrayList<City>();
  private int mId;
  private List<Job> mJobs;

  public City (String name){
    mCity = name;
    instances.add(this);
    mId = instances.size();
    mJobs = new ArrayList<Job>();
  }

  public String getName(){
    return mCity;
  }
  public static List<City>all(){
    return instances;
  }
  public static void clear(){
    instances.clear();
  }
  public int getId(){
    return mId;
  }
  public List<Job> getJobs(){
    return mJobs;
  }
  public void addJobs(Job title){
    mJobs.add(title);
  }
  public static City find(int id){
    return instances.get(id -1);
  }
}
