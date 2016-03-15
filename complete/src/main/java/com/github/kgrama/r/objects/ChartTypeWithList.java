package com.github.kgrama.r.objects;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@SuppressWarnings("unused")
@Data
public class ChartTypeWithList{
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
	
	@JsonIgnore
	public SupportedGraphs requestedGraph;
}

