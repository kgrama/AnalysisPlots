package com.github.kgrama.r.hateoas.API;

import com.github.kgrama.r.API.RJSONCurrentAPI;

public class WebRHateoasAPIAssembler {
	
	public static RJSONCurrentAPI getAPIV1(){
		RJSONCurrentAPI returnValue = RJSONCurrentAPI.getAPIv1Instance();
		return returnValue;
	}
}
