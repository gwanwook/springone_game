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

		int rank1 = 100;
		int rank2 = 100;
		int rank3 = 100;
		int rank4 = 100;
		int rank5 = 100;

		for(int i=0; i<arrCnt.size(); i++) {
			if(rank1<=(int)arrCnt.get(i)) {

			}else {
				rank1 = (int)arrCnt.get(i);
				su = i;
			}
		}
		lbCnt0.setText(arrCnt.get(su).toString());
		lbNick0.setText(arrNick.get(su).toString());
		arrCnt.remove(su);
		arrNick.remove(su);
		for(int i=0; i<arrCnt.size(); i++) {
			if(rank2<=(int)arrCnt.get(i)) {

			}else {
				rank2 = (int)arrCnt.get(i);
				su = i;
			}
		}
		lbCnt1.setText(arrCnt.get(su).toString());
		lbNick1.setText(arrNick.get(su).toString());
		arrCnt.remove(su);
		arrNick.remove(su);
		for(int i=0; i<arrCnt.size(); i++) {
			if(rank3<=(int)arrCnt.get(i)) {

			}else {
				rank3 = (int)arrCnt.get(i);
				su = i;
			}
		}
		lbCnt2.setText(arrCnt.get(su).toString());
		lbNick2.setText(arrNick.get(su).toString());
		arrCnt.remove(su);
		arrNick.remove(su);
		for(int i=0; i<arrCnt.size(); i++) {
			if(rank4<=(int)arrCnt.get(i)) {

			}else {
				rank4 = (int)arrCnt.get(i);
				su = i;
			}
		}
		lbCnt3.setText(arrCnt.get(su).toString());
		lbNick3.setText(arrNick.get(su).toString());
		arrCnt.remove(su);
		arrNick.remove(su);
		for(int i=0; i<arrCnt.size(); i++) {
			if(rank5<=(int)arrCnt.get(i)) {

			}else {
				rank5 = (int)arrCnt.get(i);
				su = i;
			}
		}
		lbCnt4.setText(arrCnt.get(su).toString());
		lbNick4.setText(arrNick.get(su).toString());
		arrCnt.remove(su);
		arrNick.remove(su);
	}

}
