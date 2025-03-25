package com.biblioteca.services;

import com.biblioteca.dtos.CompradorDTO;
import com.biblioteca.dtos.EnderecoDTO;
import com.biblioteca.dtos.LivroDTO;
import com.biblioteca.exception.BussinesException;
import com.biblioteca.models.Comprador;
import com.biblioteca.models.Endereco;
import com.biblioteca.models.Livro;
import com.biblioteca.repositories.LivroRepository;
import com.biblioteca.specs.LivroSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    @Autowired
    LivroSpec livroSpec;
    @Autowired
    LivroRepository livroRepository;

    public LivroDTO cadastrarLivro(LivroDTO livroDTO) {
            Livro livro = converterLivroDTOParaLivro(livroDTO);
            livro = livroRepository.save(livro);
            return converterLivroParaLivroDTO(livro);
        }
        public LivroDTO converterLivroParaLivroDTO (Livro livro){
            LivroDTO livroDTO = new LivroDTO(livro.getId(),
                    livro.getNome(),
                    livro.getAno(),
                    livro.getEditora());
            return livroDTO;
        }
        public Livro converterLivroDTOParaLivro (LivroDTO livroDTO){
            Livro livro = new Livro(livroDTO.getId(),
                    livroDTO.getNome(),
                    livroDTO.getAno(),
                    livroDTO.getEditora());
            return livro;
        }
        public void deletarLivro (Long id){
            livroRepository.deleteById(id);

        }

        public LivroDTO buscarLivroPorId (Long id){
            Livro livro = livroRepository.findById(id).orElseThrow(() ->
                    new BussinesException("Livro não encontrado"));
            return converterLivroParaLivroDTO(livro);
        }

        public LivroDTO atualizarLivro (LivroDTO livroDTO){
            livroRepository.findById(livroDTO.getId());
            Livro livro = converterLivroDTOParaLivro(livroDTO);
            livroRepository.save(livro);
            return converterLivroParaLivroDTO(livro);
        }

        public LivroDTO buscarLivroPorNome (String nome){
            Livro livro = livroRepository.findByNome(nome);
            return converterLivroParaLivroDTO(livro);
        }
    }



