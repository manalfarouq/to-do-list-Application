import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class ToDoList {
    private ArrayList<Task> tasks;

    // Constructeur : initialise une liste vide
    public ToDoList() {
        this.tasks = new ArrayList<>();
    }

    // Ajouter une tâche à la liste
    public void addTask(String description, String category, String dueDate) {
        LocalDate parsedDate = null;
        try {
            if (!dueDate.isEmpty()) {
                parsedDate = LocalDate.parse(dueDate); // Conversion de la chaîne en LocalDate
            }
        } catch (DateTimeParseException e) {
            System.out.println("Format de date invalide. La tâche sera ajoutée sans date limite.");
        }
        Task task = new Task(description, category, parsedDate);
        tasks.add(task);
    }

    // Afficher toutes les tâches
    public void displayTasks(boolean showCompleted) {
        System.out.println("\n--- Liste des Tâches ---");
        if (tasks.isEmpty()) {
            System.out.println("Aucune tâche disponible.");
            return;
        }

        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (showCompleted || !task.isCompleted()) {
                System.out.println((i + 1) + ". " + task);
            }
        }
    }

    // Marquer une tâche comme terminée
    public void markTaskAsCompleted(int index) {
        if (index < 0 || index >= tasks.size()) {
            System.out.println("Numéro de tâche invalide. Veuillez entrer un numéro valide.");
            return;
        }
        tasks.get(index).markAsCompleted();
        System.out.println("La tâche a été marquée comme terminée.");
    }


    // Supprimer une tâche
    public void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("La tâche a été supprimée.");
        } else {
            System.out.println("Index invalide.");
        }
    }
}
