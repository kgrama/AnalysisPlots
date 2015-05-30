package com.rD3PlotSubset.implementation.factory;

import com.rD3PlotSubset.API.IRD3Plot;
import com.rD3PlotSubset.implementation.objects.RD3PlotJRI;

public class RD3PlotFactory {
   public static IRD3Plot getInstance(){
	   
	   return RD3PlotJRI.buildInstance();
   }
}


