package backendnovice.projectportfolio.global.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTime {
    @CreatedDate
    @Column(name = "CREATE_DT", updatable = false)
    private LocalDateTime createdDate;
    
    @LastModifiedDate
    @Column(name = "MODIFY_DT")
    private LocalDateTime ModifiedDate;
}
