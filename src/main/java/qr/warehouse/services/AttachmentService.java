package qr.warehouse.services;

import qr.warehouse.finaly.Result;
import qr.warehouse.models.Attachment;

import java.util.List;

public interface AttachmentService {

    Result addAttachment(Attachment attachment);

    List<Attachment> getAttachments();

    Result updateAttachment(Long attachmentId, Attachment attachment);

    Result deleteAttachment(Long attachmentId);

    Attachment getAttachmentById(Long attachmentId);
}