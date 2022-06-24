package com.commentaries.shared;

import java.util.Optional;

public class Either<L, R> {
  private Either(Optional<L> l, Optional<R> r) {
    left = l;
    right = r;
  }

  public static <L, R> Either<L, R> left(L value) {
    return new Either<>(Optional.of(value), null);
  }

  public static <L, R> Either<L, R> right(R value) {
    return new Either<>(null, Optional.of(value));
  }

  private final Optional<L> left;
  private final Optional<R> right;

  public boolean isLeft() {
    return left != null;
  }

  public Optional<L> Left() {
    return left;
  }

  public Optional<R> Right() {
    return right;
  }

  
  public boolean isRight() {
    return right != null;
  }
}

/*
class A {}
class B {}

public class Either {
  private Optional<A> left = null;
  private Optional<B> right = null;

  private Either(Optional<A> a,Optional<B> b) {
      left = a;
      right = b;
  }

  public static  Either left(Optional<A> a) {
      return new Either(a,null);
  }

  public Optional<A> left() {
      return left;
  }

  public boolean isLeft() {
      return left != null;
  }

  public boolean isRight() {
      return right != null;
  }

  public Optional<B> right() {
      return right;
  }

  public static  Either right(Optional<B> b) {
      return new Either(null,b);
  }
}
*/