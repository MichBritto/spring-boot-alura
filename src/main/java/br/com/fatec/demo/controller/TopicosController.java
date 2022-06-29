package br.com.fatec.demo.controller;

import br.com.fatec.demo.controller.dto.TopicoDto;
import br.com.fatec.demo.modelo.Curso;
import br.com.fatec.demo.modelo.Topico;
import br.com.fatec.demo.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController //utilizando essa anotação não se torna necessário utilizar @ResponseBody
public class TopicosController {

    @Autowired //usado para injeção na classe
    TopicoRepository topicoRepository;

    @RequestMapping("/topicos")
    public List<TopicoDto> lista(){
        List<Topico> topicos = topicoRepository.findAll();//método para trazer todos os dados de TOPICOS do banco
        return TopicoDto.converter(topicos); //devolve uma lista com 3 topicos iguais
    }

}
