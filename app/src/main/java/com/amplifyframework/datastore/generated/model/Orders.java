package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.temporal.Temporal;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the Orders type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Orders")
public final class Orders implements Model {
  public static final QueryField ID = field("Orders", "id");
  public static final QueryField PICKUP_DATE = field("Orders", "pickupDate");
  public static final QueryField DELIVERY_DATE = field("Orders", "deliveryDate");
  public static final QueryField LONGITUDE = field("Orders", "longitude");
  public static final QueryField LATITUDE = field("Orders", "latitude");
  public static final QueryField SHIRTS_QUANTITY = field("Orders", "shirtsQuantity");
  public static final QueryField JACKETS_QUANTITY = field("Orders", "jacketsQuantity");
  public static final QueryField UNDER_WARES_QUANTITY = field("Orders", "underWaresQuantity");
  public static final QueryField PANTIES_QUANTITY = field("Orders", "pantiesQuantity");
  public static final QueryField SUITES_QUANTITY = field("Orders", "suitesQuantity");
  public static final QueryField OTHERS_QUANTITY = field("Orders", "othersQuantity");
  public static final QueryField USER_ID = field("Orders", "userId");
  public static final QueryField STATE = field("Orders", "state");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String pickupDate;
  private final @ModelField(targetType="String", isRequired = true) String deliveryDate;
  private final @ModelField(targetType="Float", isRequired = true) Double longitude;
  private final @ModelField(targetType="Float", isRequired = true) Double latitude;
  private final @ModelField(targetType="Int") Integer shirtsQuantity;
  private final @ModelField(targetType="Int") Integer jacketsQuantity;
  private final @ModelField(targetType="Int") Integer underWaresQuantity;
  private final @ModelField(targetType="Int") Integer pantiesQuantity;
  private final @ModelField(targetType="Int") Integer suitesQuantity;
  private final @ModelField(targetType="Int") Integer othersQuantity;
  private final @ModelField(targetType="String") String userId;
  private final @ModelField(targetType="State") State state;

  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;

  public String getId() {
      return id;
  }
  
  public String getPickupDate() {
      return pickupDate;
  }
  
  public String getDeliveryDate() {
      return deliveryDate;
  }
  
  public Double getLongitude() {
      return longitude;
  }
  
  public Double getLatitude() {
      return latitude;
  }
  
  public Integer getShirtsQuantity() {
      return shirtsQuantity;
  }
  
  public Integer getJacketsQuantity() {
      return jacketsQuantity;
  }
  
  public Integer getUnderWaresQuantity() {
      return underWaresQuantity;
  }
  
  public Integer getPantiesQuantity() {
      return pantiesQuantity;
  }
  
  public Integer getSuitesQuantity() {
      return suitesQuantity;
  }
  
  public Integer getOthersQuantity() {
      return othersQuantity;
  }
  
  public String getUserId() {
      return userId;
  }
  
