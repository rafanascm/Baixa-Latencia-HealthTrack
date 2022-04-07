package br.com.healthtrack.model;
import static br.com.healthtrack.model.Usuario.usuarios;

public class Meta {

    private long idMeta;
    private String tipoMeta;
    private float tempoMeta;

    /**
     * Getters e Setters da classe Meta
     * @return
     */

    public long getIdMeta() {
        return idMeta;
    }

    public void setIdMeta(long idMeta) {
        this.idMeta = idMeta;
    }

    public String getTipoMeta() {
        return tipoMeta;
    }

    public void setTipoMeta(String tipoMeta) {
        this.tipoMeta = tipoMeta;
    }

    public float getTempoMeta() {
        return tempoMeta;
    }

    public void setTempoMeta(float tempoMeta) {
        this.tempoMeta = tempoMeta;
    }
    /**
     * Metodo para adicionar uma meta a um usuario especifico
     * @param meta recebe uma meta a qual sera adicionado ao usuario
     * @param idPessoa recebe o identificador unico do usuario, para atribuir a ele a meta
     * @return
     */
    public Meta adicionarMeta(Meta meta, long idPessoa){
        for (Usuario usuario : usuarios)
        {
            if (usuario.getIdPessoa() == idPessoa){
                usuario.setMeta(meta);
            }
        }
        return meta;
    }



    /**
     * Construtor com os parametros necessarios para adicionar uma meta a um usuario
     * @param idMeta recebe um identificador unico
     * @param tipoMeta recebe o nome da meta ex: musculacao
     * @param tempoMeta recebe o tempo que voce praticou aquele exercicio em horas ex: 1.30 = uma hora e meia
     */

    public Meta(long idMeta, String tipoMeta, float tempoMeta) {
        this.idMeta = idMeta;
        this.tipoMeta = tipoMeta;
        this.tempoMeta = tempoMeta;
    }

    /**
     * Estou Sobrescrevendo o método ToString para printar os valores de forma correta
     * @return
     */

    @Override
    public String toString() {
        return " ID: " + idMeta +
                " Tipo Meta: " + tipoMeta +
                 " Meta em hora: "+ tempoMeta;
    }
}
