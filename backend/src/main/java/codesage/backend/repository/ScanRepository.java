package codesage.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import codesage.backend.model.Scan;

public interface ScanRepository extends JpaRepository<Scan, Long> {
}
