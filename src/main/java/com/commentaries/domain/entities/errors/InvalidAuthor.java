package com.commentaries.domain.entities.errors;

public class InvalidAuthor extends Error {
  public InvalidAuthor () {
    super(new Error("This author is invalid"));
  }
}
