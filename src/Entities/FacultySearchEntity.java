package Entities;

import java.util.Date;

public class FacultySearchEntity {
  enum Status {
    active,
    inactive
  }

  private Date startDate;
  private Date enDate;
  private Status Status;
  private Integer id;

  public Date getEnDate() {
    return enDate;
  }

  public void setEnDate(Date enDate) {
    this.enDate = enDate;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Status getStatus() {
    return Status;
  }

  public void setStatus(Status status) {
    Status = status;
  }

}
