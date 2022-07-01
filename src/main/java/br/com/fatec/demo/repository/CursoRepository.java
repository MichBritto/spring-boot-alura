package br.com.fatec.demo.repository;


import br.com.fatec.demo.modelo.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

/*Como no Topico.Repository.java temos uma interface e não uma classe,
não preciso colocar nenhuma anotação em cima dela. Normalmente,
as classes que são gerenciadas pelo Spring, temos que colocar um
@controller, @service, @Repository, @Component.
 */
public interface CursoRepository extends JpaRepository<Curso, Long> {

    Curso findByNome(String nome); //retornando um curso por nome do curso
}
