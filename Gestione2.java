/* 

//ultima versione delle 22:16  1/12/2024

//VERSIONE CON LINTERS E FORMATTERS

import java.util.Scanner;

public class Gestione2 {

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

    public static int sceltaTraDue() {
        int scelta;
        System.out.println("1)Depositarli sul conto in Banca");
        System.out.println("2)Depositarli sul portafoglio personale");
        System.out.print("Inserisci la scelta: ");
        scelta = conversioneInt(tastiera.nextLine());
        while (scelta < 1 || scelta > 2) {
            System.out.println("Opzione non disponibile");
            System.out.print("Reinserisci: ");
            scelta = conversioneInt(tastiera.nextLine());
        }

        return scelta;
    }

    public static double Investimento(int grandezzaRischio, double soldiDaInvestire) {
        double guadagno;
        int rischio = (int) (Math.random() * grandezzaRischio);
        if (rischio <= 50) {
            guadagno = (soldiDaInvestire * (grandezzaRischio / 20.0));
        } else {
            guadagno = (double) ((20.0 / grandezzaRischio) * soldiDaInvestire);
        }
        return guadagno;
    }

    public static void main(String[] args) {

        int scelta;
        double contoBancario = 1000;
        double portafoglio = 200;
        double guadagno = 0;
        int mese = 0;

        do {

            scelta = menu();

            switch (scelta) {
                case 1 -> {
                    System.out.print("Inserisci quanto vuoi depositare nel conto Bancario: ");
                    double saldo = deposita(portafoglio);

                    portafoglio = portafoglio - saldo;
                    contoBancario = contoBancario + saldo;

                    System.out.println("Portafoglio: " + portafoglio);
                    System.out.println("Conto in banca: " + contoBancario);
                    System.out.println();
                }
                case 2 -> {
                    System.out.print("Inserisci quanto vuoi prelevare dal conto Bancario: ");
                    double saldo = preleva(contoBancario);

                    portafoglio = portafoglio + saldo;
                    contoBancario = contoBancario - saldo;

                    System.out.println("Portafoglio: " + portafoglio);
                    System.out.println("Conto in banca: " + contoBancario);
                    System.out.println();
                }
                case 3 -> {
                    if (contoBancario <= 0) {
                        System.out.println("Non puoi investire, saldo insufficiente!");
                    } else {
                        System.out.println("Benvenuto nella sezione investimenti \n");
                        System.out.println(
                                "Ricorda che nell'arco de tempo d'investimento i soldi mensili vanno SOLO sul conto in banca \n");
                        scelta = menuPerDurata();

                        System.out.print(
                                "Inserire quanti soldi vuoi investire. Ricorda che puoi solo investire con il conto bancario! ");
                        double soldiDaInvestire = conversioneDouble(tastiera.nextLine());
                        contoBancario = contoBancario - soldiDaInvestire;

                        switch (scelta) {
                            case 1 -> {

                                System.out.println("\nInvestimento di breve durata (1 mese)");
                                mese = mese + 1;
                                contoBancario = contoBancario + 100;

                                scelta = menuPerRischio();

                                switch (scelta) {
                                    case 1 -> {
                                        System.out.println("\nBasso rischio");
                                        guadagno = Investimento(100, soldiDaInvestire);
                                        contoBancario = contoBancario + guadagno;

                                    }
                                    case 2 -> {
                                        System.out.println("\nMedio rischio");
                                        guadagno = Investimento(250, soldiDaInvestire);
                                        contoBancario = contoBancario + guadagno;
                                    }
                                    case 3 -> {
                                        System.out.println("\nAlto rischio");
                                        guadagno = Investimento(500, soldiDaInvestire);
                                        contoBancario = contoBancario + guadagno;
                                    }
                                }

                            }
                            case 2 -> {

                                System.out.println("\nInvestimento di media durata (3 mesi)");
                                mese = mese + 3;
                                contoBancario = contoBancario + (100 * 3);
                                scelta = menuPerRischio();

                                switch (scelta) {
                                    case 1 -> {
                                        System.out.println("\nBasso rischio");
                                        guadagno = Investimento(100, soldiDaInvestire);
                                        contoBancario = contoBancario + guadagno;
                                    }
                                    case 2 -> {
                                        System.out.println("\nMedio rischio");
                                        guadagno = Investimento(250, soldiDaInvestire);
                                        contoBancario = contoBancario + guadagno;
                                    }
                                    case 3 -> {
                                        System.out.println("\nAlto rischio");
                                        guadagno = Investimento(500, soldiDaInvestire);
                                        contoBancario = contoBancario + guadagno;
                                    }
                                }

                            }
                            case 3 -> {

                                System.out.println("\nInvestimento di lunga durata (6 mesi)");
                                mese = mese + 6;
                                contoBancario = contoBancario + (100 * 6);
                                scelta = menuPerRischio();

                                switch (scelta) {
                                    case 1 -> {
                                        System.out.println("\nBasso rischio");
                                        guadagno = Investimento(100, soldiDaInvestire);
                                        contoBancario = contoBancario + guadagno;
                                    }
                                    case 2 -> {
                                        System.out.println("\nMedio rischio");
                                        guadagno = Investimento(250, soldiDaInvestire);
                                        contoBancario = contoBancario + guadagno;
                                    }
                                    case 3 -> {
                                        System.out.println("\nAlto rischio");
                                        guadagno = Investimento(500, soldiDaInvestire);
                                        contoBancario = contoBancario + guadagno;
                                    }
                                }

                            }
                        }

                        System.out.println();
                        if (guadagno <= soldiDaInvestire) {
                            System.out.println("Mi dispiace. L'investimento non e' andato a buon fine!!!");
                            System.out.println("Hai perso " + guadagno + " euro");
                        } else {
                            System.out.println("CONGRATULAZIONI. L'investimento e' andato a buon fine!!!");
                            System.out.println("Hai guadagnato " + guadagno + " euro!!!");
                        }

                        System.out.println("Il tuo conto in banca e' " + contoBancario);

                    }
                }

                case 4 -> {
                    System.out.print("Di quanti mesi vuoi andare avanti: ");
                    int n = conversioneInt(tastiera.nextLine());
                    System.out.println("Sei andato avanti di " + n + " mesi! \n");
                    System.out.println("Saldo del conto in Banca: " + contoBancario);
                    System.out.println("Saldo del portafoglio personale: " + portafoglio);
                    System.out.println();
                    mese = mese + n;
                    System.out.println("Ora hai a disposizione altri " + (n * 100) + "€, dove vuoi depositarli? \n");

                    scelta = sceltaTraDue();
                    switch (scelta) {
                        case 1 -> {
                            System.out.println("Sono stati depositati 100 euro nel conto in Banca \n");
                            contoBancario = contoBancario + (n * 100);
                            System.out.println("Saldo del conto in Banca: " + contoBancario);
                            System.out.println("Saldo del portafoglio personale: " + portafoglio);
                        }
                        case 2 -> {
                            System.out.println("Sono stati depositati 100 euro nel portafoglio personale \n");
                            portafoglio = portafoglio + (n * 100);
                            System.out.println("Saldo del conto in Banca: " + contoBancario);
                            System.out.println("Saldo del portafoglio personale: " + portafoglio);
                        }
                    }

                    System.out.println();
                }

                case 5 -> {
                    System.out.println("Stato del conto in banca: " + contoBancario);
                    System.out.println();
                }

                case 6 -> {
                    System.out.println("Stato del portafoglio: " + portafoglio);
                    System.out.println();
                }

            }

        } while (scelta != 7);
        System.out.println("Grazie per aver usato questo programma!");
        // tastiera.close();
    }

}


*/