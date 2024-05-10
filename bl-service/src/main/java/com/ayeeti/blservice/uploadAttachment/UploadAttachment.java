package com.ayeeti.blservice.uploadAttachment;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "UPLOAD_ATTACHMENT")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UploadAttachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "file_name", nullable = false, length = 255)
    private String fileName;

    @Column(name = "file_type", nullable = false, length = 50)
    private String fileType;

    @Lob
    @Column(name = "file_content", nullable = false)
    private byte[] fileContent;


}
