package br.com.healthtrack.model;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static br.com.healthtrack.model.Usuario.usuarios;

/**
 * Classe que abstrai uma Pessoa, ela e abstract, portanto, nao podera ser instanciada, apenas servindo de generalizacao para as outras tres classes: usuario, personal e nutricionista
 * @author Israel Cavalcante
 * @version 1.0<h3> </h3>*/

public abstract class Pessoa {
    private long idPessoa;
    private String nomePessoa;
    private String passPessoa;
    private String foto;
    private float peso;
    private float altura;
    private Date dataNascimento;
    private String emailUsuario;
    private char sexo;

    public Pessoa(long idPessoa, String nomePessoa, String passPessoa, String foto, String dataNascimento, String emailUsuario, char sexo) {
    }

    /**
     * Getters e Setters da classe Pessoa
     * @return
     */

    public long getIdPessoa() {
        return idPessoa;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public String getPassPessoa() {
        return passPessoa;
    }

    public String getFoto() {
        return foto;
    }

    public float getPeso() {
        return peso;
    }

    public float getAltura() {
        return altura;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public char getSexo() {
        return sexo;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public void setPassPessoa(String passPessoa) {
        this.passPessoa = passPessoa;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void setIdPessoa(long idPessoa) {
        this.idPessoa = idPessoa;
    }



    /**
     * Construtor completo com as informacoes de uma pessoa
     * @param idPessoa é o numero de identificacao unico para cada usuario, recebe um long
     * @param nomePessoa nome da pessoa que utilizara a conta, tanto de usuario, quanto de nutricionista/personal, recebe uma String
     * @param passPessoa senha unica de usuario, recebe uma String
     * @param foto recebe a foto de um usuario, tipo Blob
     * @param peso recebe o peso de um usuario, tipo float
     * @param altura recebe a altura de um usuário, tipo float
     * @param dataNascimento recebe a data de nascimento do usuário
     * @param emailUsuario recebe o e-mail do usuario, do tipo String
     * @param sexo recebe um sexo sendo "m" ou "f", do tipo char
     */

    public Pessoa(long idPessoa, String nomePessoa, String passPessoa, String foto, float peso, float altura, String dataNascimento, String emailUsuario, char sexo) {
        this.idPessoa = idPessoa;
        this.nomePessoa = nomePessoa;
        this.passPessoa = passPessoa;
        this.foto = foto;
        this.peso = peso;
        this.altura = altura;
        try {
            this.dataNascimento = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimento);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.emailUsuario = emailUsuario;
        this.sexo = sexo;
    }

    /**
     * Construtor vazio para testes
     */

    public Pessoa(){
    }
}

