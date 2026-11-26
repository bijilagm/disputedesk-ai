package com.bijila.disputedesk.service;

import com.bijila.disputedesk.dto.DisputeExtraction;
import com.bijila.disputedesk.dto.DisputeRequest;

public interface DisputeService {
    DisputeExtraction analyze(DisputeRequest request);
}
