package br.com.math.revisitor.entity;

import br.com.math.revisitor.DTO.EnderecoDTO;
import jakarta.persistence.Embeddable;

@Embeddable
public class Endereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(EnderecoDTO endereco) {
        this.logradouro = endereco.logradouro();
        this.bairro = endereco.bairro();
        this.cep = endereco.cep();
        this.numero = endereco.numero();
        this.complemento = endereco.complemento();
        this.cidade = endereco.cidade();
        this.uf = endereco.uf();
    }

    public Endereco() {
    }

    public void atualizarEndereco(EnderecoDTO endereco) {
        if (endereco.logradouro() != null) this.logradouro = endereco.logradouro();
        if (endereco.bairro() != null) this.bairro = endereco.bairro();
        if (endereco.cep() != null) this.cep = endereco.cep();
        if (endereco.numero() != null) this.numero = endereco.numero();
        if (endereco.complemento() != null) this.complemento = endereco.complemento();
        if (endereco.cidade() != null) this.cidade = endereco.cidade();
        if (endereco.uf() != null) this.uf = endereco.uf();
    }
}