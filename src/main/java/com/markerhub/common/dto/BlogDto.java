package com.markerhub.common.dto;

import javax.validation.constraints.NotBlank;

public class BlogDto {
    @NotBlank
    private Long userId;

    @NotBlank
    private String title;
}
