package codesage.backend.controller;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import codesage.backend.dto.CreateScanRequest;
import codesage.backend.dto.ScanResponse;
import codesage.backend.service.ScanService;

@RestController
@RequestMapping("/api/repositories/{repositoryId}/scans")
public class ScanController {

    @Autowired 
    ScanService scanService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ScanResponse createScan(@PathVariable Integer repositoryId, @Valid @RequestBody CreateScanRequest request) {
        return scanService.createScan(repositoryId, request);
    }
}
