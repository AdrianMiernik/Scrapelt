package pl.miernik.scrapelt.documents;

import lombok.Builder;

import java.util.Date;

@Builder
public class DocumentDTO {
    private Long fileId;
    private String fileName;
    private Date createdAt;

    public Long getFileId() {
        return fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }


}
