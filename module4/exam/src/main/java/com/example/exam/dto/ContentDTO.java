package com.example.exam.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class ContentDTO {
    private Integer id;
    @NotNull(message = "Khong duoc de trong !!!")
    @Size(min=5, max = 100, message = "Tieu de phai tu 5 den 100 ki tu")
    private String title;
    @NotNull(message = "Khong duoc de trong !!!")
    @Size(min=10, max = 500, message = "Noi dung phai tu 10 den 500 ki tu")
    private String content;
    private String answer;

    private Integer typeId;

    private String date;
    private Integer status;

    public ContentDTO() {
    }

    public ContentDTO(Integer id, String title, String content, String answer, Integer typeId, String date, Integer status) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.answer = answer;
        this.typeId = typeId;
        this.date = date;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
