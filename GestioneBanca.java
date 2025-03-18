import java.util.Scanner;

public class GestioneBanca {
    static Scanner tastiera = new Scanner(System.in);
    
    public static void main(String[] args) {
        boolean autenticato = false;
        String username = "";
        
        while (!autenticato) {
            System.out.println("1) Login");
            System.out.println("2) Registrati");
            System.out.print("Scegli un'opzione: ");
            int scelta = Integer.parseInt(tastiera.nextLine());
            
            System.out.print("Inserisci username: ");
            username = tastiera.nextLine();
            System.out.print("Inserisci password: ");
            String password = tastiera.nextLine();
            
            if (scelta == 1) {
                if (LoginBanca.login(username, password)) {
                    autenticato = true;
                    System.out.println("Login avvenuto con successo!");
                } else {
                    System.out.println("Credenziali errate o utente non registrato. Riprova.");
                }
            } else if (scelta == 2) {
                if (RegisterBanca.register(username, password)) {
                    System.out.println("Registrazione completata! Ora puoi effettuare il login.");
                } else {
                    System.out.println("Errore durante la registrazione. Riprova.");
                }
            }
        }
        
        // Avvio del programma di gestione finanziaria dopo l'autenticazione
        System.out.println("Benvenuto nel sistema di gestione bancaria, " + username + "!");
        GestioneFinanziaria.main(new String[]{});
    }
}