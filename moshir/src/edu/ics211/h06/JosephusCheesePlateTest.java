package edu.ics211.h06;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import edu.ics211.h02.Cheese;
import edu.ics211.h02.CheeseType;
import edu.ics211.h02.ManoaCheeseFromager;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class JosephusCheesePlateTest {
  private ManoaCheeseFromager fromager;
  private Cheese[] cheeses;
  private static final int NUM_CHEESES = 7;

  @BeforeEach
  void setUp() throws Exception {
    this.fromager = ManoaCheeseFromager.getInstance();
    this.cheeses = new Cheese[NUM_CHEESES];
    for (int i = 0; i < NUM_CHEESES; i++) {
      cheeses[i] = fromager.makeCheese("Cheese " + (i + 1), CheeseType.getRandomCheeseType());
    }
  }


  @Test
  void testTasteCheeses() {
    JosephusCheesePlate plate = new JosephusCheesePlate(cheeses);
    List<Cheese> tasting = plate.tasteCheeses(1, 3, true);
    assertEquals(cheeses.length, tasting.size());
    assertEquals(cheeses[2], tasting.get(0));
    assertEquals(cheeses[5],tasting.get(1));
    assertEquals(cheeses[1], tasting.get(2));
    assertEquals(cheeses[6], tasting.get(3));
    assertEquals(cheeses[4], tasting.get(4));
    assertEquals(cheeses[0], tasting.get(5));
    assertEquals(cheeses[3], tasting.get(6));
    tasting = plate.tasteCheeses(4, 2, false);
    assertTrue(tasting.size() == cheeses.length);
    assertEquals(cheeses[2], tasting.get(0));
    assertEquals(cheeses[0], tasting.get(1));
    assertEquals(cheeses[5], tasting.get(2));
    assertEquals(cheeses[3], tasting.get(3));
    assertEquals(cheeses[6], tasting.get(4));
    assertEquals(cheeses[1], tasting.get(5));
    assertEquals(cheeses[4], tasting.get(6));
    tasting = plate.tasteCheeses(1, 1, false);
    assertTrue(tasting.size() == cheeses.length);
    assertEquals(cheeses[0], tasting.get(0));
    assertEquals(cheeses[6], tasting.get(1));
    assertEquals(cheeses[5], tasting.get(2));
    assertEquals(cheeses[4], tasting.get(3));
    assertEquals(cheeses[3], tasting.get(4));
    assertEquals(cheeses[2], tasting.get(5));

  }

}
