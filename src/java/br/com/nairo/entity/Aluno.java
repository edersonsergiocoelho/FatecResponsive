/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nairo.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author eders
 */
@Entity
@Table(name = "aluno")
@NamedQueries({
    @NamedQuery(name = "Aluno.findAll", query = "SELECT a FROM Aluno a")
    , @NamedQuery(name = "Aluno.findByCodigoAluno", query = "SELECT a FROM Aluno a WHERE a.codigoAluno = :codigoAluno")
    , @NamedQuery(name = "Aluno.findByEmail", query = "SELECT a FROM Aluno a WHERE a.email = :email")
    , @NamedQuery(name = "Aluno.findBySenha", query = "SELECT a FROM Aluno a WHERE a.senha = :senha")
    , @NamedQuery(name = "Aluno.findByEmailAndSenha", query = "SELECT a FROM Aluno a WHERE a.email = :email AND a.senha = :senha")
    , @NamedQuery(name = "Aluno.findByNomeAluno", query = "SELECT a FROM Aluno a WHERE a.nomeAluno = :nomeAluno")
    , @NamedQuery(name = "Aluno.findByRg", query = "SELECT a FROM Aluno a WHERE a.rg = :rg")
    , @NamedQuery(name = "Aluno.findByCpf", query = "SELECT a FROM Aluno a WHERE a.cpf = :cpf")
    , @NamedQuery(name = "Aluno.findByEndereco", query = "SELECT a FROM Aluno a WHERE a.endereco = :endereco")
    , @NamedQuery(name = "Aluno.findByNumero", query = "SELECT a FROM Aluno a WHERE a.numero = :numero")
    , @NamedQuery(name = "Aluno.findByCidade", query = "SELECT a FROM Aluno a WHERE a.cidade = :cidade")
    , @NamedQuery(name = "Aluno.findByEstado", query = "SELECT a FROM Aluno a WHERE a.estado = :estado")
    , @NamedQuery(name = "Aluno.findByCep", query = "SELECT a FROM Aluno a WHERE a.cep = :cep")})
public class Aluno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoAluno")
    private Integer codigoAluno;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "senha")
    private String senha;
    @Basic(optional = false)
    @Column(name = "nomeAluno")
    private String nomeAluno;
    @Basic(optional = false)
    @Column(name = "rg")
    private String rg;
    @Basic(optional = false)
    @Column(name = "cpf")
    private String cpf;
    @Basic(optional = false)
    @Column(name = "endereco")
    private String endereco;
    @Basic(optional = false)
    @Column(name = "numero")
    private int numero;
    @Basic(optional = false)
    @Column(name = "cidade")
    private String cidade;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @Column(name = "cep")
    private String cep;

    public Aluno() {
    }

    public Aluno(Integer codigoAluno) {
        this.codigoAluno = codigoAluno;
    }

    public Aluno(Integer codigoAluno, String email, String senha, String nomeAluno, String rg, String cpf, String endereco, int numero, String cidade, String estado, String cep) {
        this.codigoAluno = codigoAluno;
        this.email = email;
        this.senha = senha;
        this.nomeAluno = nomeAluno;
        this.rg = rg;
        this.cpf = cpf;
        this.endereco = endereco;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public Integer getCodigoAluno() {
        return codigoAluno;
    }

    public void setCodigoAluno(Integer codigoAluno) {
        this.codigoAluno = codigoAluno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoAluno != null ? codigoAluno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aluno)) {
            return false;
        }
        Aluno other = (Aluno) object;
        if ((this.codigoAluno == null && other.codigoAluno != null) || (this.codigoAluno != null && !this.codigoAluno.equals(other.codigoAluno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.nairo.entity.Aluno[ codigoAluno=" + codigoAluno + " ]";
    }
    
}
