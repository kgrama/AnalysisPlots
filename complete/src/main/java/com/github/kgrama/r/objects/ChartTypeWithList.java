package com.github.kgrama.r.objects;

public class ChartTypeWithList {
	/*
	 * {
	 * "graphType":"abc",
	 * "valuesAndLabels":[{"label":"abc","value":"65"}, {"label":"cde","value":"67"},{"label":"efg","value":"88"}]
	 * }
	 */
	public String getGraphType() {
		return graphType;
	}
	
	public void setGraphType(String graphType) {
		this.graphType = graphType;
		try{
			requestedGraph = SupportedGraphs.valueOf(graphType);
		}catch (Exception e){
			this.requestedGraph = SupportedGraphs.Unknown; 
		}
	}
	String graphType;
	LabelValueImplList valuesAndLabels;
	
	public LabelValueImplList getValuesAndLabels() {
		return valuesAndLabels;
	}
	public void setValuesAndLabels(LabelValueImplList valuesAndLabels) {
		this.valuesAndLabels = valuesAndLabels;
	}
	
	public SupportedGraphs requestedGraph;
}

