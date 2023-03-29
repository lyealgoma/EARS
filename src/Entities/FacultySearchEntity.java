package Entities;

import java.util.Date;

public class FacultySearchEntity {

  private Date startDate;
  private Date enDate;
  private String status;
  private Integer id;
  private String title;

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

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

}
