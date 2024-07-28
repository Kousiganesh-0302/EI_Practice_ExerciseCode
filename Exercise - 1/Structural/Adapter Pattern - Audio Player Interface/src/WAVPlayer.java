public class WAVPlayer implements AdvancedAudioPlayer {
    @Override
    public void playMP3(String fileName) {
        // Do nothing
    }

    @Override
    public void playWAV(String fileName) {
        System.out.println("Playing WAV file. Name: " + fileName);
    }

    @Override
    public void playFLAC(String fileName) {
        // Do nothing
    }
}
