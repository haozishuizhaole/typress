package cc.chenzhihao.typress.core.domain.condition;

import cc.chenzhihao.typress.core.domain.condition.base.Condition;
import java.util.List;
import java.util.ArrayList;
import cc.chenzhihao.typress.core.domain.model.vo.session.SessionId;
import cc.chenzhihao.typress.core.domain.model.vo.Timestamp;

public class SessionCondition extends Condition {
	private final List<Criteria> oredCriteria;

	public SessionCondition() {
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
		private Boolean sessionIdIsNull;
		private Boolean sessionIdIsNotNull;
		private SessionId sessionIdEqualTo;
		private SessionId sessionIdNotEqualTo;
		private SessionId sessionIdGreaterThan;
		private SessionId sessionIdGreaterThanOrEqualTo;
		private SessionId sessionIdLessThan;
		private SessionId sessionIdLessThanOrEqualTo;
		private List<SessionId> sessionIdIn;
		private List<SessionId> sessionIdNotIn;
		private SessionId[] sessionIdBetween;
		private SessionId[] sessionIdNotBetween;

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

		public Boolean getSessionIdIsNull() {
			return sessionIdIsNull;
		}

		public void sessionIdIsNull() {
			this.sessionIdIsNull = Boolean.TRUE;
		}

		public Boolean getSessionIdIsNotNull() {
			return sessionIdIsNotNull;
		}

		public void sessionIdIsNotNull() {
			this.sessionIdIsNotNull = Boolean.TRUE;
		}

		public SessionId getSessionIdEqualTo() {
			return sessionIdEqualTo;
		}

		public void sessionIdEqualTo(SessionId value) {
			this.sessionIdEqualTo = value;
		}

		public SessionId getSessionIdNotEqualTo() {
			return sessionIdNotEqualTo;
		}

		public void sessionIdNotEqualTo(SessionId value) {
			this.sessionIdNotEqualTo = value;
		}

		public SessionId getSessionIdGreaterThan() {
			return sessionIdGreaterThan;
		}

		public void sessionIdGreaterThan(SessionId value) {
			this.sessionIdGreaterThan = value;
		}

		public SessionId getSessionIdGreaterThanOrEqualTo() {
			return sessionIdGreaterThanOrEqualTo;
		}

		public void sessionIdGreaterThanOrEqualTo(SessionId value) {
			this.sessionIdGreaterThanOrEqualTo = value;
		}

		public SessionId getSessionIdLessThan() {
			return sessionIdLessThan;
		}

		public void sessionIdLessThan(SessionId value) {
			this.sessionIdLessThan = value;
		}

		public SessionId getSessionIdLessThanOrEqualTo() {
			return sessionIdLessThanOrEqualTo;
		}

		public void sessionIdLessThanOrEqualTo(SessionId value) {
			this.sessionIdLessThanOrEqualTo = value;
		}

		public List<SessionId> getSessionIdIn() {
			return sessionIdIn;
		}

		public void sessionIdIn(List<SessionId> value) {
			this.sessionIdIn = value;
		}

		public List<SessionId> getSessionIdNotIn() {
			return sessionIdNotIn;
		}

		public void sessionIdNotIn(List<SessionId> value) {
			this.sessionIdNotIn = value;
		}

		public SessionId[] getSessionIdBetween() {
			return sessionIdBetween;
		}

		public void sessionIdBetween(SessionId beginValue, SessionId endValue) {
			this.sessionIdBetween = new SessionId[]{beginValue, endValue};
		}

		public SessionId[] getSessionIdNotBetween() {
			return sessionIdNotBetween;
		}

		public void sessionIdNotBetween(SessionId beginValue, SessionId endValue) {
			this.sessionIdNotBetween = new SessionId[]{beginValue, endValue};
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

	}
}
