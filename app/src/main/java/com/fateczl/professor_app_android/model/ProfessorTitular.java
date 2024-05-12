package com.fateczl.professor_app_android.model;

public class ProfessorTitular extends Professor{

    private int anosInstituicao;
    private double salario;

    public ProfessorTitular(){
        super();
    }

    public int getAnosInstituicao() {
        return anosInstituicao;
    }

    public void setAnosInstituicao(int anosInstituicao) {
        this.anosInstituicao = anosInstituicao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
