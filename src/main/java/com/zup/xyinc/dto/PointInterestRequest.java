package com.zup.xyinc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PointInterestRequest {

    @NotEmpty(message = "O nome não pode estar vazio")
    private String name;

    @NotNull(message = "A coordenada X não pode estar vazia")
    @Min(value = 0L, message = "A coordenada X deve ser maior que 0 (zero)")
    private Long coordinateX;

    @NotNull(message = "A coordenada Y não pode estar vazia")
    @Min(value = 0L, message = "A coordenada Y deve ser maior que 0 (zero)")
    private Long coordinateY;
}
