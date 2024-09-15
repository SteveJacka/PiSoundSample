import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;

public class Sound {

    public void playSound(String fN) {
    // Will only play files of type .wav
    // get the sound file as a resource out of jar file;
    // The sound file must in the resources folder.
      try {
        System.out.println("Playing Audio file" + fN);
        //InputStream inputStream = classloader.getResourceAsStream(fileName);
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource(fN));
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();

       //close clip when done playing
        clip.addLineListener(event -> {
          if(LineEvent.Type.STOP.equals(event.getType())) {
            System.out.println("Stopped playing Audio File");  
            clip.close();
          }
        });

    } catch(Exception ex) {
        System.out.println("Error with playing sound.");
        ex.printStackTrace();
    }
  }
 }

