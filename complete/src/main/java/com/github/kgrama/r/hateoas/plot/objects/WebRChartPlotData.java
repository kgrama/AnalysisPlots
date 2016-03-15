package com.github.kgrama.r.hateoas.plot.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.AccessLevel;

@Data
public class WebRChartPlotData {
	String chartTitle;
	String chartType;
	WebRChartPlotValueList valList;
	
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	@JsonIgnore
	WebRChartPlotTypes senum;
	
	public void setChartType(String chartType){
		this.chartType = chartType;
		try{
			this.senum = WebRChartPlotTypes.valueOf(this.chartType.toLowerCase());
		}catch(Exception e){
			this.senum = WebRChartPlotTypes.unsupported;
		}
	}
}
