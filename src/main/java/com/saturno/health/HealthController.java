package com.saturno.health;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Map;

@RestController
@RequestMapping("api/v1/health")
public class HealthController {

    @GetMapping
    public ResponseEntity<Map<String, String>> health(){
        var details = Map.of(
                "status", "UP",
                "name", "x",
                "timestamp", Instant.now().toString()
        );

        return ResponseEntity.ok().body(details);
    }
}
