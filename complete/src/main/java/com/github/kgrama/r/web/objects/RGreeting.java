package com.github.kgrama.r.web.objects;


import java.util.List;

import org.rosuda.JRI.Rengine;
import org.rosuda.REngine.JRI.JRIEngine;

import com.github.kgrama.r.demo.WebRDemo;

public class RGreeting {

    static JRIEngine jri;
    static Rengine r;
    static{
    	try {
			jri = new JRIEngine();
			r = jri.getRni();
		} catch (Exception e) {
			
			e.printStackTrace(System.out);
		}
    }
    
    public String getHardcodedPlot(List<String> commandList){
    	try{
    		plotFromCommandList(commandList);
    		return WebRDemo.readDemoSVGFile();
    	}
    	catch(Exception e){
    		e.printStackTrace(System.out);
    	}
    	return "not what you want";
    }
    
	
	public void plotFromCommandList(List<String> commandList) throws Exception{
		for (String current: commandList){
			System.out.println(current);
			r.eval(current);
		}
	}


	public String getHardcodedPredict(List<String> commandList) throws Exception {
		plotFromCommandList(commandList);
		return WebRDemo.readDemoSVGFile();
	}
	
}
