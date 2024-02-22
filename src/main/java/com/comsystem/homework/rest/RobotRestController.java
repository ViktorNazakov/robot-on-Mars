package com.comsystem.homework.rest;

import com.comsystem.homework.exception.NumberOfDaysNotValidException;
import com.comsystem.homework.model.RobotPlan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.comsystem.homework.robot.RobotOperations;

@RestController
@RequestMapping("/api/v1/robot/operation")
public final class RobotRestController {


    private final RobotOperations robotOperations;

    public RobotRestController(RobotOperations robotOperations) {
        this.robotOperations = robotOperations;
    }

    /**
     * This method exposes the functionality of {@link RobotOperations#excavateStonesForDays(int)} via HTTP
     */
    @PostMapping("/excavation")
    public ResponseEntity<RobotPlan> excavateStones(@RequestParam Integer numberOfDays) throws NumberOfDaysNotValidException {
        return new ResponseEntity<>(robotOperations.excavateStonesForDays(numberOfDays), HttpStatus.OK);
    }

    /**
     * This method exposes the functionality of {@link RobotOperations#daysRequiredToCollectStones(int)} via HTTP
     */
    @PostMapping("/approximation")
    public ResponseEntity<RobotPlan> approximateDays(@RequestParam Integer numberOfStones) {
        return new ResponseEntity<>(robotOperations.daysRequiredToCollectStones(numberOfStones), HttpStatus.OK);
    }

}
