package agentes;

import java.util.ArrayList;
import teste.Comunicador;

public class AgSedet extends Agente {
    private double atividadesPorSemana;

    public AgSedet(String nome, Comunicador comunicador) {
        super(nome, comunicador);
    }

    @Override
    public void receberDados(){
        ArrayList<Double> dados = comunicador.recebe();
        atividadesPorSemana = dados.get(0);
    }
    
    @Override
    public void enviarDadosAgenteSedentarismo() {
        ArrayList<Double> dados = new ArrayList<>();
        dados.add(calcularGrauEvidencia());  // Adiciona o grau de evidência de nicotina à lista

        // Envia os dados através do comunicador
        comunicador.envia(dados);
    }

    @Override
    public DadosAgente processarDados() {
        double grauEvidencia = calcularGrauEvidencia();

        return new DadosAgente("Sedentarismo", grauEvidencia);
    }
    
    @Override
    public void startComunicador(){
        comunicador.start();
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
