package com.github.kgrama.r.objects;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LabelValueImplList extends ArrayList<LabelValue> {
	private static final long serialVersionUID = -167153401543503224L; }
