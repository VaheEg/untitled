package org.example.feign.client.response;

import lombok.Data;

@Data
public class CatClientResponse {
    private String fact;
    private int length;
}
