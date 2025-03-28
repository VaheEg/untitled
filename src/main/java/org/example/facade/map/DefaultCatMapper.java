package org.example.facade.map;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.response.CatResponse;
import org.example.feign.client.response.CatClientResponse;
import org.springframework.stereotype.Component;
import java.util.List;

@Slf4j
@Component
public class DefaultCatMapper implements CatMapper {
    @Override
    public CatResponse map(CatClientResponse catClientResponse) {
        log.info("Trying map cat client response to the cat response");

        CatResponse response = new CatResponse(catClientResponse.getFact(), catClientResponse.getLength());

        log.info("Successfully mapped cat client response to the cat response, cat response - {}", response);
        return response;
    }

    @Override
    public List<CatResponse> mapList(List<CatClientResponse> catClientResponseList) {
        log.info("Trying list of cat client response map to the list of cat response ");

        final List<CatResponse> mapedList = catClientResponseList
                .stream()
                .map(x -> {
                    return new CatResponse(x.getFact(), x.getLength());
                })
                .toList();

        log.info("Successfully mapped list of cat client response to the list of cat client, mapped list - {}", mapedList);
        return mapedList;
    }
}
