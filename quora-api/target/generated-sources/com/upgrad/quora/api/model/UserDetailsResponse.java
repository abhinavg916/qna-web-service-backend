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
 * UserDetailsResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-30T22:51:24.126+05:30")

public class UserDetailsResponse   {
  @JsonProperty("first_name")
  private String firstName = null;

  @JsonProperty("last_name")
  private String lastName = null;

  @JsonProperty("user_name")
  private String userName = null;

  @JsonProperty("email_address")
  private String emailAddress = null;

  @JsonProperty("country")
  private String country = null;

  @JsonProperty("aboutMe")
  private String aboutMe = null;

  @JsonProperty("dob")
  private String dob = null;

  @JsonProperty("contact_number")
  private String contactNumber = null;

  public UserDetailsResponse firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * First name of the user
   * @return firstName
  **/
  @ApiModelProperty(value = "First name of the user")


  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public UserDetailsResponse lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Last name of the user
   * @return lastName
  **/
  @ApiModelProperty(value = "Last name of the user")


  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public UserDetailsResponse userName(String userName) {
    this.userName = userName;
    return this;
  }

  /**
   * Username
   * @return userName
  **/
  @ApiModelProperty(value = "Username")


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public UserDetailsResponse emailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
    return this;
  }

  /**
   * Email address of the user
   * @return emailAddress
  **/
  @ApiModelProperty(value = "Email address of the user")


  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public UserDetailsResponse country(String country) {
    this.country = country;
    return this;
  }

  /**
   * Country of the user
   * @return country
  **/
  @ApiModelProperty(value = "Country of the user")


  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public UserDetailsResponse aboutMe(String aboutMe) {
    this.aboutMe = aboutMe;
    return this;
  }

  /**
   * Details of the user
   * @return aboutMe
  **/
  @ApiModelProperty(value = "Details of the user")


  public String getAboutMe() {
    return aboutMe;
  }

  public void setAboutMe(String aboutMe) {
    this.aboutMe = aboutMe;
  }

  public UserDetailsResponse dob(String dob) {
    this.dob = dob;
    return this;
  }

  /**
   * Date of birth of the user
   * @return dob
  **/
  @ApiModelProperty(value = "Date of birth of the user")


  public String getDob() {
    return dob;
  }

  public void setDob(String dob) {
    this.dob = dob;
  }

  public UserDetailsResponse contactNumber(String contactNumber) {
    this.contactNumber = contactNumber;
    return this;
  }

  /**
   * Mobile number of the user
   * @return contactNumber
  **/
  @ApiModelProperty(value = "Mobile number of the user")


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
    UserDetailsResponse userDetailsResponse = (UserDetailsResponse) o;
    return Objects.equals(this.firstName, userDetailsResponse.firstName) &&
        Objects.equals(this.lastName, userDetailsResponse.lastName) &&
        Objects.equals(this.userName, userDetailsResponse.userName) &&
        Objects.equals(this.emailAddress, userDetailsResponse.emailAddress) &&
        Objects.equals(this.country, userDetailsResponse.country) &&
        Objects.equals(this.aboutMe, userDetailsResponse.aboutMe) &&
        Objects.equals(this.dob, userDetailsResponse.dob) &&
        Objects.equals(this.contactNumber, userDetailsResponse.contactNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName, userName, emailAddress, country, aboutMe, dob, contactNumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserDetailsResponse {\n");
    
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
    sb.append("    emailAddress: ").append(toIndentedString(emailAddress)).append("\n");
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

