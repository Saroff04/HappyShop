package ci553.happyshop.utility;

import  javafx.scene.media.AudioClip;

public final class SoundFX { // adding the sound
    private SoundFX(){}
        private static final AudioClip clickSound =
                new AudioClip(SoundFX.class.getResource("/click.mp3").toString());

        public static void click() { // class to be called and play the click sound
            clickSound.play();
        }
}
