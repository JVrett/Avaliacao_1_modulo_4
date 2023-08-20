package br.com.tech4me.tech4music.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.tech4music.shared.MusicaDto;

public interface MusicaService {
    List<MusicaDto> obterTodasASMusicas();

    Optional<MusicaDto> obterMusicaPorId(String id);

    MusicaDto cadastrarMusica(MusicaDto musica);

    Optional<MusicaDto> atualizarMusicaPorId(String id, MusicaDto musica);

    void excluirMusicaPorId(String id);

}
