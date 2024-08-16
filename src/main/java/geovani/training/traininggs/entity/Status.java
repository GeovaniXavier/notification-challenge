package geovani.training.traininggs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_status")
public class Status {

    @Id
    private Long statusId;
    private String description;

    public Status() {
    }

    public Status(Long statusId, String description) {
        this.statusId = statusId;
        this.description = description;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public enum Values {
        PENDING(1L, "Pending"),
        SUCESS(2L, "Success"),
        ERROR(3L, "Error"),
        FAILED(4L, "Failed");

        private Long Id;
        private String description;

        Values(Long id, String description) {
            Id = id;
            this.description = description;
        }
        public Status getStatus() {
            return new Status(Id, description);
        }
    }
}
