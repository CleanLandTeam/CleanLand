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

/** This is an auto generated class representing the Donate type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Donates")
public final class Donate implements Model {
  public static final QueryField ID = field("Donate", "id");
  public static final QueryField PICKUP_DATE = field("Donate", "pickupDate");
  public static final QueryField LONGITUDE = field("Donate", "longitude");
  public static final QueryField LATITUDE = field("Donate", "latitude");
  public static final QueryField SHIRTS_QUANTITY = field("Donate", "shirtsQuantity");
  public static final QueryField JACKETS_QUANTITY = field("Donate", "jacketsQuantity");
  public static final QueryField UNDER_WARES_QUANTITY = field("Donate", "underWaresQuantity");
  public static final QueryField PANTIES_QUANTITY = field("Donate", "pantiesQuantity");
  public static final QueryField SUITES_QUANTITY = field("Donate", "suitesQuantity");
  public static final QueryField OTHERS_QUANTITY = field("Donate", "othersQuantity");
  public static final QueryField USER_ID = field("Donate", "userId");
  public static final QueryField CONDITION = field("Donate", "condition");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String pickupDate;
  private final @ModelField(targetType="Float", isRequired = true) Double longitude;
  private final @ModelField(targetType="Float", isRequired = true) Double latitude;
  private final @ModelField(targetType="Int") Integer shirtsQuantity;
  private final @ModelField(targetType="Int") Integer jacketsQuantity;
  private final @ModelField(targetType="Int") Integer underWaresQuantity;
  private final @ModelField(targetType="Int") Integer pantiesQuantity;
  private final @ModelField(targetType="Int") Integer suitesQuantity;
  private final @ModelField(targetType="Int") Integer othersQuantity;
  private final @ModelField(targetType="String") String userId;
  private final @ModelField(targetType="Condition") Condition condition;

  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;

  public String getId() {
      return id;
  }
  
  public String getPickupDate() {
      return pickupDate;
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
  
  public Condition getCondition() {
      return condition;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Donate(String id, String pickupDate, Double longitude, Double latitude, Integer shirtsQuantity, Integer jacketsQuantity, Integer underWaresQuantity, Integer pantiesQuantity, Integer suitesQuantity, Integer othersQuantity, String userId, Condition condition) {
    this.id = id;
    this.pickupDate = pickupDate;
    this.longitude = longitude;
    this.latitude = latitude;
    this.shirtsQuantity = shirtsQuantity;
    this.jacketsQuantity = jacketsQuantity;
    this.underWaresQuantity = underWaresQuantity;
    this.pantiesQuantity = pantiesQuantity;
    this.suitesQuantity = suitesQuantity;
    this.othersQuantity = othersQuantity;
    this.userId = userId;
    this.condition = condition;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Donate donate = (Donate) obj;
      return ObjectsCompat.equals(getId(), donate.getId()) &&
              ObjectsCompat.equals(getPickupDate(), donate.getPickupDate()) &&
              ObjectsCompat.equals(getLongitude(), donate.getLongitude()) &&
              ObjectsCompat.equals(getLatitude(), donate.getLatitude()) &&
              ObjectsCompat.equals(getShirtsQuantity(), donate.getShirtsQuantity()) &&
              ObjectsCompat.equals(getJacketsQuantity(), donate.getJacketsQuantity()) &&
              ObjectsCompat.equals(getUnderWaresQuantity(), donate.getUnderWaresQuantity()) &&
              ObjectsCompat.equals(getPantiesQuantity(), donate.getPantiesQuantity()) &&
              ObjectsCompat.equals(getSuitesQuantity(), donate.getSuitesQuantity()) &&
              ObjectsCompat.equals(getOthersQuantity(), donate.getOthersQuantity()) &&
              ObjectsCompat.equals(getUserId(), donate.getUserId()) &&
              ObjectsCompat.equals(getCondition(), donate.getCondition()) &&
              ObjectsCompat.equals(getCreatedAt(), donate.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), donate.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getPickupDate())
      .append(getLongitude())
      .append(getLatitude())
      .append(getShirtsQuantity())
      .append(getJacketsQuantity())
      .append(getUnderWaresQuantity())
      .append(getPantiesQuantity())
      .append(getSuitesQuantity())
      .append(getOthersQuantity())
      .append(getUserId())
      .append(getCondition())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Donate {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("pickupDate=" + String.valueOf(getPickupDate()) + ", ")
      .append("longitude=" + String.valueOf(getLongitude()) + ", ")
      .append("latitude=" + String.valueOf(getLatitude()) + ", ")
      .append("shirtsQuantity=" + String.valueOf(getShirtsQuantity()) + ", ")
      .append("jacketsQuantity=" + String.valueOf(getJacketsQuantity()) + ", ")
      .append("underWaresQuantity=" + String.valueOf(getUnderWaresQuantity()) + ", ")
      .append("pantiesQuantity=" + String.valueOf(getPantiesQuantity()) + ", ")
      .append("suitesQuantity=" + String.valueOf(getSuitesQuantity()) + ", ")
      .append("othersQuantity=" + String.valueOf(getOthersQuantity()) + ", ")
      .append("userId=" + String.valueOf(getUserId()) + ", ")
      .append("condition=" + String.valueOf(getCondition()) + ", ")
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
  public static Donate justId(String id) {
    try {
      UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
    } catch (Exception exception) {
      throw new IllegalArgumentException(
              "Model IDs must be unique in the format of UUID. This method is for creating instances " +
              "of an existing object with only its ID field for sending as a mutation parameter. When " +
              "creating a new object, use the standard builder method and leave the ID field blank."
      );
    }
    return new Donate(
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
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      pickupDate,
      longitude,
      latitude,
      shirtsQuantity,
      jacketsQuantity,
      underWaresQuantity,
      pantiesQuantity,
      suitesQuantity,
      othersQuantity,
      userId,
      condition);
  }
  public interface PickupDateStep {
    LongitudeStep pickupDate(String pickupDate);
  }
  

  public interface LongitudeStep {
    LatitudeStep longitude(Double longitude);
  }
  

  public interface LatitudeStep {
    BuildStep latitude(Double latitude);
  }
  

  public interface BuildStep {
    Donate build();
    BuildStep id(String id) throws IllegalArgumentException;
    BuildStep shirtsQuantity(Integer shirtsQuantity);
    BuildStep jacketsQuantity(Integer jacketsQuantity);
    BuildStep underWaresQuantity(Integer underWaresQuantity);
    BuildStep pantiesQuantity(Integer pantiesQuantity);
    BuildStep suitesQuantity(Integer suitesQuantity);
    BuildStep othersQuantity(Integer othersQuantity);
    BuildStep userId(String userId);
    BuildStep condition(Condition condition);
  }
  

  public static class Builder implements PickupDateStep, LongitudeStep, LatitudeStep, BuildStep {
    private String id;
    private String pickupDate;
    private Double longitude;
    private Double latitude;
    private Integer shirtsQuantity;
    private Integer jacketsQuantity;
    private Integer underWaresQuantity;
    private Integer pantiesQuantity;
    private Integer suitesQuantity;
    private Integer othersQuantity;
    private String userId;
    private Condition condition;
    @Override
     public Donate build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Donate(
          id,
          pickupDate,
          longitude,
          latitude,
          shirtsQuantity,
          jacketsQuantity,
          underWaresQuantity,
          pantiesQuantity,
          suitesQuantity,
          othersQuantity,
          userId,
          condition);
    }
    
    @Override
     public LongitudeStep pickupDate(String pickupDate) {
        Objects.requireNonNull(pickupDate);
        this.pickupDate = pickupDate;
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
     public BuildStep condition(Condition condition) {
        this.condition = condition;
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
    private CopyOfBuilder(String id, String pickupDate, Double longitude, Double latitude, Integer shirtsQuantity, Integer jacketsQuantity, Integer underWaresQuantity, Integer pantiesQuantity, Integer suitesQuantity, Integer othersQuantity, String userId, Condition condition) {
      super.id(id);
      super.pickupDate(pickupDate)
        .longitude(longitude)
        .latitude(latitude)
        .shirtsQuantity(shirtsQuantity)
        .jacketsQuantity(jacketsQuantity)
        .underWaresQuantity(underWaresQuantity)
        .pantiesQuantity(pantiesQuantity)
        .suitesQuantity(suitesQuantity)
        .othersQuantity(othersQuantity)
        .userId(userId)
        .condition(condition);
    }
    
    @Override
     public CopyOfBuilder pickupDate(String pickupDate) {
      return (CopyOfBuilder) super.pickupDate(pickupDate);
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
     public CopyOfBuilder condition(Condition condition) {
      return (CopyOfBuilder) super.condition(condition);
    }
  }
  
}
