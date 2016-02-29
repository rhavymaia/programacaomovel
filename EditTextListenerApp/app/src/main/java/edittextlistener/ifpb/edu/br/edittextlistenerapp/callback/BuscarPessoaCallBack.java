package edittextlistener.ifpb.edu.br.edittextlistenerapp.callback;

import java.util.List;

import edittextlistener.ifpb.edu.br.edittextlistenerapp.entidade.Pessoa;

/**
 * Created by Rerisson Daniel on 25/02/16.
 */
public interface BuscarPessoaCallBack {

    void backBuscarNome(List<Pessoa> names);

    void errorBuscarNome(String error);
}