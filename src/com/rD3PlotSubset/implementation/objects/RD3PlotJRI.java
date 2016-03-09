package com.rD3PlotSubset.implementation.objects;

import java.util.List;
import java.util.Map;

import org.rosuda.JRI.Rengine;
import org.rosuda.REngine.REngine;
import org.rosuda.REngine.REngineException;
import org.rosuda.REngine.JRI.JRIEngine;

import com.rD3PlotSubset.API.IRD3Plot;
import com.rD3PlotSubset.API.IRD3PlotData;

public class RD3PlotJRI implements IRD3Plot {
	REngine plotEngine = null;
	private RD3PlotJRI() throws REngineException {
		plotEngine = JRIEngine.createEngine();
	}
	
	@Override
	public void addDataForPlot(List<IRD3PlotData> plotData) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPlotConfig(Map<String, String> plotConfig) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getPlotSVG() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean pollPlotComplete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void callbackPlotComplete(boolean plotComplete) {
		// TODO Auto-generated method stub

	}

	public static IRD3Plot buildInstance() {
			try {
				return new RD3PlotJRI();
			} catch (REngineException e) {
				e.printStackTrace();
			}
			return null;
	}

}
