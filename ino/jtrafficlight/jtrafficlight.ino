
uint8_t led_r = 7;
uint8_t led_y = 8;
uint8_t led_g = 9;

void setup() {
  Serial.begin(9600);

  pinMode(LED_BUILTIN, OUTPUT);
  pinMode(led_r, OUTPUT);
  pinMode(led_y, OUTPUT);
  pinMode(led_g, OUTPUT);

  digitalWrite(LED_BUILTIN, LOW);
  digitalWrite(led_r, LOW);
  digitalWrite(led_y, LOW);
  digitalWrite(led_g, LOW);
}

int i = 0;

void loop() {

  if (i == 64) {
    i = 0;
  }

  if (Serial.available() > 0) {
    digitalWrite(LED_BUILTIN, HIGH);
    delay(1000);
    digitalWrite(LED_BUILTIN, LOW);
  }

  digitalWrite(led_r, switchOn(1) ? HIGH : LOW);
  digitalWrite(led_y, switchOn(64) ? HIGH : LOW);
  digitalWrite(led_g, switchOn(32) ? HIGH : LOW);

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
