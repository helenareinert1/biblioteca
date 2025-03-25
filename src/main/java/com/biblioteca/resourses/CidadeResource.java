package com.biblioteca.resourses;

import com.biblioteca.dtos.CidadeDTO;
import com.biblioteca.services.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cidades")
public class CidadeResource {

    @Autowired
    private CidadeService cidadeService;

    @GetMapping("/{id}")
    public ResponseEntity<CidadeDTO> buscarCidadePorId(@PathVariable Long id) {
        return ResponseEntity.ok(cidadeService.buscarCidadePorId(id));
    }

    @PostMapping()
    public ResponseEntity<CidadeDTO> cadastrarCidade(@RequestBody CidadeDTO cidadeDTO) {
        CidadeDTO cidade = cidadeService.cadastrarCidade(cidadeDTO);
        return ResponseEntity.ok(cidade);
    }

    @DeleteMapping()
    public ResponseEntity<Void> deletarCidade(@RequestBody CidadeDTO cidadeDTO) {
        cidadeService.deletarCidade(cidadeDTO.getId());
        return ResponseEntity.noContent().build();
    }

    @PutMapping()
    public ResponseEntity<CidadeDTO> atualizarCidade(@RequestBody CidadeDTO cidadeDTO) {
        return ResponseEntity.ok(cidadeService.atualizarCidade(cidadeDTO));
    }

    @GetMapping("/buscar")
    public ResponseEntity<CidadeDTO> buscarCidadePorNome(@RequestParam String nome) {
        return ResponseEntity.ok(cidadeService.buscarCidadePorNome(nome));
    }
}



