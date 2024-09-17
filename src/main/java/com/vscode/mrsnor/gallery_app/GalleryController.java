package com.vscode.mrsnor.gallery_app;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.vscode.mrsnor.gallery_app.model.Photo;
import com.vscode.mrsnor.gallery_app.service.PhotosService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
public class GalleryController {

    private final PhotosService photosService;

    public GalleryController(PhotosService photosService) {
        this.photosService = photosService;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello Mom!";
    }

    @GetMapping("/photos")
    public Iterable<Photo> get() {
        return photosService.get();
    }

    @GetMapping("/photos/{id}")
    public Photo get(@PathVariable Integer id) {
        Photo photo = photosService.get(id);
        if (photo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return photosService.get(id);
    }

    @DeleteMapping("/photos/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        photosService.remove(id);

        System.out.println("Photo deleted: " + id);

        // return a custom success message saying image <id> was deleted
        return ResponseEntity.ok().build();
    }

    @PostMapping("/photos")
    public Photo create(@RequestPart("photo") MultipartFile file) throws IOException {

        return photosService.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());
    }
}
