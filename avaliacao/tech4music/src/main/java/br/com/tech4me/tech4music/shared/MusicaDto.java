package br.com.tech4me.tech4music.shared;

public record MusicaDto(
        String id,
        String nome,
        String artista,
        String genero,
        Integer anoLancamento,
        String compositor) {

}
