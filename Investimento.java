class Investimento {
    public static double calcolaGuadagno(int grandezzaRischio, double soldiDaInvestire) {
        int rischio = (int) (Math.random() * grandezzaRischio);
        return rischio <= 50 ? soldiDaInvestire * (grandezzaRischio / 20.0) : (20.0 / grandezzaRischio) * soldiDaInvestire;
    }
}
