public class Conversion {
  // cm
  public static float cm_to_m(float num) {
    return num / 100;
  }
  public static float cm_to_km(float num) {
    return num / 10000;
  }

  // m
  public static float m_to_cm(float num) {
    return num * 100;
  }
  public static float m_to_km(float num) {
    return num / 1000;
  }

  // km
  public static float km_to_cm(float num) {
    return num * 10000;
  }
  public static float km_to_m(float num) {
    return num * 1000;
  }
}
