package com.upgrad.quora.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SignupUserRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-30T22:51:23.812+05:30")

public class SignupUserRequest   {
  @JsonProperty("first_name")
  private String firstName = null;

  @JsonProperty("last_name")
  private String lastName = null;

  @JsonProperty("user_name")
  private String userName = null;

  @JsonProperty("email_address")
  private String emailAddress = null;

  @JsonProperty("password")
  private String password = null;

  @JsonProperty("country")
  private String country = null;

  @JsonProperty("aboutMe")
  private String aboutMe = null;

  @JsonProperty("dob")
  private String dob = null;

  @JsonProperty("contact_number")
  private String contactNumber = null;

  public SignupUserRequest firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * First name of the new user
   * @return firstName
  **/
  @ApiModelProperty(required = true, value = "First name of the new user")
  @NotNull


  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public SignupUserRequest lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Last name of the new user
   * @return lastName
  **/
  @ApiModelProperty(required = true, value = "Last name of the new user")
  @NotNull


  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public SignupUserRequest userName(String userName) {
    this.userName = userName;
    return this;
  }

  /**
   * Username
   * @return userName
  **/
  @ApiModelProperty(required = true, value = "Username")
  @NotNull


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public SignupUserRequest emailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
    return this;
  }

  /**
   * Email address of the new user
   * @return emailAddress
  **/
  @ApiModelProperty(required = true, value = "Email address of the new user")
  @NotNull


  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public SignupUserRequest password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Password of the new user
   * @return password
  **/
  @ApiModelProperty(required = true, value = "Password of the new user")
  @NotNull


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public SignupUserRequest country(String country) {
    this.country = country;
    return this;
  }

  /**
   * Country of the new user
   * @return country
  **/
  @ApiModelProperty(value = "Country of the new user")


  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public SignupUserRequest aboutMe(String aboutMe) {
    this.aboutMe = aboutMe;
    return this;
  }

  /**
   * Details of the new user
   * @return aboutMe
  **/
  @ApiModelProperty(value = "Details of the new user")


  public String getAboutMe() {
    return aboutMe;
  }

  public void setAboutMe(String aboutMe) {
    this.aboutMe = aboutMe;
  }

  public SignupUserRequest dob(String dob) {
    this.dob = dob;
    return this;
  }

  /**
   * Date of birth of the new user
   * @return dob
  **/
  @ApiModelProperty(value = "Date of birth of the new user")


  public String getDob() {
    return dob;
  }

  public void setDob(String dob) {
    this.dob = dob;
  }

  public SignupUserRequest contactNumber(String contactNumber) {
    this.contactNumber = contactNumber;
    return this;
  }

  /**
   * Mobile number of the new user
   * @return contactNumber
  **/
  @ApiModelProperty(value = "Mobile number of the new user")


  public String getContactNumber() {
    return contactNumber;
  }

  public void setContactNumber(String contactNumber) {
    this.contactNumber = contactNumber;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SignupUserRequest signupUserRequest = (SignupUserRequest) o;
    return Objects.equals(this.firstName, signupUserRequest.firstName) &&
        Objects.equals(this.lastName, signupUserRequest.lastName) &&
        Objects.equals(this.userName, signupUserRequest.userName) &&
        Objects.equals(this.emailAddress, signupUserRequest.emailAddress) &&
        Objects.equals(this.password, signupUserRequest.password) &&
        Objects.equals(this.country, signupUserRequest.country) &&
        Objects.equals(this.aboutMe, signupUserRequest.aboutMe) &&
        Objects.equals(this.dob, signupUserRequest.dob) &&
        Objects.equals(this.contactNumber, signupUserRequest.contactNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName, userName, emailAddress, password, country, aboutMe, dob, contactNumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SignupUserRequest {\n");
    
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
    sb.append("    emailAddress: ").append(toIndentedString(emailAddress)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    aboutMe: ").append(toIndentedString(aboutMe)).append("\n");
    sb.append("    dob: ").append(toIndentedString(dob)).append("\n");
    sb.append("    contactNumber: ").append(toIndentedString(contactNumber)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

