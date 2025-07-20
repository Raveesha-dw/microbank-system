package com.springboot.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data @AllArgsConstructor
@Schema(
        name = "Response",
        description = "To hold successful response information"
)
public class ResponseDto {
    @Schema(
            description = "Status Code in the response"
    )
    private String statusCode;

    @Schema(
            description = "Status Message in the response"
    )
    private String statusMsg;
}
