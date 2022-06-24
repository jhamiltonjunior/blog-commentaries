package com.commentaries.domain.entities.validators;

import com.commentaries.domain.entities.errors.InvalidTitle;
import com.commentaries.shared.Either;

public class Title {
  private String title;

  private Title(String title) {
    this.title = title;
  }

  public String value() {
    return this.title;
  }

  public static Either<InvalidTitle, Title> create(String title) {
    if (!Title.validator(title)) {
      return Either.left(new InvalidTitle());
    }

    return Either.right(new Title(title));
  }

  public static boolean validator(String title) {
    final int titleLength = title.length();
    
    if (
      title == null ||
      titleLength > 255 ||
      titleLength < 10    
    ) {
      return false;
    }

    return true;
  }
}
