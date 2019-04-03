import services.StudentServiceImpl;
import services.UserServiceImpl;
import model.User;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class ApplicationRun {

    static UserServiceImpl userService = new UserServiceImpl();
    static StudentServiceImpl productService = new StudentServiceImpl();

    static String adminCommand = "whoAmI, Logout, ListUsers, ListStudent, EnterAStudent, DeleteAStudent";
    static String userCommand = "whoAmI, Logout";

    static Scanner info = new Scanner(System.in);
 

    public static void main(String args[]) throws IOException {

        System.out.println("Did you sign up?(yes or no)");
        String choice = info.next();
        System.out.println("Please enter an username");
        String username = info.next();
        System.out.println("Please enter a password");
        String password = info.next();
      
        

        if (choice.equals("yes")) {
            boolean session = true;
            User user = userService.loginUser(new User(username, password));

            while (session) {
                System.out.println("------------");
                String command = commands(user.type);
                switch (command) {
                    case "whoAmI":
                        System.out.println("name : " + user.name);
                        break;
                    case "Logout":
                        session = userService.logoutUser(user.name);
                        break;
                    case "ListUsers":
                        if (user.type.equals("admin")) {
                            System.out.println("user list : ");
                            System.out.println(userService.listUser());
                        }
                        break;
                    case "ListStudent":
                        if (user.type.equals("admin")) {
                            System.out.println("Student list : ");
                            System.out.println(productService.listProduct());

                        }
                        break;
                    case "EnterAStudent":
                        if (user.type.equals("admin"))
                            productService.addProduct();
                        break;
                    case "DeleteAStudent":
                        if (user.type.equals("admin")) {
                            System.out.println("Please student id (type integer)");
                            int id = info.nextInt();
                            productService.deleteProduct(id);
                        }
                        break;
                        
                    case "ShowGPA":
                    	 if (user.type.equals("admin")) {
                              System.out.println("Grade list : ");
                              System.out.println(productService.listProduct());

                          }
                    	
                    	break;
                     
                        
                
                    	
                    default:
                        commands(user.type);
                        break;
                }


            }
        } else if (choice.equals("no")) {
            System.out.println("Please choose your type(admin or user)");
            String type = info.next();
            if (type.equals("admin") || type.equals("user")) {
                System.out.println(username + ":" + password + ":" + type + "!");

                userService.registerUser(new User(username, password, type));
            } else {
                System.out.println("Your type is none");
            }


        } else {
            System.out.println("Wrong choosen");
        }

    }


 


	public static void showStudentGPA() throws IOException {
		
		File file = new File("students.txt");
		Scanner scanFile = new Scanner(file);
		Scanner keyboard = new Scanner(System.in);
		String ss = null;
		String id;
		
		System.out.println("Please enter stdID: ");
		id = keyboard.next();
		
		
		while(scanFile.hasNext()) {
			
			ss = scanFile.nextLine();
			
			if(ss.contains(id)) {
				
				String[] parts = ss.split("GPA: ");
				System.out.println(parts[1].trim());
			}
			
		}
				
	}
	


	public static String commands(String userType) {
        System.out.println("commands");
        if (userType.equals("admin")) {
            System.out.println(adminCommand);
        } else {
            System.out.println(userCommand);
        }
        System.out.println("Please enter a command");
        String command = info.next();
        return command;
    }
    
    
}