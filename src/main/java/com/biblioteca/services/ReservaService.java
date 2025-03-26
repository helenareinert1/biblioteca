package com.biblioteca.services;

import com.biblioteca.dtos.ReservaDTO;
import com.biblioteca.exception.BussinesException;
import com.biblioteca.models.Reserva;
import com.biblioteca.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {

    private static final String MSG_RESERVA = "Reserva não encontrada";

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private CompradorService compradorService;

    public ReservaDTO cadastrarReserva(ReservaDTO reservaDTO){
        Reserva reserva = converterReservaDTOParaReserva(reservaDTO);
        reserva = reservaRepository.save(reserva);
        return converterReservaParaReservaDTO(reserva);
    }
    public ReservaDTO converterReservaParaReservaDTO (Reserva reserva){
        ReservaDTO reservaDTO = new ReservaDTO(
                reserva.getId(),
                reserva.getData(),
                reserva.getHora_inicio(),
                reserva.getHora_fim(),
                reserva.getDescricao(),
                reserva.getCategoria(),
                reserva.getCodigo(),
                reserva.getStatus(),
                compradorService.buscarCompradorPorId(reserva.getComprador().getId()));
        return reservaDTO;
    }
    public Reserva converterReservaDTOParaReserva (ReservaDTO reservaDTO){
        Reserva reserva = new Reserva(reservaDTO.getId(),
                reservaDTO.getData(),
                reservaDTO.getHora_inicio(),
                reservaDTO.getHora_fim(),
                reservaDTO.getDescricao(),
                reservaDTO.getCategoria(),
                reservaDTO.getCodigo(),
                reservaDTO.getStatus(),
                compradorService.converterCompradorDTOParaComprador(reservaDTO.getComprador()));
        return reserva;
    }
    public void deletarReserva (Long id){
        reservaRepository.deleteById(id);

    }

    public ReservaDTO buscarReservaPorId (Long id){
        Reserva reserva = reservaRepository.findById(id).orElseThrow(() ->
                new BussinesException("Reserva não encontrada"));
        return converterReservaParaReservaDTO(reserva);
    }

    public ReservaDTO atualizarReserva (ReservaDTO reservaDTO){
        reservaRepository.findById(reservaDTO.getId());
        Reserva reserva = converterReservaDTOParaReserva(reservaDTO);
        reservaRepository.save(reserva);
        return converterReservaParaReservaDTO(reserva);
    }

    public ReservaDTO buscarReservaPorDescricao (String descricao){
        Reserva reserva = reservaRepository. findByDescricao(descricao);
        return converterReservaParaReservaDTO(reserva);
    }
}
