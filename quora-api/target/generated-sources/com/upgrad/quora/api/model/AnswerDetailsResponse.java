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
 * AnswerDetailsResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-30T22:51:24.557+05:30")

public class AnswerDetailsResponse   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("questionContent")
  private String questionContent = null;

  @JsonProperty("answerContent")
  private String answerContent = null;

  public AnswerDetailsResponse id(String id) {
    this.id = id;
    return this;
  }

  /**
   * answer uuid
   * @return id
  **/
  @ApiModelProperty(required = true, value = "answer uuid")
  @NotNull


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public AnswerDetailsResponse questionContent(String questionContent) {
    this.questionContent = questionContent;
    return this;
  }

  /**
   * Content of the question
   * @return questionContent
  **/
  @ApiModelProperty(required = true, value = "Content of the question")
  @NotNull


  public String getQuestionContent() {
    return questionContent;
  }

  public void setQuestionContent(String questionContent) {
    this.questionContent = questionContent;
  }

  public AnswerDetailsResponse answerContent(String answerContent) {
    this.answerContent = answerContent;
    return this;
  }

  /**
   * Answer content
   * @return answerContent
  **/
  @ApiModelProperty(required = true, value = "Answer content")
  @NotNull


  public String getAnswerContent() {
    return answerContent;
  }

  public void setAnswerContent(String answerContent) {
    this.answerContent = answerContent;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AnswerDetailsResponse answerDetailsResponse = (AnswerDetailsResponse) o;
    return Objects.equals(this.id, answerDetailsResponse.id) &&
        Objects.equals(this.questionContent, answerDetailsResponse.questionContent) &&
        Objects.equals(this.answerContent, answerDetailsResponse.answerContent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, questionContent, answerContent);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AnswerDetailsResponse {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    questionContent: ").append(toIndentedString(questionContent)).append("\n");
    sb.append("    answerContent: ").append(toIndentedString(answerContent)).append("\n");
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

