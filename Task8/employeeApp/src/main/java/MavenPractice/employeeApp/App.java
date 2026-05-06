package MavenPractice.employeeApp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {

        @SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        EmployeeService services = context.getBean(EmployeeService.class);

        services.addEmployee(101, "Anand", "CSE");
        services.addEmployee(102, "Divya", "ECE");
        services.addEmployee(103, "Ravi", "IT");

        System.out.println("All Employees:");
        services.getAllEmployees().forEach(System.out::println);

        System.out.println("\nFind Employee 102:");
        System.out.println(services.getEmployee(102));

        System.out.println("\nDelete Employee 101:");
        System.out.println("Deleted? " + services.removeEmployee(101));

        System.out.println("\nAll Employees After Delete:");
        services.getAllEmployees().forEach(System.out::println);
    }
}
