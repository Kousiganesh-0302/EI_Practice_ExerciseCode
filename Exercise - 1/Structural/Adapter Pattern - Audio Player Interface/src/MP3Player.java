public class MP3Player implements AdvancedAudioPlayer {
    @Override
    public void playMP3(String fileName) {
        System.out.println("Playing MP3 file. Name: " + fileName);
    }

    @Override
    public void playWAV(String fileName) {
        // Do nothing
    }

    @Override
    public void playFLAC(String fileName) {
        // Do nothing
    }
}
