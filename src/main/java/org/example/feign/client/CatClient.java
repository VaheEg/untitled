package org.example.feign.client;

import org.example.feign.client.response.CatClientResponse;
import org.example.feign.client.response.CatListClientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "CatClient", url = "https://catfact.ninja")
public interface CatClient {

    @GetMapping("/fact")
    ResponseEntity<CatClientResponse> get();

    @GetMapping("/facts")
    ResponseEntity<CatListClientResponse> getCats();
}
