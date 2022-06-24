package com.commentaries.domain.entities.interfaces;

import java.time.LocalDateTime;

public class CommentaryData {
  public String title;
  public String body;
  public AuthorData author;
  public LocalDateTime createdAt;
  public LocalDateTime updatedAt;

}
