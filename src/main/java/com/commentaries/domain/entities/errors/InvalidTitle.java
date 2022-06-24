package com.commentaries.domain.entities.errors;

public class InvalidTitle extends Error {
  public InvalidTitle () {
    super(new Error("This author is invalid"));
  }
}
