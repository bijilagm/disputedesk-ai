package com.bijila.disputedesk.dto;

import jakarta.validation.constraints.NotBlank;

public record DisputeRequest(
        @NotBlank(message = "customerId is required") String customerId,
        @NotBlank(message = "text is required") String text
) {
}
