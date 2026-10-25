/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa um cliente. Dependente tambem e um Cliente:
 * a diferenca e que o dependente tem codTitular preenchido.
 */

public class Cliente {
    private int codigo;
    private String nome;
    private String rua;
    private String bairro;
    private String cidade;
    private String uf;
    private int situacao = 1; // 1 - habilitado, 2 - desabilitado
    private Integer codTitular; // null = e titular
    private List<Cliente> dependentes = new ArrayList<>();

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }

    public Integer getCodTitular() {
        return codTitular;
    }

    public void setCodTitular(Integer codTitular) {
        this.codTitular = codTitular;
    }

    public List<Cliente> getDependentes() {
        return dependentes;
    }

    public void setDependentes(List<Cliente> dependentes) {
        this.dependentes = dependentes;
    }
    
    public String getSituacaoDescricao() {
        return situacao == 1 ? "Habilitado" : "Desabilitado";
    }
    
    
}
