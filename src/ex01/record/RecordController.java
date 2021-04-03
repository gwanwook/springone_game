package ex01.record;

import java.net.URL;
import java.util.ResourceBundle;

import ex01.Controller;
import ex01.record.service.RecordService;
import ex01.record.service.RecordServiceImpl;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class RecordController implements Initializable{
	Parent root;
	RecordService rs;
	public void setRoot(Parent root) {
		this.root = root;
		rs.setRecord(root);
	}
	
	public void cancelProc() {
		Controller.cs.exit(root);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		rs = new RecordServiceImpl();
	}
}
