package Entities;

public class ApplicationEntity {

  enum Status {
    reject,
    accept
  }

  private Integer id;

  private Status status;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }
}
