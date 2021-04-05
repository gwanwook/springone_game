package quiz01.mediaService;

import ex01.loginService.LoginServiceImpl;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import quiz02.QuizMain;

public class MediaServiceImpl implements MediaServer{
	MediaPlayer mediaPlayer;
	MediaView mediaView;
	Button btn0, btn1, btn2;
	

	@Override
	public void myBtn0() {
		LoginServiceImpl.dto.updateCount(1);
//		quiz01.QuizMain quiz01 = new quiz01.QuizMain();
//		quiz01.quiz01();
	}
	@Override
	public void myBtn1() {
		QuizMain quiz02 = new QuizMain();
		quiz02.quiz02();
	}
	@Override
	public void myBtn2() {
		mediaPlayer.stop();
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
			if(mediaName.equals("../../game_resources/media/horror01_3.mp4")||mediaName.equals("../../game_resources/media/2horror01_2.mp4")||mediaName.equals("../../game_resources/media/3horror01_2.mp4")||mediaName.equals("../../game_resources/media/4horror01_1.mp4")) {
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
