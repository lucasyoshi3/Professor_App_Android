package com.fateczl.professor_app_android.model;

public class ProfessorHorista extends Professor{

    private int horasAula;
    private double valorHoraAula;

    public ProfessorHorista(){
        super();
    }

    @Override
    public void calcSalario() {

    }

    public int getHorasAula() {
        return horasAula;
    }

    public void setHorasAula(int horasAula) {
        this.horasAula = horasAula;
    }

    public double getValorHoraAula() {
        return valorHoraAula;
    }

    public void setValorHoraAula(double valorHoraAula) {
        this.valorHoraAula = valorHoraAula;
    }
}
