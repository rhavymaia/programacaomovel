package br.edu.ifpb.retrofit2app;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Entidade Sine baseada no JSon do TCU - Cívico.
 *
 * Modelo:
 *  {
         "codPosto": "2334007-0",
         "nome": "PREFEITURA MUNICIPAL DE BEBERIBE/CE",
         "entidadeConveniada": "Sine Estadual - Ceara",
         "endereco": "RUA MARIA CALADO, S/N, SL 1008",
         "bairro": "CENTRO",
         "cep": "62840000",
         "telefone": "33382594",
         "municipio": "Beberibe",
         "uf": "Ceará",
         "lat": -4.1828786,
         "long": -38.1300362
    }
 */
public class Sine {

    @SerializedName("codPosto")
    @Expose
    private String codPosto;

    @SerializedName("nome")
    @Expose
    private String nome;

    @SerializedName("entidadeConveniada")
    @Expose
    private String entidadeConveniada;

    @SerializedName("endereco")
    @Expose
    private String endereco;

    @SerializedName("bairro")
    @Expose
    private String bairro;

    @SerializedName("cep")
    @Expose
    private String cep;

    @SerializedName("telefone")
    @Expose
    private String telefone;

    @SerializedName("municipio")
    @Expose
    private String municipio;

    @SerializedName("uf")
    @Expose
    private String uf;

    @SerializedName("lat")
    @Expose
    private Double latitude;

    @SerializedName("long")
    @Expose
    private Double longitude;

    public String getCodPosto() {
        return codPosto;
    }

    public void setCodPosto(String codPosto) {
        this.codPosto = codPosto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEntidadeConveniada() {
        return entidadeConveniada;
    }

    public void setEntidadeConveniada(String entidadeConveniada) {
        this.entidadeConveniada = entidadeConveniada;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double _long) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Sine ["
                + "nome=" + nome
                + "]";
    }
}