package org.example.camping.domain.controller;

import lombok.RequiredArgsConstructor;
import org.example.camping.domain.service.CampService;
import org.example.camping.global.common.ResponseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/camping")
public class CampController {

    private final CampService campingService;

    @PostMapping("/info")
    public ResponseEntity<?> createCampingInfo() {
        try {
            campingService.createCampingInfo();
            return ResponseUtils.createResponse(HttpStatus.OK, "캠핑 정보 저장 성공");
        } catch (ParserConfigurationException | IOException | SAXException e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/info")
    public ResponseEntity<?> getCampingInfo() {
        return ResponseUtils.createResponse(HttpStatus.OK, "캠핑 정보 조회 성공", campingService.getCampingInfo());
    }

    @GetMapping("/info/{id}")
    public ResponseEntity<?> getCampingInfoById(@PathVariable Long id) {
        return ResponseUtils.createResponse(HttpStatus.OK, "캠핑 정보 조회 성공", campingService.getCampingInfoById(id));

    }
}