  public State getState() {
      return state;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Orders(String id, String pickupDate, String deliveryDate, Double longitude, Double latitude, Integer shirtsQuantity, Integer jacketsQuantity, Integer underWaresQuantity, Integer pantiesQuantity, Integer suitesQuantity, Integer othersQuantity, String userId, State state) {
    this.id = id;
    this.pickupDate = pickupDate;
    this.deliveryDate = deliveryDate;
    this.longitude = longitude;
    this.latitude = latitude;
    this.shirtsQuantity = shirtsQuantity;
    this.jacketsQuantity = jacketsQuantity;
    this.underWaresQuantity = underWaresQuantity;
    this.pantiesQuantity = pantiesQuantity;
    this.suitesQuantity = suitesQuantity;
    this.othersQuantity = othersQuantity;
    this.userId = userId;
    this.state = state;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Orders orders = (Orders) obj;
      return ObjectsCompat.equals(getId(), orders.getId()) &&
              ObjectsCompat.equals(getPickupDate(), orders.getPickupDate()) &&
              ObjectsCompat.equals(getDeliveryDate(), orders.getDeliveryDate()) &&
              ObjectsCompat.equals(getLongitude(), orders.getLongitude()) &&
              ObjectsCompat.equals(getLatitude(), orders.getLatitude()) &&
              ObjectsCompat.equals(getShirtsQuantity(), orders.getShirtsQuantity()) &&
              ObjectsCompat.equals(getJacketsQuantity(), orders.getJacketsQuantity()) &&
              ObjectsCompat.equals(getUnderWaresQuantity(), orders.getUnderWaresQuantity()) &&
              ObjectsCompat.equals(getPantiesQuantity(), orders.getPantiesQuantity()) &&
              ObjectsCompat.equals(getSuitesQuantity(), orders.getSuitesQuantity()) &&
              ObjectsCompat.equals(getOthersQuantity(), orders.getOthersQuantity()) &&
              ObjectsCompat.equals(getUserId(), orders.getUserId()) &&
              ObjectsCompat.equals(getState(), orders.getState()) &&
              ObjectsCompat.equals(getCreatedAt(), orders.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), orders.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getPickupDate())
      .append(getDeliveryDate())
      .append(getLongitude())
      .append(getLatitude())
      .append(getShirtsQuantity())
      .append(getJacketsQuantity())
      .append(getUnderWaresQuantity())
      .append(getPantiesQuantity())
      .append(getSuitesQuantity())
      .append(getOthersQuantity())
      .append(getUserId())
      .append(getState())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Orders {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("pickupDate=" + String.valueOf(getPickupDate()) + ", ")
      .append("deliveryDate=" + String.valueOf(getDeliveryDate()) + ", ")
      .append("longitude=" + String.valueOf(getLongitude()) + ", ")
      .append("latitude=" + String.valueOf(getLatitude()) + ", ")
      .append("shirtsQuantity=" + String.valueOf(getShirtsQuantity()) + ", ")
      .append("jacketsQuantity=" + String.valueOf(getJacketsQuantity()) + ", ")
      .append("underWaresQuantity=" + String.valueOf(getUnderWaresQuantity()) + ", ")
      .append("pantiesQuantity=" + String.valueOf(getPantiesQuantity()) + ", ")
      .append("suitesQuantity=" + String.valueOf(getSuitesQuantity()) + ", ")
      .append("othersQuantity=" + String.valueOf(getOthersQuantity()) + ", ")
      .append("userId=" + String.valueOf(getUserId()) + ", ")
      .append("state=" + String.valueOf(getState()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static PickupDateStep builder() {
      return new Builder();
  }
  
  /** 
   * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
   * This is a convenience method to return an instance of the object with only its ID populated
   * to be used in the context of a parameter in a delete mutation or referencing a foreign key
   * in a relationship.
   * @param id the id of the existing item this instance will represent
   * @return an instance of this model with only ID populated
   * @throws IllegalArgumentException Checks that ID is in the proper format
   */
  public static Orders justId(String id) {
    try {
      UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
    } catch (Exception exception) {
      throw new IllegalArgumentException(
              "Model IDs must be unique in the format of UUID. This method is for creating instances " +
              "of an existing object with only its ID field for sending as a mutation parameter. When " +
              "creating a new object, use the standard builder method and leave the ID field blank."
      );
    }
    return new Orders(
      id,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      pickupDate,
      deliveryDate,
      longitude,
      latitude,
      shirtsQuantity,
      jacketsQuantity,
      underWaresQuantity,
      pantiesQuantity,
      suitesQuantity,
      othersQuantity,
      userId,
      state);
  }
  public interface PickupDateStep {
    DeliveryDateStep pickupDate(String pickupDate);
  }
  

  public interface DeliveryDateStep {
    LongitudeStep deliveryDate(String deliveryDate);
  }
  

  public interface LongitudeStep {
    LatitudeStep longitude(Double longitude);
  }
  

  public interface LatitudeStep {
    BuildStep latitude(Double latitude);
  }
  

  public interface BuildStep {
    Orders build();
    BuildStep id(String id) throws IllegalArgumentException;
    BuildStep shirtsQuantity(Integer shirtsQuantity);
    BuildStep jacketsQuantity(Integer jacketsQuantity);
    BuildStep underWaresQuantity(Integer underWaresQuantity);
    BuildStep pantiesQuantity(Integer pantiesQuantity);
    BuildStep suitesQuantity(Integer suitesQuantity);
    BuildStep othersQuantity(Integer othersQuantity);
    BuildStep userId(String userId);
    BuildStep state(State state);
  }
  

  public static class Builder implements PickupDateStep, DeliveryDateStep, LongitudeStep, LatitudeStep, BuildStep {
    private String id;
    private String pickupDate;
    private String deliveryDate;
    private Double longitude;
    private Double latitude;
    private Integer shirtsQuantity;
    private Integer jacketsQuantity;
    private Integer underWaresQuantity;
    private Integer pantiesQuantity;
    private Integer suitesQuantity;
    private Integer othersQuantity;
    private String userId;
    private State state;
    @Override
     public Orders build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Orders(
          id,
          pickupDate,
          deliveryDate,
          longitude,
          latitude,
          shirtsQuantity,
          jacketsQuantity,
          underWaresQuantity,
          pantiesQuantity,
          suitesQuantity,
          othersQuantity,
          userId,
          state);
    }
    
    @Override
     public DeliveryDateStep pickupDate(String pickupDate) {
        Objects.requireNonNull(pickupDate);
        this.pickupDate = pickupDate;
        return this;
    }
    
    @Override
     public LongitudeStep deliveryDate(String deliveryDate) {
        Objects.requireNonNull(deliveryDate);
        this.deliveryDate = deliveryDate;
        return this;
    }
    
    @Override
     public LatitudeStep longitude(Double longitude) {
        Objects.requireNonNull(longitude);
        this.longitude = longitude;
        return this;
    }
    
    @Override
     public BuildStep latitude(Double latitude) {
        Objects.requireNonNull(latitude);
        this.latitude = latitude;
        return this;
    }
    
    @Override
     public BuildStep shirtsQuantity(Integer shirtsQuantity) {
        this.shirtsQuantity = shirtsQuantity;
        return this;
    }
    
    @Override
     public BuildStep jacketsQuantity(Integer jacketsQuantity) {
        this.jacketsQuantity = jacketsQuantity;
        return this;
    }
    
    @Override
     public BuildStep underWaresQuantity(Integer underWaresQuantity) {
        this.underWaresQuantity = underWaresQuantity;
        return this;
    }
    
    @Override
     public BuildStep pantiesQuantity(Integer pantiesQuantity) {
        this.pantiesQuantity = pantiesQuantity;
        return this;
    }
    
    @Override
     public BuildStep suitesQuantity(Integer suitesQuantity) {
        this.suitesQuantity = suitesQuantity;
        return this;
    }
    
    @Override
     public BuildStep othersQuantity(Integer othersQuantity) {
        this.othersQuantity = othersQuantity;
        return this;
    }
    
    @Override
     public BuildStep userId(String userId) {
        this.userId = userId;
        return this;
    }
    
    @Override
     public BuildStep state(State state) {
        this.state = state;
        return this;
    }
    
    /** 
     * WARNING: Do not set ID when creating a new object. Leave this blank and one will be auto generated for you.
     * This should only be set when referring to an already existing object.
     * @param id id
     * @return Current Builder instance, for fluent method chaining
     * @throws IllegalArgumentException Checks that ID is in the proper format
     */
    public BuildStep id(String id) throws IllegalArgumentException {
        this.id = id;
        
        try {
            UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
        } catch (Exception exception) {
          throw new IllegalArgumentException("Model IDs must be unique in the format of UUID.",
                    exception);
        }
        
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, String pickupDate, String deliveryDate, Double longitude, Double latitude, Integer shirtsQuantity, Integer jacketsQuantity, Integer underWaresQuantity, Integer pantiesQuantity, Integer suitesQuantity, Integer othersQuantity, String userId, State state) {
      super.id(id);
      super.pickupDate(pickupDate)
        .deliveryDate(deliveryDate)
        .longitude(longitude)
        .latitude(latitude)
        .shirtsQuantity(shirtsQuantity)
        .jacketsQuantity(jacketsQuantity)
        .underWaresQuantity(underWaresQuantity)
        .pantiesQuantity(pantiesQuantity)
        .suitesQuantity(suitesQuantity)
        .othersQuantity(othersQuantity)
        .userId(userId)
        .state(state);
    }
    
    @Override
     public CopyOfBuilder pickupDate(String pickupDate) {
      return (CopyOfBuilder) super.pickupDate(pickupDate);
    }
    
    @Override
     public CopyOfBuilder deliveryDate(String deliveryDate) {
      return (CopyOfBuilder) super.deliveryDate(deliveryDate);
    }
    
    @Override
     public CopyOfBuilder longitude(Double longitude) {
      return (CopyOfBuilder) super.longitude(longitude);
    }
    
    @Override
     public CopyOfBuilder latitude(Double latitude) {
      return (CopyOfBuilder) super.latitude(latitude);
    }
    
    @Override
     public CopyOfBuilder shirtsQuantity(Integer shirtsQuantity) {
      return (CopyOfBuilder) super.shirtsQuantity(shirtsQuantity);
    }
    
    @Override
     public CopyOfBuilder jacketsQuantity(Integer jacketsQuantity) {
      return (CopyOfBuilder) super.jacketsQuantity(jacketsQuantity);
    }
    
    @Override
     public CopyOfBuilder underWaresQuantity(Integer underWaresQuantity) {
      return (CopyOfBuilder) super.underWaresQuantity(underWaresQuantity);
    }
    
    @Override
     public CopyOfBuilder pantiesQuantity(Integer pantiesQuantity) {
      return (CopyOfBuilder) super.pantiesQuantity(pantiesQuantity);
    }
    
    @Override
     public CopyOfBuilder suitesQuantity(Integer suitesQuantity) {
      return (CopyOfBuilder) super.suitesQuantity(suitesQuantity);
    }
    
    @Override
     public CopyOfBuilder othersQuantity(Integer othersQuantity) {
      return (CopyOfBuilder) super.othersQuantity(othersQuantity);
    }
    
    @Override
     public CopyOfBuilder userId(String userId) {
      return (CopyOfBuilder) super.userId(userId);
    }
    
    @Override
     public CopyOfBuilder state(State state) {
      return (CopyOfBuilder) super.state(state);
    }
  }
  
}
