package com.commentaries.domain.entities.errors;

public class InvalidBody extends Error {
  public InvalidBody () {
    super(new Error("This author is invalid"));
  }
}
