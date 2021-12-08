package com.example.dixtechapp;

public class Funcionario {
    int idFunc;
    String EmailFunc;
    String SenhaFunc;
    String NomeFunc;
    String CargoFunc;
    String CpfFunc;


    public Funcionario(){

    }

    public Funcionario(int VidFunc){
        this.idFunc=VidFunc;
    }


    //update
    public Funcionario(int VidFunc, String VEmailFunc, String VSenhaFunc, String VNomeFunc, String VCargoFunc, String VCpfFunc){
        this.idFunc=VidFunc;
        this.EmailFunc=VEmailFunc;
        this.SenhaFunc=VSenhaFunc;
        this.NomeFunc=VNomeFunc;
        this.CargoFunc=VCargoFunc;
        this.CpfFunc=VCpfFunc;
    }

    //insert
    public Funcionario(String VEmailFunc, String VSenhaFunc, String VNomeFunc, String VCargoFunc, String VCpfFunc){
        this.EmailFunc=VEmailFunc;
        this.SenhaFunc=VSenhaFunc;
        this.NomeFunc=VNomeFunc;
        this.CargoFunc=VCargoFunc;
        this.CpfFunc=VCpfFunc;

    }


    //============================================

    public int getIdFunc() {
        return idFunc;
    }
    public void setIdFunc(int idFunc) {
        this.idFunc = idFunc;
    }


    public String getEmailFunc() {
        return EmailFunc;
    }
    public void setEmailFunc(String emailFunc) {
        EmailFunc = emailFunc;
    }


    public String getSenhaFunc() {
        return SenhaFunc;
    }
    public void setSenhaFunc(String senhaFunc) {
        SenhaFunc = senhaFunc;
    }


    public String getNomeFunc() {
        return NomeFunc;
    }
    public void setNomeFunc(String nomeFunc) {
        NomeFunc = nomeFunc;
    }


    public String getCargoFunc() {
        return CargoFunc;
    }
    public void setCargoFunc(String cargoFunc) {
        CargoFunc = cargoFunc;
    }


    public String getCpfFunc() {
        return CpfFunc;
    }
    public void setCpfFunc(String cpfFunc) {
        CargoFunc = cpfFunc;
    }



}