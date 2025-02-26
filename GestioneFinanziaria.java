import java.util.Scanner;

public class GestioneFinanziaria {
    private static Scanner tastiera = new Scanner(System.in);
    private static Conto conto = new Conto(1000, 200);
    
    private static int menu() {
        System.out.println("--- MENU ---");
        System.out.println("1) Depositare soldi");
        System.out.println("2) Prelevare soldi");
        System.out.println("3) Investire soldi");
        System.out.println("4) Andare avanti di n mesi");
        System.out.println("5) Stato del conto");
        System.out.println("6) Stato del portafoglio");
        System.out.println("7) USCIRE");
        return conversioneInt("Inserisci l'opzione: ");
    }

    private static int conversioneInt(String messaggio) {
        int valore = -1;
        while (valore <= 0) {
            try {
                System.out.print(messaggio);
                valore = Integer.parseInt(tastiera.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Formato non valido");
            }
        }
        return valore;
    }

    private static double conversioneDouble(String messaggio) {
        double valore = -1;
        while (valore <= 0) {
            try {
                System.out.print(messaggio);
                valore = Double.parseDouble(tastiera.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Formato non valido");
            }
        }
        return valore;
    }

    public static void main(String[] args) {
        int scelta;
        do {
            scelta = menu();
            switch (scelta) {
                case 1 -> {
                    double saldo = conversioneDouble("Quanto vuoi depositare? ");
                    conto.deposita(saldo);
                }
                case 2 -> {
                    double saldo = conversioneDouble("Quanto vuoi prelevare? ");
                    conto.preleva(saldo);
                }
                case 3 -> {
                    if (conto.getContoBancario() > 0) {
                        double soldiDaInvestire = conversioneDouble("Quantità da investire: ");
                        conto.preleva(soldiDaInvestire);
                        double guadagno = Investimento.calcolaGuadagno(100, soldiDaInvestire);
                        conto.deposita(guadagno);
                        System.out.println("Hai guadagnato: " + guadagno);
                    } else {
                        System.out.println("Saldo insufficiente!");
                    }
                }
                case 4 -> {
                    int mesi = conversioneInt("Di quanti mesi vuoi avanzare? ");
                    conto.aggiornaSaldo(mesi);
                }
                case 5 -> System.out.println("Conto in banca: " + conto.getContoBancario());
                case 6 -> System.out.println("Portafoglio: " + conto.getPortafoglio());
                case 7 -> System.out.println("Grazie per aver usato il programma!");
            }
        } while (scelta != 7);
    }
}