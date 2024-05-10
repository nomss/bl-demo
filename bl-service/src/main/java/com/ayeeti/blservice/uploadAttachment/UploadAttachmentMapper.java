package com.ayeeti.blservice.uploadAttachment;

public class UploadAttachmentMapper {

    public static UploadAttachment mapFromUploadAttachmentRequestToUploadAttachment(UploadAttachmentRequest uploadAttachmentRequest) {
        return UploadAttachment.builder()
                .fileName(uploadAttachmentRequest.getFileName())
                .fileType(uploadAttachmentRequest.getFileType())
                .fileContent(uploadAttachmentRequest.getFileContent())
                .build();
    }

    public static UploadAttachmentDTO mapFromUploadAttachmentToUploadAttachmentDTO(UploadAttachment uploadAttachment) {
        return UploadAttachmentDTO.builder()
                .id(uploadAttachment.getId())
                .fileName(uploadAttachment.getFileName())
                .fileType(uploadAttachment.getFileType())
                .fileContent(uploadAttachment.getFileContent())
                .build();

    }

}
