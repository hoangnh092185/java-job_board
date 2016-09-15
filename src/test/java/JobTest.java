import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;


public class JobTest{
  @Test
  public void Job_instanctiatesCorrectly_true(){
    Job testJob = new Job("Jr. Web Developer","Develop web pages with supervision.", "billG@microsoft.com");
    assertEquals(true, testJob instanceof Job);
  }
  @Test
  public void Job_returnJobTitle_String(){
    Job testJob = new Job("Jr. Web Developer","Develop web pages with supervision.", "billG@microsoft.com");
    assertEquals("Jr. Web Developer", testJob.getTitle());
  }
  @Test
  public void Job_returnJobDescription_String(){
    Job testJob = new Job("Jr. Web Developer","Develop web pages with supervision.", "billG@microsoft.com");
    assertEquals("Develop web pages with supervision.", testJob.getDiscription());
  }
  @Test
  public void Job_returnJobContact_String(){
    Job testJob = new Job("Jr. Web Developer","Develop web pages with supervision.", "billG@microsoft.com");
    assertEquals("billG@microsoft.com", testJob.getContact());
  }
  @Test
  public void Job_returnAllInstancesOfJob_true(){
    Job testJob = new Job("Jr. Web Developer","Develop web pages with supervision.", "billG@microsoft.com");
    Job testJob2 = new Job("Sr. Web Developer","Supervise the development of web pages.", "billG@microsoft.com");
    assertEquals(true, Job.all().contains(testJob));
    assertEquals(true, Job.all().contains(testJob2));
  }
  @Test
  public void clear_returnsAllJobListSize_0(){
    Job testJob = new Job("Jr. Web Developer","Develop web pages with supervision.", "billG@microsoft.com");
    Job testJob2 = new Job("Sr. Web Developer","Supervise the development of web pages.", "billG@microsoft.com");
    Job.clear();
    assertEquals(0, Job.all().size());
  }
  @Test
  public void formList_returnsJobRequested_1(){
  Job testJob = new Job("Jr. Web Developer","Develop web pages with supervision.", "billG@microsoft.com");
    assertEquals(1, Job.all().size());
  }

  @After
  public void tearDown() {
    Job.clear();
  }
}
