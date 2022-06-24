package com.commentaries.domain.entities.validators;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Test;

import com.commentaries.shared.Either;
import com.commentaries.domain.entities.errors.InvalidUpdatedAt;

public class UpdatedAtTest {
  @Test
  public void shouldBeLeftCaseNull() {
    final Either<InvalidUpdatedAt, UpdatedAt> updatedAt = UpdatedAt.create(null);

    assertEquals(updatedAt.isLeft(), true);
  }

  @Test
  public void shouldBeRight() {
    final Either<InvalidUpdatedAt, UpdatedAt> updatedAt = UpdatedAt.create(LocalDateTime.now());

    assertEquals(updatedAt.isRight(), true);
  }
}
