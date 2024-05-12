package com.ayeeti.blservice.uploadAttachment;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UploadAttachmentRequest {

    private Long id;
    private String fileName;
    private String fileType;
    private byte[] fileContent;

}
