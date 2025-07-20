package com.springboot.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data @AllArgsConstructor
@Schema(name = "ErrorResponse", description = "Schema to hold Error Response information")
public class ErrorResponseDto {

    @Schema(
            description = "API path invoked by Client"
    )
    private String apiPath;

    @Schema(
            description = "Error code representing the error"
    )
    private HttpStatus errorCode;

    private String errorMessage;
    private LocalDateTime errorTime;
}
