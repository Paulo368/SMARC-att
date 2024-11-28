package agentes;

import teste.Comunicador;

public class AgPressArt extends Agente {
    private double pas;  // Pressão Arterial Sistólica
    private double pad;  // Pressão Arterial Diastólica

    public AgPressArt(double pas, double pad, String nome, Comunicador comunicador) {
        super(nome, comunicador);
        this.pas = pas;
        this.pad = pad;
    }

    

    @Override
    public DadosAgente processarDados() {
        double grauEvidencia = calcularGrauEvidencia();

        return new DadosAgente("Pressao", grauEvidencia);
    }

    private double calcularGrauEvidencia() {
        if (pas < 120 && pad < 80) {
            return 0.0; // Normal
        } else if (pas >= 180 || pad >= 120) {
            return 1.0; // Crise hipertensiva
        } else {
            return 0.5; // Outros casos intermediários, como hipertensão leve ou moderada
        }
    }
    private String classificarPressao(double pas, double pad) {
        if (pas < 120 && pad < 80) {
            return "Normal";
        } else if ((pas >= 120 && pas < 130) && pad < 80) {
            return "Elevada";
        } else if ((pas >= 130 && pas < 140) || (pad >= 80 && pad < 90)) {
            return "Hipertensão Estágio 1";
        } else if ((pas >= 140 && pas < 180) || (pad >= 90 && pad < 120)) {
            return "Hipertensão Estágio 2";
        } else if (pas >= 180 || pad >= 120) {
            return "Crise Hipertensiva";
        } else {
            return "Classificação Indefinida";
        }
    }
    public double getGrauPressaoArterial() {
        return calcularGrauEvidencia();
    }
    
}
