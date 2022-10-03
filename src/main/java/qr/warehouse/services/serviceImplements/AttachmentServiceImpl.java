package qr.warehouse.services.serviceImplements;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import qr.warehouse.finaly.Result;
import qr.warehouse.models.Attachment;
import qr.warehouse.repositories.AttachmentRepository;
import qr.warehouse.services.AttachmentService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AttachmentServiceImpl implements AttachmentService {

    private final AttachmentRepository repository;

    @Override
    public Result addAttachment(Attachment attachment) {
        try {
            boolean generationName =
                    repository.existsByGenerationName(attachment.getGenerationName());
            if (generationName) {
                return new Result("Attachment is already exist", false);
            } else {
                Attachment newAttachment = new Attachment();
                newAttachment.setOriginalName(attachment.getOriginalName());
                newAttachment.setSize(attachment.getSize());
                newAttachment.setContentType(attachment.getContentType());
                newAttachment.setGenerationName(attachment.getGenerationName());

                repository.save(newAttachment);
                return new Result("Successfully saved!", true);
            }
        } catch (Exception e) {
            return new Result("An error occurred!", false);
        }
    }

    @Override
    public List<Attachment> getAttachments() {
        return repository.findAll();
    }

    @Override
    public Result updateAttachment(Long attachmentId, Attachment attachment) {
        Optional<Attachment> optionalAttachment = repository.findById(attachmentId);
        if (optionalAttachment.isPresent()) {
            Attachment updatingAttachment = optionalAttachment.get();
            updatingAttachment.setOriginalName(attachment.getOriginalName());
            updatingAttachment.setSize(attachment.getSize());
            updatingAttachment.setContentType(attachment.getContentType());
            updatingAttachment.setGenerationName(attachment.getGenerationName());

            repository.save(updatingAttachment);
            return new Result("Attachment successfully updated!", true);
        }
        return new Result("Attachment is not found or Exception!", false);
    }

    @Override
    public Result deleteAttachment(Long attachmentId) {
        Optional<Attachment> optionalAttachment = repository.findById(attachmentId);
        if (optionalAttachment.isPresent()) {
            repository.deleteById(attachmentId);
            return new Result("Attachment deleted!", true);
        }
        return new Result("Attachment not found or Exception!", false);
    }

    @Override
    public Attachment getAttachmentById(Long attachmentId) {
        return repository.findById(attachmentId).orElse(null);
    }
}