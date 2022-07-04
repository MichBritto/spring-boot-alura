package br.com.fatec.demo.config.validacao;

//Classe usada para tratar os erros de requisições (BAD_REQUEST 400)
public class ErroDeFormularioDto {

    private String erro;
    private String campo;

    public ErroDeFormularioDto(String erro, String campo) {
        this.erro = erro;
        this.campo = campo;
    }

    public String getErro() {
        return erro;
    }

    public String getCampo() {
        return campo;
    }
}
