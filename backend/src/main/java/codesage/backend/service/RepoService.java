package codesage.backend.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import codesage.backend.repository.RepoRepository;
import io.swagger.v3.oas.annotations.servers.Server;
import codesage.backend.dto.RepoRequest;
import codesage.backend.dto.RepoResponse;
import codesage.backend.model.Repo;

@Service 
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
