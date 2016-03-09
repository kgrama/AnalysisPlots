package com.github.kgrama.r.web.objects;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.rosuda.JRI.Rengine;
import org.rosuda.REngine.JRI.JRIEngine;

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
    
    public String getHardcodedPlot(UUID session){
    	try{
    	r.eval("slices <- c(10, 12,4, 16, 8)");
    	r.eval("svg('/home/evd/testsvg/1.svg')");
    	r.eval("pie2 <- pie(slices)");
    	r.eval("print(pie2)");
    	r.eval("dev.off()");
    	r.eval("rm(pie2)");
    	r.eval("rm(slices)");
    	}
    	catch(Exception e){
    		e.printStackTrace(System.out);
    	}
    	try{
    		byte[] encoded = Files.readAllBytes(Paths.get("/home/evd/testsvg/1.svg"));
    		return new String(encoded);
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
	
}
