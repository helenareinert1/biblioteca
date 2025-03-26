package com.biblioteca.resourses;

import com.biblioteca.dtos.ReservaDTO;
import com.biblioteca.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservas")
public class ReservaResource {
    @Autowired
    private ReservaService reservaService;

    @GetMapping("/{id}")
    public ResponseEntity<ReservaDTO> buscarReservaPorId(@PathVariable Long id) {
            return ResponseEntity.ok(reservaService.buscarReservaPorId(id));
    }
    @PostMapping()
    public ResponseEntity<ReservaDTO> cadastrarReserva(@RequestBody ReservaDTO reservaDTO) {
       return ResponseEntity.ok(reservaService.cadastrarReserva(reservaDTO));
    }

    @DeleteMapping()
    public ResponseEntity<Void> deletarReserva(@RequestBody ReservaDTO reservaDTO) {
        reservaService.deletarReserva(reservaDTO.getId());
        return ResponseEntity.noContent().build();

}
    @PutMapping()
    public ResponseEntity<ReservaDTO> atualizarReserva(@RequestBody ReservaDTO reservaDTO) {
        return ResponseEntity.ok(reservaService.atualizarReserva(reservaDTO));
    }
    @GetMapping("/buscar")
    public ResponseEntity<ReservaDTO> buscarReservaPorDescricao(@RequestParam String descricao) {
        return ResponseEntity.ok(reservaService.buscarReservaPorDescricao(descricao));
    }
}

