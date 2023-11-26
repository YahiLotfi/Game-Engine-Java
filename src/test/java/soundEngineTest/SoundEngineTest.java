package soundEngineTest;

import soundEngine.SoundEngine;

import org.junit.jupiter.api.Test;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SoundEngineTest {

    @Test
    void testLoad() {
        SoundEngine soundEngine = new SoundEngine();
        String filePath = "src/main/resources/sample/Sounds/audio4.wav";
        try {
            soundEngine.load(filePath);
            assertNotNull(soundEngine.clip);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void testPlay() {
        SoundEngine soundEngine = new SoundEngine();
        String filePath = "src/main/resources/sample/Sounds/audio4.wav";
        try {
            soundEngine.load(filePath);
            soundEngine.play();
            assertEquals("play", soundEngine.status);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void testPause() {
        SoundEngine soundEngine = new SoundEngine();
        String filePath = "src/main/resources/sample/Sounds/audio4.wav";
        try {
            soundEngine.load(filePath);
            soundEngine.play();
            soundEngine.pause();
            assertEquals("paused", soundEngine.status);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void testResumeAudio() {
        SoundEngine soundEngine = new SoundEngine();
        String filePath = "src/main/resources/sample/Sounds/audio4.wav";
        try {
            soundEngine.load(filePath);
            soundEngine.play();
            soundEngine.pause();
            soundEngine.resumeAudio(filePath);
            assertEquals("play", soundEngine.status);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void testRestart() {
        SoundEngine soundEngine = new SoundEngine();
        String filePath = "src/main/resources/sample/Sounds/audio4.wav";
        try {
            soundEngine.load(filePath);
            soundEngine.play();
            soundEngine.restart(filePath);
            assertEquals("play", soundEngine.status);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void testStop() {
        SoundEngine soundEngine = new SoundEngine();
        String filePath = "src/main/resources/sample/Sounds/audio4.wav";
        try {
            soundEngine.load(filePath);
            soundEngine.play();
            soundEngine.stop();
            assertEquals("stopped", soundEngine.status);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }


}
