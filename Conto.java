
class Conto {
    private double contoBancario;
    private double portafoglio;
    
    public Conto(double contoBancario, double portafoglio) {
        this.contoBancario = contoBancario;
        this.portafoglio = portafoglio;
    }

    public void deposita(double saldo) {
        if (saldo <= portafoglio) {
            portafoglio -= saldo;
            contoBancario += saldo;
        } else {
            System.out.println("Saldo del portafoglio non sufficiente");
        }
    }

    public void preleva(double saldo) {
        if (saldo <= contoBancario) {
            contoBancario -= saldo;
            portafoglio += saldo;
        } else {
            System.out.println("Saldo del conto bancario non sufficiente");
        }
    }

    public void aggiornaSaldo(int mesi) {
        contoBancario += mesi * 100;
    }

    public double getContoBancario() {
        return contoBancario;
    }

    public double getPortafoglio() {
        return portafoglio;
    }
}
