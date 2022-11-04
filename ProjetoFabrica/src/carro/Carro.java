/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carro;

/**
 *
 * @author IFTM
 */
public class Carro {
    private String chassi;
    private int ano;
    private String modelo;
    private String fabricante;
    private float potencia;

    public Carro(String chassi, int ano, String modelo, String fabricante, float potencia) {
        this.chassi = chassi;
        this.ano = ano;
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.potencia = potencia;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public float getPotencia() {
        return potencia;
    }

    public void setPotencia(float potencia) {
        this.potencia = potencia;
    }

    @Override
    public String toString() {
        return "Carro{" + "chassi=" + chassi + ", ano=" + ano + ", modelo=" + modelo + ", fabricante=" + fabricante + ", potencia=" + potencia + '}';
    }
}
