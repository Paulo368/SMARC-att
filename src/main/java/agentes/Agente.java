/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agentes;

import java.io.Serializable;
import teste.Comunicador;

/**
 *
 * @author 2022122760265
 */
public abstract class Agente implements Serializable{
    protected String nome;
    protected Comunicador comunicador;

    public Agente(String nome, Comunicador comunicador) {
        this.nome = nome;
        this.comunicador = comunicador;
    }

    public abstract DadosAgente processarDados(); // Método abstrato para cada agente implementar sua lógico

    public String getNome() {
        return nome;
    }
}
