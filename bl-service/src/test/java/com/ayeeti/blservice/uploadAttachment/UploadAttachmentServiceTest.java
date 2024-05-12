package com.ayeeti.blservice.uploadAttachment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UploadAttachmentServiceTest {

    @Autowired
    private UploadAttachmentService uploadAttachmentService;

    @Test
    void uploadAttachment() {
        UploadAttachmentRequest uploadAttachmentRequest = UploadAttachmentRequest.builder()
                .fileName("Test")
                .fileType("txt")
                .fileContent("Hello World".getBytes())
                .build();
        uploadAttachmentService.uploadAttachment(uploadAttachmentRequest);
    }

}