/**
 * Copyright (C) 2015 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.platform.finance.future;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.joda.beans.Bean;
import org.joda.beans.BeanDefinition;
import org.joda.beans.ImmutableBean;
import org.joda.beans.ImmutableValidator;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectFieldsBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import com.opengamma.basics.PutCall;
import com.opengamma.collect.ArgChecker;

/**
 * An expanded futures option contract, based on an IBOR-like index, with dates calculated ready for pricing.
 * <p>
 * An Ibor future option is an option on a financial instrument that is based on the future value of
 * an IBOR-like interest rate.
 * An Ibor future option is also known as a <i>STIR future option</i> (Short Term Interest Rate).
 * <p>
 * This class represents the structure of a single futures contract, which is typically exchange traded.
 * <p>
 * An {@code ExpandedIborFutureOption} contains information based on holiday calendars.
 * If a holiday calendar changes, the adjusted dates may no longer be correct.
 * Care must be taken when placing the expanded form in a cache or persistence layer.
 */
@BeanDefinition
public class ExpandedIborFutureOption implements IborFutureOptionProduct, ImmutableBean, Serializable {

  /**
   * Whether the option is put or call.
   */
  @PropertyDefinition
  private final PutCall putCall;
  /**
   * The expiration date of option.  
   * <p>
   * The date must not be after last trade date of the underlying future. 
   */
  @PropertyDefinition(validate = "notNull")
  private final LocalDate expirationDate;
  /**
   * The strike price of option. 
   * <p>
   * This should be represented in decimal. 
   * Thus strike rate is given by 1.0 - strike which can take negative values.
   */
  @PropertyDefinition
  private final double strikePrice;
  /**
   * The underlying expanded Ibor future.
   */
  @PropertyDefinition(validate = "notNull")
  private final ExpandedIborFuture iborFuture;

  //-------------------------------------------------------------------------
  @ImmutableValidator
  private void validate() {
    ArgChecker.inOrderOrEqual(expirationDate, iborFuture.getRate().getFixingDate(), "expirationDate", "rateFixingDate");
  }

  //-------------------------------------------------------------------------
  @Override
  public ExpandedIborFutureOption expand() {
    return this;
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code ExpandedIborFutureOption}.
   * @return the meta-bean, not null
   */
  public static ExpandedIborFutureOption.Meta meta() {
    return ExpandedIborFutureOption.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(ExpandedIborFutureOption.Meta.INSTANCE);
  }

  /**
   * The serialization version id.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Returns a builder used to create an instance of the bean.
   * @return the builder, not null
   */
  public static ExpandedIborFutureOption.Builder builder() {
    return new ExpandedIborFutureOption.Builder();
  }

  /**
   * Restricted constructor.
   * @param builder  the builder to copy from, not null
   */
  protected ExpandedIborFutureOption(ExpandedIborFutureOption.Builder builder) {
    JodaBeanUtils.notNull(builder.expirationDate, "expirationDate");
    JodaBeanUtils.notNull(builder.iborFuture, "iborFuture");
    this.putCall = builder.putCall;
    this.expirationDate = builder.expirationDate;
    this.strikePrice = builder.strikePrice;
    this.iborFuture = builder.iborFuture;
    validate();
  }

