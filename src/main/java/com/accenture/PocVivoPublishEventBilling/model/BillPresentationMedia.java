package com.accenture.PocVivoPublishEventBilling.model;

import com.accenture.PocVivoPublishEventBilling.utils.ModelUtils;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * A mean of communicating a bill, supported by the associated bill format. For example, post mail, email, web page.
 */
@ApiModel(description = "A mean of communicating a bill, supported by the associated bill format. For example, post mail, email, web page.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-11-06T21:16:01.493Z")


public class BillPresentationMedia   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  public BillPresentationMedia id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the bill presentation media
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier of the bill presentation media")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public BillPresentationMedia href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Reference of the bill presentation media
   * @return href
  **/
  @ApiModelProperty(value = "Reference of the bill presentation media")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public BillPresentationMedia description(String description) {
    this.description = description;
    return this;
  }

  /**
   * An explanatory text describing this bill presentation media
   * @return description
  **/
  @ApiModelProperty(value = "An explanatory text describing this bill presentation media")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BillPresentationMedia name(String name) {
    this.name = name;
    return this;
  }

  /**
   * A short descriptive name
   * @return name
  **/
  @ApiModelProperty(required = true, value = "A short descriptive name")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BillPresentationMedia baseType(String baseType) {
    this.baseType = baseType;
    return this;
  }

  /**
   * When sub-classing, this defines the super-class
   * @return baseType
  **/
  @ApiModelProperty(value = "When sub-classing, this defines the super-class")


  public String getBaseType() {
    return baseType;
  }

  public void setBaseType(String baseType) {
    this.baseType = baseType;
  }

  public BillPresentationMedia schemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
    return this;
  }

  /**
   * A URI to a JSON-Schema file that defines additional attributes and relationships
   * @return schemaLocation
  **/
  @ApiModelProperty(value = "A URI to a JSON-Schema file that defines additional attributes and relationships")


  public String getSchemaLocation() {
    return schemaLocation;
  }

  public void setSchemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
  }

  public BillPresentationMedia type(String type) {
    this.type = type;
    return this;
  }

  /**
   * When sub-classing, this defines the sub-class entity name
   * @return type
  **/
  @ApiModelProperty(value = "When sub-classing, this defines the sub-class entity name")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BillPresentationMedia billPresentationMedia = (BillPresentationMedia) o;
    return Objects.equals(this.id, billPresentationMedia.id) &&
        Objects.equals(this.href, billPresentationMedia.href) &&
        Objects.equals(this.description, billPresentationMedia.description) &&
        Objects.equals(this.name, billPresentationMedia.name) &&
        Objects.equals(this.baseType, billPresentationMedia.baseType) &&
        Objects.equals(this.schemaLocation, billPresentationMedia.schemaLocation) &&
        Objects.equals(this.type, billPresentationMedia.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, description, name, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    return ModelUtils.modelToString(this);
  }
}

