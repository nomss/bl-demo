package com.ayeeti.blservice.uploadAttachment;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UploadAttachmentDTO {
    private Long id;
    private String fileName;
    private String fileType;
    private byte[] fileContent;
    private String errorMessage;
}
