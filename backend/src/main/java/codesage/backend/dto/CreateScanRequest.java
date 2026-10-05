package codesage.backend.dto;


import jakarta.validation.constraints.NotBlank;

public record CreateScanRequest(

        @NotBlank(message = "Branch is required")
        String branch

) {
}