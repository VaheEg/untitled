package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.facade.CatFacade;
import org.example.domain.response.CatResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cats")
public class CatController {

    private final CatFacade catFacade;

    @GetMapping("/fact")
    public ResponseEntity<CatResponse> get() {

        final CatResponse catResponse = catFacade.get();
        final ResponseEntity<CatResponse> response = ResponseEntity.ok(catResponse);

        return response;
    }

    @GetMapping("/facts")
    public ResponseEntity<List<CatResponse>> getList() {

        final List<CatResponse> catResponseList = catFacade.getList();
        final ResponseEntity<List<CatResponse>> response = ResponseEntity.ok(catResponseList);

        return response;
    }
}
