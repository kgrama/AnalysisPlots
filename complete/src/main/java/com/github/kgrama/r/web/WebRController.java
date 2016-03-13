package com.github.kgrama.r.web;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.kgrama.r.objects.ChartTypeWithList;
import com.github.kgrama.r.demo.WebRDemo;
import com.github.kgrama.r.web.objects.RGreeting;


@RestController
public class WebRController {
	
    @RequestMapping(value="/getTestImage")
    @ResponseBody
    public String defaultSVGImage() {
    	try{
    		RGreeting testGreet = new RGreeting();
    		return testGreet.getHardcodedPlot(WebRDemo.getHardcodedPlot());
    	}catch (Exception e){
    		e.printStackTrace(System.out);
    	}
    	return "";
    }
    
    @RequestMapping(value="/getTestPredict")
    @ResponseBody
    public String getTestPredict() {
    	try{
    		RGreeting testGreet = new RGreeting();
    		return testGreet.getHardcodedPredict(WebRDemo.getHardcodedPrediction());
    	}catch (Exception e){
    		e.printStackTrace(System.out);
    	}
    	return "";
    }
    
    @RequestMapping(value={"/selectGraphForValues"}, 
    		consumes = "application/json", produces="image/svg+xml", 
    		method=RequestMethod.POST)
    @ResponseBody
    public String selectGraphForValues(@RequestBody ChartTypeWithList values) {
    	try{
    		return values.requestedGraph.generateGraph(values.getValuesAndLabels());
    	}catch (Exception e){
    		e.printStackTrace(System.out);
    	}
    	return "";
    }
}
