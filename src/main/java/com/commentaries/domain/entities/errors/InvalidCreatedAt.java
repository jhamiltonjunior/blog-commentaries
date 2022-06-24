package com.commentaries.domain.entities.errors;

public class InvalidCreatedAt extends Error {
  public InvalidCreatedAt () {
    super(new Error("This author is invalid"));
  }
}
