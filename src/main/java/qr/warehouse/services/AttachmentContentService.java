package qr.warehouse.services;

import org.springframework.web.multipart.MultipartHttpServletRequest;
import qr.warehouse.finaly.Result;

import javax.servlet.http.HttpServletResponse;

public interface AttachmentContentService {

    Result addAttachmentContent(MultipartHttpServletRequest request);

    void getAttachmentContent(Long attachmentContentId, HttpServletResponse response);

    Result deleteAttachment(Long attachmentContentId);
}