package de.br.multimedia.mediathekplus.b7.service.rest.mock.data;

import java.util.ArrayList;
import java.util.List;

import de.br.multimedia.mediathekplus.b7.model.GeoprotectionTypeEnum;
import de.br.multimedia.mediathekplus.b7.model.Order;

public class OrdersTestDataBuilder {

	
	
	public List<Order> buildRecordingOrders() {
		List<Order> list = new ArrayList<Order>();
		list.add(new Order("dmb-first", true, true, GeoprotectionTypeEnum.DACH));
		list.add(new Order("dmb-second", false, true, GeoprotectionTypeEnum.WORLDWIDE));
		list.add(new Order("dmb-third", true, true, GeoprotectionTypeEnum.WORLDWIDE));
		list.add(new Order("dmb-fourth", true, true, GeoprotectionTypeEnum.GERMANY));
		return list;
	}

	public List<Order> buildStreamingOrders() {
		List<Order> list = new ArrayList<Order>();
		list.add(new Order("dmb-first", true, true, GeoprotectionTypeEnum.DACH));
		list.add(new Order("dmb-second", false, true, GeoprotectionTypeEnum.WORLDWIDE));
		list.add(new Order("dmb-third", true, true, GeoprotectionTypeEnum.WORLDWIDE));
		list.add(new Order("dmb-fourth", true, true, GeoprotectionTypeEnum.GERMANY));
		list.add(new Order("dmb-fifth", true, false, GeoprotectionTypeEnum.EBU));
		list.add(new Order("dmb-sixth", false, false, null));
		return list;
	}

}
