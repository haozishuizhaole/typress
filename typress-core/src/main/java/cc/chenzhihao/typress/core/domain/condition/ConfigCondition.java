package cc.chenzhihao.typress.core.domain.condition;

import cc.chenzhihao.typress.core.domain.condition.base.Condition;
import java.util.List;
import java.util.ArrayList;
import cc.chenzhihao.typress.core.domain.model.vo.config.ConfigName;
import cc.chenzhihao.typress.core.domain.model.vo.Timestamp;

public class ConfigCondition extends Condition {
	private final List<Criteria> oredCriteria;

	public ConfigCondition() {
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
		private Boolean configNameIsNull;
		private Boolean configNameIsNotNull;
		private ConfigName configNameEqualTo;
		private ConfigName configNameNotEqualTo;
		private ConfigName configNameGreaterThan;
		private ConfigName configNameGreaterThanOrEqualTo;
		private ConfigName configNameLessThan;
		private ConfigName configNameLessThanOrEqualTo;
		private List<ConfigName> configNameIn;
		private List<ConfigName> configNameNotIn;
		private ConfigName[] configNameBetween;
		private ConfigName[] configNameNotBetween;

		private Boolean configValueIsNull;
		private Boolean configValueIsNotNull;
		private Object configValueEqualTo;
		private Object configValueNotEqualTo;
		private Object configValueGreaterThan;
		private Object configValueGreaterThanOrEqualTo;
		private Object configValueLessThan;
		private Object configValueLessThanOrEqualTo;
		private List<Object> configValueIn;
		private List<Object> configValueNotIn;
		private Object[] configValueBetween;
		private Object[] configValueNotBetween;

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

		public Boolean getConfigNameIsNull() {
			return configNameIsNull;
		}

		public void configNameIsNull() {
			this.configNameIsNull = Boolean.TRUE;
		}

		public Boolean getConfigNameIsNotNull() {
			return configNameIsNotNull;
		}

		public void configNameIsNotNull() {
			this.configNameIsNotNull = Boolean.TRUE;
		}

		public ConfigName getConfigNameEqualTo() {
			return configNameEqualTo;
		}

		public void configNameEqualTo(ConfigName value) {
			this.configNameEqualTo = value;
		}

		public ConfigName getConfigNameNotEqualTo() {
			return configNameNotEqualTo;
		}

		public void configNameNotEqualTo(ConfigName value) {
			this.configNameNotEqualTo = value;
		}

		public ConfigName getConfigNameGreaterThan() {
			return configNameGreaterThan;
		}

		public void configNameGreaterThan(ConfigName value) {
			this.configNameGreaterThan = value;
		}

		public ConfigName getConfigNameGreaterThanOrEqualTo() {
			return configNameGreaterThanOrEqualTo;
		}

		public void configNameGreaterThanOrEqualTo(ConfigName value) {
			this.configNameGreaterThanOrEqualTo = value;
		}

		public ConfigName getConfigNameLessThan() {
			return configNameLessThan;
		}

		public void configNameLessThan(ConfigName value) {
			this.configNameLessThan = value;
		}

		public ConfigName getConfigNameLessThanOrEqualTo() {
			return configNameLessThanOrEqualTo;
		}

		public void configNameLessThanOrEqualTo(ConfigName value) {
			this.configNameLessThanOrEqualTo = value;
		}

		public List<ConfigName> getConfigNameIn() {
			return configNameIn;
		}

		public void configNameIn(List<ConfigName> value) {
			this.configNameIn = value;
		}

		public List<ConfigName> getConfigNameNotIn() {
			return configNameNotIn;
		}

		public void configNameNotIn(List<ConfigName> value) {
			this.configNameNotIn = value;
		}

		public ConfigName[] getConfigNameBetween() {
			return configNameBetween;
		}

		public void configNameBetween(ConfigName beginValue, ConfigName endValue) {
			this.configNameBetween = new ConfigName[]{beginValue, endValue};
		}

		public ConfigName[] getConfigNameNotBetween() {
			return configNameNotBetween;
		}

		public void configNameNotBetween(ConfigName beginValue, ConfigName endValue) {
			this.configNameNotBetween = new ConfigName[]{beginValue, endValue};
		}

		public Boolean getConfigValueIsNull() {
			return configValueIsNull;
		}

		public void configValueIsNull() {
			this.configValueIsNull = Boolean.TRUE;
		}

		public Boolean getConfigValueIsNotNull() {
			return configValueIsNotNull;
		}

		public void configValueIsNotNull() {
			this.configValueIsNotNull = Boolean.TRUE;
		}

		public Object getConfigValueEqualTo() {
			return configValueEqualTo;
		}

		public void configValueEqualTo(Object value) {
			this.configValueEqualTo = value;
		}

		public Object getConfigValueNotEqualTo() {
			return configValueNotEqualTo;
		}

		public void configValueNotEqualTo(Object value) {
			this.configValueNotEqualTo = value;
		}

		public Object getConfigValueGreaterThan() {
			return configValueGreaterThan;
		}

		public void configValueGreaterThan(Object value) {
			this.configValueGreaterThan = value;
		}

		public Object getConfigValueGreaterThanOrEqualTo() {
			return configValueGreaterThanOrEqualTo;
		}

		public void configValueGreaterThanOrEqualTo(Object value) {
			this.configValueGreaterThanOrEqualTo = value;
		}

		public Object getConfigValueLessThan() {
			return configValueLessThan;
		}

		public void configValueLessThan(Object value) {
			this.configValueLessThan = value;
		}

		public Object getConfigValueLessThanOrEqualTo() {
			return configValueLessThanOrEqualTo;
		}

		public void configValueLessThanOrEqualTo(Object value) {
			this.configValueLessThanOrEqualTo = value;
		}

		public List<Object> getConfigValueIn() {
			return configValueIn;
		}

		public void configValueIn(List<Object> value) {
			this.configValueIn = value;
		}

		public List<Object> getConfigValueNotIn() {
			return configValueNotIn;
		}

		public void configValueNotIn(List<Object> value) {
			this.configValueNotIn = value;
		}

		public Object[] getConfigValueBetween() {
			return configValueBetween;
		}

		public void configValueBetween(Object beginValue, Object endValue) {
			this.configValueBetween = new Object[]{beginValue, endValue};
		}

		public Object[] getConfigValueNotBetween() {
			return configValueNotBetween;
		}

		public void configValueNotBetween(Object beginValue, Object endValue) {
			this.configValueNotBetween = new Object[]{beginValue, endValue};
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
