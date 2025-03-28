package org.example.facade;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.response.CatResponse;
import org.example.facade.map.CatMapper;
import org.example.feign.client.CatClient;
import org.example.feign.client.response.CatClientResponse;
import org.example.feign.client.response.CatListClientResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class DefaultCatFacade implements CatFacade {

    private final CatClient catClient;
    private final CatMapper catMapper;
    @Override
    public CatResponse get() {
        log.info("Received request for getting fact");

        final ResponseEntity<CatClientResponse> catClientResponseResponseEntity = catClient.get();
        final CatClientResponse catClientResponse = catClientResponseResponseEntity.getBody();
        final CatResponse response = catMapper.map(catClientResponse);

        log.info("Successfully received response for get request, response - {}", response);
        return response;
    }

    @Override
    public List<CatResponse> getList() {
        log.info("Received request for getting facts");

        final ResponseEntity<CatListClientResponse> catsResponse = catClient.getCats();
        final CatListClientResponse cats = catsResponse.getBody();
        final List<CatResponse> response = catMapper.mapList(cats.getData());

        log.info("Successfully received response for get facts, response - {}", response);
        return response;
    }
}
