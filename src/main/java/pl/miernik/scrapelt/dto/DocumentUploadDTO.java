package pl.miernik.scrapelt.dto;

public class DocumentUploadDTO {
    private Long id;
    private String fileType;
    private String message;
    private boolean uploadStatus;

    public Long getId() {
        return id;
    }

    public DocumentUploadDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFileType() {
        return fileType;
    }

    public DocumentUploadDTO setFileType(String fileType) {
        this.fileType = fileType;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public DocumentUploadDTO setMessage(String message) {
        this.message = message;
        return this;
    }

    public boolean isUploadStatus() {
        return uploadStatus;
    }

    public DocumentUploadDTO setUploadStatus(boolean uploadStatus) {
        this.uploadStatus = uploadStatus;
        return this;
    }
}
