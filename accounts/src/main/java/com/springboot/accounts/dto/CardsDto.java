package com.springboot.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
@Schema(
        name = "Card",
        description = "Schema to hold Card Details"
)
public class CardsDto {

    @Schema(
            description = "Mobile Number the Card is based on",
            example = "4354437687"
    )
    @NotEmpty(message = "Mobile Number cannot be null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile Number should be 10 digits")
    private String mobileNumber;

    @Schema(
            description = "Card Number of the Card",
            example = "100123456789"
    )
    @NotEmpty(message = "Card Number cannot be null or empty")
    @Pattern(regexp = "(^$|[0-9]{12})", message = "Card Number should be 12 digits")
    private String cardNumber;

    @Schema(
            description = "Type of Card",
            example = "Credit Card"
    )
    @NotEmpty(message = "Card type cannot be null or empty")
    private String cardType;


    @Schema(
            description = "Total amount limit available against a card", example = "100000"
    )
    @Positive(message = "Total Limit should be greater than zero")
    private int totalLimit;

    @Schema(
            description = "Total amount used by a Customer", example = "1000"
    )
    @PositiveOrZero(message = "Amount Used should be greater than or equal to zero")
    private int amountUsed;

    @Schema(
            description = "Total available amount against a card", example = "90000"
    )
    @PositiveOrZero(message = "Available Amount should be greater than or equal to zero")
    private int availableAmount;
}
