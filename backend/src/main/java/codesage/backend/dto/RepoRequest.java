package codesage.backend.dto;

import jakarta.validation.constraints.NotBlank;

public record RepoRequest(
        @NotBlank(message = "Repository name is required")
        String name,

        @NotBlank(message = "Repository URL is required")
        String url,

        @NotBlank(message = "Branch is required")
        String branch
) {
    
}
