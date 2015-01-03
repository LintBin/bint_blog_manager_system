package com.bint.base.util;

import com.bint.model.ClassificationModel;
import com.bint.model.UserModel;
import com.bint.test.base.AbstractTransactionalSpringContextTest;

public class ClassificationlTestUtil extends AbstractTransactionalSpringContextTest{
	public ClassificationModel classification;
	public UserModel user;
	public ClassificationlTestUtil(){
		user = new UserModel();
		classification = new ClassificationModel();
		classification.setClassificationName("Éú»î");
	}
}
