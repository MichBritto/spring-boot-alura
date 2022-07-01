package br.com.fatec.demo.repository;

import br.com.fatec.demo.modelo.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*Como no Topico.Repository.java temos uma interface e não uma classe,
não preciso colocar nenhuma anotação em cima dela. Normalmente,
as classes que são gerenciadas pelo Spring, temos que colocar um
@controller, @service, @Repository, @Component.
 */
public interface TopicoRepository extends JpaRepository<Topico, Long> {//extends para herdar os métodos de injeção no banco de dados
    List<Topico> findByCursoNome(String nomeCurso); //método criado para fazer buscas por nome de Curso, o nome deve seguir
                                                // esse padrão (Classe+Atributo)

}
