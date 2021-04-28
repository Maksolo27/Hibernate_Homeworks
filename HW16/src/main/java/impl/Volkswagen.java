package impl;

import Interfeces.AudioSystem;
import Interfeces.Vehicle;
import Interfeces.Wheel;

/**
 * Created by maxim on 28.04.2021.
 */
public class Volkswagen implements Vehicle {

    private Wheel wheel;
    private AudioSystem audioSystem;

    public void drive() {
        System.out.println("Едет Volkswagen");
        wheel.spinning();
        audioSystem.music();
    }

    public Volkswagen(Wheel wheel, AudioSystem audioSystem) {
        this.wheel = wheel;
        this.audioSystem = audioSystem;
    }


}
