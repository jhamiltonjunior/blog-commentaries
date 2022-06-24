package com.commentaries.domain.entities.validators;

import java.time.LocalDateTime;

import com.commentaries.domain.entities.errors.InvalidUpdatedAt;
import com.commentaries.shared.Either;

public class UpdatedAt {
  protected LocalDateTime updatedAt;
  
  private UpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  public LocalDateTime value() {
    return this.updatedAt;
  }

  public static Either<InvalidUpdatedAt, UpdatedAt> create (LocalDateTime updatedAt) {
    if (!UpdatedAt.validator(updatedAt)){
      return Either.left(new InvalidUpdatedAt());
    }
    
    return Either.right(new UpdatedAt(updatedAt));
  }

  public static boolean validator(LocalDateTime updatedAt) {
    if (updatedAt == null) {
      return false;
    }

    return true;
  }
}
