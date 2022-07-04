package br.com.fatec.demo.controller;

import br.com.fatec.demo.controller.dto.DetalhesTopicoDto;
import br.com.fatec.demo.controller.dto.TopicoDto;
import br.com.fatec.demo.controller.form.AtualizacaoTopicoForm;
import br.com.fatec.demo.controller.form.TopicoForm;
import br.com.fatec.demo.modelo.Curso;
import br.com.fatec.demo.modelo.Topico;
import br.com.fatec.demo.repository.CursoRepository;
import br.com.fatec.demo.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

@RestController //utilizando essa anotação não se torna necessário utilizar @ResponseBody

@RequestMapping("/topicos") //toda vez que eu chamar essa URL vai cair nesse método
public class TopicosController {
    @Autowired //usado para injeção na classe
    TopicoRepository topicoRepository;
    @Autowired
    CursoRepository cursoRepository;

    @GetMapping //usado para indicar que é um método de leitura de dados
    public List<TopicoDto> lista(String nomeCurso){
        if(nomeCurso == null){
            List<Topico> topicos = topicoRepository.findAll();//método para trazer todos os dados de TOPICOS do banco
            return TopicoDto.converter(topicos); //devolve uma lista
        }
        else{
            List<Topico> topicos = topicoRepository.findByCursoNome(nomeCurso);//método para trazer os dados de acordo com o curso, existe um padrão de nomeclatura
            return TopicoDto.converter(topicos); //devolve uma lista
        }
    }

    @PostMapping //usado para indicar que é um método de cadastro de
    @Transactional //essa anotação deve estar presente em todos os metodos do crud
    /*ResponseEntity para nao retornar um '200' generico*/
    public ResponseEntity<TopicoDto>  cadastrar(@RequestBody @Valid TopicoForm topicoForm, UriComponentsBuilder uriBuilder){ //@RequestBody diferencia o parametro, pois como é um método de cadastro, precisa diferenciar que eu quero que as informaÇões venham no corpo da requisição | @Valid anotação necessária para realizar validação de campos
        Topico topico = topicoForm.converter(cursoRepository); //cria um topicoForm passando um parametro de nome do curso para o cursoRepository
        topicoRepository.save(topico); //usado para guardar informaçôes, através do repository que extends Jpa

        URI uri = uriBuilder.path("topicos/{id}").buildAndExpand(topico.getId()).toUri(); //metodo para pegar a uri que é o caminho necessário, para passarmos como parametro no retorno
        return ResponseEntity.created(uri).body(new TopicoDto(topico));
    }

    @GetMapping("/{id}") //especificando que para entrar nesse metodo get é necessário passar id
    public DetalhesTopicoDto detalhar(@PathVariable Long id){//para indicar que o id deve ir para a URL, deve ter o mesmo nome que o id do @GetMapping
        Topico topico = topicoRepository.getReferenceById(id);//passa um ID especifico para ser buscado
        return new DetalhesTopicoDto(topico); //retornando somente os dados necessários através da classe Dto
    }

    @PutMapping("/{id}")//metodo para atualIzar dados por meio do Id
    @Transactional //avisar ao spring para commitar ou subir as atualizações
    public ResponseEntity<TopicoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoTopicoForm form){
        Topico topico = form.atualizar(id, topicoRepository); //usando um metodo para atualizar, ao passar dessa linha ele ja tera atualizado

        return ResponseEntity.ok(new TopicoDto(topico));  //parametro OK é o corpo que vai ser devolvido ao chamarmos esse método
    }

    @DeleteMapping("/{id}")
    @Transactional //essa anotação deve estar presente em todos os metodos do crud
    public ResponseEntity<?> excluir(@PathVariable Long id){
        topicoRepository.deleteById(id); //deletando um objeto por id

        return ResponseEntity.ok().build(); //devolvendo apenas um "ok" já que o objeto foi excluido
    }
}

