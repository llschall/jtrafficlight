#include "config.h"

bool switchOn(int d);

void setup_impl() {
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

int blink_r = 0;
int blink_y = 0;
int blink_g = 0;

char buffer[5];

void loop_impl() {

  if (i == 64) i = 0;

  if (Serial.available() >= 5) {
    Serial.readBytes(buffer, 5);

    digitalWrite(LED_BUILTIN, HIGH);
    delay(1000);
    digitalWrite(LED_BUILTIN, LOW);
    blink_r = buffer[1] - '0';
    blink_y = buffer[2] - '0';
    blink_g = buffer[3] - '0';
  }

  digitalWrite(LED_R_PIN, switchOn(blink_r) ? HIGH : LOW);
  digitalWrite(LED_Y_PIN, switchOn(blink_y) ? HIGH : LOW);
  digitalWrite(LED_G_PIN, switchOn(blink_g) ? HIGH : LOW);

  delay(64);
  i++;
}

bool switchOn(int d) {

  if (d == 0) return false;

  int p = pow(2, d);

  bool on = false;
  for (int j = 0; j <= i; j++) {
    if (j % p == 0) {
      on = !on;
    }
  }
  return on;
}
