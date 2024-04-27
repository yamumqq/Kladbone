import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<String> availableFlowers = new ArrayList<>();
    static ArrayList<String> employees = new ArrayList<>();
    static ArrayList<String> services = new ArrayList<>();
    static String cemeteryName;
    static String cemeteryAddress;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        cemeteryName = "Кладбище";
        cemeteryAddress = "Метро Пыхтино";
        availableFlowers.add("Роза");
        availableFlowers.add("Гвоздика");
        availableFlowers.add("Тюльпаны");
        employees.add("Гвоздиков Н.В., Зарплата: 2200.0, Должность: Дворник");
        employees.add("Грушин Н.В., Зарплата: 1000000.0, Должность: Директор");
        employees.add("Якшин М.Е., Зарплата: 1337.0, Должность: Гробовщики");
        services.add("Захоронение, Цена: 2500.0");
        services.add("Уборка на могиле, Цена: 1000.0");
        services.add("Вознесение цветов, Цена: 300.0");

        int choice;
        do {
            System.out.println("\n1. Вывод сотрудников");
            System.out.println("2. Добавить сотрудника");
            System.out.println("3. Уволить сотрудника");
            System.out.println("4. Вывести услуги");
            System.out.println("5. Добавить услугу");
            System.out.println("6. Удалить услугу");
            System.out.println("7. Вывести адрес");
            System.out.println("8. Добавить цветы");
            System.out.println("9. Вывести список цветов");
            System.out.println("0. Выход");
            System.out.print("Введите номер: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    displayAllEmployees();
                    break;
                case 2:
                    addEmployeeWithInput(scanner);
                    break;
                case 3:
                    removeEmployeeByIndexWithInput(scanner);
                    break;
                case 4:
                    displayAllServices();
                    break;
                case 5:
                    addServiceWithInput(scanner);
                    break;
                case 6:
                    removeServiceByIndexWithInput(scanner);
                    break;
                case 7:
                    displayCemeteryAddress();
                    break;
                case 8:
                    addFlowerWithInput(scanner);
                    break;
                case 9:
                    displayAvailableFlowers();
                    break;
                case 0:
                    exitProgram();
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        } while (choice != 0);

        scanner.close();
    }

    public static void addEmployeeWithInput(Scanner scanner) {
        System.out.print("Ввести имя сотрудника: ");
        String name = scanner.nextLine();
        System.out.print("Ввести зарплату: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Ввести должность: ");
        String position = scanner.nextLine();
        employees.add("Фио: " + name + ", Зарплата: " + salary + ", Должность: " + position);
    }

    public static void removeEmployeeByIndexWithInput(Scanner scanner) {
        System.out.print("Введите индекс сотрудника которого нужно уволить: ");
        int empIndex = scanner.nextInt();
        scanner.nextLine();
        if (empIndex >= 1 && empIndex <= employees.size()) {
            employees.remove(empIndex - 1);
            System.out.println("Сотрудник удален успешно.");
        } else {
            System.out.println("Неправильный ввод.");
        }
    }

    public static void addServiceWithInput(Scanner scanner) {
        System.out.print("Ввести название услуги: ");
        String serviceName = scanner.nextLine();
        System.out.print("Ввести цену услуги: ");
        double serviceCost = scanner.nextDouble();
        scanner.nextLine();
        services.add("Название: " + serviceName + ", Цена: " + serviceCost);
    }

    public static void removeServiceByIndexWithInput(Scanner scanner) {
        System.out.print("Введите индекс услуги для ее удаления: ");
        int serviceIndex = scanner.nextInt();
        scanner.nextLine();
        if (serviceIndex >= 1 && serviceIndex <= services.size()) {
            services.remove(serviceIndex - 1);
            System.out.println("Услуга удалена успешно.");
        } else {
            System.out.println("Неправильный ввод.");
        }
    }

    public static void displayCemeteryAddress() {
        System.out.println("Адрес: " + cemeteryAddress);
    }

    public static void displayAllEmployees() {
        System.out.println("Сотрудники:");
        for (int i = 0; i < employees.size(); i++) {
            System.out.println((i + 1) + ". " + employees.get(i));
        }
    }

    public static void displayAllServices() {
        System.out.println("Услуги:");
        for (int i = 0; i < services.size(); i++) {
            System.out.println((i + 1) + ". " + services.get(i));
        }
    }

    public static void addFlowerWithInput(Scanner scanner) {
        System.out.print("Введите название цветов: ");
        String flowerName = scanner.nextLine();
        availableFlowers.add(flowerName);
    }

    public static void displayAvailableFlowers() {
        System.out.println("Цветы:");
        for (String flower : availableFlowers) {
            System.out.println("- " + flower);
        }
    }

    public static void exitProgram() {
        System.out.println("Выход");
    }
}
