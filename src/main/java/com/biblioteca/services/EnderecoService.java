package com.biblioteca.services;

import com.biblioteca.dtos.EnderecoDTO;
import com.biblioteca.exception.BussinesException;
import com.biblioteca.models.Comprador;
import com.biblioteca.models.Endereco;
import com.biblioteca.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    private static final String MSG_ENDERECO = "Endereco não encontrado";
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private CidadeService cidadeService;

    public EnderecoDTO buscarEnderecoPorId(Long id) {
        Endereco endereco = enderecoRepository.findById(id).orElseThrow(() ->
                new BussinesException("Endereco não encontrado"));
        return converterEnderecoParaEnderecoDTO(endereco);
    }

    public EnderecoDTO cadastrarEndereco(EnderecoDTO enderecoDTO) {
        Endereco endereco = converterEnderecoDTOParaEndereco(enderecoDTO);
        endereco = enderecoRepository.save(endereco);
        return converterEnderecoParaEnderecoDTO(endereco);

    }

    public EnderecoDTO converterEnderecoParaEnderecoDTO(Endereco endereco){
        EnderecoDTO enderecoDTO = new EnderecoDTO(endereco.getId(),
               endereco.getNumero(),
               endereco.getCep(),
               endereco.getRua(),
               endereco.getBairro(),
              cidadeService.buscarCidadePorId(endereco.getCidade().getId()));
        return enderecoDTO;
    }

    public Endereco converterEnderecoDTOParaEndereco(EnderecoDTO enderecoDTO){
        Endereco endereco = new Endereco(enderecoDTO.getId(),
                enderecoDTO.getNumero(),
                enderecoDTO.getCep(),
                enderecoDTO.getRua(),
                enderecoDTO.getBairro(),
               cidadeService.converterCidadeDTOParaCidade(enderecoDTO.getCidade()));
        return endereco;
    }

    public void deletarEndereco(Long id) {
        enderecoRepository.deleteById(id);
    }

    public EnderecoDTO atualizarEndereco(EnderecoDTO enderecoDTO){
        enderecoRepository.findById(enderecoDTO.getId());
        Endereco endereco = converterEnderecoDTOParaEndereco(enderecoDTO);
        enderecoRepository.save(endereco);
        return converterEnderecoParaEnderecoDTO(endereco);
    }
    public EnderecoDTO buscarEnderecoPorCep(String cep){
        Endereco endereco = enderecoRepository.findByCep(cep);
        return converterEnderecoParaEnderecoDTO(endereco);
    }


}