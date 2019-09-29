package com.lnsf.bean;

import java.util.ArrayList;
import java.util.List;

public class HistoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HistoryExample() {
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

        public Criteria andHidIsNull() {
            addCriterion("hid is null");
            return (Criteria) this;
        }

        public Criteria andHidIsNotNull() {
            addCriterion("hid is not null");
            return (Criteria) this;
        }

        public Criteria andHidEqualTo(Integer value) {
            addCriterion("hid =", value, "hid");
            return (Criteria) this;
        }

        public Criteria andHidNotEqualTo(Integer value) {
            addCriterion("hid <>", value, "hid");
            return (Criteria) this;
        }

        public Criteria andHidGreaterThan(Integer value) {
            addCriterion("hid >", value, "hid");
            return (Criteria) this;
        }

        public Criteria andHidGreaterThanOrEqualTo(Integer value) {
            addCriterion("hid >=", value, "hid");
            return (Criteria) this;
        }

        public Criteria andHidLessThan(Integer value) {
            addCriterion("hid <", value, "hid");
            return (Criteria) this;
        }

        public Criteria andHidLessThanOrEqualTo(Integer value) {
            addCriterion("hid <=", value, "hid");
            return (Criteria) this;
        }

        public Criteria andHidIn(List<Integer> values) {
            addCriterion("hid in", values, "hid");
            return (Criteria) this;
        }

        public Criteria andHidNotIn(List<Integer> values) {
            addCriterion("hid not in", values, "hid");
            return (Criteria) this;
        }

        public Criteria andHidBetween(Integer value1, Integer value2) {
            addCriterion("hid between", value1, value2, "hid");
            return (Criteria) this;
        }

        public Criteria andHidNotBetween(Integer value1, Integer value2) {
            addCriterion("hid not between", value1, value2, "hid");
            return (Criteria) this;
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

        public Criteria andCollectionidIsNull() {
            addCriterion("collectionId is null");
            return (Criteria) this;
        }

        public Criteria andCollectionidIsNotNull() {
            addCriterion("collectionId is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionidEqualTo(Integer value) {
            addCriterion("collectionId =", value, "collectionid");
            return (Criteria) this;
        }

        public Criteria andCollectionidNotEqualTo(Integer value) {
            addCriterion("collectionId <>", value, "collectionid");
            return (Criteria) this;
        }

        public Criteria andCollectionidGreaterThan(Integer value) {
            addCriterion("collectionId >", value, "collectionid");
            return (Criteria) this;
        }

        public Criteria andCollectionidGreaterThanOrEqualTo(Integer value) {
            addCriterion("collectionId >=", value, "collectionid");
            return (Criteria) this;
        }

        public Criteria andCollectionidLessThan(Integer value) {
            addCriterion("collectionId <", value, "collectionid");
            return (Criteria) this;
        }

        public Criteria andCollectionidLessThanOrEqualTo(Integer value) {
            addCriterion("collectionId <=", value, "collectionid");
            return (Criteria) this;
        }

        public Criteria andCollectionidIn(List<Integer> values) {
            addCriterion("collectionId in", values, "collectionid");
            return (Criteria) this;
        }

        public Criteria andCollectionidNotIn(List<Integer> values) {
            addCriterion("collectionId not in", values, "collectionid");
            return (Criteria) this;
        }

        public Criteria andCollectionidBetween(Integer value1, Integer value2) {
            addCriterion("collectionId between", value1, value2, "collectionid");
            return (Criteria) this;
        }

        public Criteria andCollectionidNotBetween(Integer value1, Integer value2) {
            addCriterion("collectionId not between", value1, value2, "collectionid");
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