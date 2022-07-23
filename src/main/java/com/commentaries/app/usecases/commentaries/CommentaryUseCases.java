package com.commentaries.app.usecases.commentaries;

import com.commentaries.app.usecases.commentaries.interfaces.CommentaryInterface;
import com.commentaries.domain.entities.Commentary;
import com.commentaries.domain.entities.interfaces.AuthorData;
import com.commentaries.domain.entities.interfaces.CommentaryData;
import com.commentaries.shared.Either;

public class CommentaryUseCases implements CommentaryInterface {
  public Either<Error, CommentaryData> createCommentaryOnDatabase(CommentaryData commentary, AuthorData author) {
    Either<Error, Commentary> commentaryOrError = Commentary.create(commentary);

    if (commentaryOrError.isLeft()) {
      return Either.left(new Error("Does not posible create commentary"));
    }

    Commentary commentaryData = commentaryOrError.Right().get();

    return Either.left(new Error());
  }

  public Either<Error, String> deleteCommentary (String userId, String commentaryId) {
    return Either.right("i");
  }
}
