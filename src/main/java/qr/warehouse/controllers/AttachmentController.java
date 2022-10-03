package qr.warehouse.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import qr.warehouse.finaly.Result;
import qr.warehouse.models.Attachment;
import qr.warehouse.services.AttachmentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/attachment")
public class AttachmentController {

    private final AttachmentService service;

    @PostMapping
    private Result addAttachment(@RequestBody Attachment attachment) {
        return service.addAttachment(attachment);
    }

    @GetMapping
    private List<Attachment> getAllAttachments() {
        return service.getAttachments();
    }

    @GetMapping("/{attachmentId}")
    private Attachment getAttachmentById(@PathVariable Long attachmentId) {
        return service.getAttachmentById(attachmentId);
    }

    @PutMapping("/{attachmentId}")
    private Result updateAttachment(@PathVariable Long attachmentId,
                                    @RequestBody Attachment attachment) {
        return service.updateAttachment(attachmentId, attachment);
    }

    @DeleteMapping("/{attachmentId}")
    private Result deleteAttachment(@PathVariable Long attachmentId) {
        return service.deleteAttachment(attachmentId);
    }

}