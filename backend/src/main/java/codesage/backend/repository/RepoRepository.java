package codesage.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import codesage.backend.model.Repo;

public interface RepoRepository extends JpaRepository <Repo, Integer> {}
