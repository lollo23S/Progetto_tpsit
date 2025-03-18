import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class LoginBanca {
    public static boolean login(String username, String password) {
        File userFile = new File(username + ".txt");
        if (!userFile.exists()) {
            System.out.println("\n Utente non trovato.");
            return false;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(userFile))) {
            String storedPassword = reader.readLine();
            return storedPassword != null && storedPassword.equals(password);
        } catch (IOException e) {
            System.out.println("Errore nella lettura del file utente.");
        }
        return false;
    }
}