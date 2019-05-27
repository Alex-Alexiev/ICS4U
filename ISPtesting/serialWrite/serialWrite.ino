const int sampleWindow = 50; // Sample window width in mS (50 mS = 20Hz)
const int numMics = 2;

const int averageLength = 10;
double past[numMics][averageLength];

double levels[numMics];
double averages[numMics];

const int diffHistoryLength = 20;
double pastDiffs[diffHistoryLength];

double d = 1;
double l = 0.3;

void setup()
{
  Serial.begin(9600);
}

void loop()
{
  unsigned long startMillis = millis(); // Start of sample window

  double signalMax[numMics];
  double signalMin[numMics];

  for (int i = 0; i < numMics; i++) {
    signalMin[i] = 1024;
  }

  // collect data for 50 mS
  while (millis() - startMillis < sampleWindow) {
    double sample[] = {analogRead(0), analogRead(1)};
    for (int i = 0; i < numMics; i++) {
      if (sample[i] < 1024) {
        if (sample[i] > signalMax[i]) {
          signalMax[i] = sample[i];
        } else if (sample[i] < signalMin[i]) {
          signalMin[i] = sample[i];
        }
      }
    }
  }

  for (int i = 0; i < numMics; i++) {
    levels[i] = signalMax[i] - signalMin[i];

    past[i][0] = levels[i];
    double sum = levels[i];
    for (int j = averageLength; j > 0; j--) {
      past[i][j] = past[i][j - 1];
      sum += past[i][j];
    }
    averages[i] = sum / averageLength;
  }

  double diff = averages[0] - averages[1];

  for (int i = diffHistoryLength; i > 0; i--) {
    pastDiffs[i] = pastDiffs[i - 1];
  }
  pastDiffs[0] = diff;

  double offset = 0;

  double tempSum = 0;
  double maxDiff = 0;
  double minDiff = 0;
  for (int i = 0; i < diffHistoryLength; i++) {
    tempSum += pastDiffs[i];
    if (pastDiffs[i] < minDiff) minDiff = pastDiffs[i] + offset;
    if (pastDiffs[i] > maxDiff) maxDiff = pastDiffs[i] + offset;
  }

  double diffAvg = tempSum / diffHistoryLength;

  /*

    Serial.print("X: "); Serial.print(averages[0]); Serial.print("  ");
    Serial.print("Y: "); Serial.print(averages[1]); Serial.print("  ");
    Serial.println("uT");
  */
  
/*
       Serial.print("X: "); Serial.print(maxDiff); Serial.print("  ");
       Serial.print("Y: "); Serial.print(minDiff); Serial.print("  ");
       Serial.print("Z: "); Serial.print(diffAvg); Serial.print("  ");
       Serial.println("uT");
*/
       Serial.println(diffAvg);
  
  //double avgLev = (levels[0] + levels[1]) / 2;
  //if (avgLev > 350) {
    //Serial.println(diffAvg);
  //}
  //Serial.println(avgLev);

  /*
    double  ratio = averages[1] / averages[0];
    double angle = acos((d / l) * (sqrt(ratio) - 1));
    angle = angle * (180 / PI);
    Serial.print("Ratio: "); Serial.print(ratio); Serial.println("  ");
    //Serial.println("uT");

  */
  //double volts = (peakToPeak * 5.0) / 1024;  // convert to volts

}
