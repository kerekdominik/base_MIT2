package hu.bme.mit.train.sensor;

import java.time.LocalDateTime;

import com.google.common.collect.Table;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;

public class TrainSensorImpl implements TrainSensor {

	private TrainController controller;
	private TrainUser user;
	private int speedLimit = 5;

	public TrainSensorImpl(TrainController controller, TrainUser user) {
		this.controller = controller;
		this.user = user;
	}

	@Override
	public int getSpeedLimit() {
		return speedLimit;
	}

	@Override
	public void overrideSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
		controller.setSpeedLimit(speedLimit);
	}

	//This is the new method
	// This is the new feature
	@Override
    public void emergencyBrake() {
        this.speedLimit = 0;
        controller.setSpeedLimit(speedLimit)
    }

	@Override
	public Table<LocalDateTime, Integer, Integer> getTachographTable() {
		Table<LocalDateTime, Integer, Integer> tachographData = null;
		
		LocalDateTime currentTime = LocalDateTime.now();
        int joystickPosition = user.getJoystickPosition();
        int referenceSpeed = controller.getReferenceSpeed();
		tachographData.put(currentTime, joystickPosition, referenceSpeed);
		return tachographData;
	}

	
}
