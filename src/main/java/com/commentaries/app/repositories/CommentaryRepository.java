package com.commentaries.app.repositories;

import com.commentaries.domain.entities.interfaces.CommentaryData;

public interface CommentaryRepository {
  String deleteById(String userId, String commentaryId);
  void add(CommentaryData commentary, String userId, String articleId);
}
