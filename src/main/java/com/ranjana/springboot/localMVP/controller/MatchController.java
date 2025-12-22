package com.ranjana.springboot.localMVP.controller;

import com.ranjana.springboot.localMVP.dto.MatchResponse;
import com.ranjana.springboot.localMVP.service.MatchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MatchController {

    private final MatchService service;

    public MatchController(MatchService service) {
        this.service = service;
    }

    @GetMapping("/matches")
    public List<MatchResponse> matches(
            @RequestParam Long subscriptionId) {
        return service.findMatches(subscriptionId);
    }
}