  @Override
  public ExpandedIborFutureOption.Meta metaBean() {
    return ExpandedIborFutureOption.Meta.INSTANCE;
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
   * Gets whether the option is put or call.
   * @return the value of the property
   */
  public PutCall getPutCall() {
    return putCall;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the expiration date of option.
   * <p>
   * The date must not be after last trade date of the underlying future.
   * @return the value of the property, not null
   */
  public LocalDate getExpirationDate() {
    return expirationDate;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the strike price of option.
   * <p>
   * This should be represented in decimal.
   * Thus strike rate is given by 1.0 - strike which can take negative values.
   * @return the value of the property
   */
  public double getStrikePrice() {
    return strikePrice;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the underlying expanded Ibor future.
   * @return the value of the property, not null
   */
  public ExpandedIborFuture getIborFuture() {
    return iborFuture;
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
      ExpandedIborFutureOption other = (ExpandedIborFutureOption) obj;
      return JodaBeanUtils.equal(getPutCall(), other.getPutCall()) &&
          JodaBeanUtils.equal(getExpirationDate(), other.getExpirationDate()) &&
          JodaBeanUtils.equal(getStrikePrice(), other.getStrikePrice()) &&
          JodaBeanUtils.equal(getIborFuture(), other.getIborFuture());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash = hash * 31 + JodaBeanUtils.hashCode(getPutCall());
    hash = hash * 31 + JodaBeanUtils.hashCode(getExpirationDate());
    hash = hash * 31 + JodaBeanUtils.hashCode(getStrikePrice());
    hash = hash * 31 + JodaBeanUtils.hashCode(getIborFuture());
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(160);
    buf.append("ExpandedIborFutureOption{");
    int len = buf.length();
    toString(buf);
    if (buf.length() > len) {
      buf.setLength(buf.length() - 2);
    }
    buf.append('}');
    return buf.toString();
  }

  protected void toString(StringBuilder buf) {
    buf.append("putCall").append('=').append(JodaBeanUtils.toString(getPutCall())).append(',').append(' ');
    buf.append("expirationDate").append('=').append(JodaBeanUtils.toString(getExpirationDate())).append(',').append(' ');
    buf.append("strikePrice").append('=').append(JodaBeanUtils.toString(getStrikePrice())).append(',').append(' ');
    buf.append("iborFuture").append('=').append(JodaBeanUtils.toString(getIborFuture())).append(',').append(' ');
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code ExpandedIborFutureOption}.
   */
  public static class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code putCall} property.
     */
    private final MetaProperty<PutCall> putCall = DirectMetaProperty.ofImmutable(
        this, "putCall", ExpandedIborFutureOption.class, PutCall.class);
    /**
     * The meta-property for the {@code expirationDate} property.
     */
    private final MetaProperty<LocalDate> expirationDate = DirectMetaProperty.ofImmutable(
        this, "expirationDate", ExpandedIborFutureOption.class, LocalDate.class);
    /**
     * The meta-property for the {@code strikePrice} property.
     */
    private final MetaProperty<Double> strikePrice = DirectMetaProperty.ofImmutable(
        this, "strikePrice", ExpandedIborFutureOption.class, Double.TYPE);
    /**
     * The meta-property for the {@code iborFuture} property.
     */
    private final MetaProperty<ExpandedIborFuture> iborFuture = DirectMetaProperty.ofImmutable(
        this, "iborFuture", ExpandedIborFutureOption.class, ExpandedIborFuture.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "putCall",
        "expirationDate",
        "strikePrice",
        "iborFuture");

    /**
     * Restricted constructor.
     */
    protected Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case -219971059:  // putCall
          return putCall;
        case -668811523:  // expirationDate
          return expirationDate;
        case 50946231:  // strikePrice
          return strikePrice;
        case 194327967:  // iborFuture
          return iborFuture;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public ExpandedIborFutureOption.Builder builder() {
      return new ExpandedIborFutureOption.Builder();
    }

    @Override
    public Class<? extends ExpandedIborFutureOption> beanType() {
      return ExpandedIborFutureOption.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code putCall} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<PutCall> putCall() {
      return putCall;
    }

    /**
     * The meta-property for the {@code expirationDate} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<LocalDate> expirationDate() {
      return expirationDate;
    }

    /**
     * The meta-property for the {@code strikePrice} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<Double> strikePrice() {
      return strikePrice;
    }

    /**
     * The meta-property for the {@code iborFuture} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<ExpandedIborFuture> iborFuture() {
      return iborFuture;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case -219971059:  // putCall
          return ((ExpandedIborFutureOption) bean).getPutCall();
        case -668811523:  // expirationDate
          return ((ExpandedIborFutureOption) bean).getExpirationDate();
        case 50946231:  // strikePrice
          return ((ExpandedIborFutureOption) bean).getStrikePrice();
        case 194327967:  // iborFuture
          return ((ExpandedIborFutureOption) bean).getIborFuture();
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
   * The bean-builder for {@code ExpandedIborFutureOption}.
   */
  public static class Builder extends DirectFieldsBeanBuilder<ExpandedIborFutureOption> {

    private PutCall putCall;
    private LocalDate expirationDate;
    private double strikePrice;
    private ExpandedIborFuture iborFuture;

    /**
     * Restricted constructor.
     */
    protected Builder() {
    }

    /**
     * Restricted copy constructor.
     * @param beanToCopy  the bean to copy from, not null
     */
    protected Builder(ExpandedIborFutureOption beanToCopy) {
      this.putCall = beanToCopy.getPutCall();
      this.expirationDate = beanToCopy.getExpirationDate();
      this.strikePrice = beanToCopy.getStrikePrice();
      this.iborFuture = beanToCopy.getIborFuture();
    }

    //-----------------------------------------------------------------------
    @Override
    public Object get(String propertyName) {
      switch (propertyName.hashCode()) {
        case -219971059:  // putCall
          return putCall;
        case -668811523:  // expirationDate
          return expirationDate;
        case 50946231:  // strikePrice
          return strikePrice;
        case 194327967:  // iborFuture
          return iborFuture;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
    }

    @Override
    public Builder set(String propertyName, Object newValue) {
      switch (propertyName.hashCode()) {
        case -219971059:  // putCall
          this.putCall = (PutCall) newValue;
          break;
        case -668811523:  // expirationDate
          this.expirationDate = (LocalDate) newValue;
          break;
        case 50946231:  // strikePrice
          this.strikePrice = (Double) newValue;
          break;
        case 194327967:  // iborFuture
          this.iborFuture = (ExpandedIborFuture) newValue;
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
    public ExpandedIborFutureOption build() {
      return new ExpandedIborFutureOption(this);
    }

    //-----------------------------------------------------------------------
    /**
     * Sets the {@code putCall} property in the builder.
     * @param putCall  the new value
     * @return this, for chaining, not null
     */
    public Builder putCall(PutCall putCall) {
      this.putCall = putCall;
      return this;
    }

    /**
     * Sets the {@code expirationDate} property in the builder.
     * @param expirationDate  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder expirationDate(LocalDate expirationDate) {
      JodaBeanUtils.notNull(expirationDate, "expirationDate");
      this.expirationDate = expirationDate;
      return this;
    }

    /**
     * Sets the {@code strikePrice} property in the builder.
     * @param strikePrice  the new value
     * @return this, for chaining, not null
     */
    public Builder strikePrice(double strikePrice) {
      this.strikePrice = strikePrice;
      return this;
    }

    /**
     * Sets the {@code iborFuture} property in the builder.
     * @param iborFuture  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder iborFuture(ExpandedIborFuture iborFuture) {
      JodaBeanUtils.notNull(iborFuture, "iborFuture");
      this.iborFuture = iborFuture;
      return this;
    }

    //-----------------------------------------------------------------------
    @Override
    public String toString() {
      StringBuilder buf = new StringBuilder(160);
      buf.append("ExpandedIborFutureOption.Builder{");
      int len = buf.length();
      toString(buf);
      if (buf.length() > len) {
        buf.setLength(buf.length() - 2);
      }
      buf.append('}');
      return buf.toString();
    }

    protected void toString(StringBuilder buf) {
      buf.append("putCall").append('=').append(JodaBeanUtils.toString(putCall)).append(',').append(' ');
      buf.append("expirationDate").append('=').append(JodaBeanUtils.toString(expirationDate)).append(',').append(' ');
      buf.append("strikePrice").append('=').append(JodaBeanUtils.toString(strikePrice)).append(',').append(' ');
      buf.append("iborFuture").append('=').append(JodaBeanUtils.toString(iborFuture)).append(',').append(' ');
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}