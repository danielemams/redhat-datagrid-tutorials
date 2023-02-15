package org.infinispan.tutorial.simple.remote.persistence;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DBCreatorTest {

   DBCreator dbCreator = new DBCreator();

   @Test
   public void createAndPopulateDB() {
      dbCreator.setUrl();
      dbCreator.createAndPopulate();

      List<Author> authors = dbCreator.readAuthors();

      assertEquals(4, authors.size());

      List<String> bookIds = dbCreator.loadBooksId();
      assertEquals(4, bookIds.size());
      assertTrue(bookIds.contains("20-111-000"));
   }

}