package br.com.healthtrack.model;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que abstrai um usuario e herda da classe Pessoa, ou seja, aquela pessoa que irá utilizar os beneficios do aplicativo Health Track
 * Essa classe e uma entidade, portanto, ira produzir instancias, diferente de Pessoa.
 * @author Israel Cavalcante
 * @version 1.0<h3> </h3>*/

public class Usuario extends Pessoa{

    private ArrayList<Meta> meta = new ArrayList<>();
    private ArrayList<HistoricoPeso> historicoPeso = new ArrayList<>();

    /**
     * Instanciando uma lista para armarzenar os usuarios, de forma que, consiga implementar o CRUD (solucao temporaria) ate poder usar algum banco de dados.
     */

    public static ArrayList<Usuario> usuarios = new ArrayList<>();

    public List<Meta> getMeta( ) {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta.add(meta);
    }

    public List<HistoricoPeso> getHistoricoPeso() {
        return historicoPeso;
    }

    public void setHistoricoPeso(ArrayList<HistoricoPeso> historicoPeso) {
        this.historicoPeso = historicoPeso;
    }

    /* Crud básico utilizando lista estática, apenas para efeito de demonstração
    (provavelmente seria feito em um banco de dados) */

    /**
     * Metodo para registrar um usuario
     * @param usuario
     * @return
     */

    public void registroUsuario(Usuario usuario){
        usuarios.add(usuario);
    }

    /**
     * Esse metodo tem como objetivo editar um usuario, sem mexer no proprio, ou seja, sera editado um usuario
     * e depois essas informacoes editadas serao atualizadas no objeto que realmente queremos atualizar.
     * @param usuario que recebera o usuario que foi instanciado somente para editar
     * @return
     */
    public static Usuario editarUsuario(Usuario usuario){
        for (Usuario usuarioSalvo : usuarios){
            // Ele irá buscar na lista/banco de dados usuarios, pelo usuário que tenha o mesmo ID do que foi instanciado
            // para editar
            if (usuarioSalvo.getIdPessoa() == usuario.getIdPessoa()){
                // Aqui escolhi quais dados poderão ser atualizados, de acordo com a regra de negócio
                // Lembrando que aqui serão os dados que a pessoa conseguirá editar no Perfil, haverá outras telas
                // Para editar Peso, por exemplo.
                usuarioSalvo.setEmailUsuario(usuario.getEmailUsuario());
                usuarioSalvo.setPassPessoa(usuario.getPassPessoa());
                usuarioSalvo.setAltura(usuario.getAltura());
                usuarioSalvo.setFoto(usuario.getFoto());
            }
        }
        return usuario;
    }

    /**
     * Método para excluir uma conta/pessoa do sistema
     * @param usuario você tem que passar o objeto pessoa, da classe Pessoa, para que uma pessoa seja excluida.
     */

    public static void excluirUsuario(Usuario usuario){
        usuarios.remove(usuario);
    }

    public static void exibirUsuarios(){
        System.out.println("----------------------- Buscando Usuários cadastrados ----------------------------");
        if (usuarios.size() == 0){
            System.out.println("Não há usuários cadastrados no momento");
        }else{
            System.out.println("Atualmente há " + usuarios.size() + " usuários cadastrados");
        }
        for (Usuario usuarioSalvo : usuarios){
            System.out.println(usuarioSalvo);
        }
    }
    public static Pessoa buscarPorId(long idPessoa) {
        Usuario usuarioRetorno = null;
        for (Usuario usuarioSalvo : usuarios) {
            if (usuarioSalvo.getIdPessoa() == idPessoa) {
                usuarioRetorno = usuarioSalvo;
                System.out.println("-------------------Buscando Usuário por ID--------------------------");
                System.out.println("Usuário encontrado: ");
                System.out.println(usuarioSalvo);
            }else{
                System.out.println("-------------------Buscando Usuário por ID--------------------------");
                System.out.println("Usuário não encontrado");
            }
        }
        return usuarioRetorno;
    }

    /**
     * Construtor com as informacoes necessarias para criar um usuario
     * @param idPessoa e o numero de identificacao unico para cada usuario, recebe um long
     * @param nomePessoa nome da pessoa que utilizara a conta, tanto de usuario, quanto de nutricionista/personal, recebe uma String
     * @param passPessoa senha unica de usuario, recebe uma String
     * @param foto recebe a foto de um usuario, tipo Blob
     * @param peso recebe o peso de um usuario, tipo float
     * @param altura recebe a altura de um usuário, tipo float
     * @param dataNascimento recebe a data de nascimento do usuário
     * @param emailUsuario recebe o e-mail do usuario, do tipo String
     * @param sexo recebe um sexo sendo "m" ou "f", do tipo char
     */

    public Usuario(long idPessoa, String nomePessoa, String passPessoa, String foto, float peso,
                   float altura, String dataNascimento, String emailUsuario, char sexo){

        super(idPessoa, nomePessoa, passPessoa, foto, peso, altura, dataNascimento, emailUsuario, sexo);
    }

    /**
     * Sobrescrevendo o metodo toString, para que ele exiba as informacoes Nome, Email e Metas, caso contrario, exibiria apenas o hascode onde esta alocado na memoria
     * @return
     */

    public Usuario(){
    }

    @Override
    public String toString() {
        return  " Nome: " + getNomePessoa() +
                "\n Data de Nascimento " + getDataNascimento() +
                "\n Email: " + getEmailUsuario() +
                "\n Senha: " + getPassPessoa() +
                "\n Peso: " + getPeso() +
                "\n Altura: " + getAltura() +
                "\n Metas: " + String.valueOf(meta);
    }
}

