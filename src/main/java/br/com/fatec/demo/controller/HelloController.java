package br.com.fatec.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //controller vindo do pacote do spring
public class HelloController {

    @RequestMapping (value = "/helloworld") //mostra o que devemos digitar na porta 8080 localhost para chamarmos esse método,
                          //no caso seria: localhost:8080/
    @ResponseBody //para o localhost nao considerar que estamos procurando por uma pág web chamada "Hello World"
    public String hello(){
        return "http://www.google.com";
    }
}
