package com.bint.base.util;

import java.util.Date;

import com.bint.model.ArticleModel;
import com.bint.model.ClassificationModel;
import com.bint.model.UserModel;
import com.bint.test.base.AbstractTransactionalSpringContextTest;

public class ArtcileModelTestUtil extends AbstractTransactionalSpringContextTest{
	public ArticleModel article = null;
	public ArtcileModelTestUtil(){
		article = new ArticleModel();
		ClassificationModel classifiction = new ClassificationModel();
		classifiction.setId(8);
		article.setClassification(classifiction);
		article.setContent("contents");
		article.setDigest("digest");
		article.setHeadline("headline");
		article.setPraiseAmount(10);
		article.setStateCode(1);
		article.setUploadTime(new Date());
		UserModel user = new UserModel();
		user.setId(12);
		article.setAuthor(user);
	}
}
