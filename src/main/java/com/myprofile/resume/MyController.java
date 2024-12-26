package com.myprofile.resume;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class MyController {

    @GetMapping("/resume")
    public ResponseEntity<byte[]> getPdf() throws IOException {
        // Load the PDF from the resources/static directory
        var pdfFile = new ClassPathResource("static/resume.pdf");

        byte[] pdfBytes = pdfFile.getInputStream().readAllBytes();

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"resume.pdf\"")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfBytes);
    }
}
