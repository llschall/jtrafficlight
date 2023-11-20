
unsigned long BAUD = 9600;

int LED_0_R_PIN = 2;
int LED_0_Y_PIN = 3;
int LED_0_G_PIN = 4;

int LED_1_R_PIN = 5;
int LED_1_Y_PIN = 6;
int LED_1_G_PIN = 7;

int LED_2_R_PIN = 8;
int LED_2_Y_PIN = 9;
int LED_2_G_PIN = 10;

bool switchOn(int d);
void fireConnectionLost();

void setup_impl() {
  Serial.begin(BAUD);

  pinMode(LED_0_R_PIN, OUTPUT);
  pinMode(LED_0_Y_PIN, OUTPUT);
  pinMode(LED_0_G_PIN, OUTPUT);

  pinMode(LED_1_R_PIN, OUTPUT);
  pinMode(LED_1_Y_PIN, OUTPUT);
  pinMode(LED_1_G_PIN, OUTPUT);

  pinMode(LED_2_R_PIN, OUTPUT);
  pinMode(LED_2_Y_PIN, OUTPUT);
  pinMode(LED_2_G_PIN, OUTPUT);

  pinMode(LED_BUILTIN, OUTPUT);

  digitalWrite(LED_BUILTIN, LOW);
}

int i = 0;

int blink_0_r = 1;
int blink_0_y = 1;
int blink_0_g = 1;

int blink_1_r = 1;
int blink_1_y = 1;
int blink_1_g = 1;

int blink_2_r = 1;
int blink_2_y = 1;
int blink_2_g = 1;

char buffer[11];

long last = millis();

void loop_impl() {

  if (i == 1024) i = 0;

  if (Serial.available() >= 11) {
    Serial.readBytes(buffer, 1);
    if (buffer[0] != 'm') return;

    Serial.readBytes(buffer, 10);

    blink_0_r = buffer[0] - '0';
    blink_0_y = buffer[1] - '0';
    blink_0_g = buffer[2] - '0';

    blink_1_r = buffer[3] - '0';
    blink_1_y = buffer[4] - '0';
    blink_1_g = buffer[5] - '0';

    blink_2_r = buffer[6] - '0';
    blink_2_y = buffer[7] - '0';
    blink_2_g = buffer[8] - '0';

    last = millis();
  }

  if ((millis() - last) > 40000) {
    fireConnectionLost();
  }

  digitalWrite(LED_0_R_PIN, switchOn(blink_0_r) ? HIGH : LOW);
  digitalWrite(LED_0_Y_PIN, switchOn(blink_0_y) ? HIGH : LOW);
  digitalWrite(LED_0_G_PIN, switchOn(blink_0_g) ? HIGH : LOW);

  digitalWrite(LED_1_R_PIN, switchOn(blink_1_r) ? HIGH : LOW);
  digitalWrite(LED_1_Y_PIN, switchOn(blink_1_y) ? HIGH : LOW);
  digitalWrite(LED_1_G_PIN, switchOn(blink_1_g) ? HIGH : LOW);

  digitalWrite(LED_2_R_PIN, switchOn(blink_2_r) ? HIGH : LOW);
  digitalWrite(LED_2_Y_PIN, switchOn(blink_2_y) ? HIGH : LOW);
  digitalWrite(LED_2_G_PIN, switchOn(blink_2_g) ? HIGH : LOW);

  delay(200);
  i++;
}

bool switchOn(int d) {
  
  if (d == 8) return true;
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

void fireConnectionLost() {

  blink_0_r = 1;
  blink_0_y = 1;
  blink_0_g = 1;

  blink_1_r = 1;
  blink_1_y = 1;
  blink_1_g = 1;

  blink_2_r = 1;
  blink_2_y = 1;
  blink_2_g = 1;
}
