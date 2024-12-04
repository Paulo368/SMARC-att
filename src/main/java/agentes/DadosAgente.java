/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agentes;

import java.io.Serializable;

/**
 *
 * @author 2022122760265
 */
public class DadosAgente implements Serializable {
    private String tipo;
    private double grauEvidencia;

    public DadosAgente(String tipo, double grauEvidencia) {
        this.tipo = tipo;
        this.grauEvidencia = grauEvidencia;
    }

    public String getTipo() {
        return tipo;
    }

    public double getGrauEvidencia() {
        return grauEvidencia;
    }

    
    @Override
    public String toString() {
        return "DadosAgente{" + "tipo=" + tipo + ", grauEvidencia=" + grauEvidencia + '}';
    }

}
