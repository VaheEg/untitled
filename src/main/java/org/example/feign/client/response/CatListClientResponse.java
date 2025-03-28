package org.example.feign.client.response;

import lombok.Data;
import java.util.List;

@Data
public class CatListClientResponse {
    private List<CatClientResponse> data;
}
