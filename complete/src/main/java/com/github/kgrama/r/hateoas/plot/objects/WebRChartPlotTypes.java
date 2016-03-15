package com.github.kgrama.r.hateoas.plot.objects;

public enum WebRChartPlotTypes {
	pie {
		@Override
		public String getPlotForData(WebRChartPlotValueList values) {
			return null;
		}
	},
	bar {
		@Override
		public String getPlotForData(WebRChartPlotValueList values) {
			return null;
		}
	},
	unsupported {
		@Override
		public String getPlotForData(WebRChartPlotValueList values) {
			return null;
		}
	};
	
	abstract public String getPlotForData(WebRChartPlotValueList values); 
}
