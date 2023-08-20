package br.com.tech4me.tech4music.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.tech4music.model.Musica;
import br.com.tech4me.tech4music.repository.MusicaRepository;
import br.com.tech4me.tech4music.shared.MusicaDto;

@Service
public class MusicaServiceImpl implements MusicaService {
    @Autowired
    private MusicaRepository repositorio;

    @Override
    public List<MusicaDto> obterTodasASMusicas() {

        return repositorio.findAll()
                .stream()
                .map(p -> new MusicaDto(p.getId(), p.getNome(), p.getArtista(), p.getAlbum(), p.getGenero(),
                        p.getAnoLancamento(),
                        p.getCompositor()))
                .toList();
    }

    @Override
    public Optional<MusicaDto> obterMusicaPorId(String id) {
        Optional<Musica> musica = repositorio.findById(id);

        if (musica.isPresent()) {
            return Optional.of(new MusicaDto(musica.get().getId(), musica.get().getNome(), musica.get().getArtista(),
                    musica.get().getAlbum(), musica.get().getGenero(), musica.get().getAnoLancamento(),
                    musica.get().getCompositor()));

        }
        return Optional.empty();

    }

    @Override
    public MusicaDto cadastrarMusica(MusicaDto musica) {
        Musica music = new Musica(musica);

        repositorio.save(music);
        return new MusicaDto(music.getId(), music.getNome(), music.getArtista(), music.getAlbum(), music.getGenero(),
                music.getAnoLancamento(), music.getCompositor());

    }

    @Override
    public Optional<MusicaDto> atualizarMusicaPorId(String id, MusicaDto musica) {
        Optional<Musica> music = repositorio.findById(id);

        if (music.isPresent()) {
            Musica musicaAtualizada = new Musica(musica);
            musicaAtualizada.setId(id);
            repositorio.save(musicaAtualizada);
            return Optional.of(new MusicaDto(musicaAtualizada.getId(), musicaAtualizada.getNome(),
                    musicaAtualizada.getArtista(), musicaAtualizada.getAlbum(), musicaAtualizada.getGenero(),
                    musicaAtualizada.getAnoLancamento(),
                    musicaAtualizada.getCompositor()));
        }
        return Optional.empty();

    }

    @Override
    public void excluirMusicaPorId(String id) {

        repositorio.deleteById(id);

    }

}
