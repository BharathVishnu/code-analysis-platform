package codesage.backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import codesage.backend.dto.RepoRequest;
import codesage.backend.dto.RepoResponse;
import codesage.backend.service.RepoService;

import java.util.List;

@RestController
@RequestMapping("/api/repositories")
@Tag(name = "Repositories", description = "Endpoints for managing registered code repositories")
public class RepoController {

    @Autowired 
    RepoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Register a repository", description = "Registers a new Git repository for analysis")
    @ApiResponse(responseCode = "201", description = "Repository registered successfully")
    @ApiResponse(responseCode = "400", description = "Invalid request payload")
    public RepoResponse create(@Valid @RequestBody RepoRequest request) {
        return service.create(request);
    }

    @GetMapping
    @Operation(summary = "List all repositories", description = "Retrieves all registered code repositories")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved repositories")
    public List<RepoResponse> getAll() {
        return service.getAll();
    }
}
