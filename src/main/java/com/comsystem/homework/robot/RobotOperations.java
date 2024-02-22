package com.comsystem.homework.robot;


import com.comsystem.homework.exception.NumberOfDaysNotValidException;
import com.comsystem.homework.exception.NumberOfStonesNotValidException;
import com.comsystem.homework.model.RobotAction;
import com.comsystem.homework.model.RobotPlan;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RobotOperations {

    /**
     * An algorithm that converts a number of days into an action plan.
     *
     * @param days the number of days that the robot can work
     * @return The action plan <em>must maximize</em> the number of stones that the robot will dig. In other words, this
     * algorithm must try to achieve the highest value of {@link RobotPlan#numberOfStones} possible for the
     * number of provided days. The value of {@link RobotPlan#numberOfDays} is equal to the input
     * days parameter
     * @see RobotPlan
     */
    public RobotPlan excavateStonesForDays(int days) throws NumberOfDaysNotValidException {

//      short formula to get maximum number of stones and
//      save time complexity O(1) - Math.pow(2, days - 1)

        if (days <= 0) {
            throw new NumberOfDaysNotValidException("Number of days is less or equal to 0");
        }
        if (days == 1) {
            return new RobotPlan(days, 1, List.of(RobotAction.DIG));
        }
        final int cloneDays = days - 1;
        int stonesMined;
        List<RobotAction> robotActions = new ArrayList<>();
        int currentRobots = 1;
        for (int i = 1; i <= cloneDays; i++) {
            robotActions.add(RobotAction.CLONE);
            currentRobots *= 2;
        }
        robotActions.add(RobotAction.DIG);
        stonesMined = currentRobots;
        return new RobotPlan(days, stonesMined, robotActions);
    }

    /**
     * An algorithm that converts a number of stones into an action plan. Essentially this algorithm is the inverse of
     * {@link #excavateStonesForDays(int)}.
     *
     * @param numberOfStones the number of stones the robot has to collect
     * @return The action plan <em>must minimize</em> the number of days necessary for the robot to dig the
     * provided number of stones. In other words, this algorithm must try to achieve the lowest value of
     * {@link RobotPlan#numberOfDays} possible for the number of provided stones. The value of
     * {@link RobotPlan#numberOfStones} is equal to the numberOfStones parameter
     * @see RobotPlan
     */
    public RobotPlan daysRequiredToCollectStones(int numberOfStones) {
        if (numberOfStones <= 0) {
            throw new NumberOfStonesNotValidException("Number of stones is less or equal to 0");
        }
        List<RobotAction> robotActions = new ArrayList<>();
        int days = 0;
        int currentStones = numberOfStones;
        while (currentStones > 0) {
            if (currentStones % 2 == 0) {
//                without digging on the last day
//                if (currentStones == 2) {
//                    days++;
//                    robotActions.add(RobotAction.CLONE);
//                    break;
//                }
                currentStones /= 2;
                robotActions.add(RobotAction.CLONE);
            } else {
                currentStones -= 1;
                robotActions.add(RobotAction.DIG);
            }
            days++;
        }
        return new RobotPlan(days, numberOfStones, robotActions);
    }

}
