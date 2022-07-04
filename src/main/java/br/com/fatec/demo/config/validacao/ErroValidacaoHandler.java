package br.com.fatec.demo.config.validacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice //usado para tratar os erros das requisições (ex: 400)
public class ErroValidacaoHandler {

    @Autowired
    private MessageSource messageSource;
    @ResponseStatus(code = HttpStatus.BAD_REQUEST) //usado para garantir que será devolvido um erro 400, não um ok 200
    @ExceptionHandler(MethodArgumentNotValidException.class) //recebe um parametro que mostra em qual exception esse método será chamado (No nosso caso: Validação de usuário)
    public List<ErroDeFormularioDto> handle(MethodArgumentNotValidException exception){

        List<ErroDeFormularioDto> dto = new ArrayList(); //objeto criado para guardar a lsita de mensagem
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();  //pegando todos as mensagens de erro
       //criando um for a partir de uma expressão lambda
        fieldErrors.forEach(e ->{
            String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale()); //pegando a mensagem e o local para formatar no idioma correto
            ErroDeFormularioDto erro = new ErroDeFormularioDto(e.getField(), mensagem); // capturando erro especifico
            dto.add(erro); //passando o erro para a list
        });
        return dto;

    }
}
