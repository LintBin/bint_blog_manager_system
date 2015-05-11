package com.bint.base.util;

import com.bint.model.ClassificationModel;
import com.bint.test.base.AbstractTransactionalSpringContextTest;

public class ClassificationModellTestUtil extends AbstractTransactionalSpringContextTest{
	public ClassificationModel classification;
	public ClassificationModellTestUtil(){
		classification = new ClassificationModel();
		classification.setClassificationName("Éú»î");
	}
}
