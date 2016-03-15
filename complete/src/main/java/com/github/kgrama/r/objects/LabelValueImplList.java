package com.github.kgrama.r.objects;

import java.util.ArrayList;

//import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class LabelValueImplList extends ArrayList<LabelValue> {
	//@JsonIgnore
	//private static final long serialVersionUID = -167153401543503224L; 
	}
