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
    
    double grauEvidenciaNicotina;
    double grauEvidenciaObesidade;
    double grauEvidenciaPressao;
    double grauEvidenciaSedentarismo;

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
            grauEvidenciaNicotina = dadosAgente.get(0); // Assume-se que o primeiro valor é o grau de evidência
            System.out.println("Grau de Evidência (Nicotina): " + grauEvidenciaNicotina);
        }
    }

    @Override
    public void recebeDadosAgenteObesidade() {
        // Recebe os dados do agente de obesidade (apenas o grau de evidência)
        ArrayList<Double> dadosAgente = comunicador.recebe(); // O comunicador vai fornecer os dados
        if (dadosAgente != null && !dadosAgente.isEmpty()) {
            grauEvidenciaObesidade = 1-dadosAgente.get(0); // Assume-se que o primeiro valor é o grau de evidência
            System.out.println("Grau de Evidência (Obesidade): " + grauEvidenciaObesidade);
        }
    }

    @Override
    public void recebeDadosAgentePressao() {
        // Recebe os dados do agente de pressão arterial (apenas o grau de evidência)
        ArrayList<Double> dadosAgente = comunicador.recebe(); // O comunicador vai fornecer os dados
        if (dadosAgente != null && !dadosAgente.isEmpty()) {
            grauEvidenciaPressao = dadosAgente.get(0); // Assume-se que o primeiro valor é o grau de evidência
            System.out.println("Grau de Evidência (Pressão): " + grauEvidenciaPressao);
        }
    }

    @Override
    public void recebeDadosAgenteSedentarismo() {
        // Recebe os dados do agente de sedentarismo (apenas o grau de evidência)
        ArrayList<Double> dadosAgente = comunicador.recebe(); // O comunicador vai fornecer os dados
        if (dadosAgente != null && !dadosAgente.isEmpty()) {
            grauEvidenciaSedentarismo = 1-dadosAgente.get(0); // Assume-se que o primeiro valor é o grau de evidência
            System.out.println("Grau de Evidência (Sedentarismo): " + grauEvidenciaSedentarismo);
        }
    }

    @Override
    public void startComunicador() {
        comunicador.start();
    }

    @Override
    public DadosAgente processarDados() {
        double muFavoravel = Math.max(grauEvidenciaNicotina,grauEvidenciaPressao);
        double lambdaDesfavoravel = Math.min(grauEvidenciaSedentarismo, grauEvidenciaObesidade);
        
        double grauEvidenciaNap1g1 = calcularEvidenciaParaconsistente(muFavoravel, lambdaDesfavoravel);

        // NAP2g1: combinação entre Nicotina e Obesidade
        double grauEvidenciaNap2g1 = calcularEvidenciaParaconsistente(grauEvidenciaNicotina, grauEvidenciaObesidade);

        // NAP3g1: combinação de NAP1g1 e NAP2g1
        double grauEvidenciaNap3g1 = calcularEvidenciaParaconsistente(grauEvidenciaNap1g1, grauEvidenciaNap2g1);

        // Ajuste final com base na pressão arterial
        double grauEvidenciaFinal = grauEvidenciaNap3g1;

        // Agora calculando o valor de UG (função de utilidade)
        double ugFinal = calcularUG(muFavoravel, lambdaDesfavoravel);  // Pode ajustar se for necessário outro valor para UG

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
