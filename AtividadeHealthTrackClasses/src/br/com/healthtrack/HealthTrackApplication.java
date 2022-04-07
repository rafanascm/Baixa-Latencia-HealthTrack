package br.com.healthtrack;
import br.com.healthtrack.model.Meta;
import br.com.healthtrack.model.Personal;
import br.com.healthtrack.model.Usuario;

import static br.com.healthtrack.model.Personal.exibirPersonais;
import static br.com.healthtrack.model.Personal.registroPersonal;
import static br.com.healthtrack.model.Usuario.buscarPorId;
import static br.com.healthtrack.model.Usuario.*;
public class HealthTrackApplication {

    public static void main(String[] args) {
        // Primeira instância de um usuário comum, que apenas irá utilizar os benefícios do aplicativo.
        Usuario usuarioComum = new Usuario(224, "Leo", "Primeira-Senha", "minhaFoto", 68.50f, 1.68f
                , "08/03/2001", "leo@gmail.com", 'm' );

        // Salvando o usuário na lista estática que simula um banco de dados
        usuarioComum.registroUsuario(usuarioComum);

        // Exibindo o usuário após ser instanciado e registrado no banco de dados"
        System.out.println("Usuário com as informações desatualizadas e sem nenhuma meta definida");
        exibirUsuarios();

        // Instanciando a meta com seus parâmetros
        Meta meta = new Meta(2, "Natação", 1.45f);
        // Aqui estou atribuindo a meta á um usuário
        meta.adicionarMeta(meta, 224);
        // Instanciando o objeto que só servirá para editar o usuarioComum
        Usuario usuarioEditar = new Usuario();
        // Escolhendo os novos atributos a serem editados
        usuarioEditar.setEmailUsuario("leopontorua@gmail.com");
        usuarioEditar.setPassPessoa("Nova-Senha");
        usuarioEditar.setAltura(1.69f);
        usuarioEditar.setFoto("Nova-Foto");
        // Setando o mesmo ID do usuarioComum, pois é necessário para a edição
        usuarioEditar.setIdPessoa(224);

        /*
        Aqui chamo a função, através do usuarioComum passando o usuarioEditar que foi instanciando apenas para essa edição
        Optei por essa lógica, por conta de que não estava descrito se poderia utilizar Banco de Dados na atividade
        E por estar utilizando uma lista estática, para simular um banco de dados, esse é o único método para fazer a edição
        sem mexer diretamente no usuário que está na lista estática, visto que utilizar set diretamente no usuário é errado.
         */
        editarUsuario(usuarioEditar);

        //Aqui já irá retornar o usuário com os novos dados
        exibirUsuarios();

        // Método para buscar um usuário específico por ID
        buscarPorId(224);

        // Método para excluir o usuário do banco de dados/lista
        excluirUsuario(usuarioComum);
        exibirUsuarios();

        Personal personalTeste = new Personal(324, "Juliana", "39823232", "fotoJuliana"
                , "08/03/1998", "Juliana@gmail.com", 'F', "3823232-12" );
        registroPersonal(personalTeste);
        exibirPersonais();
    }

}

