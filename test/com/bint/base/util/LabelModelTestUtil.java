package com.bint.base.util;

import com.bint.model.LabelModel;
import com.bint.test.base.AbstractTransactionalSpringContextTest;

public class LabelModelTestUtil extends AbstractTransactionalSpringContextTest{
	public LabelModel label;
	public LabelModelTestUtil(){
		label = new LabelModel();
		label.setLabelName("Java");
	}
}
