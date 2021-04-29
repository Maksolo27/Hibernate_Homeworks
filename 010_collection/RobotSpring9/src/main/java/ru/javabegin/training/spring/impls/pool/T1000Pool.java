package ru.javabegin.training.spring.impls.pool;

import java.util.Map;

import ru.javabegin.training.spring.interfaces.Robot;
import ru.javabegin.training.spring.interfaces.RobotPool;

public class T1000Pool implements RobotPool {

	private Map<String, Robot> robotCollection;

	public void setRobotCollection(Map<String,Robot> robotCollection) {
		this.robotCollection = robotCollection;
	}

	//@Override
	public Map<String, Robot> getRobotCollection() {
		return robotCollection;
	}

	public void action() {
		robotCollection.get("one").action();
	}

}
