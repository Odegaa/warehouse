package qr.warehouse.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import qr.warehouse.finaly.Result;
import qr.warehouse.services.AttachmentContentService;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/attachment_content")
public class AttachmentContentController {

    private final AttachmentContentService service;

    @PostMapping
    private Result addAttachmentContent(MultipartHttpServletRequest request) {
        return service.addAttachmentContent(request);
    }

    @GetMapping("/{attachmentContentId}")
    private void getAttachmentContent(@PathVariable Long attachmentContentId, HttpServletResponse response) {
        service.getAttachmentContent(attachmentContentId, response);
    }

    @DeleteMapping("/{attachmentContentId}")
    private Result deleteAttachmentContent(@PathVariable Long attachmentContentId) {
        return service.deleteAttachment(attachmentContentId);
    }
}