package com.edts.tdlib.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for health check.
 */
@RestController
@CrossOrigin("*")
public class HealthCheckController {
    /**
     * Health check always response with status 200 OK.
     *
     * @return response entity with status 200 OK
     */
    @GetMapping("/health")
    public ResponseEntity<Void> health() {
        return ResponseEntity.ok().build();
    }
}
