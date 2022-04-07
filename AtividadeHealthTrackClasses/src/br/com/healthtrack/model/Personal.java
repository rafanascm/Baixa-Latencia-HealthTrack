package br.com.healthtrack.model;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Personal extends Pessoa {
    private String cref;
    private ArrayList<Skill> skill;

    /**
     * Instanciando uma lista para armarzenar os usuarios, de forma que, consiga implementar o CRUD (solucao temporaria) ate poder usar algum banco de dados.
     */
    public static ArrayList<Personal> personais = new ArrayList<>();

    /**
     * Getters and Setters
     * @return
     */
    public String getCref() {
        return cref;
    }

    public void setCref(String cref) {
        this.cref = cref;
    }

    public ArrayList<Skill> getSkill() {
        return skill;
    }

    public void setSkill(ArrayList<Skill> skill) {
        this.skill = skill;
    }

    /**
     * metodo para registrar um personal
     * @param personal recebe um personal, para ser adicionado ao banco de dados/lista
     */

    public static void registroPersonal(Personal personal){
        personais.add(personal);
    }

    /**
     *
     * @param personal recebe um personal, para excluir um personal
     */

    public static void excluirPersonal(Personal personal){
        personais.remove(personal);
    }

    public static void exibirPersonais(){
        System.out.println("----------------------- Buscando Personais Cadastrados ----------------------------");
        if (personais.size() == 0){
            System.out.println("Não há personais cadastrados no momento");
        }else{
            System.out.println("Atualmente há " + personais.size() + " personais cadastrados");
        }
        for (Personal personalSalvo : personais){
            System.out.println(personalSalvo);
        }
    }


    /**
     * Construtor completo com as informacoes de uma pessoa
     * @param idPessoa é o numero de identificacao unico para cada usuario, recebe um long
     * @param nomePessoa nome da pessoa que utilizara a conta, tanto de usuario, quanto de nutricionista/personal, recebe uma String
     * @param passPessoa senha unica de usuario, recebe uma String
     * @param foto recebe a foto de um usuario, tipo Blob
     * @param dataNascimento recebe a data de nascimento do usuário
     * @param emailUsuario recebe o e-mail do usuario, do tipo String
     * @param sexo recebe um sexo sendo "m" ou "f", do tipo char
     * @param cref recebe o documento de identificação de um Personal Trainer, do tipo String
     */


    public Personal(long idPessoa, String nomePessoa, String passPessoa, String foto, String dataNascimento, String emailUsuario, char sexo, String cref) {
        super(idPessoa, nomePessoa, passPessoa, foto,  dataNascimento, emailUsuario, sexo);
        this.cref = cref;
        try {
            this.setDataNascimento((Date) new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimento));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.setNomePessoa(nomePessoa);
        this.setEmailUsuario(emailUsuario);
        this.setPassPessoa(passPessoa);
    }

    public Personal(String cref, ArrayList<Skill> skill) {
        this.cref = cref;
    }

    @Override
    public String toString(){
        return  " Nome: " + getNomePessoa() +
                "\n Data de Nascimento " + getDataNascimento() +
                "\n Email: " + getEmailUsuario() +
                "\n Senha: " + getPassPessoa() +
                "\n Cref: " + getCref() +
                "\n Skills: " + String.valueOf(skill);
    }
}
