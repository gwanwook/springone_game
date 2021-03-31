package ex01.record.service;

import java.util.ArrayList;

import ex01.database.DataBaseService;
import ex01.database.DatabaseServiceImpl;
import javafx.scene.Parent;
import javafx.scene.control.Label;

public class RecordServiceImpl implements RecordService{

	@Override
	public void setRecord(Parent root) {
		Label lbNick0 = (Label)root.lookup("#lbNic0");
		Label lbNick1 = (Label)root.lookup("#lbNic1");
		Label lbNick2 = (Label)root.lookup("#lbNic2");
		Label lbNick3 = (Label)root.lookup("#lbNic3");
		Label lbNick4 = (Label)root.lookup("#lbNic4");

		Label lbCnt0 = (Label)root.lookup("#lbCnt0");
		Label lbCnt1 = (Label)root.lookup("#lbCnt1");
		Label lbCnt2 = (Label)root.lookup("#lbCnt2");
		Label lbCnt3 = (Label)root.lookup("#lbCnt3");
		Label lbCnt4 = (Label)root.lookup("#lbCnt4");

		ArrayList<String> arrNick = new ArrayList<String>();
		ArrayList<Number> arrCnt = new ArrayList<Number>();

		DataBaseService db = new DatabaseServiceImpl();

		arrNick = db.getNick();
		arrCnt = db.getCnt();

		int su = 0;

		for(int i=0; i<arrCnt.size(); i++) {
			for(int i2=1; i2<arrCnt.size(); i2++) {
				if((int)arrCnt.get(i)<=(int)arrCnt.get(i2)) {
					lbCnt0.setText(arrCnt.get(i).toString());
					lbNick0.setText(arrNick.get(i));					
				}else {
					lbCnt0.setText(arrCnt.get(i2).toString());
					lbNick0.setText(arrNick.get(i2));
					su = i2;
				}
			}
			if(lbCnt0.getText().equals(arrCnt.get(i).toString())) {
				arrCnt.remove(i);
				arrNick.remove(i);
			}else {
				arrCnt.remove(su);
				arrNick.remove(su);
			}
			for(int i2=1; i2<arrCnt.size(); i2++) {
				if((int)arrCnt.get(i)<=(int)arrCnt.get(i2)) {
					lbCnt1.setText(arrCnt.get(i).toString());
					lbNick1.setText(arrNick.get(i));
				}else {
					lbCnt1.setText(arrCnt.get(i2).toString());
					lbNick1.setText(arrNick.get(i2));
					su = i2;
				}
			}
			if(lbCnt1.getText().equals(arrCnt.get(i).toString())) {
				arrCnt.remove(i);
				arrNick.remove(i);
			}else {
				arrCnt.remove(su);
				arrNick.remove(su);
			}
			for(int i2=1; i2<arrCnt.size(); i2++) {
				if((int)arrCnt.get(i)<=(int)arrCnt.get(i2)) {
					lbCnt2.setText(arrCnt.get(i).toString());
					lbNick2.setText(arrNick.get(i));
				}else {
					lbCnt2.setText(arrCnt.get(i2).toString());
					lbNick2.setText(arrNick.get(i2));
					su = i2;
				}
			}
			if(lbCnt2.getText().equals(arrCnt.get(i).toString())) {
				arrCnt.remove(i);
				arrNick.remove(i);
			}else {
				arrCnt.remove(su);
				arrNick.remove(su);
			}
			for(int i2=1; i2<arrCnt.size(); i2++) {
				if((int)arrCnt.get(i)<=(int)arrCnt.get(i2)) {
					lbCnt3.setText(arrCnt.get(i).toString());
					lbNick3.setText(arrNick.get(i));
				}else {
					lbCnt3.setText(arrCnt.get(i2).toString());
					lbNick3.setText(arrNick.get(i2));
					su = i2;
				}
			}
			if(lbCnt3.getText().equals(arrCnt.get(i).toString())) {
				arrCnt.remove(i);
				arrNick.remove(i);
			}else {
				arrCnt.remove(su);
				arrNick.remove(su);
			}
			for(int i2=1; i2<arrCnt.size(); i2++) {
				if((int)arrCnt.get(i)<=(int)arrCnt.get(i2)) {
					lbCnt4.setText(arrCnt.get(i).toString());
					lbNick4.setText(arrNick.get(i));
				}else {
					lbCnt4.setText(arrCnt.get(i2).toString());
					lbNick4.setText(arrNick.get(i2));
					su = i2;
				}
			}
			if(lbCnt4.getText().equals(arrCnt.get(i).toString())) {
				arrCnt.remove(i);
				arrNick.remove(i);
			}else {
				arrCnt.remove(su);
				arrNick.remove(su);
			}
			
		}
	}

}
