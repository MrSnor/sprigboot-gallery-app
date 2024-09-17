package com.vscode.mrsnor.gallery_app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Table("PHOTOS")
public class Photo {

    @Id
    private Integer id;

    @NotEmpty
    private String fileName;

    private static final String DEFAULT_CONTENT_TYPE = "image/jpeg";

    private String contentType = DEFAULT_CONTENT_TYPE;

    // @JsonIgnore
    private byte[] data;

    public Photo() {
    }

    // raw data
    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public void setContentType(String fileType) {
        this.contentType = fileType;
    }

    public String getContentType() {
        return contentType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
