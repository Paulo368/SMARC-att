package agentes;

import java.util.ArrayList;
import teste.Comunicador;

public class AgObesi extends Agente {

    private double peso;
    private double altura;

    public AgObesi(String nome, Comunicador comunicador) {
        super(nome, comunicador);
    }

    @Override
    public void receberDados() {
        ArrayList<Double> dados = comunicador.recebe();
        peso = dados.get(0);
        altura = dados.get(1);
    }

    @Override
    public void enviarDadosAgenteObesidade() {
        ArrayList<Double> dados = new ArrayList<>();
        dados.add(calcularGrauEvidencia());  // Adiciona o grau de evidência de nicotina à lista

        // Envia os dados através do comunicador
        comunicador.envia(dados);
    }

    @Override
    public void startComunicador() {
        comunicador.start();
    }

    @Override
    public DadosAgente processarDados() {
        double imc = peso / (altura * altura);
        double grauEvidencia = calcularGrauEvidencia();

        return new DadosAgente("Obesidade", grauEvidencia);
    }

    private double calcularIMC() {
        return peso / (altura * altura);
    }

    private double calcularGrauEvidencia() {
        double imc = calcularIMC();
        if (imc < 25) {
            return 0.0; // Sem risco de obesidade
        } else if (imc >= 40) {
            return 1.0; // Obesidade grave
        } else {
            return (imc - 25) / 15; // Grau de obesidade proporcional
        }
    }

    public double getGrauObesidade() {
        return calcularGrauEvidencia();
    }
}
