package services;

import model.Student;
import model.EngineerStudent;
import model.MedicalStudent;

import java.io.*;
import java.util.*;

public class StudentServiceImpl extends StundentServices {

    static int id = 1;

    static File file = new File("students.txt");
    static File tempFile = new File("studentsstemp.txt");
  
    
    
    static Scanner info = new Scanner(System.in);


    public void deleteProduct(int id) {
        Map<Integer,String> tempMap = new HashMap<>();
        try {

            BufferedReader buff = new BufferedReader(new FileReader(file));
            while (buff.ready()) {
                String read = buff.readLine();
                String productArrays[] = read.split(":");
                tempMap.put(Integer.parseInt(productArrays[0]), read);
            }
            tempMap.remove(id);
            buff.close();

            BufferedWriter buffw = new BufferedWriter(new FileWriter(tempFile, true));

            for (Map.Entry<Integer, String> entry : tempMap.entrySet())
            {
                buffw.write(entry.getValue());
                buffw.newLine();
            }

            tempFile.renameTo(file);
            buffw.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void addProduct() {
        try {
            BufferedWriter buffw = new BufferedWriter(new FileWriter(file, true));
            
            
            System.out.println("student number (type integer)");
            int stNumber = info.nextInt();
            

            System.out.println("student name");
            String name = info.next();

            System.out.println("student surname (type string)");
            String surname = info.next();
            
            System.out.println("Enter grade1 (type integer)");
            Double grade1 = info.nextDouble();
            
            System.out.println("Enter grade2 (type integer)");
            Double grade2 = info.nextDouble();
            
            System.out.println("Enter grade3 (type integer)");
            Double grade3 = info.nextDouble();
            
            System.out.println("Enter grade4 (type integer)");
            Double grade4 = info.nextDouble();
            
            System.out.println("Enter grade5 (type integer)");
            Double grade5 = info.nextDouble();
            
            
            

            System.out.println("student Type (Engineer or Health)");
            String type = info.next();

            EngineerStudent engineer = null;
            MedicalStudent medical = null;
            if (type.equalsIgnoreCase("Engineer")) {
                engineer = new EngineerStudent(id, stNumber, name, surname);
            } else if (type.equalsIgnoreCase("book")) {
                medical = new MedicalStudent(id, stNumber, name, surname);
            }


            if (engineer != null) {
                buffw.write(engineer.toString());
            } else {
                buffw.write(medical.toString());
            }

            buffw.newLine();
            buffw.close();

            id++;
        } catch (IOException e) {
            e.printStackTrace();

        }

    }
    
        

    public List<String> listProduct() {
        List<String> products = new ArrayList<>();
        try {
            BufferedReader buff = new BufferedReader(new FileReader(file));
            while (buff.ready()) {
                String read = buff.readLine();
                products.add(read);
                System.out.println(read);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }
}
