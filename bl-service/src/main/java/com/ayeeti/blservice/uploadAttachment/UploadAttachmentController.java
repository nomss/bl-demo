package com.ayeeti.blservice.uploadAttachment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/attachments")
public class UploadAttachmentController {

    private final UploadAttachmentService uploadAttachmentService;

    public UploadAttachmentController(UploadAttachmentService uploadAttachmentService) {
        this.uploadAttachmentService = uploadAttachmentService;
    }

    @GetMapping
    public UploadAttachmentDTO getAttachment(UploadAttachmentRequest uploadAttachmentRequest) {
        return uploadAttachmentService.getUploadAttachment(uploadAttachmentRequest);
    }

    @PostMapping
    public UploadAttachmentDTO uploadAttachment(UploadAttachmentRequest uploadAttachmentRequest) {
        return uploadAttachmentService.uploadAttachment(uploadAttachmentRequest);
    }

}
