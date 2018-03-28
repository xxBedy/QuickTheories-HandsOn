package com.vendavo.interview.thermometer;

import static org.junit.Assert.assertEquals;
import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.SourceDSL.doubles;

import org.junit.Before;
import org.junit.Test;

/**
 * User: mbednar Date: 04.03.18 Time: 12:17
 */
public class ThermometerImplTest {

  private Thermometer thermometer;

  @Before
  public void setUp() throws Exception {
    thermometer = new ThermometerImpl();
  }

  @Test
  public void checkRED() {
    qt()
        .forAll(doubles().from(40).upToAndIncluding(Double.MAX_VALUE))
        .checkAssert(
            (temp) -> assertEquals("Values above 40 is RED", thermometer.measure(temp), Color.RED));
  }

  @Test
  public void checkORANGE() {
    qt()
        .forAll(doubles().from(35).upToAndIncluding(40)).assuming((x) -> x != 40)
        .checkAssert(
            (temp) -> assertEquals("Values between (35, 40> is ORANGE", thermometer.measure(temp),
                Color.ORANGE));
  }

  @Test
  public void checkYELLOW() {
    qt()
        .forAll(doubles().from(25).upToAndIncluding(35)).assuming((x) -> x != 35)
        .checkAssert(
            (temp) -> assertEquals("Values between (25, 35> is YELLOW", thermometer.measure(temp),
                Color.YELLOW));
  }

  @Test
  public void checkGREEN() {
    qt()
        .forAll(doubles().from(10).upToAndIncluding(25)).assuming((x) -> x != 25)
        .checkAssert(
            (temp) -> assertEquals("Values between (15, 25> is GREEN", thermometer.measure(temp),
                Color.GREEN));
  }

  @Test
  public void checkLIGHT_BLUE() {
    qt()
        .forAll(doubles().from(5).upToAndIncluding(10)).assuming((x) -> x != 10)
        .checkAssert((temp) -> assertEquals("Values between (5, 10> is LIGHT_BLUE",
            thermometer.measure(temp), Color.LIGHT_BLUE));
  }

  @Test
  public void checkBLUE() {
    qt()
        .forAll(doubles().from(-10).upToAndIncluding(5).assuming((x) -> x != 5))
        .checkAssert(
            (temp) -> assertEquals("Values between (5, 10> is BLUE", thermometer.measure(temp),
                Color.BLUE));
  }

  @Test
  public void checkDARK_BLUE() {
    qt()
        .forAll(doubles().from(-273.149806372).upToAndIncluding(-10)).assuming((x) -> x != -10)
        .checkAssert((temp) -> assertEquals("Values between (5, 10> is DARK_BLUE", Color.DARK_BLUE,
            thermometer.measure(temp)));
  }

}