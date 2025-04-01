package com.biblioteca.services;

import com.biblioteca.dtos.CidadeDTO;
import com.biblioteca.exception.BussinesException;
import com.biblioteca.models.Cidade;
import com.biblioteca.repositories.CidadeRepository;
import com.biblioteca.specs.CidadeSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CidadeService {

    @Autowired
    CidadeSpec cidadeSpec;
    @Autowired
    CidadeRepository cidadeRepository;

    public CidadeDTO cadastrarCidade(CidadeDTO cidadeDTO) {

        Cidade nomeCidade = cidadeRepository.findByNome(cidadeDTO.getNome());
        cidadeSpec.verificarSeExisteCidadeComNomeDuplicado(nomeCidade);


        Cidade cidade = converterCidadeDTOParaCidade(cidadeDTO);
        cidade = cidadeRepository.save(cidade);
        return converterCidadeParaCidadeDTO(cidade);
    }
    public Cidade converterCidadeDTOParaCidade(CidadeDTO cidadeDTO) {
        Cidade cidade = new Cidade();
        cidade.setId(cidadeDTO.getId());
        cidade.setNome(cidadeDTO.getNome());
       cidade.setEstado(cidadeDTO.getEstado());
        return cidade;
    }

    public CidadeDTO converterCidadeParaCidadeDTO(Cidade cidade) {
        CidadeDTO cidadeDTO = new CidadeDTO();
        cidadeDTO.setId(cidade.getId());
        cidadeDTO.setNome(cidade.getNome());
        cidadeDTO.setEstado(cidade.getEstado());
        return cidadeDTO;

    }

    public void deletarCidade(Long id) {
        cidadeRepository.deleteById(id);
    }

    public CidadeDTO buscarCidadePorId (Long id){
        Cidade cidade = cidadeRepository.findById(id)
                .orElseThrow(() -> new BussinesException("Usuário não encontrado"));
              return converterCidadeParaCidadeDTO(cidade);
        }

        public CidadeDTO atualizarCidade (CidadeDTO cidadeDTO){
            cidadeRepository.findById(cidadeDTO.getId())
                    .orElseThrow(() ->
                            new BussinesException("Cidade não encontrada"));
            Cidade cidade = converterCidadeDTOParaCidade(cidadeDTO);
            cidadeRepository.save(cidade);
            return converterCidadeParaCidadeDTO(cidade);
        }

        public CidadeDTO buscarCidadePorNome(String nome){
            Cidade cidade = cidadeRepository.findByNome(nome);
            return converterCidadeParaCidadeDTO(cidade);
    }
}
