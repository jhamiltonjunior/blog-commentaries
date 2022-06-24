package com.commentaries.domain.entities.errors;

public class InvalidError {
  public InvalidTitle invalidTitle;
    public InvalidBody invalidBody;
    public InvalidAuthor invalidAuthor;
    public InvalidCreatedAt invalidCreatedAt;
    public InvalidUpdatedAt invalidUpdatedAt;

    public InvalidError(InvalidTitle type) {
      this.invalidTitle = type;
    }

    public InvalidError(InvalidBody type) {
      this.invalidBody = type;

    }

    public InvalidError(InvalidAuthor type) {
      this.invalidAuthor = type;

    }

    public InvalidError(InvalidCreatedAt type) {
      this.invalidCreatedAt = type;

    }

    public InvalidError(InvalidUpdatedAt type) {
      this.invalidUpdatedAt = type;

    }
}
