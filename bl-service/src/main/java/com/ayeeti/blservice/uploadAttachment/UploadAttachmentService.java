package com.ayeeti.blservice.uploadAttachment;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UploadAttachmentService {

    private final IUploadAttachmentRepository uploadAttachmentRepository;
    public UploadAttachmentService(IUploadAttachmentRepository uploadAttachmentRepository) {
        this.uploadAttachmentRepository = uploadAttachmentRepository;
    }

    public UploadAttachmentDTO uploadAttachment(UploadAttachmentRequest uploadAttachmentRequest) {
        UploadAttachment uploadAttachment = UploadAttachmentMapper.mapFromUploadAttachmentRequestToUploadAttachment(uploadAttachmentRequest);
        UploadAttachment attachment = uploadAttachmentRepository.save(uploadAttachment);
        return UploadAttachmentMapper.mapFromUploadAttachmentToUploadAttachmentDTO(attachment);
    }

    public UploadAttachmentDTO getUploadAttachment(UploadAttachmentRequest uploadAttachmentRequest) {
        if (uploadAttachmentRequest != null && uploadAttachmentRequest.getId() != null) {
            Optional<UploadAttachment> uploadAttachment = uploadAttachmentRepository.findById(uploadAttachmentRequest.getId());
            if (uploadAttachment.isPresent()) {
                return UploadAttachmentMapper.mapFromUploadAttachmentToUploadAttachmentDTO(uploadAttachment.get());
            }
        }
        return UploadAttachmentDTO.builder()
                .errorMessage("Attachment could not be found.")
                .build();
    }

}
