/**
 * Copyright (C) 2014 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.platform.finance.security.equity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.joda.beans.Bean;
import org.joda.beans.BeanDefinition;
import org.joda.beans.ImmutableBean;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectFieldsBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import com.google.common.collect.ImmutableMap;
import com.opengamma.basics.currency.Currency;
import com.opengamma.platform.finance.security.SecurityType;
import com.opengamma.platform.source.id.StandardId;
import com.opengamma.platform.source.id.StandardIdentifiable;

/**
 * An equity share of a company.
 */
@BeanDefinition
public class Equity
    implements StandardIdentifiable, ImmutableBean, Serializable {

  /**
   * The security type constant for this class.
   */
  public static final SecurityType TYPE = SecurityType.of("Equity");

  /** Serialization version. */
  private static final long serialVersionUID = 1L;

  /**
   * The primary standard identifier for the security.
   * <p>
   * The standard identifier is used to identify the security.
   * It will typically be an identifier in an external data system.
   */
  @PropertyDefinition(validate = "notNull", overrideGet = true)
  private final StandardId standardId;
  /**
   * The company name.
   */
  @PropertyDefinition(validate = "notNull")
  private final String companyName;
  /**
   * The short name.
   */
  @PropertyDefinition
  private final String shortName;
  /**
   * The exchange.
   */
  @PropertyDefinition(validate = "notNull")
  private final String exchange;
  /**
   * The exchange code.
   */
  @PropertyDefinition(validate = "notNull")
  private final String exchangeCode;
  /**
   * The currency that the equity is priced in.
   */
  @PropertyDefinition(validate = "notNull")
  private final Currency currency;
  /**
   * The GICS code.
   * <p>
   * This is used to classify the equity.
   */
  @PropertyDefinition
  private final GicsCode gicsCode;
  /**
   * The flag indicating whether the equity has preferred status or not.
   */
  @PropertyDefinition
  private final boolean preferred;
  /**
   * The extensible set of attributes.
   * <p>
   * Most data is available as bean properties.
   * Attributes are used to tag the object with additional information.
   */
  @PropertyDefinition(validate = "notNull")
  private final ImmutableMap<String, String> attributes;

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code Equity}.
   * @return the meta-bean, not null
   */
  public static Equity.Meta meta() {
    return Equity.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(Equity.Meta.INSTANCE);
  }

  /**
   * Returns a builder used to create an instance of the bean.
   * @return the builder, not null
   */
  public static Equity.Builder builder() {
    return new Equity.Builder();
  }

  /**
   * Restricted constructor.
   * @param builder  the builder to copy from, not null
   */
  protected Equity(Equity.Builder builder) {
    JodaBeanUtils.notNull(builder.standardId, "standardId");
    JodaBeanUtils.notNull(builder.companyName, "companyName");
    JodaBeanUtils.notNull(builder.exchange, "exchange");
    JodaBeanUtils.notNull(builder.exchangeCode, "exchangeCode");
    JodaBeanUtils.notNull(builder.currency, "currency");
    JodaBeanUtils.notNull(builder.attributes, "attributes");
    this.standardId = builder.standardId;
    this.companyName = builder.companyName;
    this.shortName = builder.shortName;
    this.exchange = builder.exchange;
    this.exchangeCode = builder.exchangeCode;
    this.currency = builder.currency;
    this.gicsCode = builder.gicsCode;
    this.preferred = builder.preferred;
    this.attributes = ImmutableMap.copyOf(builder.attributes);
  }

  @Override
  public Equity.Meta metaBean() {
    return Equity.Meta.INSTANCE;
  }

  @Override
  public <R> Property<R> property(String propertyName) {
    return metaBean().<R>metaProperty(propertyName).createProperty(this);
  }

  @Override
  public Set<String> propertyNames() {
    return metaBean().metaPropertyMap().keySet();
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the primary standard identifier for the security.
   * <p>
   * The standard identifier is used to identify the security.
   * It will typically be an identifier in an external data system.
   * @return the value of the property, not null
   */
  @Override
  public StandardId getStandardId() {
    return standardId;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the company name.
   * @return the value of the property, not null
   */
  public String getCompanyName() {
    return companyName;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the short name.
   * @return the value of the property
   */
  public String getShortName() {
    return shortName;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the exchange.
   * @return the value of the property, not null
   */
  public String getExchange() {
    return exchange;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the exchange code.
   * @return the value of the property, not null
   */
  public String getExchangeCode() {
    return exchangeCode;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the currency that the equity is priced in.
   * @return the value of the property, not null
   */
  public Currency getCurrency() {
    return currency;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the GICS code.
   * <p>
   * This is used to classify the equity.
   * @return the value of the property
   */
  public GicsCode getGicsCode() {
    return gicsCode;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the flag indicating whether the equity has preferred status or not.
   * @return the value of the property
   */
  public boolean isPreferred() {
    return preferred;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the extensible set of attributes.
   * <p>
   * Most data is available as bean properties.
   * Attributes are used to tag the object with additional information.
   * @return the value of the property, not null
   */
  public ImmutableMap<String, String> getAttributes() {
    return attributes;
  }

  //-----------------------------------------------------------------------
  /**
   * Returns a builder that allows this bean to be mutated.
   * @return the mutable builder, not null
   */
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      Equity other = (Equity) obj;
      return JodaBeanUtils.equal(getStandardId(), other.getStandardId()) &&
          JodaBeanUtils.equal(getCompanyName(), other.getCompanyName()) &&
          JodaBeanUtils.equal(getShortName(), other.getShortName()) &&
          JodaBeanUtils.equal(getExchange(), other.getExchange()) &&
          JodaBeanUtils.equal(getExchangeCode(), other.getExchangeCode()) &&
          JodaBeanUtils.equal(getCurrency(), other.getCurrency()) &&
          JodaBeanUtils.equal(getGicsCode(), other.getGicsCode()) &&
          (isPreferred() == other.isPreferred()) &&
          JodaBeanUtils.equal(getAttributes(), other.getAttributes());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash += hash * 31 + JodaBeanUtils.hashCode(getStandardId());
    hash += hash * 31 + JodaBeanUtils.hashCode(getCompanyName());
    hash += hash * 31 + JodaBeanUtils.hashCode(getShortName());
    hash += hash * 31 + JodaBeanUtils.hashCode(getExchange());
    hash += hash * 31 + JodaBeanUtils.hashCode(getExchangeCode());
    hash += hash * 31 + JodaBeanUtils.hashCode(getCurrency());
    hash += hash * 31 + JodaBeanUtils.hashCode(getGicsCode());
    hash += hash * 31 + JodaBeanUtils.hashCode(isPreferred());
    hash += hash * 31 + JodaBeanUtils.hashCode(getAttributes());
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(320);
    buf.append("Equity{");
    int len = buf.length();
    toString(buf);
    if (buf.length() > len) {
      buf.setLength(buf.length() - 2);
    }
    buf.append('}');
    return buf.toString();
  }

  protected void toString(StringBuilder buf) {
    buf.append("standardId").append('=').append(JodaBeanUtils.toString(getStandardId())).append(',').append(' ');
    buf.append("companyName").append('=').append(JodaBeanUtils.toString(getCompanyName())).append(',').append(' ');
    buf.append("shortName").append('=').append(JodaBeanUtils.toString(getShortName())).append(',').append(' ');
    buf.append("exchange").append('=').append(JodaBeanUtils.toString(getExchange())).append(',').append(' ');
    buf.append("exchangeCode").append('=').append(JodaBeanUtils.toString(getExchangeCode())).append(',').append(' ');
    buf.append("currency").append('=').append(JodaBeanUtils.toString(getCurrency())).append(',').append(' ');
    buf.append("gicsCode").append('=').append(JodaBeanUtils.toString(getGicsCode())).append(',').append(' ');
    buf.append("preferred").append('=').append(JodaBeanUtils.toString(isPreferred())).append(',').append(' ');
    buf.append("attributes").append('=').append(JodaBeanUtils.toString(getAttributes())).append(',').append(' ');
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code Equity}.
   */
  public static class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code standardId} property.
     */
    private final MetaProperty<StandardId> standardId = DirectMetaProperty.ofImmutable(
        this, "standardId", Equity.class, StandardId.class);
    /**
     * The meta-property for the {@code companyName} property.
     */
    private final MetaProperty<String> companyName = DirectMetaProperty.ofImmutable(
        this, "companyName", Equity.class, String.class);
    /**
     * The meta-property for the {@code shortName} property.
     */
    private final MetaProperty<String> shortName = DirectMetaProperty.ofImmutable(
        this, "shortName", Equity.class, String.class);
    /**
     * The meta-property for the {@code exchange} property.
     */
    private final MetaProperty<String> exchange = DirectMetaProperty.ofImmutable(
        this, "exchange", Equity.class, String.class);
    /**
     * The meta-property for the {@code exchangeCode} property.
     */
    private final MetaProperty<String> exchangeCode = DirectMetaProperty.ofImmutable(
        this, "exchangeCode", Equity.class, String.class);
    /**
     * The meta-property for the {@code currency} property.
     */
    private final MetaProperty<Currency> currency = DirectMetaProperty.ofImmutable(
        this, "currency", Equity.class, Currency.class);
    /**
     * The meta-property for the {@code gicsCode} property.
     */
    private final MetaProperty<GicsCode> gicsCode = DirectMetaProperty.ofImmutable(
        this, "gicsCode", Equity.class, GicsCode.class);
    /**
     * The meta-property for the {@code preferred} property.
     */
    private final MetaProperty<Boolean> preferred = DirectMetaProperty.ofImmutable(
        this, "preferred", Equity.class, Boolean.TYPE);
    /**
     * The meta-property for the {@code attributes} property.
     */
    @SuppressWarnings({"unchecked", "rawtypes" })
    private final MetaProperty<ImmutableMap<String, String>> attributes = DirectMetaProperty.ofImmutable(
        this, "attributes", Equity.class, (Class) ImmutableMap.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "standardId",
        "companyName",
        "shortName",
        "exchange",
        "exchangeCode",
        "currency",
        "gicsCode",
        "preferred",
        "attributes");

    /**
     * Restricted constructor.
     */
    protected Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case -1284477768:  // standardId
          return standardId;
        case -508582744:  // companyName
          return companyName;
        case -2028219097:  // shortName
          return shortName;
        case 1989774883:  // exchange
          return exchange;
        case 1429202608:  // exchangeCode
          return exchangeCode;
        case 575402001:  // currency
          return currency;
        case 762040799:  // gicsCode
          return gicsCode;
        case -1294005119:  // preferred
          return preferred;
        case 405645655:  // attributes
          return attributes;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public Equity.Builder builder() {
      return new Equity.Builder();
    }

    @Override
    public Class<? extends Equity> beanType() {
      return Equity.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code standardId} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<StandardId> standardId() {
      return standardId;
    }

    /**
     * The meta-property for the {@code companyName} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<String> companyName() {
      return companyName;
    }

    /**
     * The meta-property for the {@code shortName} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<String> shortName() {
      return shortName;
    }

    /**
     * The meta-property for the {@code exchange} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<String> exchange() {
      return exchange;
    }

    /**
     * The meta-property for the {@code exchangeCode} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<String> exchangeCode() {
      return exchangeCode;
    }

    /**
     * The meta-property for the {@code currency} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<Currency> currency() {
      return currency;
    }

    /**
     * The meta-property for the {@code gicsCode} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<GicsCode> gicsCode() {
      return gicsCode;
    }

    /**
     * The meta-property for the {@code preferred} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<Boolean> preferred() {
      return preferred;
    }

    /**
     * The meta-property for the {@code attributes} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<ImmutableMap<String, String>> attributes() {
      return attributes;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case -1284477768:  // standardId
          return ((Equity) bean).getStandardId();
        case -508582744:  // companyName
          return ((Equity) bean).getCompanyName();
        case -2028219097:  // shortName
          return ((Equity) bean).getShortName();
        case 1989774883:  // exchange
          return ((Equity) bean).getExchange();
        case 1429202608:  // exchangeCode
          return ((Equity) bean).getExchangeCode();
        case 575402001:  // currency
          return ((Equity) bean).getCurrency();
        case 762040799:  // gicsCode
          return ((Equity) bean).getGicsCode();
        case -1294005119:  // preferred
          return ((Equity) bean).isPreferred();
        case 405645655:  // attributes
          return ((Equity) bean).getAttributes();
      }
      return super.propertyGet(bean, propertyName, quiet);
    }

    @Override
    protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
      metaProperty(propertyName);
      if (quiet) {
        return;
      }
      throw new UnsupportedOperationException("Property cannot be written: " + propertyName);
    }

  }

  //-----------------------------------------------------------------------
  /**
   * The bean-builder for {@code Equity}.
   */
  public static class Builder extends DirectFieldsBeanBuilder<Equity> {

    private StandardId standardId;
    private String companyName;
    private String shortName;
    private String exchange;
    private String exchangeCode;
    private Currency currency;
    private GicsCode gicsCode;
    private boolean preferred;
    private Map<String, String> attributes = new HashMap<String, String>();

    /**
     * Restricted constructor.
     */
    protected Builder() {
    }

    /**
     * Restricted copy constructor.
     * @param beanToCopy  the bean to copy from, not null
     */
    protected Builder(Equity beanToCopy) {
      this.standardId = beanToCopy.getStandardId();
      this.companyName = beanToCopy.getCompanyName();
      this.shortName = beanToCopy.getShortName();
      this.exchange = beanToCopy.getExchange();
      this.exchangeCode = beanToCopy.getExchangeCode();
      this.currency = beanToCopy.getCurrency();
      this.gicsCode = beanToCopy.getGicsCode();
      this.preferred = beanToCopy.isPreferred();
      this.attributes = new HashMap<String, String>(beanToCopy.getAttributes());
    }

    //-----------------------------------------------------------------------
    @Override
    public Object get(String propertyName) {
      switch (propertyName.hashCode()) {
        case -1284477768:  // standardId
          return standardId;
        case -508582744:  // companyName
          return companyName;
        case -2028219097:  // shortName
          return shortName;
        case 1989774883:  // exchange
          return exchange;
        case 1429202608:  // exchangeCode
          return exchangeCode;
        case 575402001:  // currency
          return currency;
        case 762040799:  // gicsCode
          return gicsCode;
        case -1294005119:  // preferred
          return preferred;
        case 405645655:  // attributes
          return attributes;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Builder set(String propertyName, Object newValue) {
      switch (propertyName.hashCode()) {
        case -1284477768:  // standardId
          this.standardId = (StandardId) newValue;
          break;
        case -508582744:  // companyName
          this.companyName = (String) newValue;
          break;
        case -2028219097:  // shortName
          this.shortName = (String) newValue;
          break;
        case 1989774883:  // exchange
          this.exchange = (String) newValue;
          break;
        case 1429202608:  // exchangeCode
          this.exchangeCode = (String) newValue;
          break;
        case 575402001:  // currency
          this.currency = (Currency) newValue;
          break;
        case 762040799:  // gicsCode
          this.gicsCode = (GicsCode) newValue;
          break;
        case -1294005119:  // preferred
          this.preferred = (Boolean) newValue;
          break;
        case 405645655:  // attributes
          this.attributes = (Map<String, String>) newValue;
          break;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
      return this;
    }

    @Override
    public Builder set(MetaProperty<?> property, Object value) {
      super.set(property, value);
      return this;
    }

    @Override
    public Builder setString(String propertyName, String value) {
      setString(meta().metaProperty(propertyName), value);
      return this;
    }

    @Override
    public Builder setString(MetaProperty<?> property, String value) {
      super.setString(property, value);
      return this;
    }

    @Override
    public Builder setAll(Map<String, ? extends Object> propertyValueMap) {
      super.setAll(propertyValueMap);
      return this;
    }

    @Override
    public Equity build() {
      return new Equity(this);
    }

    //-----------------------------------------------------------------------
    /**
     * Sets the {@code standardId} property in the builder.
     * @param standardId  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder standardId(StandardId standardId) {
      JodaBeanUtils.notNull(standardId, "standardId");
      this.standardId = standardId;
      return this;
    }

    /**
     * Sets the {@code companyName} property in the builder.
     * @param companyName  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder companyName(String companyName) {
      JodaBeanUtils.notNull(companyName, "companyName");
      this.companyName = companyName;
      return this;
    }

    /**
     * Sets the {@code shortName} property in the builder.
     * @param shortName  the new value
     * @return this, for chaining, not null
     */
    public Builder shortName(String shortName) {
      this.shortName = shortName;
      return this;
    }

    /**
     * Sets the {@code exchange} property in the builder.
     * @param exchange  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder exchange(String exchange) {
      JodaBeanUtils.notNull(exchange, "exchange");
      this.exchange = exchange;
      return this;
    }

    /**
     * Sets the {@code exchangeCode} property in the builder.
     * @param exchangeCode  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder exchangeCode(String exchangeCode) {
      JodaBeanUtils.notNull(exchangeCode, "exchangeCode");
      this.exchangeCode = exchangeCode;
      return this;
    }

    /**
     * Sets the {@code currency} property in the builder.
     * @param currency  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder currency(Currency currency) {
      JodaBeanUtils.notNull(currency, "currency");
      this.currency = currency;
      return this;
    }

    /**
     * Sets the {@code gicsCode} property in the builder.
     * @param gicsCode  the new value
     * @return this, for chaining, not null
     */
    public Builder gicsCode(GicsCode gicsCode) {
      this.gicsCode = gicsCode;
      return this;
    }

    /**
     * Sets the {@code preferred} property in the builder.
     * @param preferred  the new value
     * @return this, for chaining, not null
     */
    public Builder preferred(boolean preferred) {
      this.preferred = preferred;
      return this;
    }

    /**
     * Sets the {@code attributes} property in the builder.
     * @param attributes  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder attributes(Map<String, String> attributes) {
      JodaBeanUtils.notNull(attributes, "attributes");
      this.attributes = attributes;
      return this;
    }

    //-----------------------------------------------------------------------
    @Override
    public String toString() {
      StringBuilder buf = new StringBuilder(320);
      buf.append("Equity.Builder{");
      int len = buf.length();
      toString(buf);
      if (buf.length() > len) {
        buf.setLength(buf.length() - 2);
      }
      buf.append('}');
      return buf.toString();
    }

    protected void toString(StringBuilder buf) {
      buf.append("standardId").append('=').append(JodaBeanUtils.toString(standardId)).append(',').append(' ');
      buf.append("companyName").append('=').append(JodaBeanUtils.toString(companyName)).append(',').append(' ');
      buf.append("shortName").append('=').append(JodaBeanUtils.toString(shortName)).append(',').append(' ');
      buf.append("exchange").append('=').append(JodaBeanUtils.toString(exchange)).append(',').append(' ');
      buf.append("exchangeCode").append('=').append(JodaBeanUtils.toString(exchangeCode)).append(',').append(' ');
      buf.append("currency").append('=').append(JodaBeanUtils.toString(currency)).append(',').append(' ');
      buf.append("gicsCode").append('=').append(JodaBeanUtils.toString(gicsCode)).append(',').append(' ');
      buf.append("preferred").append('=').append(JodaBeanUtils.toString(preferred)).append(',').append(' ');
      buf.append("attributes").append('=').append(JodaBeanUtils.toString(attributes)).append(',').append(' ');
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
