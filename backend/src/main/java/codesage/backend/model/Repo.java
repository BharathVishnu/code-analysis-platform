package codesage.backend.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter 
@ToString 
@Entity 
public class Repo {
    @Id 
    private Integer id;
    private String name;
    private String url;
    private String branch;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
