
package school;

/**
 *
 * author antto Hautamäki
 */
public class PupilTypeC extends pupilType {

    @Override
    public Boolean isAwayProb(Boolean yesterdayAway, String weekday) {
        int prob = (int) (100 * Math.random());
        if (yesterdayAway!=null && yesterdayAway == false) {
            return prob > -1 && prob < 20;
        } else {
            return prob > -1 && prob < 40;
        }

    }

}
