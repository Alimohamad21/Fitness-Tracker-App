package sample;
public class Activities {
    public static int totalCalories=0;      //global variables so all activities contribute to the total calories/heart rate
    public  static double totalHeartRate=80;

    public static abstract class Sport{
        int Calories=0;
        double HeartRate=0; //All activities share the same two variables (not necessary,just to avoid repetition)
    }

    public static class Swimming extends Sport{
        void calculate(int minutes) {
            this.Calories+=minutes * 4;//contributes to the calories of THIS specific activity,increases each time u call this method e.g:swim.calculate(5);swim.calculate(4);
            this.HeartRate+=totalHeartRate*0.002 * minutes;
            totalHeartRate+=totalHeartRate*0.002*minutes; //contributes to the global totalCalories in order to get the total calories of all activities
            totalCalories+=minutes*4;
        }

    }

    public static class Running extends Sport{
        void calculate(int minutes) {
            this.Calories+=minutes * 5;
            this.HeartRate+=totalHeartRate*0.003 * minutes;
            totalHeartRate+=totalHeartRate*0.003*minutes;
            totalCalories+=minutes*5;
        }

    }

    public static class KickBoxing extends Sport  {

        void calculate(int minutes) {
            this.Calories += minutes * 3;
            this.HeartRate+=totalHeartRate*0.005 * minutes;
            totalHeartRate+=totalHeartRate*0.005*minutes;
            totalCalories+=minutes*3;
        }

    }

    public static class StrengthTraining extends Sport {

        void calculate(int minutes) {
            this.Calories =Calories + minutes * 5;
            this.HeartRate+=totalHeartRate*0.006 * minutes;
            totalHeartRate+=totalHeartRate*0.006*minutes;
            totalCalories+=minutes * 5;
        }
    }

}