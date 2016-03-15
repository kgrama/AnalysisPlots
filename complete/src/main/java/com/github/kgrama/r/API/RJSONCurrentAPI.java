package com.github.kgrama.r.API;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceSupport;

import com.github.kgrama.r.hateoas.plot.objects.WebRChartPlotData;
import com.github.kgrama.r.hateoas.plot.objects.WebRChartPlotValue;
import com.github.kgrama.r.hateoas.plot.objects.WebRChartPlotValueList;
import com.github.kgrama.r.web.WebRHateoasController;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RJSONCurrentAPI extends ResourceSupport{
	
	Resource<WebRChartPlotData> plot2DData;
	RJSONCurrentAPI()
	{}
	
	public static RJSONCurrentAPI getAPIv1Instance(){
		RJSONCurrentAPI returnInstance = new RJSONCurrentAPI();
		WebRChartPlotData apiBuild = new WebRChartPlotData();
		apiBuild.setChartTitle("Chart Title");
		apiBuild.setChartType("Pie, Bar");
		apiBuild.setValList(new WebRChartPlotValueList());
		WebRChartPlotValue apiValue = new WebRChartPlotValue();
		apiValue.setLabel("Label");
		apiValue.setValue("numeric value");
		apiBuild.getValList().add(apiValue);
		Link chartLink = linkTo(
				methodOn(WebRHateoasController.class).getPlotForColData(apiBuild))
				.withRel("getPlotData");
		returnInstance.plot2DData = 
				new Resource<WebRChartPlotData>(apiBuild, chartLink);
		return returnInstance;
	}
}