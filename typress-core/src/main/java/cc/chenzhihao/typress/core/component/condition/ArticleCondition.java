package cc.chenzhihao.typress.core.component.condition;

import cc.chenzhihao.typress.commons.component.condition.Condition;
import java.util.List;
import java.util.ArrayList;
import cc.chenzhihao.typress.core.domain.article.vo.ArticleID;
import cc.chenzhihao.typress.commons.model.vo.MarkdownText;
import cc.chenzhihao.typress.commons.model.vo.Timestamp;

public class ArticleCondition extends Condition {
	private final List<Criteria> oredCriteria;

	public ArticleCondition() {
		oredCriteria = new ArrayList<>();
	}

	public Criteria createCriteria() {
		Criteria criteria = new Criteria();
		oredCriteria.add(criteria);
 		return criteria;
	}

	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	public static class Criteria {
		private Boolean articleIDIsNull;
		private Boolean articleIDIsNotNull;
		private ArticleID articleIDEqualTo;
		private ArticleID articleIDNotEqualTo;
		private ArticleID articleIDGreaterThan;
		private ArticleID articleIDGreaterThanOrEqualTo;
		private ArticleID articleIDLessThan;
		private ArticleID articleIDLessThanOrEqualTo;
		private List<ArticleID> articleIDIn;
		private List<ArticleID> articleIDNotIn;
		private ArticleID[] articleIDBetween;
		private ArticleID[] articleIDNotBetween;

		private Boolean articleTitleIsNull;
		private Boolean articleTitleIsNotNull;
		private String articleTitleEqualTo;
		private String articleTitleNotEqualTo;
		private String articleTitleGreaterThan;
		private String articleTitleGreaterThanOrEqualTo;
		private String articleTitleLessThan;
		private String articleTitleLessThanOrEqualTo;
		private List<String> articleTitleIn;
		private List<String> articleTitleNotIn;
		private String[] articleTitleBetween;
		private String[] articleTitleNotBetween;
		private String articleTitleLike;
		private String articleTitleNotLike;

		private Boolean articleContentIsNull;
		private Boolean articleContentIsNotNull;
		private MarkdownText articleContentEqualTo;
		private MarkdownText articleContentNotEqualTo;
		private MarkdownText articleContentGreaterThan;
		private MarkdownText articleContentGreaterThanOrEqualTo;
		private MarkdownText articleContentLessThan;
		private MarkdownText articleContentLessThanOrEqualTo;
		private List<MarkdownText> articleContentIn;
		private List<MarkdownText> articleContentNotIn;
		private MarkdownText[] articleContentBetween;
		private MarkdownText[] articleContentNotBetween;

		private Boolean createTimeIsNull;
		private Boolean createTimeIsNotNull;
		private Timestamp createTimeEqualTo;
		private Timestamp createTimeNotEqualTo;
		private Timestamp createTimeGreaterThan;
		private Timestamp createTimeGreaterThanOrEqualTo;
		private Timestamp createTimeLessThan;
		private Timestamp createTimeLessThanOrEqualTo;
		private List<Timestamp> createTimeIn;
		private List<Timestamp> createTimeNotIn;
		private Timestamp[] createTimeBetween;
		private Timestamp[] createTimeNotBetween;

		private Boolean updateTimeIsNull;
		private Boolean updateTimeIsNotNull;
		private Timestamp updateTimeEqualTo;
		private Timestamp updateTimeNotEqualTo;
		private Timestamp updateTimeGreaterThan;
		private Timestamp updateTimeGreaterThanOrEqualTo;
		private Timestamp updateTimeLessThan;
		private Timestamp updateTimeLessThanOrEqualTo;
		private List<Timestamp> updateTimeIn;
		private List<Timestamp> updateTimeNotIn;
		private Timestamp[] updateTimeBetween;
		private Timestamp[] updateTimeNotBetween;

		public Boolean getArticleIDIsNull() {
			return articleIDIsNull;
		}

		public void articleIDIsNull() {
			this.articleIDIsNull = Boolean.TRUE;
		}

		public Boolean getArticleIDIsNotNull() {
			return articleIDIsNotNull;
		}

		public void articleIDIsNotNull() {
			this.articleIDIsNotNull = Boolean.TRUE;
		}

		public ArticleID getArticleIDEqualTo() {
			return articleIDEqualTo;
		}

		public void articleIDEqualTo(ArticleID value) {
			this.articleIDEqualTo = value;
		}

		public ArticleID getArticleIDNotEqualTo() {
			return articleIDNotEqualTo;
		}

		public void articleIDNotEqualTo(ArticleID value) {
			this.articleIDNotEqualTo = value;
		}

		public ArticleID getArticleIDGreaterThan() {
			return articleIDGreaterThan;
		}

		public void articleIDGreaterThan(ArticleID value) {
			this.articleIDGreaterThan = value;
		}

		public ArticleID getArticleIDGreaterThanOrEqualTo() {
			return articleIDGreaterThanOrEqualTo;
		}

		public void articleIDGreaterThanOrEqualTo(ArticleID value) {
			this.articleIDGreaterThanOrEqualTo = value;
		}

		public ArticleID getArticleIDLessThan() {
			return articleIDLessThan;
		}

		public void articleIDLessThan(ArticleID value) {
			this.articleIDLessThan = value;
		}

		public ArticleID getArticleIDLessThanOrEqualTo() {
			return articleIDLessThanOrEqualTo;
		}

		public void articleIDLessThanOrEqualTo(ArticleID value) {
			this.articleIDLessThanOrEqualTo = value;
		}

		public List<ArticleID> getArticleIDIn() {
			return articleIDIn;
		}

		public void articleIDIn(List<ArticleID> value) {
			this.articleIDIn = value;
		}

		public List<ArticleID> getArticleIDNotIn() {
			return articleIDNotIn;
		}

		public void articleIDNotIn(List<ArticleID> value) {
			this.articleIDNotIn = value;
		}

		public ArticleID[] getArticleIDBetween() {
			return articleIDBetween;
		}

		public void articleIDBetween(ArticleID beginValue, ArticleID endValue) {
			this.articleIDBetween = new ArticleID[]{beginValue, endValue};
		}

		public ArticleID[] getArticleIDNotBetween() {
			return articleIDNotBetween;
		}

		public void articleIDNotBetween(ArticleID beginValue, ArticleID endValue) {
			this.articleIDNotBetween = new ArticleID[]{beginValue, endValue};
		}

		public Boolean getArticleTitleIsNull() {
			return articleTitleIsNull;
		}

		public void articleTitleIsNull() {
			this.articleTitleIsNull = Boolean.TRUE;
		}

		public Boolean getArticleTitleIsNotNull() {
			return articleTitleIsNotNull;
		}

		public void articleTitleIsNotNull() {
			this.articleTitleIsNotNull = Boolean.TRUE;
		}

		public String getArticleTitleEqualTo() {
			return articleTitleEqualTo;
		}

		public void articleTitleEqualTo(String value) {
			this.articleTitleEqualTo = value;
		}

		public String getArticleTitleNotEqualTo() {
			return articleTitleNotEqualTo;
		}

		public void articleTitleNotEqualTo(String value) {
			this.articleTitleNotEqualTo = value;
		}

		public String getArticleTitleGreaterThan() {
			return articleTitleGreaterThan;
		}

		public void articleTitleGreaterThan(String value) {
			this.articleTitleGreaterThan = value;
		}

		public String getArticleTitleGreaterThanOrEqualTo() {
			return articleTitleGreaterThanOrEqualTo;
		}

		public void articleTitleGreaterThanOrEqualTo(String value) {
			this.articleTitleGreaterThanOrEqualTo = value;
		}

		public String getArticleTitleLessThan() {
			return articleTitleLessThan;
		}

		public void articleTitleLessThan(String value) {
			this.articleTitleLessThan = value;
		}

		public String getArticleTitleLessThanOrEqualTo() {
			return articleTitleLessThanOrEqualTo;
		}

		public void articleTitleLessThanOrEqualTo(String value) {
			this.articleTitleLessThanOrEqualTo = value;
		}

		public List<String> getArticleTitleIn() {
			return articleTitleIn;
		}

		public void articleTitleIn(List<String> value) {
			this.articleTitleIn = value;
		}

		public List<String> getArticleTitleNotIn() {
			return articleTitleNotIn;
		}

		public void articleTitleNotIn(List<String> value) {
			this.articleTitleNotIn = value;
		}

		public String[] getArticleTitleBetween() {
			return articleTitleBetween;
		}

		public void articleTitleBetween(String beginValue, String endValue) {
			this.articleTitleBetween = new String[]{beginValue, endValue};
		}

		public String[] getArticleTitleNotBetween() {
			return articleTitleNotBetween;
		}

		public void articleTitleNotBetween(String beginValue, String endValue) {
			this.articleTitleNotBetween = new String[]{beginValue, endValue};
		}

		public String getArticleTitleLike() {
			return articleTitleLike;
		}

		public void articleTitleLike(String value) {
			this.articleTitleLike = value;
		}

		public String getArticleTitleNotLike() {
			return articleTitleNotLike;
		}

		public void articleTitleNotLike(String value) {
			this.articleTitleNotLike = value;
		}

		public Boolean getArticleContentIsNull() {
			return articleContentIsNull;
		}

		public void articleContentIsNull() {
			this.articleContentIsNull = Boolean.TRUE;
		}

		public Boolean getArticleContentIsNotNull() {
			return articleContentIsNotNull;
		}

		public void articleContentIsNotNull() {
			this.articleContentIsNotNull = Boolean.TRUE;
		}

		public MarkdownText getArticleContentEqualTo() {
			return articleContentEqualTo;
		}

		public void articleContentEqualTo(MarkdownText value) {
			this.articleContentEqualTo = value;
		}

		public MarkdownText getArticleContentNotEqualTo() {
			return articleContentNotEqualTo;
		}

		public void articleContentNotEqualTo(MarkdownText value) {
			this.articleContentNotEqualTo = value;
		}

		public MarkdownText getArticleContentGreaterThan() {
			return articleContentGreaterThan;
		}

		public void articleContentGreaterThan(MarkdownText value) {
			this.articleContentGreaterThan = value;
		}

		public MarkdownText getArticleContentGreaterThanOrEqualTo() {
			return articleContentGreaterThanOrEqualTo;
		}

		public void articleContentGreaterThanOrEqualTo(MarkdownText value) {
			this.articleContentGreaterThanOrEqualTo = value;
		}

		public MarkdownText getArticleContentLessThan() {
			return articleContentLessThan;
		}

		public void articleContentLessThan(MarkdownText value) {
			this.articleContentLessThan = value;
		}

		public MarkdownText getArticleContentLessThanOrEqualTo() {
			return articleContentLessThanOrEqualTo;
		}

		public void articleContentLessThanOrEqualTo(MarkdownText value) {
			this.articleContentLessThanOrEqualTo = value;
		}

		public List<MarkdownText> getArticleContentIn() {
			return articleContentIn;
		}

		public void articleContentIn(List<MarkdownText> value) {
			this.articleContentIn = value;
		}

		public List<MarkdownText> getArticleContentNotIn() {
			return articleContentNotIn;
		}

		public void articleContentNotIn(List<MarkdownText> value) {
			this.articleContentNotIn = value;
		}

		public MarkdownText[] getArticleContentBetween() {
			return articleContentBetween;
		}

		public void articleContentBetween(MarkdownText beginValue, MarkdownText endValue) {
			this.articleContentBetween = new MarkdownText[]{beginValue, endValue};
		}

		public MarkdownText[] getArticleContentNotBetween() {
			return articleContentNotBetween;
		}

		public void articleContentNotBetween(MarkdownText beginValue, MarkdownText endValue) {
			this.articleContentNotBetween = new MarkdownText[]{beginValue, endValue};
		}

		public Boolean getCreateTimeIsNull() {
			return createTimeIsNull;
		}

		public void createTimeIsNull() {
			this.createTimeIsNull = Boolean.TRUE;
		}

		public Boolean getCreateTimeIsNotNull() {
			return createTimeIsNotNull;
		}

		public void createTimeIsNotNull() {
			this.createTimeIsNotNull = Boolean.TRUE;
		}

		public Timestamp getCreateTimeEqualTo() {
			return createTimeEqualTo;
		}

		public void createTimeEqualTo(Timestamp value) {
			this.createTimeEqualTo = value;
		}

		public Timestamp getCreateTimeNotEqualTo() {
			return createTimeNotEqualTo;
		}

		public void createTimeNotEqualTo(Timestamp value) {
			this.createTimeNotEqualTo = value;
		}

		public Timestamp getCreateTimeGreaterThan() {
			return createTimeGreaterThan;
		}

		public void createTimeGreaterThan(Timestamp value) {
			this.createTimeGreaterThan = value;
		}

		public Timestamp getCreateTimeGreaterThanOrEqualTo() {
			return createTimeGreaterThanOrEqualTo;
		}

		public void createTimeGreaterThanOrEqualTo(Timestamp value) {
			this.createTimeGreaterThanOrEqualTo = value;
		}

		public Timestamp getCreateTimeLessThan() {
			return createTimeLessThan;
		}

		public void createTimeLessThan(Timestamp value) {
			this.createTimeLessThan = value;
		}

		public Timestamp getCreateTimeLessThanOrEqualTo() {
			return createTimeLessThanOrEqualTo;
		}

		public void createTimeLessThanOrEqualTo(Timestamp value) {
			this.createTimeLessThanOrEqualTo = value;
		}

		public List<Timestamp> getCreateTimeIn() {
			return createTimeIn;
		}

		public void createTimeIn(List<Timestamp> value) {
			this.createTimeIn = value;
		}

		public List<Timestamp> getCreateTimeNotIn() {
			return createTimeNotIn;
		}

		public void createTimeNotIn(List<Timestamp> value) {
			this.createTimeNotIn = value;
		}

		public Timestamp[] getCreateTimeBetween() {
			return createTimeBetween;
		}

		public void createTimeBetween(Timestamp beginValue, Timestamp endValue) {
			this.createTimeBetween = new Timestamp[]{beginValue, endValue};
		}

		public Timestamp[] getCreateTimeNotBetween() {
			return createTimeNotBetween;
		}

		public void createTimeNotBetween(Timestamp beginValue, Timestamp endValue) {
			this.createTimeNotBetween = new Timestamp[]{beginValue, endValue};
		}

		public Boolean getUpdateTimeIsNull() {
			return updateTimeIsNull;
		}

		public void updateTimeIsNull() {
			this.updateTimeIsNull = Boolean.TRUE;
		}

		public Boolean getUpdateTimeIsNotNull() {
			return updateTimeIsNotNull;
		}

		public void updateTimeIsNotNull() {
			this.updateTimeIsNotNull = Boolean.TRUE;
		}

		public Timestamp getUpdateTimeEqualTo() {
			return updateTimeEqualTo;
		}

		public void updateTimeEqualTo(Timestamp value) {
			this.updateTimeEqualTo = value;
		}

		public Timestamp getUpdateTimeNotEqualTo() {
			return updateTimeNotEqualTo;
		}

		public void updateTimeNotEqualTo(Timestamp value) {
			this.updateTimeNotEqualTo = value;
		}

		public Timestamp getUpdateTimeGreaterThan() {
			return updateTimeGreaterThan;
		}

		public void updateTimeGreaterThan(Timestamp value) {
			this.updateTimeGreaterThan = value;
		}

		public Timestamp getUpdateTimeGreaterThanOrEqualTo() {
			return updateTimeGreaterThanOrEqualTo;
		}

		public void updateTimeGreaterThanOrEqualTo(Timestamp value) {
			this.updateTimeGreaterThanOrEqualTo = value;
		}

		public Timestamp getUpdateTimeLessThan() {
			return updateTimeLessThan;
		}

		public void updateTimeLessThan(Timestamp value) {
			this.updateTimeLessThan = value;
		}

		public Timestamp getUpdateTimeLessThanOrEqualTo() {
			return updateTimeLessThanOrEqualTo;
		}

		public void updateTimeLessThanOrEqualTo(Timestamp value) {
			this.updateTimeLessThanOrEqualTo = value;
		}

		public List<Timestamp> getUpdateTimeIn() {
			return updateTimeIn;
		}

		public void updateTimeIn(List<Timestamp> value) {
			this.updateTimeIn = value;
		}

		public List<Timestamp> getUpdateTimeNotIn() {
			return updateTimeNotIn;
		}

		public void updateTimeNotIn(List<Timestamp> value) {
			this.updateTimeNotIn = value;
		}

		public Timestamp[] getUpdateTimeBetween() {
			return updateTimeBetween;
		}

		public void updateTimeBetween(Timestamp beginValue, Timestamp endValue) {
			this.updateTimeBetween = new Timestamp[]{beginValue, endValue};
		}

		public Timestamp[] getUpdateTimeNotBetween() {
			return updateTimeNotBetween;
		}

		public void updateTimeNotBetween(Timestamp beginValue, Timestamp endValue) {
			this.updateTimeNotBetween = new Timestamp[]{beginValue, endValue};
		}

	}
}
