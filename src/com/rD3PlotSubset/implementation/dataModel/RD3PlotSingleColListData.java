package com.rD3PlotSubset.implementation.dataModel;

import java.util.List;

import com.rD3PlotSubset.API.IRD3PlotData;

public class RD3PlotSingleColListData implements IRD3PlotData {
	String dataHeader;
	List<?> dataForPlot;
	@Override
	public void setDataValues(List<?> dataValues) {
		dataForPlot = dataValues;
	}

	@Override
	public void setFieldHeader(String headerName) {
		dataHeader = headerName;
	}

}
