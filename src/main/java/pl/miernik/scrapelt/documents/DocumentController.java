package pl.miernik.scrapelt.documents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.miernik.scrapelt.dto.DocumentDTO;
import pl.miernik.scrapelt.dto.DocumentListDTO;
import pl.miernik.scrapelt.dto.DocumentUploadDTO;
import pl.miernik.scrapelt.exception.FileNotFoundException;

import java.util.List;

@RestController
@RequestMapping("/file")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @PostMapping("/upload")
    public DocumentUploadDTO uploadFile(@RequestParam("file") MultipartFile multipartFile) {
        Document document = documentService.saveFile(multipartFile);
        DocumentUploadDTO response = new DocumentUploadDTO();
        if (document != null) {
            response.setId(document.getId());
            response.setFileType(document.getType());
            response.setUploadStatus(true);
            response.setMessage("File has been uploaded successfully!");
            return response;
        }
        response.setMessage("Something went wrong during the upload....");
        return response;
    }


    @GetMapping("/list")
    public List<DocumentListDTO> getList() {
        return documentService.getList();
    }

    @GetMapping("/get/{id}")
    public DocumentDTO getFile(@PathVariable Long id) {
        Document document = documentService.getFile(id)
                .orElseThrow(() -> new FileNotFoundException("File not found - id: " + id));
        return DocumentDTO.builder()
                .fileId(document.getId())
                .fileName(document.getName())
                .createdAt(document.getUploadTime())
                .build();

    }

    @GetMapping("/download/{id}")
    public ResponseEntity<Resource> downloadFile(@PathVariable Long id) {
        Document document = documentService.downloadFile(id);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(document.getType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; name= " + document.getName())
                .body(new ByteArrayResource(document.getContent()));
    }
}
