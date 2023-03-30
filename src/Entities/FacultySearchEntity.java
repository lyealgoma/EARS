package Entities;

import java.time.LocalDate;
import java.util.Date;

public class FacultySearchEntity {
  enum Status {
    active,
    inactive
  }
  String title;
  private Date startDate;
  private Date endDate;
  private Status Status;
  private Integer id;

public FacultySearchEntity(String title){
  this.title = title;
}

public  FacultySearchEntity( String title, Date startDate, Date endDate){
  this.title = title;
  this.startDate = startDate;
  this.endDate = endDate;
}

  public String gettitle() {
    return title;
  }
  public Date getEndDate() {
    return endDate;
  }

  public void setEnDate(Date enDate) {
    this.endDate = enDate;
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
