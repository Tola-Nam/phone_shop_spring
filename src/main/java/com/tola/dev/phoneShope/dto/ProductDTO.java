package com.tola.dev.phoneShope.dto;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductDTO {

    @JsonProperty("model_id")
    @NotNull(message = "modelId is required")
    private Long modelId;   // ✅ wrapper, no default

    @JsonProperty("color_id")
    @NotNull(message = "colorId is required")
    private Long colorId;   // ✅ wrapper, no default
}
