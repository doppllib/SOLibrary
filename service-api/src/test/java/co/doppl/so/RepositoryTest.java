package co.doppl.so;

import org.junit.Test;
import java.util.List;
import co.doppl.so.api.Question;
import co.doppl.so.api.Repository;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class RepositoryTest {
  @Test
  public void current() {
    List<Question> result=Repository.get().current().blockingGet();

    assertEquals(15, result.size());

    for (Question q : result) {
      assertNotNull(q.getTitle());
      assertTrue(q.getOwnerAvatar().startsWith("https://"));
    }
  }
}
