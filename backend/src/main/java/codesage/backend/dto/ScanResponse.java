package codesage.backend.dto;

import codesage.backend.model.Scan;
import codesage.backend.model.ScanStatus;

import java.time.LocalDateTime;

public record ScanResponse(
        Long id,
        Long repositoryId,
        ScanStatus status,
        String branch,
        String commitHash,
        LocalDateTime createdAt,
        LocalDateTime startedAt,
        LocalDateTime completedAt,
        Integer qualityScore
) {

    public static ScanResponse from(Scan scan) {

        return new ScanResponse(
                scan.getId(),
                scan.getRepository().getId(),
                scan.getStatus(),
                scan.getBranch(),
                scan.getCommitHash(),
                scan.getCreatedAt(),
                scan.getStartedAt(),
                scan.getCompletedAt(),
                scan.getQualityScore()
        );
    }
}