package com.accenture.PocVivoPublishEventBilling.model;

import com.accenture.PocVivoPublishEventBilling.utils.ModelUtils;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * An attachment by value or by reference.
 */
@ApiModel(description = "An attachment by value or by reference.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-11-06T21:16:01.493Z")


public class BillPresentationMediaRefOrValue   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("isRef")
  private Boolean isRef = true;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  @JsonProperty("@referredType")
  private String referredType = null;

  public BillPresentationMediaRefOrValue id(String id) {
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

  public BillPresentationMediaRefOrValue href(String href) {
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

  public BillPresentationMediaRefOrValue description(String description) {
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

  public BillPresentationMediaRefOrValue isRef(Boolean isRef) {
    this.isRef = isRef;
    return this;
  }

  /**
   * Get isRef
   * @return isRef
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Boolean isIsRef() {
    return isRef;
  }

  public void setIsRef(Boolean isRef) {
    this.isRef = isRef;
  }

  public BillPresentationMediaRefOrValue name(String name) {
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

  public BillPresentationMediaRefOrValue baseType(String baseType) {
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

  public BillPresentationMediaRefOrValue schemaLocation(String schemaLocation) {
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

  public BillPresentationMediaRefOrValue type(String type) {
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

  public BillPresentationMediaRefOrValue referredType(String referredType) {
    this.referredType = referredType;
    return this;
  }

  /**
   * The actual type of the target instance when needed for disambiguation.
   * @return referredType
  **/
  @ApiModelProperty(value = "The actual type of the target instance when needed for disambiguation.")


  public String getReferredType() {
    return referredType;
  }

  public void setReferredType(String referredType) {
    this.referredType = referredType;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BillPresentationMediaRefOrValue billPresentationMediaRefOrValue = (BillPresentationMediaRefOrValue) o;
    return Objects.equals(this.id, billPresentationMediaRefOrValue.id) &&
        Objects.equals(this.href, billPresentationMediaRefOrValue.href) &&
        Objects.equals(this.description, billPresentationMediaRefOrValue.description) &&
        Objects.equals(this.isRef, billPresentationMediaRefOrValue.isRef) &&
        Objects.equals(this.name, billPresentationMediaRefOrValue.name) &&
        Objects.equals(this.baseType, billPresentationMediaRefOrValue.baseType) &&
        Objects.equals(this.schemaLocation, billPresentationMediaRefOrValue.schemaLocation) &&
        Objects.equals(this.type, billPresentationMediaRefOrValue.type) &&
        Objects.equals(this.referredType, billPresentationMediaRefOrValue.referredType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, description, isRef, name, baseType, schemaLocation, type, referredType);
  }

  @Override
  public String toString() {
    return ModelUtils.modelToString(this);
  }
}

