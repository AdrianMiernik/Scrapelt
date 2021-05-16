package pl.miernik.scrapelt.documents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentService {
    @Autowired
    private DocumentRepository documentRepository;

    public Document saveFile(MultipartFile multipartfile) {
        Document document = new Document();
        try {
            document.setName(multipartfile.getOriginalFilename());
            document.setType(multipartfile.getContentType());
            document.setUploadTime(new Date());
            document.setContent(multipartfile.getBytes());
           return documentRepository.save(document);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Optional<Document> getFile(Long id) {
        return documentRepository.findById(id);
    }

    public List<Document> getListOfFiles() {
        return documentRepository.findAll();
    }

    public Document downloadFile(Long id) {
        Document document = documentRepository.getOne(id);
        return document;
    }
}
