package com.biblioteca.resourses;

import com.biblioteca.dtos.CompradorDTO;
import com.biblioteca.services.CompradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/compradores")
public class CompradorResource {

    @Autowired
    private CompradorService compradorService;

    @GetMapping("/{id}")
    public  ResponseEntity<CompradorDTO> buscarCompradorPorId(@PathVariable Long id){
        return ResponseEntity.ok(compradorService.buscarCompradorPorId(id));
    }
    @PostMapping()
    public ResponseEntity<CompradorDTO> cadastrarComprador(@RequestBody CompradorDTO compradorDTO){
        CompradorDTO comprador = compradorService.cadastrarComprador(compradorDTO);
        return ResponseEntity.ok(comprador);
    }
    @DeleteMapping()
    public ResponseEntity<Void> deletarComprador(@RequestBody CompradorDTO compradorDTO){
        compradorService.deletarComprador(compradorDTO.getId());
        return ResponseEntity.noContent().build();
    }
    @PutMapping()
    public ResponseEntity<CompradorDTO> atualizarComprador(@RequestBody CompradorDTO compradorDTO){
        return ResponseEntity.ok(compradorService.atualizarComprador(compradorDTO));
    }
    @GetMapping("/buscar")
    public ResponseEntity<CompradorDTO> buscarCompradorPorEmail(@RequestParam String email){
        return ResponseEntity.ok(compradorService.buscarCompradorPorEmail(email));
    }
}
