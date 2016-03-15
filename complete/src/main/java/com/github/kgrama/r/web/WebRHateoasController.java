package com.github.kgrama.r.web;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.LinkedList;
import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.kgrama.r.API.RJSONCurrentAPI;
import com.github.kgrama.r.hateoas.API.WebRHateoasAPIAssembler;
import com.github.kgrama.r.hateoas.plot.objects.WebRChartPlotData;


@SuppressWarnings("rawtypes")
@RestController
public class WebRHateoasController {
	
	@RequestMapping(value="/getRestAPI",
    		produces= "application/json",
    		method=RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Resource> getAPI() {
    	try{
    		Link selfLink = linkTo(methodOn(WebRHateoasController.class).getAPI()).withSelfRel();
    		List<Resource> returnResourceList = new LinkedList<Resource>();
    		Resource<RJSONCurrentAPI> apiResource =
    				new Resource<RJSONCurrentAPI>(WebRHateoasAPIAssembler.getAPIV1(), selfLink);
    		returnResourceList.add(apiResource);
    		//Resources<Resource> wrappedRes = new Resources<Resource>(returnResourceList, selfLink);
    		return new ResponseEntity<Resource>(apiResource, HttpStatus.OK);
    	}catch (Exception e){
    		e.printStackTrace(System.out);
    		return null;
    	}
    }
	
	@RequestMapping(value="/getPlotForColData",
			consumes= "application/json",
    		produces= "image/svg+xml",
    		method=RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Resources> getPlotForColData(@RequestBody WebRChartPlotData twoDPlotObject) {
    	try{
    		return null;
    	}catch (Exception e){
    		e.printStackTrace(System.out);
    		return null;
    	}
    }
}
