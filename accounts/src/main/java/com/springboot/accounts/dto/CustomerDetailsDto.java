package com.springboot.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        name = "Customer Details",
        description = "Schema to hold Customer, Account, Cards and Loans Information"
)
public class CustomerDetailsDto {

    @Schema(
            description = "Customer Name",
            example = "John Doe"
    )
    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 5, max = 30, message = "The length of Customer Name should be between 5 and 30")
    private String name;

    @Schema(
            description = "Email of the Customer",
            example = "johndoe@gmail.com"
    )
    @NotEmpty(message = "Email address cannot be empty")
    @Email(message = "Email address is in invalid format")
    private String email;

    @Schema(
            description = "Mobile Number of the Customer",
            example = "0771234567"
    )
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile Number should be 10 digits")
    private String mobileNumber;

    @Schema(
            description = "Accounts Information of the Customer"
    )
    private AccountsDto accountsDto;

    @Schema(
            description = "Loans Information of the Customer"
    )
    private LoansDto loansDto;

    @Schema(
            description = "Cards Information of the Customer"
    )
    private CardsDto cardsDto;
}
