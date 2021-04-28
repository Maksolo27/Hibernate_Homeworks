package impl;

import Interfeces.AudioSystem;
import Interfeces.Vehicle;
import Interfeces.Wheel;

/**
 * Created by maxim on 28.04.2021.
 */
public class Toyota implements Vehicle{

    private Wheel wheel;
    private AudioSystem audioSystem;

    public Toyota(){}

    public Toyota(Wheel wheel, AudioSystem audioSystem) {
        super();
        this.wheel = wheel;
        this.audioSystem = audioSystem;
    }

    public void drive() {
        System.out.println("Едет Toyota");
        wheel.spinning();
        audioSystem.music();
    }
}
