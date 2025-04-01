package com.biblioteca.services;

import com.biblioteca.dtos.CompradorDTO;
import com.biblioteca.exception.BussinesException;
import com.biblioteca.models.Comprador;
import com.biblioteca.repositories.CompradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompradorService {

    private static final String MSG_CIDADE = "Comprador não encontrada";

    @Autowired
    private CompradorRepository compradorRepository;

    public CompradorDTO cadastrarComprador(CompradorDTO compradorDTO){
        Comprador comprador = converterCompradorDTOParaComprador(compradorDTO);
        comprador = compradorRepository.save(comprador);
        return converterCompradorParaCompradorDTO(comprador);
    }

    public CompradorDTO converterCompradorParaCompradorDTO(Comprador comprador){
        CompradorDTO compradorDTO = new CompradorDTO(comprador.getId(),
                comprador.getNome(),
                comprador.getEndereco(),
                comprador.getCpf(),
                comprador.getEmail(),
                comprador.getDataNascimento());
        return compradorDTO;
    }

    public Comprador converterCompradorDTOParaComprador(CompradorDTO compradorDTO){
        Comprador comprador = new Comprador(compradorDTO.getId(),
                compradorDTO.getNome(),
                compradorDTO.getEndereco(),
                compradorDTO.getCpf(),
                compradorDTO.getEmail(),
                compradorDTO.getDataNascimento());
        return comprador;
    }

    public void deletarComprador(Long id){
        compradorRepository.deleteById(id);
    }

    public CompradorDTO buscarCompradorPorId(Long id){
        Comprador comprador = compradorRepository.findById(id)
                .orElseThrow(() ->
                        new BussinesException("Comprador não encontrada"));
        return converterCompradorParaCompradorDTO(comprador);
    }

    public CompradorDTO atualizarComprador(CompradorDTO compradorDTO){
        compradorRepository.findById(compradorDTO.getId())
                .orElseThrow(() ->
                        new BussinesException("Comprador não encontrada"));
        Comprador comprador = converterCompradorDTOParaComprador(compradorDTO);
        compradorRepository.save(comprador);
        return converterCompradorParaCompradorDTO(comprador);
    }

    public CompradorDTO buscarCompradorPorEmail(String email){
        Comprador comprador = compradorRepository.findByEmail(email);
        return converterCompradorParaCompradorDTO(comprador);
    }
}
