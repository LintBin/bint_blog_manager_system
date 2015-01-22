package com.bint.base.util;

import com.bint.model.ClassificationModel;
import com.bint.model.UserModel;
import com.bint.test.base.AbstractTransactionalSpringContextTest;

public class ClassificationModellTestUtil extends AbstractTransactionalSpringContextTest{
	public ClassificationModel classification;
	public UserModel user;
	public ClassificationModellTestUtil(){
		user = new UserModel();
		user.setId(12);
		classification = new ClassificationModel();
		classification.setUser(user);
		classification.setClassificationName("Éú»î");
	}
}
