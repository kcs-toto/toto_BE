package org.example.camping.domain.service;

import lombok.RequiredArgsConstructor;
import org.example.camping.domain.entity.StarLandmark;
import org.example.camping.domain.repository.StarLandmarkRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StarLandmarkService {
    private final StarLandmarkRepository starLandmarkRepository;

    public List<StarLandmark> getLandmarkInfo() {
        return starLandmarkRepository.findAll();
    }

    public StarLandmark getLandmarkInfoById(Long id) {
        System.out.println("id: " + id);
        StarLandmark landmark = starLandmarkRepository.findById(id).orElse(null);
        System.out.println(landmark);
        return starLandmarkRepository.findById(id).orElse(null);
    }

}
