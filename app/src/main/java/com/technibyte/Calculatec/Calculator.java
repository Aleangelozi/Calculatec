package com.technibyte.Calculatec;
public class Calculator {
    private double operando;
    private double operandoAnterior;
    private String operadorAnterior;
    private double memoria;

    public Calculator(){
        operando = 0;
        operandoAnterior = 0;
        operadorAnterior = "";
        memoria = 0;
    }
    public double getOperando() {
         return operando;
    }

    public void setOperando(double operando) {
        this.operando = operando;
     }

    private void realizarOperacaoAnterior(){
        if (!operadorAnterior.equals("")){
            if (operadorAnterior.equals("+")){
                operando = operandoAnterior + operando;
            } else if (operadorAnterior.equals("-")){
                operando = operandoAnterior - operando;
            } else if (operadorAnterior.equals("x")){
                operando = operandoAnterior * operando;
            } else if (operadorAnterior.equals("÷")){
                if (operando!=0){
                    operando = operandoAnterior / operando;
                }
            }
        }
    }
    public void realizarOperacao(String op){
        if (op.equals("%")){
            operando = (operandoAnterior*operando)/100;
        }else if (op.equals("+/-")){
            operando = -operando;
        }else if (op.equals("C")){
            operando=0;
            memoria=0;
            operadorAnterior="";
        }else{
            realizarOperacaoAnterior();
            operadorAnterior=op;
            operandoAnterior=operando;
        }
    }
    public void realizarOperacaoDeMemoria(String opm){
        if (opm.equals("mc")) {
            memoria = 0;
        } else if (opm.equals("m+")) {
            memoria += operando;
        } else if (opm.equals("m-")) {
            memoria -= operando;
        } else if (opm.equals("mr")) {
            operando = memoria;
        }
    }
}
