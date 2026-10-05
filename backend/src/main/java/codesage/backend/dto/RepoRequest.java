package codesage.backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record RepoRequest(
        @NotBlank(message = "Repository name is required")
        String name,

        @NotBlank(message = "Repository URL is required")
        @Pattern(regexp = "^(https?|git)://.*", message = "Must be a valid Git URL")
        String url,

        @NotBlank(message = "Branch is required")
        @Schema(description = "Target branch to analyze", example = "main", defaultValue = "main")
        String branch
) {
    
}
