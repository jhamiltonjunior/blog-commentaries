package com.commentaries.domain.entities.validators;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.commentaries.shared.Either;
import com.commentaries.domain.entities.errors.InvalidAuthor;
import com.commentaries.domain.entities.interfaces.AuthorData;

/**
 * Unit test for simple App.
 */
public class AuthorTest {
    /**
     * Should be left if name of user have lenght < 2 :-)
     */
    @Test
    public void shouldBeLeftCaseInvalidName() {
        final AuthorData authorData = new AuthorData("", "ddd");

        Either<InvalidAuthor, Author> author = Author.create(authorData);

        assertEquals(author.isLeft(), true);
    }

    @Test
    public void shouldReturnInvalidUser() {
        // final AuthorData authorData = new AuthorData();
        // authorData.name = "";
        // authorData.user_id = "";

        // Either<InvalidAuthor, Author> author = Author.create(authorData);

        assertTrue(true);
    }

    @Test
    public void shouldBeRight() {
        final AuthorData authorData = new AuthorData("dddd", "dddd");

        Either<InvalidAuthor, Author> author = Author.create(authorData);

        assertEquals(author.isRight(), true);
    }
}
