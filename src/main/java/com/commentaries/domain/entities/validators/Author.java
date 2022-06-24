package com.commentaries.domain.entities.validators;

import com.commentaries.domain.entities.errors.InvalidAuthor;
import com.commentaries.domain.entities.interfaces.AuthorData;
import com.commentaries.shared.Either;

public class Author {
  private AuthorData author;

  private Author(AuthorData author) {
    this.author = author;
  }


  public AuthorData value() {
    return this.author;
  }

  public static Either<InvalidAuthor, Author> create(AuthorData author) {
    // author.name = author.name.trim();

    if(!Author.validator(author))
      return Either.left(new InvalidAuthor());
    else
      return Either.right(new Author(author));
  }

  static boolean validator(AuthorData author) {
    int nameLength = author.name.length();
    
    if (
      author.name == null ||
      author.user_id == null ||
      nameLength < 2 ||
      nameLength > 255
    ) {
      return false;
    }

    return true;
  }
}
