package com.ayeeti.blservice.uploadAttachment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UploadAttachmentControllerTest {

    @Autowired
    private UploadAttachmentController uploadAttachmentController;

    @Test
    void getAttachment() {
        UploadAttachmentRequest uploadAttachmentRequest = UploadAttachmentRequest.builder()
                .id(1L)
                .build();
        UploadAttachmentDTO attachment = uploadAttachmentController.getAttachment(uploadAttachmentRequest);
        System.out.println(attachment.getFileName());
    }

    @Test
    void uploadAttachment() {
        UploadAttachmentRequest uploadAttachmentRequest = UploadAttachmentRequest.builder()
                .fileName("Test2")
                .fileType("txt")
                .fileContent("Hello World2".getBytes())
                .build();
        uploadAttachmentController.uploadAttachment(uploadAttachmentRequest);
    }

}