public class SimpleAudioPlayer implements AudioPlayer {
    AudioPlayerAdapter audioPlayerAdapter;

    @Override
    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing MP3 file. Name: " + fileName);
        } else if(audioType.equalsIgnoreCase("wav") || audioType.equalsIgnoreCase("flac")) {
            audioPlayerAdapter = new AudioPlayerAdapter(audioType);
            audioPlayerAdapter.play(audioType, fileName);
        } else {
            System.out.println("Invalid media. " + audioType + " format not supported");
        }
    }
}
