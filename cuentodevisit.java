import java.util.Scanner;

class Visitor {
    private String name;
    private int age;
    private int visits;
    private double totalStayTime;

    public Visitor(String name, int age) {
        this.name = name;
        this.age = age;
        this.visits = 0;
        this.totalStayTime = 0;
    }

    public void addVisit(double stayTime) {
        visits++;
        totalStayTime += stayTime;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getVisits() {
        return visits;
    }

    public double getTotalStayTime() {
        return totalStayTime;
    }

    public double getAverageStayTime() {
        return totalStayTime / visits;
    }

    public boolean isAdult() {
        return age >= 18;
    }
}

public class VisitorManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al sistema de registro de visitantes.");

        System.out.print("Ingrese el nombre del visitante: ");
        String name = scanner.nextLine();

        System.out.print("Ingrese la edad del visitante: ");
        int age = scanner.nextInt();

        Visitor visitor = new Visitor(name, age);

        for (int i = 0; i < 7; i++) {
            System.out.printf("Ingrese el tiempo de estadía del día %d en horas: ", i + 1);
            double stayTime = scanner.nextDouble();
            visitor.addVisit(stayTime);
        }

        System.out.println("\nResumen de visitante:");
        System.out.println("Nombre: " + visitor.getName());
        System.out.println("Edad: " + visitor.getAge());
        System.out.println("Total de visitas: " + visitor.getVisits());
        System.out.printf("Tiempo promedio de estadía: %.2f horas\n", visitor.getAverageStayTime());
        System.out.println("¿Es mayor de edad?: " + (visitor.isAdult() ? "Sí" : "No"));

        scanner.close();
    }
}