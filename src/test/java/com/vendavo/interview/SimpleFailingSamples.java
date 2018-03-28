package com.vendavo.interview;

import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.SourceDSL.doubles;
import static org.quicktheories.generators.SourceDSL.integers;
import static org.quicktheories.generators.SourceDSL.strings;

import org.junit.Test;

public class SimpleFailingSamples {

  @Test
  public void checkConcat() {
    qt()
        .forAll(strings().ascii().ofLengthBetween(0, 5), strings().ascii().ofLength(5))
        .check((a, b) -> (a + b).length() > b.length());
  }


  @Test
  public void checkPlus() {
    qt()
        .forAll(integers().allPositive(), integers().allPositive())
        .check((a, b) -> a + b > a);
  }

  @Test
  public void checkDivide() {
    qt().forAll(doubles().any(), doubles().any())
//        .assuming((a, b) -> a != 0)
        .check((a, b) -> a / b < a);
  }
}