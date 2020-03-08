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
 * SigninResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-30T22:51:23.812+05:30")

public class SigninResponse   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("message")
  private String message = null;

  public SigninResponse id(String id) {
    this.id = id;
    return this;
  }

  /**
   * uuid for the user authentication after he signs in.
   * @return id
  **/
  @ApiModelProperty(required = true, value = "uuid for the user authentication after he signs in.")
  @NotNull


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public SigninResponse message(String message) {
    this.message = message;
    return this;
  }

  /**
   * message to show the status of the signed in user
   * @return message
  **/
  @ApiModelProperty(required = true, value = "message to show the status of the signed in user")
  @NotNull


  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SigninResponse signinResponse = (SigninResponse) o;
    return Objects.equals(this.id, signinResponse.id) &&
        Objects.equals(this.message, signinResponse.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SigninResponse {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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

