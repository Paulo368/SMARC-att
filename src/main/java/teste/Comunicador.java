/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package teste;

import agentes.Agente;
import agentes.DadosAgente;
import java.awt.List;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.ArrayList;

public class Comunicador extends Thread {

    private String multiCastAddress = "224.0.0.1";
    private int porta;
    private static InetAddress enderecoGrupo;
    private static MulticastSocket soc;

    public Comunicador(int porta) {
        try {
            this.porta = porta;
            enderecoGrupo = InetAddress.getByName(multiCastAddress);
            soc = new MulticastSocket(porta);
            soc.joinGroup(enderecoGrupo);
        } catch (IOException e) {
            System.out.println("FALHA IOException" + e.getMessage());
        }
    }

    public void envia(ArrayList<Double> dados, int porta) {
        try {
            ByteArrayOutputStream bASaida = new ByteArrayOutputStream();
            ObjectOutputStream saida = new ObjectOutputStream(bASaida);
            saida.writeObject(dados);
            saida.flush(); // Garante que todos os dados sejam escritos
            byte[] data = bASaida.toByteArray();
            DatagramPacket pacote = new DatagramPacket(data, data.length, enderecoGrupo, porta);
            soc.send(pacote);
            System.out.println("Enviado: " + dados);
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        }
    }

    public ArrayList<Double> recebe() {
        byte[] buffer = new byte[4096];
        ArrayList<Double> dados = null;
        try {
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            soc.receive(packet);
            ByteArrayInputStream bAEntrada = new ByteArrayInputStream(buffer, 0, packet.getLength());
            ObjectInputStream entrada = new ObjectInputStream(bAEntrada);
            dados = (ArrayList<Double>) entrada.readObject(); // Casting para ArrayList<Double>
            System.out.println("Recebido: " + dados);
        } catch (IOException e) {
            System.err.println("FALHA IOException: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("FALHA ClassNotFoundException: " + e.getMessage());
        }
        return dados;
    }
}
