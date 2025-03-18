import java.io.File;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

class RegisterBanca {
    public static boolean register(String username, String password) {
        File userFile = new File(username + ".txt");
        if (userFile.exists()) {
            System.out.println("Utente già registrato.");
            return false;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(userFile))) {
            writer.write(password);
            writer.newLine();
            return true;
        } catch (IOException e) {
            System.out.println("Errore nella creazione del file utente.");
        }
        return false;
    }
}