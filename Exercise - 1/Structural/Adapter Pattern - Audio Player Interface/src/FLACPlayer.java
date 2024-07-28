public class FLACPlayer implements AdvancedAudioPlayer {
    @Override
    public void playMP3(String fileName) {
        // Do nothing
    }

    @Override
    public void playWAV(String fileName) {
        // Do nothing
    }

    @Override
    public void playFLAC(String fileName) {
        System.out.println("Playing FLAC file. Name: " + fileName);
    }
}
