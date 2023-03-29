package Entities;

public class UserEntity {
  private String email;
  private String firstName;
  private String lastName;
  private String role;

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

  public String getRole(){
    return role;
  }

  public String getPassword(){
    return password;
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

  public void setRole(String role){
    this.role = role;
  }

  public boolean comparePassword(String password) {
    return this.password.equals(password);
  }

  

}
