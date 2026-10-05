package codesage.backend.service;

import codesage.backend.repository.RepoRepository;
import codesage.backend.dto.CreateScanRequest;
import codesage.backend.dto.ScanResponse;
import codesage.backend.model.Repo;
import codesage.backend.model.Scan;
import codesage.backend.model.ScanStatus;
import codesage.backend.repository.ScanRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ScanService {

    @Autowired 
    ScanRepository scanRepository;
    @Autowired 
    RepoRepository repoRepository;

    public ScanResponse createScan(
            Integer repositoryId,
            CreateScanRequest request) {

        Repo repository = repoRepository
                                .findById(repositoryId)
                                .orElseThrow(() ->
                                    new RuntimeException("Repository not found: " + repositoryId
                                ));

        Scan scan = new Scan();

        scan.setRepository(repository);
        scan.setBranch(request.branch());
        scan.setStatus(ScanStatus.QUEUED);
        scan.setCreatedAt(LocalDateTime.now());

        Scan savedScan = scanRepository.save(scan);
        return ScanResponse.from(savedScan);
    }
}