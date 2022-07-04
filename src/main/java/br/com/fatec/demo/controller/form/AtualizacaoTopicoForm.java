package br.com.fatec.demo.controller.form;

import br.com.fatec.demo.modelo.Topico;
import br.com.fatec.demo.repository.TopicoRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

//Para nao atualizar todos os campos, criou-se esse Form para atualizar só os campos necessários
public class AtualizacaoTopicoForm {
    @NotNull @NotEmpty @Length(min = 10, max = 20) //usando validações de campos  (não nulo, não vazio, e espaço)
    private String titulo;
    @NotNull @NotEmpty @Length(min = 10) //usando validações de campos
    private String mensagem;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Topico atualizar(Long id, TopicoRepository topicoRepository) {
        Topico topico = topicoRepository.getReferenceById(id); //buscando um topico por id
        //definindo novo titulo e nova mensagem
        topico.setTitulo(this.titulo);
        topico.setMensagem(this.mensagem);
        return topico;
    }
}
