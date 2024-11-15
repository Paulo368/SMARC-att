package agentes;

public class AgCardiaco extends Agente {
    private DadosAgente dadosSedet;
    private DadosAgente dadosNicotina;
    private DadosAgente dadosObesidade;
    private DadosAgente dadosPressao;

    public AgCardiaco(String nome, DadosAgente dadosSedet, DadosAgente dadosNicotina, DadosAgente dadosObesidade, DadosAgente dadosPressao) {
        super(nome);
        this.dadosSedet = dadosSedet;
        this.dadosNicotina = dadosNicotina;
        this.dadosObesidade = dadosObesidade;
        this.dadosPressao = dadosPressao;
    }

    @Override
    public DadosAgente processarDados() {
        // NAP1g1: combina Sedentarismo e Nicotina
        double ug11 = calcularUG(dadosSedet.getGrauEvidencia(), 1 - dadosNicotina.getGrauEvidencia());
        double grauEvidenciaNap1g1 = calcularEvidenciaParaconsistente(dadosSedet.getGrauEvidencia(), 1 - dadosNicotina.getGrauEvidencia());

        // NAP2g1: combina Nicotina e Obesidade
        double ug12 = calcularUG(dadosNicotina.getGrauEvidencia(), 1 - dadosObesidade.getGrauEvidencia());
        double grauEvidenciaNap2g1 = calcularEvidenciaParaconsistente(dadosNicotina.getGrauEvidencia(), 1 - dadosObesidade.getGrauEvidencia());

        // NAP3g1: combina os resultados de NAP1g1 e NAP2g1
        double ug13 = calcularUG(grauEvidenciaNap1g1, 1 - grauEvidenciaNap2g1);
        double grauEvidenciaFinal = calcularEvidenciaParaconsistente(grauEvidenciaNap1g1, 1 - grauEvidenciaNap2g1);

        // Considera a pressão arterial na classificação do risco cardíaco
        String classificacaoPressao = classificarPressao(dadosPressao.getGrauEvidencia());
        double grauPressao = dadosPressao.getGrauEvidencia();

        // Ajuste final com base na pressão arterial
        grauEvidenciaFinal = (grauEvidenciaFinal + grauPressao) / 2;

        System.out.println("Grau de Evidência Real (μER): " + grauEvidenciaFinal);
        System.out.println("UG Final: " + ug13);
        System.out.println("Classificação Pressão Arterial: " + classificacaoPressao);

        // Classificação do risco
        String classificacao = classificarRisco(grauEvidenciaFinal, ug13);
        return new DadosAgente("Cardiaco", grauEvidenciaFinal, classificacao);
    }

    // Método para classificar a pressão arterial
    private String classificarPressao(double pressao) {
        if (pressao > 140) {
            return "Alto risco de hipertensão";
        } else if (pressao > 120) {
            return "Moderado risco de hipertensão";
        } else {
            return "Baixo risco de hipertensão";
        }
    }

    // Método para calcular a evidência paraconsistente
    private double calcularEvidenciaParaconsistente(double muFavoravel, double lambdaDesfavoravel) {
        double gc = muFavoravel - lambdaDesfavoravel;
        double gct = muFavoravel + lambdaDesfavoravel - 1;
        double d = Math.sqrt(Math.pow(1 - gc, 2) + Math.pow(gct, 2));
        double gcr = 1 - d;
        return (gcr + 1) / 2;
    }

    // Método para calcular a função UG
    private double calcularUG(double muFavoravel, double lambdaDesfavoravel) {
        double muCtr = (muFavoravel + lambdaDesfavoravel) / 2;
        return 1 - Math.abs(2 * muCtr - 1);
    }

    // Método para classificar o risco com base nos cálculos de evidência
    private String classificarRisco(double muER, double ug) {
        if (muER > 0.75 && ug > 0.9) {
            return "Alto risco cardíaco";
        } else if (muER > 0.5 && ug > 0.7) {
            return "Moderado risco cardíaco";
        } else {
            return "Baixo risco cardíaco";
        }
    }
}
