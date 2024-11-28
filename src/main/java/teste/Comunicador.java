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
    
    public Comunicador(Agente agente) {
        try {
            enderecoGrupo = InetAddress.getByName(multiCastAddress);
            soc = new MulticastSocket(porta);
            soc.joinGroup(enderecoGrupo);
        } catch (IOException e) {
            System.out.println("FALHA IOException"+e.getMessage());
        }
    }

    public Comunicador(int porta) {
        this.porta = porta;
    }

    

    public void envia(ArrayList<String> dados, int porta) {
        try {
            ByteArrayOutputStream bASaida = new ByteArrayOutputStream();
            ObjectOutputStream saida = new ObjectOutputStream(bASaida);
            saida.writeObject(dados);
            byte[] data = bASaida.toByteArray();
            soc.send(new DatagramPacket(data, data.length, enderecoGrupo, porta));
            System.out.println("Enviado: " + dados);
        } catch (IOException e) {
            System.out.println("IOException"+e.getMessage());
        }
    }

    public ArrayList<String> recebe() {
        byte[] buffer = new byte[4096];
        ArrayList<String> dados;
        try {
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            soc.receive(packet);
            ByteArrayInputStream bAEntrada = new ByteArrayInputStream(buffer);
            ObjectInputStream entrada = new ObjectInputStream(bAEntrada);
            dados = (DadosAgente) entrada.readObject();
            System.out.println("Recebido: " + dados);
        } catch (IOException e) {
            System.out.println("FALHA IOException"+e.getMessage());
        } catch (ClassNotFoundException e){
            System.out.println("FALHA ClassNotFoundException"+e.getMessage());
        }
        return dados;
        
    }
}
