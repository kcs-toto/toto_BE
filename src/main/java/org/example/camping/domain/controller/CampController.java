package org.example.camping.domain.controller;

import lombok.RequiredArgsConstructor;
import org.example.camping.domain.service.CampService;
import org.example.camping.global.common.ResponseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/camping")
public class CampController {

    private final CampService campingService;

    @PostMapping("/info")
    public ResponseEntity<?> getCampingInfo() {
        try {
            campingService.getCampingInfo();
            return ResponseUtils.createResponse(HttpStatus.OK, "캠핑 정보 저장 성공");
        } catch (ParserConfigurationException | IOException | SAXException e) {
            return ResponseEntity.status(500).build();
        }
    }
}
