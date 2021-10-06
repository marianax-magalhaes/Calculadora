package br.com.calculadora.services;

import br.com.calculadora.domain.Operacao;

public class CalculadoraService {

    public double calcular(double operandoA, double operandoB, Operacao operacao){
        double resultado = 0;

        switch (operacao){
            case SOMA: resultado = somar(operandoA, operandoB);break;
            case SUBTRACAO: resultado = subtrair(operandoA, operandoB);break;
            case MULTIPLICACAO: resultado = multiplicar(operandoA, operandoB);break;
            case DIVISAO: resultado = dividir(operandoA, operandoB);break;
            default: {}
        }
        return resultado;
    }
    private double somar(double operandoA, double operandoB){
        return operandoA + operandoB;
     }
    private double subtrair(double operandoA, double operandoB){
        return operandoA - operandoB;
    }
    private double multiplicar(double operandoA, double operandoB){
        return operandoA * operandoB;
    }
    private double dividir(double operandoA, double operandoB) throws IllegalArgumentException{
        if(operandoB == 0) throw new IllegalArgumentException("Divisor não pode ser zero");
        return operandoA / operandoB;
    }
}
