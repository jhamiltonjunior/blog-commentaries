package com.commentaries.domain.entities.validators;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.commentaries.shared.Either;
import com.commentaries.domain.entities.errors.InvalidTitle;

public class TitleTest {
  @Test
  public void shouldBeLeftCaseHaveMuthCharacters() {
    String content = "";

    for (int i = 0; i < 257; i++) {
      content = "c";
    }
    
    final Either<InvalidTitle, Title> title = Title.create(content);

    assertEquals(title.isLeft(), true);
  }

  @Test
  public void shouldBeLeftCaseHaveLittleCharacters() {
    final String content = "small";
    
    final Either<InvalidTitle, Title> title = Title.create(content);

    assertEquals(title.isLeft(), true);
  }

  @Test
  public void shouldBeRight() {
    final String content = "How to migrate of Go to Java?";

    Either<InvalidTitle, Title> title = Title.create(content);

    assertEquals(title.isRight(), true);
  }
}
