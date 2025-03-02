package com.example.sem62ex.controller;

import com.example.sem62ex.model.Reader;
import com.example.sem62ex.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reader")
@RequiredArgsConstructor
public class ReaderController {
    private final ReaderRepository readerRepository;

    @GetMapping
    public List<Reader> getAll() {
        return readerRepository.findAll();
    }

    @PostMapping
    public Reader createReader(@RequestBody Reader reader) {
        return readerRepository.save(reader);
    }
}
