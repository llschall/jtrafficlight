#include "config.h"

void setup() {
  Serial.begin(BAUD);

  pinMode(LED_BUILTIN, OUTPUT);
  pinMode(LED_R_PIN, OUTPUT);
  pinMode(LED_Y_PIN, OUTPUT);
  pinMode(LED_G_PIN, OUTPUT);

  digitalWrite(LED_BUILTIN, LOW);
  digitalWrite(LED_R_PIN, LOW);
  digitalWrite(LED_Y_PIN, LOW);
  digitalWrite(LED_G_PIN, LOW);
}

int i = 0;

void loop() {

  if (i == 64) i = 0;

  if (Serial.available() > 0) {
    Serial.read();
    digitalWrite(LED_BUILTIN, HIGH);
    delay(1000);
    digitalWrite(LED_BUILTIN, LOW);
  }

  digitalWrite(LED_R_PIN, switchOn(1) ? HIGH : HIGH);
  digitalWrite(LED_Y_PIN, switchOn(64) ? HIGH : LOW);
  digitalWrite(LED_G_PIN, switchOn(32) ? HIGH : LOW);

  delay(64);
  i++;
}

bool switchOn(int d) {
  bool on = false;

  for (int j = 0; j <= i; j++) {
    if (j % d == 0) {
      on = !on;
    }
  }
  return on;
}
