package agentes;

public class AgSedet extends Agente {
    private int atividadesPorSemana;
    private String classificacao;

    public AgSedet(String nome, int atividadesPorSemana) {
        super(nome);
        this.atividadesPorSemana = atividadesPorSemana;
    }

    @Override
    public DadosAgente processarDados() {
        double grauEvidencia = calcularGrauEvidencia();
        classificacao = classificarSedentarismo(atividadesPorSemana);

        return new DadosAgente("Sedentarismo", grauEvidencia, classificacao);
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
