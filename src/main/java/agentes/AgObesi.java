package agentes;

public class AgObesi extends Agente {
    private double peso;
    private double altura;

    public AgObesi(String nome, double peso, double altura) {
        super(nome);
        this.peso = peso;
        this.altura = altura;
    }

    @Override
    public DadosAgente processarDados() {
        double imc = peso / (altura * altura);
        double grauEvidencia = calcularGrauEvidencia();
        String classificacao = classificarIMC(imc);


        return new DadosAgente("Obesidade", grauEvidencia, classificacao);
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

    private String classificarIMC(double imc) {
        if (imc < 20) {
            return "Abaixo do peso";
        } else if (imc >= 20 && imc < 25) {
            return "Normal";
        } else if (imc >= 25 && imc < 30) {
            return "Leve";
        } else if (imc >= 30 && imc < 40) {
            return "Moderada";
        } else {
            return "Grave";
        }
    }
    
    public double getGrauObesidade() {
        return calcularGrauEvidencia();
    }

}
