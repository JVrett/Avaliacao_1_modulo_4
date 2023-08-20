package br.com.tech4me.tech4music.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.tech4music.service.MusicaService;
import br.com.tech4me.tech4music.shared.MusicaDto;

@RestController
@RequestMapping("/musica")
public class MusicaController {

    @Autowired
    private MusicaService servico;

    @GetMapping
    public ResponseEntity<List<MusicaDto>> obterMusicas() {

        return new ResponseEntity<>(servico.obterTodasASMusicas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MusicaDto> obterMusicasPorId(@PathVariable String id) {

        if (servico.obterMusicaPorId(id).isPresent()) {
            return new ResponseEntity<>(servico.obterMusicaPorId(id).get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<MusicaDto> cadastarMusica(@RequestBody MusicaDto musica) {

        return new ResponseEntity<>(servico.cadastrarMusica(musica), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MusicaDto> atualizarMusica(@PathVariable String id, @RequestBody MusicaDto musica) {
        Optional<MusicaDto> musicaAtualizada = servico.atualizarMusicaPorId(id, musica);

        if (musicaAtualizada.isPresent()) {
            return new ResponseEntity<>(musicaAtualizada.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirMusicaPorId(@PathVariable String id) {
        servico.excluirMusicaPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
