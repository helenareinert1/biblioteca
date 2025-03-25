package com.biblioteca.resourses;


import com.biblioteca.dtos.LivroDTO;
import com.biblioteca.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/livros")
public class LivroResource {

    @Autowired
    private LivroService livroService;

    @GetMapping("/{id}")
    public ResponseEntity<LivroDTO> buscarLivroPorId(@PathVariable Long id) {
        return ResponseEntity.ok(livroService.buscarLivroPorId(id));
    }

    @PostMapping()
    public ResponseEntity<LivroDTO> cadastrarLivro(@RequestBody LivroDTO livroDTO) {
        LivroDTO livro = livroService.cadastrarLivro(livroDTO);
        return ResponseEntity.ok(livro);
    }

    @DeleteMapping()
    public ResponseEntity<Void> deletarLivro(@RequestBody LivroDTO livroDTO) {
        livroService.deletarLivro(livroDTO.getId());
        return ResponseEntity.noContent().build();
    }

    @PutMapping()
    public ResponseEntity<LivroDTO> atualizarLivro(@RequestBody LivroDTO livroDTO) {
        return ResponseEntity.ok(livroService.atualizarLivro(livroDTO));
    }

    @GetMapping("/buscar")
    public ResponseEntity<LivroDTO> buscarLivroPorNome(@RequestParam String nome) {
        return ResponseEntity.ok(livroService.buscarLivroPorNome(nome));
    }
}



