package br.com.fatec.demo.controller.dto;

import br.com.fatec.demo.modelo.Resposta;
import br.com.fatec.demo.modelo.StatusTopico;
import br.com.fatec.demo.modelo.Topico;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//Classes Dto só servem para pegarmos dados para leitura
//Em classes dto, os atributos só podem ser de tipos primitivos ou Enum
public class DetalhesTopicoDto {
    private long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private String nomeAutor;
    private StatusTopico status;
    private List<RespostasDto> respostas;

    //Construtor para pegar os dados
    public DetalhesTopicoDto(Topico topico) {
        id = topico.getId();
        titulo = topico.getTitulo();
        mensagem = topico.getMensagem();
        dataCriacao = topico.getDataCriacao();
        nomeAutor = topico.getAutor().getNome();
        status = topico.getStatus();
        respostas = new ArrayList<>();//definindo um array vazio para as respostas, e abaixo adicionando as respostas
        respostas.addAll(topico.getRespostas().stream().map(RespostasDto::new).collect(Collectors.toList()));
    }

    public long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public StatusTopico getStatus() {
        return status;
    }

    public List<RespostasDto> getRespostas() {
        return respostas;
    }
}
