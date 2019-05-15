package test;

import java.io.*;

class Employee implements Serializable {
    transient int id = 1;
    String name = "XYZ";
    static double salary = 9999.99;
}

public class EmployeeService {
    public static void main(String[] args) {
        Employee emp = new Employee();
        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream("Company.txt")
            );
            out.writeObject(emp);
            out.close();
            System.out.print(++emp.salary + " ");

            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream("Company.txt")
            );
            Employee empCopy = (Employee) in.readObject();
            in.close();
            System.out.println(String.join(" ", String.valueOf(empCopy.id), empCopy.name, String.valueOf(empCopy.salary)));
        } catch (Exception x) {
            System.out.println("Error");
        }
    }
}
