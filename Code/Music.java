import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Music implements LineListener{
	
	public void Play(String path) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		
		File audioFile = new File(path);
		 
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

        AudioFormat format = audioStream.getFormat();

        DataLine.Info info = new DataLine.Info(Clip.class, format);

        Clip audioClip = (Clip) AudioSystem.getLine(info);

        audioClip.addLineListener(this);

        audioClip.open(audioStream);
         
        audioClip.start();
        
	}

	@Override
	public void update(LineEvent event) {
		
		
	}
	
	 public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
	       String path = "The Best of Epic Music 2012 - 20 tracks - 1-hour Full Cinematic _ EpicMusicVn.mp3";
	        Music player = new Music();
	        player.Play(path);
	    }
	 
}