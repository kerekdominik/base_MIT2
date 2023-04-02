package hu.bme.mit.train.interfaces;

import java.time.LocalDateTime;

import com.google.common.collect.Table;
public interface TrainSensor {

	int getSpeedLimit();

	void overrideSpeedLimit(int speedLimit);

	void emergencyBrake();

	Table<LocalDateTime, Integer, Integer> getTachographTable();

	void createTachographTable();
}
