package com.fivt.inplan.client.utils;

import java.util.List;

import com.fivt.inplan.client.gui.model.DeaneryModel.SpecializationItem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ObservableUtils {
	private ObservableUtils() {
		
	}
	
	public static <T> ObservableList<T> getObservable(List<T> list) {
		ObservableList<T> observables = FXCollections.observableArrayList();
		observables.addAll(list);
		return observables;
	}
}
