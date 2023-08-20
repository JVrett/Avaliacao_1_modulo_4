package br.com.tech4me.tech4music.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import br.com.tech4me.tech4music.shared.MusicaDto;

@Document("musicas")
public class Musica {

    @Id
    private String id;

    private String nome;
    private String artista;
    private String genero;
    private Integer anoLancamento;
    private String compositor;

    public Musica(MusicaDto dto) {
        setId(dto.id());
        setNome(dto.nome());
        setArtista(dto.artista());
        setGenero(dto.genero());
        setAnoLancamento(dto.anoLancamento());
        setCompositor(dto.compositor());
    }

    public Musica() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getCompositor() {
        return compositor;
    }

    public void setCompositor(String compositor) {
        this.compositor = compositor;
    }

}
