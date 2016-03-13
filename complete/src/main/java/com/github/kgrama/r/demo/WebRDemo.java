package com.github.kgrama.r.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WebRDemo {
	
	static String pathToSVGFile = "/home/evd/testsvg/1.svg";
	
	public static List<String> getHardcodedPrediction() {
		String temp;
		List<String> returnList = new ArrayList<String>();
		returnList.add("require(ggplot2)");
		returnList.add("require(reshape2)");
		temp = "df <- data.frame("+
				"cbind(rnorm(200),rnorm(200, mean=.8),"+
				"rnorm(200, mean=.9),rnorm(200, mean=1),"+
				"rnorm(200, mean=.2),rnorm(200, mean=.3)),"+
				"rnorm(200, mean=4),rnorm(200, mean=.5))";
		returnList.add(temp);
		temp = "colnames(df) <-  c"+
				"(\"w.March\",\"w.April\",\"x.March\","+
				"\"x.April\",\"y.March\",\"y.April\",\"z.March\",\"z.April\")";
		returnList.add(temp);
		returnList.add("df$id <- 1:nrow(df)");
		returnList.add("df.m <- melt(df, \"id\")");
		returnList.add("df.m$grp1 <- factor(gsub(\"\\\\..*$\", \"\", df.m$variable))");
		returnList.add("df.m$grp2 <- factor(gsub(\".*\\\\.\", \"\", df.m$variable))");
		returnList.add("p <- ggplot(data = df.m, aes(x=value)) + geom_density(aes(fill=grp2), alpha = 0.4)");
		returnList.add("p <- p + facet_wrap( ~ grp1)");
		returnList.add("p + scale_fill_brewer(palette = \"Set1\"");
		returnList.add("ggsave(file=\"/home/evd/testsvg/1.svg\", plot=p, width=10, height=8)");
		return returnList;
	}
	
	public static List<String> getHardcodedPlot() {
		List<String> returnList = new ArrayList<String>();
		returnList.add("slices <- c(10, 12,4, 16, 8)");
		returnList.add("svg('/home/evd/testsvg/1.svg')");
		returnList.add("pie2 <- pie(slices)");
		returnList.add("print(pie2)");
		returnList.add("dev.off()");
		returnList.add("rm(pie2)");
		returnList.add("rm(slices)");
		return returnList;
	}
	
	public static String readDemoSVGFile(){
		try {
			byte[] encoded;
			encoded = Files.readAllBytes(Paths.get(WebRDemo.pathToSVGFile));
			return new String(encoded);
		} catch (IOException e) {
			e.printStackTrace(System.out);
			return "File error";
		}
		
	}
}
