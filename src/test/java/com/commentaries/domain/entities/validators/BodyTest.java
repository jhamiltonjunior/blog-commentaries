package com.commentaries.domain.entities.validators;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.commentaries.shared.Either;
import com.commentaries.domain.entities.errors.InvalidBody;

public class BodyTest {
  /*
   * Should Be Left case have less than 20 characters
   */
  @Test
  public void shouldBeLeftCaseInvalidBody() {
    final String contentBody = "como posso fazer?";

    Either<InvalidBody, Body> body = Body.create(contentBody);

		// assertEquals(body.Left().get(), new InvalidBody());
    assertEquals(body.isLeft(), true);
  }

  /*
   * Should Be Right case have more of 20 characters
   */
  @Test
  public void shouldBeRight() {
    // more of 20 characters
    final String contentBody = "como posso fazer iss?";

    Either<InvalidBody, Body> body = Body.create(contentBody);

    assertEquals(body.isRight(), true);
  }
}
