/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agentes;

import java.util.ArrayList;
import teste.Comunicador;

/**
 *
 * @author 2022122760265
 */
public class AgNicot extends Agente {
    private double pontuacaoFagerstrom;
    private String classificacao;

    public AgNicot(String nome, Comunicador comunicador) {
        super(nome, comunicador);
    }

    @Override
    public void receberDados(){
        ArrayList<Double> dados = comunicador.recebe();
        pontuacaoFagerstrom = dados.get(0);
    }
    
    @Override
    public void enviarDadosAgenteNicotina() {
        ArrayList<Double> dados = new ArrayList<>();
        dados.add(calcularGrauEvidencia());  // Adiciona o grau de evidência de nicotina à lista

        // Envia os dados através do comunicador
        comunicador.envia(dados);
    }
    
    @Override
    public void startComunicador(){
        comunicador.start();
    }

    @Override
    public DadosAgente processarDados() {
        double grauEvidencia = calcularGrauEvidencia();

        return new DadosAgente("Nicotina", grauEvidencia);
    }

    private double calcularGrauEvidencia() {
        // De acordo com os slides:
        // Pontuação 10: Grau de evidência = 1.0
        // Pontuação 8: Grau de evidência = 0.75
        // Pontuação 5: Grau de evidência = 0.5
        // Pontuação 3: Grau de evidência = 0.25
        // Pontuação 0: Grau de evidência = 0.0
        if (pontuacaoFagerstrom >= 10) {
            return 1.0;
        } else if (pontuacaoFagerstrom >= 8) {
            return 0.75;
        } else if (pontuacaoFagerstrom >= 5) {
            return 0.5;
        } else if (pontuacaoFagerstrom >= 3) {
            return 0.25;
        } else {
            return 0.0;
        }
    }
    
    public double getGrauNicotina() {
        return calcularGrauEvidencia();
    }
    
}
