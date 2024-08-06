package org.example.camping.domain.controller;

import lombok.RequiredArgsConstructor;
import org.example.camping.domain.service.StarLandmarkService;
import org.example.camping.global.common.ResponseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/landmark")
@RequiredArgsConstructor
public class StarLandmarkController {

    private final StarLandmarkService starLandmarkService;

    @GetMapping("/info")
    public ResponseEntity<?> getLandmarkInfo() {
        return ResponseUtils.createResponse(HttpStatus.OK, "랜드마크 정보 조회 성공", starLandmarkService.getLandmarkInfo());
    }

    @GetMapping("/info/{id}")
    public ResponseEntity<?> getLandmarkInfoById(@PathVariable Long id) {
        return ResponseUtils.createResponse(HttpStatus.OK, "랜드마크 단일 정보 조회 성공", starLandmarkService.getLandmarkInfoById(id));
    }
}
