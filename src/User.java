import java.util.ArrayList;
public abstract class User {
     protected String name;
     protected String password;
     private int number_room;
     public int number_admin;
     public int number_staff;
     public int number_customer;

     public User(){
          this.name = "";
          this.password = "";

     }
     public User(String name){
          this.name = name;
          this.password = "";

     }
     public User(String name, String password){
          this.name = name;
          this.password = password;

     }

     public String getName() {
          return name;
     }
     public void setName(String name){
          this.name = name;
     }
     public String getPassword(){
          return password;
     }
     public void setPassword(String password){
          this.password = password;
     }
     public int getNumber_admin(){
          return number_admin;
     }
     public int getNumber_staff(){
          return number_staff;
     }
     public int getNumber_customer(){
          return number_customer;
     }
     public abstract void Displayinfo_card(String name,String password);

     static class Admin extends User{
          public Admin()
          {
               super();
               number_admin++;
          }
          public Admin(String name)
          {
               super(name);
               number_admin++;
          }
          public Admin(String name, String password)
          {
               super(name, password);
               number_admin++;
          }

          @Override
          public void Displayinfo_card(String name, String password) {
               System.out.println("Name : "+name+"\nPassword : "+password);
          }
          public void modify_card(String newName, String newPassword) {
               this.setName(newName);
               this.setPassword(newPassword);
               System.out.println("Profile updated successfully.");
          }
          public void Check_admin(String name, String password){
               if (this.name.equalsIgnoreCase(name) && (this.password.equalsIgnoreCase(password))){
                    System.out.println("Welcome Admin");
               }else {
                    System.out.println("You are not an admin");
                   System.exit(0);
               }
          }

          public void modify_user(User user, String newName, String newPassword) {
               user.setName(newName);
               user.setPassword(newPassword);
               System.out.println("User profile updated: " + newName);
          }

          public void delete_card() {
               this.setName("");
               this.setPassword("");
               System.out.println("Admin account deleted.");
          }

          public void delete_user(ArrayList<User> userList, String username) {
               for (int i = 0; i < userList.size(); i++) {
                    if (userList.get(i).getName().equalsIgnoreCase(username)) {
                         userList.remove(i);
                         System.out.println("User '" + username + "' has been deleted.");
                         return;
                    }
               }
               System.out.println("User not found.");
          }
     }

     static class Staff extends User{
          public Staff()
          {
               super();
               number_staff++;
          }
          public Staff(String name)
          {
               super(name);
               number_staff++;
          }
          public Staff(String name, String password)
          {
               super(name, password);
               number_staff++;
          }
          @Override
          public void Displayinfo_card(String name, String password) {
               System.out.println("Name : "+name+"\nPassword : "+password);
          }
          public void modify_card(String password) {
               this.setPassword(password);
               System.out.println("New passwoed : "+password);
          }
     }

     static class Customer extends User{
          private ArrayList<Integer> selectedRooms;
          public Customer()
          {
               super();
               number_customer++;
          }
          public Customer(String name)
          {
               super(name);
               number_customer++;
          }
          public Customer(String name, String password)
          {
               super(name, password);
               number_customer++;
          }
          @Override
          public void Displayinfo_card(String name, String password) {
               System.out.println("Name : "+name+"\nPassword : "+password);
          }
          public void modify_name(String name)
          {
               this.setName(name);
               System.out.println("New name : "+name);

          }
          public void addRoom(int roomNumber) {
               selectedRooms.add(roomNumber);
               System.out.println("Room " + roomNumber + " has been booked.");
          }

          public ArrayList<Integer> getSelectedRooms() {
               return selectedRooms;
          }
     }
}

