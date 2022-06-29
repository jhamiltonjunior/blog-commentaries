package com.commentaries.domain.entities;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Test;

import com.commentaries.shared.Either;
import com.commentaries.domain.entities.errors.*;
import com.commentaries.domain.entities.interfaces.*;

public class CommentaryTest {
	/**
	 * Should be left if name of user have lenght < 2 :-)
	 */
	@Test
	public void shouldReturnInvalidAuthor() {

		CommentaryData contentCommentary = new CommentaryData();
		contentCommentary.author = new AuthorData("", "");

		contentCommentary.body = "This is a valid body of commentary";
		contentCommentary.title = "This is a valid title of commentary";
		contentCommentary.createdAt = LocalDateTime.now();

		Either<Error, Commentary> commentary = Commentary.create(contentCommentary);

		Error toBeLeft = commentary.Left().get();

		assertEquals(toBeLeft.toString(), new Error(new InvalidAuthor()).toString());
		assertEquals(commentary.isLeft(), true);
	}

	@Test
	public void shouldReturnInvalidBody() {
		CommentaryData contentCommentary = new CommentaryData();
		contentCommentary.author = new AuthorData("I'm José Hamilton", "is this my id");

		contentCommentary.body = "";
		contentCommentary.title = "This is a valid title of commentary";
		contentCommentary.createdAt = LocalDateTime.now();

		Either<Error, Commentary> commentary = Commentary.create(contentCommentary);

		Error toBeLeft = commentary.Left().get();

		assertEquals(toBeLeft.toString(), new Error(new InvalidBody()).toString());
		assertEquals(commentary.isLeft(), true);
	}

	@Test
	public void shouldBeRight() {
		// final AuthorData authorData = new AuthorData();
		// authorData.name = "dddd";
		// authorData.user_id = "dddd";

		// Either<InvalidAuthor, Author> author = Author.create(authorData);

		// assertEquals(author.isRight(), true);
	}
}
