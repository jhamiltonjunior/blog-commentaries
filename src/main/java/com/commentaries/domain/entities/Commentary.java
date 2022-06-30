package com.commentaries.domain.entities;

import java.time.LocalDateTime;

import com.commentaries.domain.entities.errors.*;
import com.commentaries.domain.entities.interfaces.AuthorData;
import com.commentaries.domain.entities.interfaces.CommentaryData;
import com.commentaries.domain.entities.validators.*;
import com.commentaries.shared.Either;

public class Commentary {
  public AuthorData author;
  public String body;
  public LocalDateTime createdAt;
  public String title;
  public LocalDateTime updatedAt;

  /*
   * This constructor is to be use whele the user create the commentary
   */
  private Commentary(
      AuthorData author,
      String body,
      LocalDateTime createdAt,
      String title) {
    this.author = author;
    this.body = body;
    this.createdAt = createdAt;
    this.title = title;
  }

  /*
   * This constructor is to use whele the user make update in the commentary
   */
  private Commentary(
      AuthorData author,
      String body,
      LocalDateTime createdAt,
      String title,
      LocalDateTime updatedAt) {
    this.author = author;
    this.body = body;
    this.createdAt = createdAt;
    this.title = title;
    this.updatedAt = updatedAt;
  }

  /*
   * the create method validate the content of commentary
   * 
   * please not use Error for return something different of entities/errors
   */
  public static Either<Error, Commentary> create(CommentaryData commentary) {
    final Either<InvalidAuthor, Author> authorOrError = Author.create(commentary.author);
    final Either<InvalidBody, Body> bodyOrError = Body.create(commentary.body);
    final Either<InvalidCreatedAt, CreatedAt> createdAtOrError = CreatedAt.create(commentary.createdAt);
    final Either<InvalidTitle, Title> titleOrError = Title.create(commentary.title);

    if (authorOrError.isLeft()) {
      return Either.left(new Error(new InvalidAuthor()));
    }
    if (bodyOrError.isLeft()) {
      return Either.left(new Error(new InvalidBody()));
    }
    if (createdAtOrError.isLeft()) {
      return Either.left(new Error(new InvalidCreatedAt()));
    }
    if (titleOrError.isLeft()) {
      return Either.left(new Error(new InvalidTitle()));
    }

    final Author author = authorOrError.Right().get();
    final Body body = bodyOrError.Right().get();
    final CreatedAt createdAt = createdAtOrError.Right().get();
    final Title title = titleOrError.Right().get();

    return Either.right(new Commentary(
        author.value(),
        body.value(),
        createdAt.value(),
        title.value()));
  }

  public static Either<Error, Commentary> update(CommentaryData article) {
    final Either<InvalidAuthor, Author> authorOrError = Author.create(article.author);
    final Either<InvalidBody, Body> bodyOrError = Body.create(article.body);
    final Either<InvalidCreatedAt, CreatedAt> createdAtOrError = CreatedAt.create(article.createdAt);
    final Either<InvalidTitle, Title> titleOrError = Title.create(article.title);
    final Either<InvalidUpdatedAt, UpdatedAt> updatedAtOrError = UpdatedAt.create(article.updatedAt);

    if (authorOrError.isLeft()) {
      return Either.left(new Error(new InvalidAuthor()));
    }
    if (bodyOrError.isLeft()) {
      return Either.left(new Error(new InvalidBody()));
    }
    if (createdAtOrError.isLeft()) {
      return Either.left(new Error(new InvalidCreatedAt()));
    }
    if (titleOrError.isLeft()) {
      return Either.left(new Error(new InvalidTitle()));
    }
    if (updatedAtOrError.isLeft()) {
      return Either.left(new Error(new InvalidUpdatedAt()));
    }

    final Author author = authorOrError.Right().get();
    final Body body = bodyOrError.Right().get();
    final CreatedAt createdAt = createdAtOrError.Right().get();
    final Title title = titleOrError.Right().get();
    final UpdatedAt updatedAt = updatedAtOrError.Right().get();

    return Either.right(new Commentary(
        author.value(),
        body.value(),
        createdAt.value(),
        title.value(),
        updatedAt.value()));
  }
}
