package com.biblioteca.specs;

import com.biblioteca.exception.BussinesException;
import com.biblioteca.models.Cidade;
import com.biblioteca.models.Livro;
import org.springframework.stereotype.Service;

import static java.util.Objects.nonNull;

@Service
public class LivroSpec {

    private static final String MSG_LIVRO = "LIVRO já cadastrado com nome: %s.";
    public void verificarSeExisteLivroComNomeDuplicado(Livro livro){
        if (nonNull(livro)){
            throw new BussinesException(
                    String.format(MSG_LIVRO,livro.getNome()));
        }
    }

}


