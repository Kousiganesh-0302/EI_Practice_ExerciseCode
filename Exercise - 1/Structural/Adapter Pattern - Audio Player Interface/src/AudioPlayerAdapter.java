public class AudioPlayerAdapter implements AudioPlayer {
    AdvancedAudioPlayer advancedAudioPlayer;

    public AudioPlayerAdapter(String audioType) {
        if(audioType.equalsIgnoreCase("mp3")) {
            advancedAudioPlayer = new MP3Player();
        } else if(audioType.equalsIgnoreCase("wav")) {
            advancedAudioPlayer = new WAVPlayer();
        } else if(audioType.equalsIgnoreCase("flac")) {
            advancedAudioPlayer = new FLACPlayer();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("mp3")) {
            advancedAudioPlayer.playMP3(fileName);
        } else if(audioType.equalsIgnoreCase("wav")) {
            advancedAudioPlayer.playWAV(fileName);
        } else if(audioType.equalsIgnoreCase("flac")) {
            advancedAudioPlayer.playFLAC(fileName);
        }
    }
}
