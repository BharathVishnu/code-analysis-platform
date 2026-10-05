package codesage.backend.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import codesage.backend.repository.RepoRepository;
import codesage.backend.dto.RepoRequest;
import codesage.backend.dto.RepoResponse;
import codesage.backend.model.Repo;

public class RepoService {
    @Autowired 
    RepoRepository repoRepository;


    public List<RepoResponse> getAll()
    {
        return repoRepository.findAll().stream().map(RepoResponse::from).toList();
    }

    public RepoResponse create(RepoRequest r)
    {
        Repo repo = new Repo();
        repo.setName(r.name());
        repo.setBranch(r.branch());
        repo.setUrl(r.url());
        
        Repo saved = repoRepository.save(repo);
        return RepoResponse.from(saved);
    }
}
