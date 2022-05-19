package br.univali.m2_mobile_cardapio;

public class comida {

    private String nomeAlimento;
    private String urlFoto;
    private String preco;


    public String getNomeAlimento() {
        return nomeAlimento;
    }

    public void setNomeAlimento(String nomoAlimento) {
        this.nomeAlimento = nomoAlimento;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }
}
