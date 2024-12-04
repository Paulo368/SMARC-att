package agentes;

import java.awt.List;
import java.util.ArrayList;
import teste.Comunicador;

public class AgParaconsist extends Agente {

    //Separar os dados para inserir inserir 
    private ArrayList<Double> dados;

    private ArrayList<Double> listNic = new ArrayList<>();
    private ArrayList<Double> listobsei = new ArrayList<>();
    private ArrayList<Double> listpress = new ArrayList<>();
    private ArrayList<Double> listsedent = new ArrayList<>();

    private double pontuacaoFagerstrom;
    private double peso;
    private double altura;
    private double pas;  // Pressão Arterial Sistólica
    private double pad;  // Pressão Arterial Diastólica
    private double atividadesPorSemana;

    public AgParaconsist(String nome, Comunicador comunicador) {
        super(nome, comunicador);
    }

    @Override
    public void enviarDadosAgenteNicotina() {
        listNic.add(dados.get(3));

        comunicador.envia(listNic);
    }

    @Override
    public void enviarDadosAgenteObesidade() {
        listobsei.add(dados.get(0));
        listobsei.add(dados.get(1));

        comunicador.envia(listobsei);
    }

    @Override
    public void enviarDadosAgentePressao() {
        listpress.add(dados.get(4));
        listpress.add(dados.get(5));

        comunicador.envia(listpress);
    }

    @Override
    public void enviarDadosAgenteSedentarismo() {
        listsedent.add(dados.get(2));

        comunicador.envia(listsedent);
    }

    @Override
    public void recebeDadosAgenteNicotina() {
        // Recebe os dados do agente de nicotina (apenas o grau de evidência)
        ArrayList<Double> dadosAgente = comunicador.recebe(); // O comunicador vai fornecer os dados
        if (dadosAgente != null && !dadosAgente.isEmpty()) {
            double grauEvidenciaNicotina = dadosAgente.get(0); // Assume-se que o primeiro valor é o grau de evidência
            System.out.println("Grau de Evidência (Nicotina): " + grauEvidenciaNicotina);
        }
    }

    @Override
    public void recebeDadosAgenteObesidade() {
        // Recebe os dados do agente de obesidade (apenas o grau de evidência)
        ArrayList<Double> dadosAgente = comunicador.recebe(); // O comunicador vai fornecer os dados
        if (dadosAgente != null && !dadosAgente.isEmpty()) {
            double grauEvidenciaObesidade = dadosAgente.get(0); // Assume-se que o primeiro valor é o grau de evidência
            System.out.println("Grau de Evidência (Obesidade): " + grauEvidenciaObesidade);
        }
    }

    @Override
    public void recebeDadosAgentePressao() {
        // Recebe os dados do agente de pressão arterial (apenas o grau de evidência)
        ArrayList<Double> dadosAgente = comunicador.recebe(); // O comunicador vai fornecer os dados
        if (dadosAgente != null && !dadosAgente.isEmpty()) {
            double grauEvidenciaPressao = dadosAgente.get(0); // Assume-se que o primeiro valor é o grau de evidência
            System.out.println("Grau de Evidência (Pressão): " + grauEvidenciaPressao);
        }
    }

    @Override
    public void recebeDadosAgenteSedentarismo() {
        // Recebe os dados do agente de sedentarismo (apenas o grau de evidência)
        ArrayList<Double> dadosAgente = comunicador.recebe(); // O comunicador vai fornecer os dados
        if (dadosAgente != null && !dadosAgente.isEmpty()) {
            double grauEvidenciaSedentarismo = dadosAgente.get(0); // Assume-se que o primeiro valor é o grau de evidência
            System.out.println("Grau de Evidência (Sedentarismo): " + grauEvidenciaSedentarismo);
        }
    }

    @Override
    public void startComunicador() {
        comunicador.start();
    }

    @Override
    public DadosAgente processarDados() {
        
        
        double grauEvidenciaNap1g1 = calcularEvidenciaParaconsistente(atividadesPorSemana, pontuacaoFagerstrom);

        // NAP2g1: combinação entre Nicotina e Obesidade
        double grauEvidenciaNap2g1 = calcularEvidenciaParaconsistente(pontuacaoFagerstrom, peso);  // peso do agente de obesidade

        // NAP3g1: combinação de NAP1g1 e NAP2g1
        double grauEvidenciaNap3g1 = calcularEvidenciaParaconsistente(grauEvidenciaNap1g1, grauEvidenciaNap2g1);

        // Cálculo do risco com base na pressão arterial
        String classificacaoPressao = classificarPressao(pas);  // ou use pad, dependendo do seu critério
        double grauPressao = calcularEvidenciaParaconsistente(pas, pad);

        // Ajuste final com base na pressão arterial
        double grauEvidenciaFinal = (grauEvidenciaNap3g1 + grauPressao) / 2;

        // Agora calculando o valor de UG (função de utilidade)
        double ugFinal = calcularUG(grauEvidenciaNap3g1, grauPressao);  // Pode ajustar se for necessário outro valor para UG

        // Classificar o risco final com base nos dois valores
        String classificacaoRisco = classificarRisco(grauEvidenciaFinal, ugFinal);

        // Retornar os dados calculados para serem usados na interface
        System.out.println("Grau de Evidência Final: " + grauEvidenciaFinal);
        System.out.println("UG Final: " + ugFinal);
        System.out.println("Classificação do Risco Cardíaco: " + classificacaoRisco);

        return new DadosAgente(classificacaoRisco, grauEvidenciaFinal);
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

    @Override
    public void setDados(ArrayList<Double> dados) {
        this.dados = dados;
    }

}
