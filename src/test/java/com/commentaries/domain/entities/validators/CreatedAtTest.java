package com.commentaries.domain.entities.validators;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Test;

import com.commentaries.shared.Either;
import com.commentaries.domain.entities.errors.InvalidCreatedAt;

public class CreatedAtTest {
  @Test
  public void shouldBeLeftCaseInvalidCreatedAt() {
    final Either<InvalidCreatedAt, CreatedAt> createdAt = CreatedAt.create(null);

    assertEquals(createdAt.isLeft(), true);
  }

  @Test
  public void shouldBeRight() {
    final Either<InvalidCreatedAt, CreatedAt> createdAt = CreatedAt.create(LocalDateTime.now());

    assertEquals(createdAt.isRight(), true);
  }
}
