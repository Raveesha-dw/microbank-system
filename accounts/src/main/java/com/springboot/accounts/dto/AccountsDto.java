package com.springboot.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Schema(
        name = "Accounts",
        description = "Schema to hold Account Information"
)
public class AccountsDto {

    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile Number should be 10 digits")
    @NotEmpty(message = "Account Number cannot be null or empty")
    @Schema(
            description = "Account Number of Bank Account",
            example = "1234567890"
    )
    private Long accountNumber;

    @Schema(
            description = "Account Type of Bank Account",
            example = "Savings"
    )
    @NotEmpty(message = "Account Type cannot be null or empty")
    private String accountType;

    @Schema(
            description = "Branch Address of Bank Account",
            example = "Thummulla, Colombo 7"
    )
    @NotEmpty(message = "Branch Address cannot be null or empty")
    private String branchAddress;
}
