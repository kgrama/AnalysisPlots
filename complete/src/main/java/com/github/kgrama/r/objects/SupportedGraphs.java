package com.github.kgrama.r.objects;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.github.kgrama.r.web.objects.RGreeting;

public enum SupportedGraphs {
	/*
	 * r.eval(listOfHeaders);
	    	r.eval(listOfValues);
	    	r.eval("svg('/home/evd/testsvg/2.svg')");
	    	r.eval("bar1 <- barplot(slicesA, names.arg=jsonLabels)");
	    	r.eval("print(bar1)");
	    	r.eval("dev.off()");type filter text
	    	r.eval("rm(bar1)");
	    	r.eval("rm(slicesA)");
	    	r.eval("rm(jsonLabels)");
	 */
	Bar {
		@Override
		public String generateGraph(LabelValueImplList values) {
			List<String> commandList = SupportedGraphs.convertStringsToRCompaitableStrings(values);
			SupportedGraphs.addSVGFileToCommandList(commandList);
			commandList.add("bar1 <- barplot(slicesA, names.arg=jsonLabels)");
			commandList.add("print(bar1)");
			commandList.add("dev.off()");
			commandList.add("rm(bar1)");
			commandList.add("rm(slicesA)");
			commandList.add("rm(jsonLabels)");
			return SupportedGraphs.generateGraphFromCommandList(commandList);
		}
	},
	Pie{
		@Override
		public String generateGraph(LabelValueImplList values) {
			List<String> commandList = SupportedGraphs.convertStringsToRCompaitableStrings(values);
			SupportedGraphs.addSVGFileToCommandList(commandList);
			commandList.add("pie1 <- pie(slicesA, labels =jsonLabels)");
			commandList.add("print(pie1)");
			commandList.add("dev.off()");
			commandList.add("rm(pie1)");
			commandList.add("rm(slicesA)");
			commandList.add("rm(jsonLabels)");
			return SupportedGraphs.generateGraphFromCommandList(commandList);
		}
	},
	Unknown{
		@Override
		public String generateGraph(LabelValueImplList valuesAndLabels) {
			return "Invalid graph type";
		}
	};
	static String pathToSVGFile = "/home/evd/testsvg/2.svg";
	static String slices = "slicesA";
	static String labels = "jsonLabels";
	
	public abstract String generateGraph(LabelValueImplList valuesAndLabels);
	
	protected static String generateGraphFromCommandList(List<String> commandList) {
		try{
			RGreeting testGreet = new RGreeting();
			testGreet.plotFromCommandList(commandList);
			byte[] encoded = Files.readAllBytes(Paths.get(SupportedGraphs.pathToSVGFile));
    		return new String(encoded);
		}catch (Exception e){
			e.printStackTrace(System.out);
			return "Error";
		}
	}

	protected static void addSVGFileToCommandList(List<String> commandList) {
		commandList.add("svg('"+ SupportedGraphs.pathToSVGFile +"')");
		
	}

	private static List<String> convertStringsToRCompaitableStrings(LabelValueImplList values){
		List<String> returnList = new ArrayList<String>();
		String listOfValues = SupportedGraphs.slices + " <- c( ";
		String listOfHeaders = SupportedGraphs.labels + " <- c( ";
		if(values.size() > 0){
			System.out.println("Arraylist size greater than 0.");
			for(LabelValue pair: values){
				listOfValues = SupportedGraphs.addToCommaSeparatedList(listOfValues, pair.getValue());
				listOfHeaders = SupportedGraphs.addToCommaSeparatedStringList(listOfHeaders, pair.getLabel());
			}
			listOfValues = SupportedGraphs.removeLastCommaAndEnd(listOfValues);
			listOfHeaders = SupportedGraphs.removeLastCommaAndEnd(listOfHeaders);
			returnList.add(listOfHeaders);
			returnList.add(listOfValues);
		}
		return returnList;
	}
	private static String addToCommaSeparatedList(String listOfValues, String value) {
		listOfValues = listOfValues + value+",";
		return listOfValues;
	}
	
	private static String addToCommaSeparatedStringList(String listOfValues, String value) {
		listOfValues = listOfValues +"\""+ value+"\",";
		return listOfValues;
	}
	
	private static String removeLastCommaAndEnd(String rString) {
		int index = rString.lastIndexOf(",");
		String returnString = rString;
		try{
			returnString =
				new StringBuilder(rString).replace(index, index+1,")").toString();
		}catch(Exception e){}
		return returnString;
	}
}
