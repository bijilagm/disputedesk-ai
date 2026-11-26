package com.bijila.disputedesk.dto;

import com.bijila.disputedesk.enums.DisputeCategory;
import com.bijila.disputedesk.enums.Urgency;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DisputeExtraction(
        String merchant,
        BigDecimal amount,
        LocalDate transactionDate,
        DisputeCategory category,
        Urgency urgency
) {
}
