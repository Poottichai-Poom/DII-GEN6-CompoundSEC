import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User.Admin admin = new User.Admin();
        User.Staff staff = new User.Staff();
        User.Customer customer = new User.Customer();
        ArrayList<Room.Lowfloor> lowfloor = new ArrayList<>();
        ArrayList<Room.Mediumfloor> mediumfloor = new ArrayList<>();
        ArrayList<Room.Highfloor> highfloor = new ArrayList<>();
        ArrayList<User> userList = new ArrayList<>();

        lowfloor.add(new Room.Lowfloor(1, 1, 101));
        lowfloor.add(new Room.Lowfloor(2, 1, 102));
        lowfloor.add(new Room.Lowfloor(2, 2, 103));
        mediumfloor.add(new Room.Mediumfloor(1, 1, 201));
        mediumfloor.add(new Room.Mediumfloor(2, 1, 202));
        mediumfloor.add(new Room.Mediumfloor(2, 2, 203));
        highfloor.add(new Room.Highfloor(1, 1, 301));
        highfloor.add(new Room.Highfloor(2, 1, 302));
        highfloor.add(new Room.Highfloor(2, 2, 303));

        try {
            String select = "";

            while (true) {
                System.out.println("Who are you?\n1.Admin\n2.Staff\n3.Customer\n0.Log out");
                select = scanner.nextLine();
                String name;
                String password;

                if (select.isEmpty()) continue;

                switch (select) {
                    case "1" -> {
                        if (admin.getName().equalsIgnoreCase("") && (admin.getPassword().equalsIgnoreCase(""))){
                            System.out.print("What is your name: ");
                            name = scanner.nextLine();
                            System.out.print("Password: ");
                            password = scanner.nextLine();
                            admin = new User.Admin(name, password);
                            admin.Displayinfo_card(name, password);
                            adminMenu(scanner, admin, userList, lowfloor, mediumfloor, highfloor);
                        } else if (!admin.getName().equalsIgnoreCase("") && (!admin.getPassword().equalsIgnoreCase(""))) {
                            System.out.print("What is your name: ");
                            name = scanner.nextLine();
                            System.out.print("Password: ");
                            password = scanner.nextLine();
                            admin.Check_admin(name,password);
                            admin.Displayinfo_card(name, password);
                            adminMenu(scanner, admin, userList, lowfloor, mediumfloor, highfloor);
                        }
                    }
                    case "2" -> {
                        System.out.print("What is your name: ");
                        name = scanner.nextLine();
                        System.out.print("Password: ");
                        password = scanner.nextLine();
                        staff = new User.Staff(name, password);
                        staff.Displayinfo_card(name, password);
                        system_staff(scanner, customer, lowfloor, mediumfloor, highfloor);
                    }
                    case "3" -> {
                        System.out.print("What is your name: ");
                        name = scanner.nextLine();
                        System.out.print("Password: ");
                        password = scanner.nextLine();
                        customer = new User.Customer(name, password);
                        customer.Displayinfo_card(name, password);
                        userList.add(customer);
                    }
                    case "0" -> {
                        System.exit(0);
                    }
                    default -> {
                        System.out.println("Invalid choice. Please select again: ");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Program terminated.");
        }
    }

    public static void adminMenu(Scanner scanner, User.Admin admin, ArrayList<User> userList, ArrayList<Room.Lowfloor> lowfloor, ArrayList<Room.Mediumfloor> mediumfloor, ArrayList<Room.Highfloor> highfloor) {
        label:
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Modify user details");
            System.out.println("2. Delete user account");
            System.out.println("3. Exit Admin menu");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1": {
                    System.out.println("\nUser List:");
                    int index = 1;
                    for (User user : userList) {
                        System.out.println(index++ + ". " + user.getName() + " (Role: " + user.getClass().getSimpleName() + ")");
                    }

                    System.out.print("Enter the number of the user to modify: ");
                    int userIndex = scanner.nextInt();
                    scanner.nextLine();
                    if (userIndex < 1 || userIndex > userList.size()) {
                        System.out.println("Invalid user number.");
                        break;
                    }

                    User selectedUser = userList.get(userIndex - 1);
                    System.out.print("Enter the new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter the new password: ");
                    String newPassword = scanner.nextLine();

                    admin.modify_user(selectedUser, newName, newPassword);
                    break;
                }
                case "2": {
                    System.out.println("\nUser List:");
                    int index = 1;
                    for (User user : userList) {
                        System.out.println(index++ + ". " + user.getName() + " (Role: " + user.getClass().getSimpleName() + ")");
                    }

                    System.out.print("Enter the number of the user to delete: ");
                    int userIndex = scanner.nextInt();
                    scanner.nextLine();
                    if (userIndex < 1 || userIndex > userList.size()) {
                        System.out.println("Invalid user number.");
                        break;
                    }

                    User selectedUser = userList.get(userIndex - 1);
                    admin.delete_user(userList, selectedUser.getName());
                    break;
                }
                case "3":
                    break label;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
    public static void system_staff(Scanner scanner, User.Customer customer, ArrayList<Room.Lowfloor> lowfloor, ArrayList<Room.Mediumfloor> mediumfloor, ArrayList<Room.Highfloor> highfloor) {
        while (true) {
            System.out.println("\nAvailable Rooms:");
            System.out.printf("%-5s %-10s %-10s %-10s%n", "No.", "Bedroom", "Toilet", "Room No.");

            ArrayList<Room> allRooms = new ArrayList<>();
            allRooms.addAll(lowfloor);
            allRooms.addAll(mediumfloor);
            allRooms.addAll(highfloor);

            int index = 1;
            for (Room room : allRooms) {
                System.out.printf("%-5d %-10d %-10d %-10d%n", index++, room.getBedroom(), room.getToilet(), room.getFloor());
            }

            System.out.print("\nEnter the number of the room you want to select (or 0 to exit): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) break;
            if (choice < 1 || choice > allRooms.size()) {
                System.out.println("Invalid selection, please try again.");
                continue;
            }

            Room selectedRoom = allRooms.get(choice - 1);
            customer.addRoom(selectedRoom.getFloor());

            switch (selectedRoom) {
                case Room.Lowfloor room -> lowfloor.remove(selectedRoom);
                case Room.Mediumfloor room -> mediumfloor.remove(selectedRoom);
                case Room.Highfloor room -> highfloor.remove(selectedRoom);
                default -> {
                }
            }

            System.out.println("You selected Room No. " + selectedRoom.getFloor());
            System.out.println("\nRooms you have booked: " + customer.getSelectedRooms());
        }
    }
}
