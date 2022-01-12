package school.hei.haapi.endpoint.event;

import java.io.Serializable;

/**
 * Event models generated by EventBridge are NOT typed, unfortunately.
 * TypedEvent takes care of that.
 */
public abstract class TypedEvent {
  public String getType() {
    return this.getClass().getTypeName();
  }

  public abstract Serializable getPayload();
}