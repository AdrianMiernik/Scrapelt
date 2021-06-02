package pl.miernik.scrapelt.dto;

import lombok.Builder;

@Builder

public class DocumentListDTO {

    private Long id;
    private String name;

    public DocumentListDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public DocumentListDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public DocumentListDTO setName(String name) {
        this.name = name;
        return this;
    }
}

