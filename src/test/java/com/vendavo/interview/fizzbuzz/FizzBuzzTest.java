package com.vendavo.interview.fizzbuzz;

import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.SourceDSL.integers;

import org.junit.Test;
import org.quicktheories.core.Configuration;

public class FizzBuzzTest {

  FizzBuzz fizzBuzz = new FizzBuzz();


  @Test
  public void solveFizz() {
    qt(() -> Configuration.systemStrategy().withGenerateAttempts(100))
        .forAll(integers().allPositive())
        .assuming((x) -> (x % 3 == 0 && x % 5 != 0))
        .check((x) -> "Fizz".equals(fizzBuzz.solve(x)));
  }

  @Test
  public void solveBuzz() {
    qt(() -> Configuration.systemStrategy().withGenerateAttempts(100))
        .forAll(integers().allPositive())
        .assuming((x) -> (x % 3 != 0 && x % 5 == 0))
        .check((x) -> "Buzz".equals(fizzBuzz.solve(x)));
  }

  @Test
  public void solveFizzBuzz() {
    qt(() -> Configuration.systemStrategy().withGenerateAttempts(100))
        .forAll(integers().allPositive())
        .assuming((x) -> (x % 3 != 0 && x % 5 != 0))
        .check((x) -> fizzBuzz.solve(x).equals("" + x));
  }

}