package com.lnsf.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CollectionhomeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CollectionhomeExample() {
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

        public Criteria andHomeidIsNull() {
            addCriterion("homeId is null");
            return (Criteria) this;
        }

        public Criteria andHomeidIsNotNull() {
            addCriterion("homeId is not null");
            return (Criteria) this;
        }

        public Criteria andHomeidEqualTo(Integer value) {
            addCriterion("homeId =", value, "homeid");
            return (Criteria) this;
        }

        public Criteria andHomeidNotEqualTo(Integer value) {
            addCriterion("homeId <>", value, "homeid");
            return (Criteria) this;
        }

        public Criteria andHomeidGreaterThan(Integer value) {
            addCriterion("homeId >", value, "homeid");
            return (Criteria) this;
        }

        public Criteria andHomeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("homeId >=", value, "homeid");
            return (Criteria) this;
        }

        public Criteria andHomeidLessThan(Integer value) {
            addCriterion("homeId <", value, "homeid");
            return (Criteria) this;
        }

        public Criteria andHomeidLessThanOrEqualTo(Integer value) {
            addCriterion("homeId <=", value, "homeid");
            return (Criteria) this;
        }

        public Criteria andHomeidIn(List<Integer> values) {
            addCriterion("homeId in", values, "homeid");
            return (Criteria) this;
        }

        public Criteria andHomeidNotIn(List<Integer> values) {
            addCriterion("homeId not in", values, "homeid");
            return (Criteria) this;
        }

        public Criteria andHomeidBetween(Integer value1, Integer value2) {
            addCriterion("homeId between", value1, value2, "homeid");
            return (Criteria) this;
        }

        public Criteria andHomeidNotBetween(Integer value1, Integer value2) {
            addCriterion("homeId not between", value1, value2, "homeid");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Integer value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Integer value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Integer value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Integer value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Integer value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Integer> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Integer> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Integer value1, Integer value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Integer value1, Integer value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeIsNull() {
            addCriterion("collection_time is null");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeIsNotNull() {
            addCriterion("collection_time is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeEqualTo(Date value) {
            addCriterion("collection_time =", value, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeNotEqualTo(Date value) {
            addCriterion("collection_time <>", value, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeGreaterThan(Date value) {
            addCriterion("collection_time >", value, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("collection_time >=", value, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeLessThan(Date value) {
            addCriterion("collection_time <", value, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeLessThanOrEqualTo(Date value) {
            addCriterion("collection_time <=", value, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeIn(List<Date> values) {
            addCriterion("collection_time in", values, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeNotIn(List<Date> values) {
            addCriterion("collection_time not in", values, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeBetween(Date value1, Date value2) {
            addCriterion("collection_time between", value1, value2, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeNotBetween(Date value1, Date value2) {
            addCriterion("collection_time not between", value1, value2, "collectionTime");
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