package com.github.kgrama.r.web.objects;


import org.rosuda.JRI.Rengine;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.rosuda.REngine.JRI.JRIEngine;

import com.github.kgrama.r.objects.LabelValue;

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
    
/*
 * [{"label":"abc","value":"65"}, {"label":"cde","value":"67"},{"label":"efg","value":"88"}]
 */
	public String getJSONPiePlot(UUID sessionUUID, List<LabelValue> values) {
		try
		{
			String listOfValues = "slicesA <- c( ";
			String listOfHeaders = "jsonLabels <- c( ";
			if(values.size() > 0){
				System.out.println("Arraylist size greater than 0.");
				for(LabelValue pair: values){
					listOfValues = addToCommaSeparatedList(listOfValues, pair.getValue());
					listOfHeaders = addToCommaSeparatedStringList(listOfHeaders, pair.getLabel());
				}
				listOfValues = removeLastCommaAndEnd(listOfValues);
				listOfHeaders = removeLastCommaAndEnd(listOfHeaders);
				System.out.println("listOfValues "+ listOfValues);
				System.out.println("listOfHeaders "+listOfHeaders);
				return plotPie(listOfValues, listOfHeaders);
			}
			else{
				System.out.println("Arraylist size not greater than 0.");
			}
			return getHardcodedPlot(sessionUUID);
		}catch(NullPointerException e){
			e.printStackTrace(System.out);
		}catch (Exception e){
			e.printStackTrace(System.out);
		}
		return null;
	}

	
	private String plotPie(String listOfValues, String listOfHeaders) {
		// pie(B, main="My Piechart", col=rainbow(length(B)),labels=c("Mon","Tue","Wed","Thu","Fri","Sat","Sun")
		try{
	    	r.eval(listOfHeaders);
	    	r.eval(listOfValues);
	    	r.eval("svg('/home/evd/testsvg/2.svg')");
	    	r.eval("pie3 <- pie(slicesA, labels =jsonLabels)");
	    	//r.eval("pie3 <- pie(slicesA)");
	    	r.eval("print(pie3)");
	    	r.eval("dev.off()");
	    	r.eval("rm(pie3)");
	    	r.eval("rm(slicesA)");
	    	r.eval("rm(jsonLabels)");
    	}
    	catch(Exception e){
    		e.printStackTrace(System.out);
    	}
    	try{
    		byte[] encoded = Files.readAllBytes(Paths.get("/home/evd/testsvg/2.svg"));
    		return new String(encoded);
    	}catch(Exception e){
    		e.printStackTrace(System.out);
    	}
		return null;
	}
	
	public String getJSONBarPlot(UUID sessionUUID, List<LabelValue> values) {
		try
		{
			String listOfValues = "slicesA <- c( ";
			String listOfHeaders = "jsonLabels <- c( ";
			if(values.size() > 0){
				System.out.println("Arraylist size greater than 0.");
				for(LabelValue pair: values){
					listOfValues = addToCommaSeparatedList(listOfValues, pair.getValue());
					listOfHeaders = addToCommaSeparatedStringList(listOfHeaders, pair.getLabel());
				}
				listOfValues = removeLastCommaAndEnd(listOfValues);
				listOfHeaders = removeLastCommaAndEnd(listOfHeaders);
				System.out.println("listOfValues "+ listOfValues);
				System.out.println("listOfHeaders "+listOfHeaders);
				return plotBar(listOfValues, listOfHeaders);
			}
			else{
				System.out.println("Arraylist size not greater than 0.");
			}
			return getHardcodedPlot(sessionUUID);
		}catch(NullPointerException e){
			e.printStackTrace(System.out);
		}catch (Exception e){
			e.printStackTrace(System.out);
		}
		return null;
	}
	private String plotBar(String listOfValues, String listOfHeaders) {
		// pie(B, main="My Piechart", col=rainbow(length(B)),labels=c("Mon","Tue","Wed","Thu","Fri","Sat","Sun")
		try{
	    	r.eval(listOfHeaders);
	    	r.eval(listOfValues);
	    	r.eval("svg('/home/evd/testsvg/2.svg')");
	    	r.eval("bar1 <- barplot(slicesA, names.arg=jsonLabels)");
	    	r.eval("print(bar1)");
	    	r.eval("dev.off()");
	    	r.eval("rm(bar1)");
	    	r.eval("rm(slicesA)");
	    	r.eval("rm(jsonLabels)");
    	}
    	catch(Exception e){
    		e.printStackTrace(System.out);
    	}
    	try{
    		byte[] encoded = Files.readAllBytes(Paths.get("/home/evd/testsvg/2.svg"));
    		return new String(encoded);
    	}catch(Exception e){
    		e.printStackTrace(System.out);
    	}
		return null;
	}
	private String removeLastCommaAndEnd(String rString) {
		int index = rString.lastIndexOf(",");
		String returnString = rString;
		try{
			returnString =
				new StringBuilder(rString).replace(index, index+1,")").toString();
		}catch(Exception e){}
		return returnString;
	}

	private String addToCommaSeparatedList(String listOfValues, String value) {
		listOfValues = listOfValues + value+",";
		System.out.println("listOfValues: "+ listOfValues + ", value:" +value );
		return listOfValues;
	}
	
	private String addToCommaSeparatedStringList(String listOfValues, String value) {
		listOfValues = listOfValues +"\""+ value+"\",";
		System.out.println("listOfValues: "+ listOfValues + ", value:" +value );
		return listOfValues;
	}
}
