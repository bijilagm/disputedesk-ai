package com.bijila.disputedesk.controller;

import com.bijila.disputedesk.dto.DisputeExtraction;
import com.bijila.disputedesk.dto.DisputeRequest;
import com.bijila.disputedesk.service.DisputeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/disputes")
public class DisputeController {

    private final DisputeService disputeService;

    public DisputeController(DisputeService disputeService) {
        this.disputeService = disputeService;
    }

    @PostMapping
    public DisputeExtraction analyze(@Valid @RequestBody DisputeRequest request) {
        return disputeService.analyze(request);
    }
}
