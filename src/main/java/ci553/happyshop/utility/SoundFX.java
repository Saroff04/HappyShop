package ci553.happyshop.utility;

import  javafx.scene.media.AudioClip;

public final class SoundFX {
    private SoundFX(){}
        private static final AudioClip clickSound =
                new AudioClip(SoundFX.class.getResource("/click.mp3").toString());

        public static void click() {
            clickSound.play();
        }
}
