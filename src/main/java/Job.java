import java.util.List;
import java.util.ArrayList;

public class Job {
  private String mTitle;
  private String mDiscription;
  private String mContact;
  private static List<Job> instances = new ArrayList<Job>();
  private int mId;

  public Job (String title, String discription, String contact){
    mTitle = title;
    mDiscription = discription;
    mContact = contact;
    instances.add(this);
    mId = instances.size();
  }
  public String getTitle(){
    return mTitle;
  }
  public String getDiscription(){
    return mDiscription;
  }
  public String getContact(){
    return mContact;
  }
  public static List<Job>all(){
    return instances;
  }
  public static void clear(){
    instances.clear();
  }
  public int getId(){
    return mId;
  }
  public static Job find(int id){
    return instances.get(id -1);
  }
}
