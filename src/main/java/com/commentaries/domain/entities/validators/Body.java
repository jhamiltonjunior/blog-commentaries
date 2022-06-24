package com.commentaries.domain.entities.validators;

import com.commentaries.domain.entities.errors.InvalidBody;
import com.commentaries.shared.Either;

public class Body {
  protected String body;

  public Body(String body) {
    this.body = body;
  }

  public String value() {
    return this.body;
  }

  public static Either<InvalidBody, Body> create(String body) {
    if (!Body.validator(body)) 
      return Either.left(new InvalidBody());
    else 
      return Either.right(new Body(body));
  }

  public static boolean validator(String body) {
    final int bodyLength = body.length();
    
    if (
    bodyLength < 20
    ) {
      return false;
    } 

    return true;
  }
}
