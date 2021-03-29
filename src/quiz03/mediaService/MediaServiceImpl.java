package quiz03.mediaService;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class MediaServiceImpl implements MediaServer{
	MediaPlayer mediaPlayer;
	MediaView mediaView;
	Button btn0, btn1, btn2;
	
	@Override
	public void myBtn0() {
		
	}
	@Override
	public void myBtn1() {
		
	}
	@Override
	public void myBtn2() {
		
	}

	@Override
	public void setMedia(Parent root, String mediaName) {
		setController(root);
		Media media = new Media(getClass().getResource(mediaName).toString());
		mediaPlayer = new MediaPlayer(media);
		mediaView.setMediaPlayer(mediaPlayer);
		mediaPlayer.play();
		mediaPlayer.setOnPlaying( () -> {
			btn0.setDisable(true);
			btn1.setDisable(true);
			btn2.setDisable(false);
		});
		mediaPlayer.setOnEndOfMedia( () -> {
			if(mediaName.equals("../../game_resources/media/horror03_4.mp4")) {
				btn0.setDisable(true);
				btn1.setDisable(false);
				btn2.setDisable(false);
			}else {
				btn0.setDisable(false);
				btn1.setDisable(true);
				btn2.setDisable(false);
			}
		});
	}
	private void setController(Parent root) {
		mediaView = (MediaView)root.lookup("#fxMediaView");
		btn0 = (Button)root.lookup("#btn0");
		btn1 = (Button)root.lookup("#btn1");
		btn2 = (Button)root.lookup("#btn2");
	}
}
