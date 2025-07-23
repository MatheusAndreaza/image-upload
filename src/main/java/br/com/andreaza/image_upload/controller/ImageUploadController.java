package br.com.andreaza.image_upload.controller;

import br.com.andreaza.image_upload.service.ImageUploadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/uploads")
public class ImageUploadController {

    private ImageUploadService imageUploadService;

    public ImageUploadController(ImageUploadService imageUploadService) {
        this.imageUploadService = imageUploadService;
    }

    @PostMapping
    public ResponseEntity<String> uploadImage(@RequestParam MultipartFile img) {

        try {
            String resultado = imageUploadService.saveImage(img);
            return ResponseEntity.ok(resultado);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Erro ao salvar a imagem : " + e.getMessage());
        }
        
    }
}
