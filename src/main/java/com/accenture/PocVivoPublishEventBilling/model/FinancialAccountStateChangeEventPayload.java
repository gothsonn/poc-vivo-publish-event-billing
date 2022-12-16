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


public class FinancialAccountStateChangeEventPayload   {
  @JsonProperty("financialAccount")
  private FinancialAccount financialAccount = null;

  public FinancialAccountStateChangeEventPayload financialAccount(FinancialAccount financialAccount) {
    this.financialAccount = financialAccount;
    return this;
  }

  /**
   * The involved resource data for the event
   * @return financialAccount
  **/
  @ApiModelProperty(value = "The involved resource data for the event")

  @Valid

  public FinancialAccount getFinancialAccount() {
    return financialAccount;
  }

  public void setFinancialAccount(FinancialAccount financialAccount) {
    this.financialAccount = financialAccount;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FinancialAccountStateChangeEventPayload financialAccountStateChangeEventPayload = (FinancialAccountStateChangeEventPayload) o;
    return Objects.equals(this.financialAccount, financialAccountStateChangeEventPayload.financialAccount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(financialAccount);
  }

  @Override
  public String toString() {
    return ModelUtils.modelToString(this);
  }
}

