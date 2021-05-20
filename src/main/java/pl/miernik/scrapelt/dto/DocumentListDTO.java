package pl.miernik.scrapelt.documents;

import lombok.Builder;

@Builder

public class DocumentListDTO {

    private Long fileId;
    private String fileName;

    public DocumentListDTO(Long fileId, String fileName) {
        this.fileId = fileId;
        this.fileName = fileName;
    }

    public Long getFileId() {
        return fileId;
    }

    public DocumentListDTO setFileId(Long fileId) {
        this.fileId = fileId;
        return this;
    }

    public String getFileName() {
        return fileName;
    }

    public DocumentListDTO setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }
}

