package com.rD3PlotSubset.API;

import java.util.List;
import java.util.Map;

public interface IRD3Plot {
	public void addDataForPlot(List<IRD3PlotData> plotData);
	public void setPlotConfig(Map<String, String> plotConfig);
	public String getPlotSVG();
	public boolean pollPlotComplete();
	public void callbackPlotComplete(boolean plotComplete);
}
