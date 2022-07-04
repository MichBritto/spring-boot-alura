package br.com.fatec.demo.controller.form;

import br.com.fatec.demo.modelo.Curso;
import br.com.fatec.demo.modelo.Topico;
import br.com.fatec.demo.repository.CursoRepository;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class TopicoForm{
    @NotNull @NotEmpty @Length(min = 10, max = 20) //usando validações de campos  (não nulo, não vazio, e espaço)
    private String titulo;
    @NotNull @NotEmpty @Length(min = 10) //usando validações de campos
    private String mensagem;
    @NotNull @NotEmpty //@Length(min = 10) //usando validações de campos
    private String nomeCurso;

    public Topico converter(CursoRepository cursoRepository){
        Curso curso = cursoRepository.findByNome(nomeCurso); //criado para pegar o curso por nome curso
        return new Topico(titulo,mensagem,curso);
    }

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

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }
}
