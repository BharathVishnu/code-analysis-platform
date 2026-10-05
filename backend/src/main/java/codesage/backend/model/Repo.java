package codesage.backend.model;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter 
@ToString 
@Entity 
@Table(name = "repositories", schema = "codesage")
public class Repo {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String url;
    private String branch;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
