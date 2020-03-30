package src;

public class Application {
    public static void main(String[] args) {
        DuplicateRemover remover = new DuplicateRemover();
        remover.remove("problem1.txt");
        remover.write("unique_words.txt");
    }
}
