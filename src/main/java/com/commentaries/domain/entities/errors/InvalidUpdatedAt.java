package com.commentaries.domain.entities.errors;

public class InvalidUpdatedAt extends Error {
  public InvalidUpdatedAt () {
    super(new Error("This author is invalid"));
  }
}
