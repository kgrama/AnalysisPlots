package com.github.kgrama.r.web;


import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.kgrama.r.objects.ChartTypeWithList;
import com.github.kgrama.r.prototype.TestSVG;
import com.github.kgrama.r.web.objects.RGreeting;


@Controller
public class WebRController {
	
    @RequestMapping(value="/getTestImage")
    @ResponseBody
    public String defaultSVGImage() {
        return TestSVG.testImage;
    }
    
    @RequestMapping(value={"/testJri"})
    @ResponseBody
    public String greetingController(@RequestParam(value="session", defaultValue="0") String session) {
    	try{
    		UUID sessionUUID = UUID.randomUUID();
    		RGreeting testGreet = new RGreeting();
    		return testGreet.getHardcodedPlot(sessionUUID);
    	}catch (Exception e){
    		e.printStackTrace(System.out);
    	}
    	return "";
    }
    
    @SuppressWarnings("unused")
    @RequestMapping(value={"/selectGraphForValues"}, consumes = "application/json", method=RequestMethod.POST)
    @ResponseBody
    public String selectGraphForValues(@RequestBody ChartTypeWithList values) {
    	try{
    		UUID sessionUUID = UUID.randomUUID();
			RGreeting testGreet = new RGreeting();
    		System.out.println("Graph type: "+ values.getGraphType());
    		System.out.println("Number of values: "+ values.getValuesAndLabels().size());
    		return values.requestedGraph.generateGraph(values.getValuesAndLabels());
    		
    	}catch (Exception e){
    		e.printStackTrace(System.out);
    	}
    	return "";
    }
}
