package com.biblioteca.resourses;

import com.biblioteca.dtos.EnderecoDTO;
import com.biblioteca.models.Endereco;
import com.biblioteca.services.CompradorService;
import com.biblioteca.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoResource {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDTO> buscarEnderecoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(enderecoService.buscarEnderecoPorId(id));
    }
    @PostMapping()
    public ResponseEntity<EnderecoDTO> cadastrarEndereco(@RequestBody EnderecoDTO enderecoDTO) {
        EnderecoDTO endereco = enderecoService.cadastrarEndereco(enderecoDTO);
        return ResponseEntity.ok(endereco);
    }
    @DeleteMapping()
    public ResponseEntity<Void> deletarEndereco(@RequestBody EnderecoDTO enderecoDTO) {
        enderecoService.deletarEndereco(enderecoDTO.getId());
        return ResponseEntity.noContent().build();
    }
    @PutMapping()
    public ResponseEntity<EnderecoDTO> atualizarEndereco(@RequestBody EnderecoDTO enderecoDTO){
        return ResponseEntity.ok(enderecoService.atualizarEndereco(enderecoDTO));
    }
    @GetMapping("/buscar")
    public ResponseEntity<EnderecoDTO> buscarEnderecoPorCep(@RequestParam String cep){
        return ResponseEntity.ok(enderecoService.buscarEnderecoPorCep(cep));
    }
}