package br.com.fatec.demo.controller.dto;

import br.com.fatec.demo.modelo.Topico;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

//Classe usada para pegarmos apenas as informaçôes que queremos da classe Topicos
public class TopicoDto {
    private long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;

    //Construtor para pegar os dados

    public TopicoDto(Topico topico) {
        id = topico.getId();
        titulo = topico.getTitulo();
        mensagem = topico.getMensagem();
        dataCriacao = topico.getDataCriacao();
    }

    public static List<TopicoDto> converter(List<Topico> topico) {
        return topico.stream().map(TopicoDto::new).collect(Collectors.toList());
    }


    //Getters e Setters

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
}
