package com.accenture.PocVivoPublishEventBilling.model;

import com.accenture.PocVivoPublishEventBilling.utils.ModelUtils;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Objects;

/**
 * The event data structure
 */
@ApiModel(description = "The event data structure")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-11-06T21:16:01.493Z")


public class SettlementAccountAttributeValueChangeEventPayload   {
  @JsonProperty("settlementAccount")
  private SettlementAccount settlementAccount = null;

  public SettlementAccountAttributeValueChangeEventPayload settlementAccount(SettlementAccount settlementAccount) {
    this.settlementAccount = settlementAccount;
    return this;
  }

  /**
   * The involved resource data for the event
   * @return settlementAccount
  **/
  @ApiModelProperty(value = "The involved resource data for the event")

  @Valid

  public SettlementAccount getSettlementAccount() {
    return settlementAccount;
  }

  public void setSettlementAccount(SettlementAccount settlementAccount) {
    this.settlementAccount = settlementAccount;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SettlementAccountAttributeValueChangeEventPayload settlementAccountAttributeValueChangeEventPayload = (SettlementAccountAttributeValueChangeEventPayload) o;
    return Objects.equals(this.settlementAccount, settlementAccountAttributeValueChangeEventPayload.settlementAccount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(settlementAccount);
  }

  @Override
  public String toString() {
    return ModelUtils.modelToString(this);
  }
}

