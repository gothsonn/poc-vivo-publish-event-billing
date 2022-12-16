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


public class PartyAccountStateChangeEventPayload   {
  @JsonProperty("partyAccount")
  private PartyAccount partyAccount = null;

  public PartyAccountStateChangeEventPayload partyAccount(PartyAccount partyAccount) {
    this.partyAccount = partyAccount;
    return this;
  }

  /**
   * The involved resource data for the event
   * @return partyAccount
  **/
  @ApiModelProperty(value = "The involved resource data for the event")

  @Valid

  public PartyAccount getPartyAccount() {
    return partyAccount;
  }

  public void setPartyAccount(PartyAccount partyAccount) {
    this.partyAccount = partyAccount;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PartyAccountStateChangeEventPayload partyAccountStateChangeEventPayload = (PartyAccountStateChangeEventPayload) o;
    return Objects.equals(this.partyAccount, partyAccountStateChangeEventPayload.partyAccount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(partyAccount);
  }

  @Override
  public String toString() {
    return ModelUtils.modelToString(this);
  }
}

