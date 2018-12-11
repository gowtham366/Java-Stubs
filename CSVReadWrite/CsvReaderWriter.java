import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class CsvReaderWriter {
 
 public static void main(String[] args) {
  String filePath = "C:\\java\\csv\\user.csv";
  
  System.out.println("starting write user.csv file: " + filePath);
  writeCsv(filePath);
  
  System.out.println("starting read user.csv file");
  readCsv(filePath);
 }
 
 public static void writeCsv(String filePath) {
  List<UserBean> users = new ArrayList<UserBean>();
  
  //create demo Users
  UserBean user = new UserBean();
  user.setId(1);
  user.setFirstName("Jack");
  user.setLastName("Rutorial 1");
  users.add(user);
  
  user = new UserBean();
  user.setId(2);
  user.setFirstName("Jack");
  user.setLastName("Rutorial 2");
  users.add(user);
  
  user = new UserBean();
  user.setId(3);
  user.setFirstName("Jack");
  user.setLastName("Rutorial 3");
  users.add(user);
  
  FileWriter fileWriter = null;
  try {
   fileWriter = new FileWriter(filePath);
   
   fileWriter.append("Id, First Name, Last Name\n");
   for(User u: users) {
    fileWriter.append(String.valueOf(u.getId()));
    fileWriter.append(",");
    fileWriter.append(u.getFirstName());
    fileWriter.append(",");
    fileWriter.append(u.getLastName());
    fileWriter.append("\n");
   }
  } catch (Exception ex) {
   ex.printStackTrace();
  } finally {
   try {
    fileWriter.flush();
    fileWriter.close();
   } catch (Exception e) {
    e.printStackTrace();
   }
  }
 }
 
 public static void readCsv(String filePath) {
  BufferedReader reader = null;
  
  try {
   List<UseBean> users = new ArrayList<UserBean>();
   String line = "";
   reader = new BufferedReader(new FileReader(filePath));
   reader.readLine();
   
   while((line = reader.readLine()) != null) {
    String[] fields = line.split(",");
    
    if(fields.length > 0) {
     UserBean user = new UserBean();
     user.setId(Integer.parseInt(fields[0]));
     user.setFirstName(fields[1]);
     user.setLastName(fields[2]);
     users.add(user);
    }
   }
   
   for(UserBean u: users) {
    System.out.printf("[userId=%d, firstName=%s, lastName=%s]\n", u.getId(), u.getFirstName(), u.getLastName());
   }
   
  } catch (Exception ex) {
   ex.printStackTrace();
  } finally {
   try {
    reader.close();
   } catch (Exception e) {
    e.printStackTrace();
   }
  }
  
 }
}
