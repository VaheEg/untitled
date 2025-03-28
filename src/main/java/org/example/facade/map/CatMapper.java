package org.example.facade.map;

import org.example.domain.response.CatResponse;
import org.example.feign.client.response.CatClientResponse;
import java.util.List;

public interface CatMapper {

    CatResponse map(CatClientResponse catClientResponse);

    List<CatResponse> mapList(List<CatClientResponse> catClientResponseList);

}
