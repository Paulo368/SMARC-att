package agentes;

import teste.Comunicador;

public class AgSedet extends Agente {
    private double atividadesPorSemana;

    public AgSedet(double atividadesPorSemana, String nome, Comunicador comunicador) {
        super(nome, comunicador);
        this.atividadesPorSemana = atividadesPorSemana;
    }

    

    @Override
    public DadosAgente processarDados() {
        double grauEvidencia = calcularGrauEvidencia();

        return new DadosAgente("Sedentarismo", grauEvidencia);
    }

    public double getGrauSedentarismo() {
        return calcularGrauEvidencia();
    }

    private double calcularGrauEvidencia() {
        if (atividadesPorSemana >= 4) {
            return 0.0; // Sem risco de sedentarismo
        } else if (atividadesPorSemana <= 0) {
            return 1.0; // Totalmente sedentário
        } else {
            return 1.0 - (atividadesPorSemana / 4.0);
        }
    }

    private String classificarSedentarismo(int atividadesPorSemana) {
        if (atividadesPorSemana >= 5) {
            return "Fisicamente Ativo";
        } else if (atividadesPorSemana >= 3) {
            return "Moderadamente Ativo";
        } else if (atividadesPorSemana >= 1) {
            return "Pouco Ativo";
        } else {
            return "Sedentário";
        }
    }
}
