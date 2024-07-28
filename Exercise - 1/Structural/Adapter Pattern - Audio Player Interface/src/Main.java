import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SimpleAudioPlayer audioPlayer = new SimpleAudioPlayer();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter audio type (MP3, WAV, FLAC) or type 'exit' to quit:");
            String audioType = scanner.nextLine();
            if (audioType.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.println("Enter file name:");
            String fileName = scanner.nextLine();

            audioPlayer.play(audioType, fileName);
        }

        scanner.close();
    }
}
