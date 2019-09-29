package com.lnsf.bean;

import java.util.ArrayList;
import java.util.List;

public class OrderlistExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderlistExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andOidIsNull() {
            addCriterion("oid is null");
            return (Criteria) this;
        }

        public Criteria andOidIsNotNull() {
            addCriterion("oid is not null");
            return (Criteria) this;
        }

        public Criteria andOidEqualTo(Integer value) {
            addCriterion("oid =", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotEqualTo(Integer value) {
            addCriterion("oid <>", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidGreaterThan(Integer value) {
            addCriterion("oid >", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidGreaterThanOrEqualTo(Integer value) {
            addCriterion("oid >=", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidLessThan(Integer value) {
            addCriterion("oid <", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidLessThanOrEqualTo(Integer value) {
            addCriterion("oid <=", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidIn(List<Integer> values) {
            addCriterion("oid in", values, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotIn(List<Integer> values) {
            addCriterion("oid not in", values, "oid");
            return (Criteria) this;
        }

        public Criteria andOidBetween(Integer value1, Integer value2) {
            addCriterion("oid between", value1, value2, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotBetween(Integer value1, Integer value2) {
            addCriterion("oid not between", value1, value2, "oid");
            return (Criteria) this;
        }

        public Criteria andUtelIsNull() {
            addCriterion("utel is null");
            return (Criteria) this;
        }

        public Criteria andUtelIsNotNull() {
            addCriterion("utel is not null");
            return (Criteria) this;
        }

        public Criteria andUtelEqualTo(String value) {
            addCriterion("utel =", value, "utel");
            return (Criteria) this;
        }

        public Criteria andUtelNotEqualTo(String value) {
            addCriterion("utel <>", value, "utel");
            return (Criteria) this;
        }

        public Criteria andUtelGreaterThan(String value) {
            addCriterion("utel >", value, "utel");
            return (Criteria) this;
        }

        public Criteria andUtelGreaterThanOrEqualTo(String value) {
            addCriterion("utel >=", value, "utel");
            return (Criteria) this;
        }

        public Criteria andUtelLessThan(String value) {
            addCriterion("utel <", value, "utel");
            return (Criteria) this;
        }

        public Criteria andUtelLessThanOrEqualTo(String value) {
            addCriterion("utel <=", value, "utel");
            return (Criteria) this;
        }

        public Criteria andUtelLike(String value) {
            addCriterion("utel like", value, "utel");
            return (Criteria) this;
        }

        public Criteria andUtelNotLike(String value) {
            addCriterion("utel not like", value, "utel");
            return (Criteria) this;
        }

        public Criteria andUtelIn(List<String> values) {
            addCriterion("utel in", values, "utel");
            return (Criteria) this;
        }

        public Criteria andUtelNotIn(List<String> values) {
            addCriterion("utel not in", values, "utel");
            return (Criteria) this;
        }

        public Criteria andUtelBetween(String value1, String value2) {
            addCriterion("utel between", value1, value2, "utel");
            return (Criteria) this;
        }

        public Criteria andUtelNotBetween(String value1, String value2) {
            addCriterion("utel not between", value1, value2, "utel");
            return (Criteria) this;
        }

        public Criteria andHtelIsNull() {
            addCriterion("htel is null");
            return (Criteria) this;
        }

        public Criteria andHtelIsNotNull() {
            addCriterion("htel is not null");
            return (Criteria) this;
        }

        public Criteria andHtelEqualTo(String value) {
            addCriterion("htel =", value, "htel");
            return (Criteria) this;
        }

        public Criteria andHtelNotEqualTo(String value) {
            addCriterion("htel <>", value, "htel");
            return (Criteria) this;
        }

        public Criteria andHtelGreaterThan(String value) {
            addCriterion("htel >", value, "htel");
            return (Criteria) this;
        }

        public Criteria andHtelGreaterThanOrEqualTo(String value) {
            addCriterion("htel >=", value, "htel");
            return (Criteria) this;
        }

        public Criteria andHtelLessThan(String value) {
            addCriterion("htel <", value, "htel");
            return (Criteria) this;
        }

        public Criteria andHtelLessThanOrEqualTo(String value) {
            addCriterion("htel <=", value, "htel");
            return (Criteria) this;
        }

        public Criteria andHtelLike(String value) {
            addCriterion("htel like", value, "htel");
            return (Criteria) this;
        }

        public Criteria andHtelNotLike(String value) {
            addCriterion("htel not like", value, "htel");
            return (Criteria) this;
        }

        public Criteria andHtelIn(List<String> values) {
            addCriterion("htel in", values, "htel");
            return (Criteria) this;
        }

        public Criteria andHtelNotIn(List<String> values) {
            addCriterion("htel not in", values, "htel");
            return (Criteria) this;
        }

        public Criteria andHtelBetween(String value1, String value2) {
            addCriterion("htel between", value1, value2, "htel");
            return (Criteria) this;
        }

        public Criteria andHtelNotBetween(String value1, String value2) {
            addCriterion("htel not between", value1, value2, "htel");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andHusernameIsNull() {
            addCriterion("husername is null");
            return (Criteria) this;
        }

        public Criteria andHusernameIsNotNull() {
            addCriterion("husername is not null");
            return (Criteria) this;
        }

        public Criteria andHusernameEqualTo(String value) {
            addCriterion("husername =", value, "husername");
            return (Criteria) this;
        }

        public Criteria andHusernameNotEqualTo(String value) {
            addCriterion("husername <>", value, "husername");
            return (Criteria) this;
        }

        public Criteria andHusernameGreaterThan(String value) {
            addCriterion("husername >", value, "husername");
            return (Criteria) this;
        }

        public Criteria andHusernameGreaterThanOrEqualTo(String value) {
            addCriterion("husername >=", value, "husername");
            return (Criteria) this;
        }

        public Criteria andHusernameLessThan(String value) {
            addCriterion("husername <", value, "husername");
            return (Criteria) this;
        }

        public Criteria andHusernameLessThanOrEqualTo(String value) {
            addCriterion("husername <=", value, "husername");
            return (Criteria) this;
        }

        public Criteria andHusernameLike(String value) {
            addCriterion("husername like", value, "husername");
            return (Criteria) this;
        }

        public Criteria andHusernameNotLike(String value) {
            addCriterion("husername not like", value, "husername");
            return (Criteria) this;
        }

        public Criteria andHusernameIn(List<String> values) {
            addCriterion("husername in", values, "husername");
            return (Criteria) this;
        }

        public Criteria andHusernameNotIn(List<String> values) {
            addCriterion("husername not in", values, "husername");
            return (Criteria) this;
        }

        public Criteria andHusernameBetween(String value1, String value2) {
            addCriterion("husername between", value1, value2, "husername");
            return (Criteria) this;
        }

        public Criteria andHusernameNotBetween(String value1, String value2) {
            addCriterion("husername not between", value1, value2, "husername");
            return (Criteria) this;
        }

        public Criteria andFalgsIsNull() {
            addCriterion("falgs is null");
            return (Criteria) this;
        }

        public Criteria andFalgsIsNotNull() {
            addCriterion("falgs is not null");
            return (Criteria) this;
        }

        public Criteria andFalgsEqualTo(Integer value) {
            addCriterion("falgs =", value, "falgs");
            return (Criteria) this;
        }

        public Criteria andFalgsNotEqualTo(Integer value) {
            addCriterion("falgs <>", value, "falgs");
            return (Criteria) this;
        }

        public Criteria andFalgsGreaterThan(Integer value) {
            addCriterion("falgs >", value, "falgs");
            return (Criteria) this;
        }

        public Criteria andFalgsGreaterThanOrEqualTo(Integer value) {
            addCriterion("falgs >=", value, "falgs");
            return (Criteria) this;
        }

        public Criteria andFalgsLessThan(Integer value) {
            addCriterion("falgs <", value, "falgs");
            return (Criteria) this;
        }

        public Criteria andFalgsLessThanOrEqualTo(Integer value) {
            addCriterion("falgs <=", value, "falgs");
            return (Criteria) this;
        }

        public Criteria andFalgsIn(List<Integer> values) {
            addCriterion("falgs in", values, "falgs");
            return (Criteria) this;
        }

        public Criteria andFalgsNotIn(List<Integer> values) {
            addCriterion("falgs not in", values, "falgs");
            return (Criteria) this;
        }

        public Criteria andFalgsBetween(Integer value1, Integer value2) {
            addCriterion("falgs between", value1, value2, "falgs");
            return (Criteria) this;
        }

        public Criteria andFalgsNotBetween(Integer value1, Integer value2) {
            addCriterion("falgs not between", value1, value2, "falgs");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}