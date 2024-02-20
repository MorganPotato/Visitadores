import java.util.InputMismatchException;
import java.util.Scanner;

class Elvisitor {
    private String name;
    private int age;
    private int visits;
    private double totalStayTime;

    public Elvisitor(String name, int age) {
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

public class Visitadores {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\n\t\tBienvenido al sistema de registro de visitantes.");

        System.out.print("\n\n\t\tIngrese el nombre del visitante: ");
        String name = scanner.nextLine();

        System.out.print("\n\n\t\tIngrese la edad del visitante: ");
        int age = scanner.nextInt();

        Elvisitor visitor = new Elvisitor(name, age);

        for (int i = 0; i < 7; i++) {
            try {
                System.out.printf("\n\n\t\tIngrese el tiempo de estadía del día %d en horas: ", i + 1);
                double stayTime = scanner.nextDouble();
                visitor.addVisit(stayTime);
            } catch (InputMismatchException e) {
                System.out.println("\n\n\t\tError: Por favor, ingrese un número que sea válido para el tiempo de estadia.");
                scanner.next();
                i--;
            }
        }

        System.out.println("\n\n\t\tResumen de visitante:");
        System.out.println("\n\n\t\tNombre: " + visitor.getName());
        System.out.println("\n\n\t\tEdad: " + visitor.getAge());
        System.out.println("\n\n\t\tTotal de visitas: " + visitor.getVisits());
        System.out.printf("\n\n\t\tTiempo promedio de estadía: %.2f horas\n", visitor.getAverageStayTime());
        System.out.println("\n\n\t\t¿Es mayor de edad el visitante?: " + (visitor.isAdult() ? "Sí" : "No"));

        scanner.close();
    }
}