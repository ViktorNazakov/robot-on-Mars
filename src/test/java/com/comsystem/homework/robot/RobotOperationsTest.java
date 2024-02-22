package com.comsystem.homework.robot;

import com.comsystem.homework.exception.NumberOfDaysNotValidException;
import com.comsystem.homework.exception.NumberOfStonesNotValidException;
import com.comsystem.homework.model.RobotAction;
import com.comsystem.homework.model.RobotPlan;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RobotOperationsTest {
    static RobotOperations robotOperations;

    @BeforeAll
    static void init() {
        robotOperations = new RobotOperations();
    }

    @Test
    void RobotOperations_excavateStonesForDays_ReturnsRobotPlanWith16Stones() throws NumberOfDaysNotValidException {
        RobotPlan robotPlan = new RobotPlan(5,16, List.of(RobotAction.CLONE,RobotAction.CLONE,RobotAction.CLONE,RobotAction.CLONE,RobotAction.DIG));

        RobotPlan response = robotOperations.excavateStonesForDays(5);

        Assertions.assertEquals(response,robotPlan);
    }

    @Test
    void RobotOperations_excavateStonesForDays_ThrowsNumberOfDaysNotValidException() {

        Assertions.assertThrows(NumberOfDaysNotValidException.class, () -> robotOperations.excavateStonesForDays(0));
    }

    @Test
    void RobotOperations_daysRequiredToCollectStones_ReturnsRobotPlanWith5Days() {
        RobotPlan robotPlan = new RobotPlan(5,13, List.of(RobotAction.DIG,RobotAction.CLONE,RobotAction.CLONE,RobotAction.DIG,RobotAction.CLONE));

        RobotPlan response = robotOperations.daysRequiredToCollectStones(13);

        Assertions.assertEquals(response,robotPlan);
    }

    @Test
    void RobotOperations_daysRequiredToCollectStones_ThrowsNumberOfStonesNotValidException() {

        Assertions.assertThrows(NumberOfStonesNotValidException.class, () -> robotOperations.daysRequiredToCollectStones(0));
    }
}