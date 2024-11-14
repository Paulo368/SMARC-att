package teste;

import agentes.AgCardiaco;
import agentes.AgNicot;
import agentes.AgObesi;
import agentes.AgPressArt;
import agentes.AgSedet;
import agentes.Agente;
import agentes.DadosAgente;

public class TesteDoComunicador {
    public static void main(String[] args) {
        // Dados de exemplo do paciente
        Agente agenteObesidade = new AgObesi("Agente Obesidade", 120, 1.70);   // IMC elevado, obesidade severa
        Agente agentePressao = new AgPressArt("Agente Pressao", 180, 120);     // Pressão arterial muito alta
        Agente agenteSedetarismo = new AgSedet("Agente Sedentarismo", 0);      // Totalmente sedentário (0 atividades por semana)
        Agente agenteNicotina = new AgNicot("Agente Nicotina", 10);

        // Criar os comunicadores para cada agente
        Comunicador comunicadorObesidade = new Comunicador(agenteObesidade);
        Comunicador comunicadorPressao = new Comunicador(agentePressao);
        Comunicador comunicadorSedentarismo = new Comunicador(agenteSedetarismo);
        Comunicador comunicadorNicotina = new Comunicador(agenteNicotina);

        // Iniciar as threads
        Thread threadObesidade = new Thread(comunicadorObesidade);
        Thread threadPressao = new Thread(comunicadorPressao);
        Thread threadSedentarismo = new Thread(comunicadorSedentarismo);
        Thread threadNicotina = new Thread(comunicadorNicotina);

        // Iniciar as threads
        threadObesidade.start();
        threadPressao.start();
        threadSedentarismo.start();
        threadNicotina.start();

        try {
            // Esperar todas as threads terminarem para continuar com o Agente Cardíaco
            threadObesidade.join();
            threadPressao.join();
            threadSedentarismo.join();
            threadNicotina.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Criar o agente cardíaco com os dados processados dos outros agentes
        DadosAgente dadosObesidade = agenteObesidade.processarDados();
        DadosAgente dadosPressao = agentePressao.processarDados();
        DadosAgente dadosSedentarismo = agenteSedetarismo.processarDados();
        DadosAgente dadosNicotina = agenteNicotina.processarDados();

        Agente agenteCardiaco = new AgCardiaco("Agente Cardíaco", dadosSedentarismo, dadosNicotina, dadosObesidade, dadosPressao);

        // Processar dados do Agente Cardíaco e exibir o resultado
        DadosAgente dadosCardiaco = agenteCardiaco.processarDados();
        System.out.println(dadosCardiaco);
    }
}
