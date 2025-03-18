import java.util.Scanner;

public class GestioneFinanziaria {

    static Scanner tastiera = new Scanner(System.in);

    public static int menu() {
        int scelta;
        System.out.println("---------------------------MENU'---------------------------");
        System.out.println("1)Depositare soldi");
        System.out.println("2)Prelevare soldi");
        System.out.println("3)Possibilità di investire soldi");
        System.out.println("4)Andare avanti di n mesi");
        System.out.println("5)Visualizzare lo stato del proprio conto");
        System.out.println("6)Visualizzare stato proprio portafoglio");
        System.out.println();
        System.out.println("7)USCIRE \n");
        System.out.print("Inserisci l'opzione desiderata: ");
        scelta = conversioneInt(tastiera.nextLine());
        while (scelta < 0 || scelta > 7) {
            System.out.println("Opzione non disponibile");
            System.out.print("Reinserisci: ");
            scelta = conversioneInt(tastiera.nextLine());
        }

        return scelta;
    }

    public static int conversioneInt(String input) {
        int toInt = -1;
        boolean ok;
        do {
            ok = true;
            try {
                toInt = (int) Integer.parseInt(input);
                if (toInt <= 0) {
                    System.out.println("Il numero deve essere maggiore di 0");
                    ok = false;
                    System.out.print("Reinserisci: ");
                    input = tastiera.nextLine();
                }
            } catch (NumberFormatException e) {
                System.out.println("Formato non valido");
                System.out.print("Reinserisci: ");
                ok = false;
                input = tastiera.nextLine();
            }
        } while (!ok);

        return toInt;
    }

    public static double deposita(double portafoglio) {
        double saldo = conversioneDouble(tastiera.nextLine());

        while (saldo > portafoglio) {
            System.out.println("Saldo del portafoglio non sufficiente");
            System.out.print("Inserisci quanto vuoi depositare nel conto Bancario: ");
            saldo = conversioneDouble(tastiera.nextLine());
        }

        return saldo;
    }

    public static double preleva(double contoBancario) {
        double saldo = conversioneDouble(tastiera.nextLine());

        while (saldo > contoBancario) {
            System.out.println("Saldo del conto bancario non sufficiente");
            System.out.print("Inserisci quanto vuoi prelevare dal conto Bancario: ");
            saldo = conversioneDouble(tastiera.nextLine());
        }

        return saldo;
    }

    public static int menuPerDurata() {
        int scelta;
        System.out.println("1)Investimenti di breve durata");
        System.out.println("2)Investimenti di media durata");
        System.out.println("3)Investimenti di lunga durata");
        System.out.print("Inserisci l'opzione desiderata: ");
        scelta = conversioneInt(tastiera.nextLine());
        while (scelta > 3) {
            System.out.println("Opzione non disponibile");
            System.out.print("Reinserisci: ");
            scelta = conversioneInt(tastiera.nextLine());
        }

        return scelta;
    }

    public static int menuPerRischio() {
        int scelta;
        System.out.println("1)Investimenti di basso rischio");
        System.out.println("2)Investimenti di medio rischio");
        System.out.println("3)Investimenti di alto rischio");
        System.out.print("Inserisci l'opzione desiderata: ");
        scelta = conversioneInt(tastiera.nextLine());
        while (scelta > 3) {
            System.out.println("Opzione non disponibile");
            System.out.print("Reinserisci: ");
            scelta = conversioneInt(tastiera.nextLine());
        }

        return scelta;
    }

    public static double conversioneDouble(String input) {
        double toDouble = -1;
        boolean ok;
        do {
            ok = true;
            try {
                toDouble = (double) Double.parseDouble(input);
                if (toDouble <= 0) {
                    System.out.println("Il numero deve essere maggiore di 0");
                    ok = false;
                    System.out.print("Reinserisci: ");
                    input = tastiera.nextLine();
                }
            } catch (NumberFormatException e) {
                System.out.println("Formato non valido");
                System.out.print("Reinserisci: ");
                ok = false;
                input = tastiera.nextLine();
            }
        } while (!ok);

        return toDouble;
    }

    public static void main(String[] args) {
        // Implementazione principale della gestione finanziaria
    }
}
    