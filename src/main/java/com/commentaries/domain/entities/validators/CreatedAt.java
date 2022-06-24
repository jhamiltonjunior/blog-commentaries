package com.commentaries.domain.entities.validators;

import java.time.LocalDateTime;

import com.commentaries.domain.entities.errors.InvalidCreatedAt;
import com.commentaries.shared.Either;

public class CreatedAt {
  protected LocalDateTime createdAt;

  private CreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDateTime value() {
    return this.createdAt;
  }

  public static Either<InvalidCreatedAt, CreatedAt> create (LocalDateTime createdAt) {
    if (!CreatedAt.validator(createdAt)){
      return Either.left(new InvalidCreatedAt());
    }
    
    return Either.right(new CreatedAt(createdAt));
  }

  public static boolean validator(LocalDateTime createdAt) {
    if (createdAt == null) {
      return false;
    }

    return true;
  }
}
