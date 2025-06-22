package com.example.recipe.app.aa03.controller;

import com.example.recipe.app.aa03.service.CsvService;
import com.example.recipe.common.controller.BaseController;
import com.example.recipe.common.dto.response.BaseResDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@AllArgsConstructor
public class UploadController extends BaseController {

    private CsvService csvService;

    @PostMapping("/api/upload")
    public BaseResDto upload(@RequestParam("file") MultipartFile file) throws Exception {
        csvService.processCsv(file);
        return new BaseResDto();
    }
}

