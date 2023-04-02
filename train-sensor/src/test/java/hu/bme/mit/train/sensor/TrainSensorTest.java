package hu.bme.mit.train.sensor;

import org.junit.Before;
import org.junit.Test;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;
import java.time.LocalDateTime;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

import com.google.common.collect.Table;

public class TrainSensorTest {

    private TrainController controllerMock;
    private TrainUser userMock;
    private TrainSensorImpl trainSensor;

    @Before
    public void before() {
        controllerMock = mock(TrainController.class);
        userMock = mock(TrainUser.class);
        trainSensor = new TrainSensorImpl(controllerMock, userMock);
    }

    @Test
    public void testGetTachographTable() {

        when(userMock.getJoystickPosition()).thenReturn(5);
        when(controllerMock.getReferenceSpeed()).thenReturn(10);
        
        trainSensor.createTachographTable();
        Table<LocalDateTime, Integer, Integer> tachographData = trainSensor.getTachographTable();

        assertNotNull(tachographData);
    }
}
