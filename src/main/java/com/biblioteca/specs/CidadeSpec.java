package com.biblioteca.specs;

import com.biblioteca.exception.BussinesException;
import com.biblioteca.models.Cidade;
import org.springframework.stereotype.Service;

import static java.util.Objects.nonNull;

@Service
public class CidadeSpec {

    private static final String MSG_CIDADE = "Cidade já cadastrada com nome: %s.";
    private static final String MSG_ESTADO = "Cidade já cadastrada com estado: %s.";

    public void verificarSeExisteCidadeComNomeDuplicado(Cidade cidade){
        if (nonNull(cidade)){
            throw new BussinesException(
                    String.format(MSG_CIDADE,cidade.getNome()));
        }
    }
    public void verificarSeExisteCidadeComEstadoDuplicado(Cidade cidade){
        if (nonNull(cidade)){
            throw new BussinesException(
                    String.format(MSG_ESTADO,cidade.getEstado()));
        }
    }
}
