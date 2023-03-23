package Entities;

public class UserEntity {
  private String email;
  private String firstName;
  private String lastName;

  // @todo: must hashed in bcrypt
  private String password;

  public String getEmail() {
    return email;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public boolean comparePassword(String password) {
    return this.password.equals(password);
  }

}
