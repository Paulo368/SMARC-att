/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agentes;

/**
 *
 * @author 2022122760265
 */
public class AgNicot extends Agente {
    private int pontuacaoFagerstrom;
    private String classificacao;

    
    public AgNicot(String nome, int pontuacaoFagerstrom) {
        super(nome);
        this.pontuacaoFagerstrom = pontuacaoFagerstrom;
    }

    @Override
    public DadosAgente processarDados() {
        double grauEvidencia = calcularGrauEvidencia();

       classificacao = classificarDependencia(grauEvidencia);
        return new DadosAgente("Nicotina", grauEvidencia, classificacao);
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
    
    private String classificarDependencia(double grauEvidencia){
        if (grauEvidencia >= 1.0) {
            return "Muito dependente";
        } else if (grauEvidencia >= 0.75) {
            return "Dependente";
        } else if (grauEvidencia >= 0.5) {
            return "Moderado";
        } else if (grauEvidencia >= 0.25) {
            return "Pouco dependente";
        } else {
            return "Não dependente";
        }
    }
    
    public double getGrauNicotina() {
        return calcularGrauEvidencia();
    }
    
}
