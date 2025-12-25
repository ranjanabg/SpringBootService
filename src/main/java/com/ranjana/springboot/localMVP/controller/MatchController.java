package com.ranjana.springboot.localMVP.controller;

import com.ranjana.springboot.localMVP.dto.ListingResponse;
import com.ranjana.springboot.localMVP.service.MatchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matches")
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping
    public ResponseEntity<List<ListingResponse>> getMatches(@RequestParam Long subscriptionId) {
        List<ListingResponse> matches = matchService.findMatches(subscriptionId);
        return ResponseEntity.ok(matches);
    }
}
