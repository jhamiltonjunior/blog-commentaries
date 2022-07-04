package com.commentaries.app.usecases.commentaries.interfaces;

import com.commentaries.domain.entities.interfaces.AuthorData;
import com.commentaries.domain.entities.interfaces.CommentaryData;
import com.commentaries.shared.Either;

public interface CommentaryInterface {
  Either<Error, CommentaryData> createCommentaryOnDatabase(CommentaryData commentary, AuthorData author);
  Either<Error, String> deleteCommentary (String userId, String commentaryId);
}
