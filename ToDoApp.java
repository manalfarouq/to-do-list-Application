import java.time.LocalDate;
import java.util.Scanner;

public class ToDoApp {
    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Menu To-Do List ---");
            System.out.println("1. Ajouter une tâche");
            System.out.println("2. Afficher les tâches");
            System.out.println("3. Marquer une tâche comme terminée");
            System.out.println("4. Supprimer une tâche");
            System.out.println("5. Quitter");
            System.out.print("Choisissez une option : ");

            if (!scanner.hasNextInt()) {
                System.out.println("Entrée invalide. Veuillez entrer un chiffre.");
                scanner.next(); // Consommer l'entrée incorrecte
                continue;
            }


            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Description : ");
                    String description = scanner.nextLine();
                    System.out.print("Catégorie (optionnel) : ");
                    String category = scanner.nextLine();
                    System.out.print("Date limite (AAAA-MM-JJ, optionnel) : ");
                    String dueDate = scanner.nextLine();
                    toDoList.addTask(description, category, dueDate);
                    System.out.println("Tâche ajoutée !");
                    break;

                case 2:
                    System.out.print("Afficher : 1. Toutes  2. Seulement non terminées : ");
                    boolean showCompleted = scanner.nextInt() == 1;
                    toDoList.displayTasks(showCompleted);
                    break;

                case 3:
                    System.out.print("Numéro de la tâche : ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Entrée invalide.");
                        scanner.next();
                        break;
                    }
                    int indexComplete = scanner.nextInt() - 1;
                    toDoList.markTaskAsCompleted(indexComplete);
                    break;

                case 4:
                    System.out.print("Numéro de la tâche : ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Entrée invalide.");
                        scanner.next();
                        break;
                    }
                    int indexDelete = scanner.nextInt() - 1;
                    toDoList.deleteTask(indexDelete);
                    break;

                case 5:
                    System.out.println("Au revoir !");
                    return;

                default:
                    System.out.println("Option invalide. Réessayez.");
            }
        }
    }
}
