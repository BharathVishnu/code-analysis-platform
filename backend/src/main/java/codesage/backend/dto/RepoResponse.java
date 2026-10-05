package codesage.backend.dto;

import java.time.LocalDateTime;

import codesage.backend.model.Repo;

public record RepoResponse (
    Integer id, String name, String url, String branch, LocalDateTime createdAt, LocalDateTime updatedAt
){
  public static RepoResponse from(Repo repository) {
        return new RepoResponse(
                repository.getId(),
                repository.getName(),
                repository.getUrl(),
                repository.getBranch(),
                repository.getCreatedAt(),
                repository.getUpdatedAt()
        );
    }
}
