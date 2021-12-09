package com.example.dixtechapp;

public class Funcionario {
    int id_func;
    String nome_func;
    String cpf;
    String cargo;
    String senha;
    String email_func;
    String tel_func;


    public Funcionario(){

    }

    public Funcionario(int v_id_func){
        this.id_func=v_id_func;
    }


    //PARA O UPDATE
    public Funcionario(int v_id_func, String v_nome_func, String v_cpf, String v_cargo, String v_senha, String v_email_func, String v_tel_func){
        this.id_func=v_id_func;
        this.nome_func=v_nome_func;
        this.cpf=v_cpf;
        this.cargo=v_cargo;
        this.senha=v_senha;
        this.email_func=v_email_func;
        this.tel_func=v_tel_func;
    }

    //PARA O INSERT
    public Funcionario(String v_nome_func, String v_cpf, String v_cargo, String v_senha, String v_email_func, String v_tel_func){
        this.nome_func=v_nome_func;
        this.cpf=v_cpf;
        this.cargo=v_cargo;
        this.senha=v_senha;
        this.email_func=v_email_func;
        this.tel_func=v_tel_func;

    }


    //GETS E SETS PARA SEREM USADOS EXTERNAMENTE

    //ID
    public int getIdFunc() {
        return id_func;
    }
    public void setIdFunc(int id_func) {
        this.id_func = id_func;
    }


    
    //NOME
    public String getNomeFunc() {
        return nome_func;
    }
    public void setNomeFunc(String nomefunc) {
        nome_func = nomefunc;
    }


    
    //CPF
    public String getCpfFunc() {
        return cpf;
    }
    public void setCpfFunc(String cpffunc) {
        cpf = cpffunc;
    }


    
    //CARGO
    public String getCargoFunc() {
        return cargo;
    }
    public void setCargoFunc(String cargoFunc) {
        cargo = cargoFunc;
    }



    //SENHA
    
    public String getSenhaFunc() {
        return senha;
    }
    public void setSenhaFunc(String senhaFunc) {
        senha = senhaFunc;
    }


    
    //EMAIL
    public String getEmailFunc() {
        return email_func;
    }
    public void setEmailFunc(String emailfunc) {
        email_func = emailfunc;
    }


    
    //TEL
    public String getTelFunc() {
        return tel_func;
    }
    public void setTelFunc(String telfunc) {
        tel_func = telfunc;
    }

}
