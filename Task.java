import java.time.LocalDate;

public class Task {
    private String description;
    private String category;
    private LocalDate dueDate;
    private boolean isCompleted;

    // Constructeurs
    public Task() {
        this.description = null;
        this.category = null;
        this.dueDate = null;
        this.isCompleted = false;
    }

    public Task(String description, String category, LocalDate dueDate) {
        this.description = description;
        this.category = category;
        this.dueDate = dueDate;
        this.isCompleted = false; // Par défaut, non terminée
    }

    // Méthode pour marquer une tâche comme terminée
    public void markAsCompleted() {
        this.isCompleted = true;
    }

    // Vérifie si la tâche est terminée
    public boolean isCompleted() {
        return this.isCompleted;
    }

    // Représentation lisible pour l'utilisateur
    @Override
    public String toString() {
        String status = isCompleted ? "✔ Terminé" : "✗ En cours";
        String cat = (category != null && !category.isEmpty()) ? " [Catégorie : " + category + "]" : "";
        String date = (dueDate != null) ? " (À faire avant : " + dueDate + ")" : "";
        return status + " - " + description + cat + date;
    }

}
