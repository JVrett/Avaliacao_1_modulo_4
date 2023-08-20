package br.com.tech4me.tech4music.shared;

public record MusicaDto(
                String id,
                String nome,
                String artista,
                String album,
                String genero,
                Integer anoLancamento,
                String compositor) {

}
