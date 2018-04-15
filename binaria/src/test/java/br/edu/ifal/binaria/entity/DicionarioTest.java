package br.edu.ifal.binaria.entity;

public interface DicionarioTest{

    void inicializarContexto();

    void dadoQueGetElementosQuandoDicionarioPopuladoComElementosEntaoDeveriaRetornarElementos();

    void dadoQueGetElementosQuandoDicionarioVazioEntaoDeveriaRetornarVazio();

    void dadoQueGetElementosQuandoElementosNuloEntaoDeveriaRetornarVazio();

    void dadoQueOrdenarElementosQuandoDicionarioPopuladoComElementosDesordenadosEntaoDeveriaOrdenarElementos();

    void dadoQueOrdenarElementosQuandoElementosNuloEntaoDeveriaNaoOrdenarElementos();
}