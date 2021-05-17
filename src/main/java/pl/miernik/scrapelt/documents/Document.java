package pl.miernik.scrapelt.documents;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "documents")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 256, nullable = false, unique = true)
    private String name;

    private String type;

    @Column(name = "upload_time")
    private Date uploadTime;

    @Lob
    private byte[] content;


    public Document() {
    }

    public Document(String name, String type, Date uploadTime, byte[] content) {
        this.name = name;
        this.type = type;
        this.uploadTime = uploadTime;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public Document setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Document setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public Document setType(String type) {
        this.type = type;
        return this;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public Document setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
        return this;
    }

    public byte[] getContent() {
        return content;
    }

    public Document setContent(byte[] content) {
        this.content = content;
        return this;
    }
}
