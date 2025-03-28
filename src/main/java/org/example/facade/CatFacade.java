package org.example.facade;

import org.example.domain.response.CatResponse;
import java.util.List;

public interface CatFacade {
    CatResponse get();
    List<CatResponse> getList();
}
