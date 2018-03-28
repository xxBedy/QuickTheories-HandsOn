package com.vendavo.interview.thermometer;

/**
 * User: mbednar Date: 04.03.18 Time: 12:17
 */
public class ThermometerImpl implements Thermometer {

  @Override
  public Color measure(double temperature) {
    if (temperature < -10) {
      return Color.DARK_BLUE;
    }
    if (temperature < 5) {
      return Color.BLUE;
    }
    if (temperature < 10) {
      return Color.LIGHT_BLUE;
    }
    if (temperature < 25) {
      return Color.GREEN;
    }
    if (temperature < 35) {
      return Color.YELLOW;
    }
    if (temperature < 40) {
      return Color.ORANGE;
    }
    return Color.RED;
  }
}
