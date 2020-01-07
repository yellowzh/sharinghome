package com.lnsf.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderListExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderListExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Integer value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Integer value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Integer value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Integer value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Integer> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Integer> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andPassengerIdIsNull() {
            addCriterion("passenger_id is null");
            return (Criteria) this;
        }

        public Criteria andPassengerIdIsNotNull() {
            addCriterion("passenger_id is not null");
            return (Criteria) this;
        }

        public Criteria andPassengerIdEqualTo(Integer value) {
            addCriterion("passenger_id =", value, "passengerId");
            return (Criteria) this;
        }

        public Criteria andPassengerIdNotEqualTo(Integer value) {
            addCriterion("passenger_id <>", value, "passengerId");
            return (Criteria) this;
        }

        public Criteria andPassengerIdGreaterThan(Integer value) {
            addCriterion("passenger_id >", value, "passengerId");
            return (Criteria) this;
        }

        public Criteria andPassengerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("passenger_id >=", value, "passengerId");
            return (Criteria) this;
        }

        public Criteria andPassengerIdLessThan(Integer value) {
            addCriterion("passenger_id <", value, "passengerId");
            return (Criteria) this;
        }

        public Criteria andPassengerIdLessThanOrEqualTo(Integer value) {
            addCriterion("passenger_id <=", value, "passengerId");
            return (Criteria) this;
        }

        public Criteria andPassengerIdIn(List<Integer> values) {
            addCriterion("passenger_id in", values, "passengerId");
            return (Criteria) this;
        }

        public Criteria andPassengerIdNotIn(List<Integer> values) {
            addCriterion("passenger_id not in", values, "passengerId");
            return (Criteria) this;
        }

        public Criteria andPassengerIdBetween(Integer value1, Integer value2) {
            addCriterion("passenger_id between", value1, value2, "passengerId");
            return (Criteria) this;
        }

        public Criteria andPassengerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("passenger_id not between", value1, value2, "passengerId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdIsNull() {
            addCriterion("business_id is null");
            return (Criteria) this;
        }

        public Criteria andBusinessIdIsNotNull() {
            addCriterion("business_id is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessIdEqualTo(Integer value) {
            addCriterion("business_id =", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdNotEqualTo(Integer value) {
            addCriterion("business_id <>", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdGreaterThan(Integer value) {
            addCriterion("business_id >", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("business_id >=", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdLessThan(Integer value) {
            addCriterion("business_id <", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdLessThanOrEqualTo(Integer value) {
            addCriterion("business_id <=", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdIn(List<Integer> values) {
            addCriterion("business_id in", values, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdNotIn(List<Integer> values) {
            addCriterion("business_id not in", values, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdBetween(Integer value1, Integer value2) {
            addCriterion("business_id between", value1, value2, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdNotBetween(Integer value1, Integer value2) {
            addCriterion("business_id not between", value1, value2, "businessId");
            return (Criteria) this;
        }

        public Criteria andHousesIdIsNull() {
            addCriterion("houses_id is null");
            return (Criteria) this;
        }

        public Criteria andHousesIdIsNotNull() {
            addCriterion("houses_id is not null");
            return (Criteria) this;
        }

        public Criteria andHousesIdEqualTo(Integer value) {
            addCriterion("houses_id =", value, "housesId");
            return (Criteria) this;
        }

        public Criteria andHousesIdNotEqualTo(Integer value) {
            addCriterion("houses_id <>", value, "housesId");
            return (Criteria) this;
        }

        public Criteria andHousesIdGreaterThan(Integer value) {
            addCriterion("houses_id >", value, "housesId");
            return (Criteria) this;
        }

        public Criteria andHousesIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("houses_id >=", value, "housesId");
            return (Criteria) this;
        }

        public Criteria andHousesIdLessThan(Integer value) {
            addCriterion("houses_id <", value, "housesId");
            return (Criteria) this;
        }

        public Criteria andHousesIdLessThanOrEqualTo(Integer value) {
            addCriterion("houses_id <=", value, "housesId");
            return (Criteria) this;
        }

        public Criteria andHousesIdIn(List<Integer> values) {
            addCriterion("houses_id in", values, "housesId");
            return (Criteria) this;
        }

        public Criteria andHousesIdNotIn(List<Integer> values) {
            addCriterion("houses_id not in", values, "housesId");
            return (Criteria) this;
        }

        public Criteria andHousesIdBetween(Integer value1, Integer value2) {
            addCriterion("houses_id between", value1, value2, "housesId");
            return (Criteria) this;
        }

        public Criteria andHousesIdNotBetween(Integer value1, Integer value2) {
            addCriterion("houses_id not between", value1, value2, "housesId");
            return (Criteria) this;
        }

        public Criteria andHousesNumIsNull() {
            addCriterion("houses_num is null");
            return (Criteria) this;
        }

        public Criteria andHousesNumIsNotNull() {
            addCriterion("houses_num is not null");
            return (Criteria) this;
        }

        public Criteria andHousesNumEqualTo(Integer value) {
            addCriterion("houses_num =", value, "housesNum");
            return (Criteria) this;
        }

        public Criteria andHousesNumNotEqualTo(Integer value) {
            addCriterion("houses_num <>", value, "housesNum");
            return (Criteria) this;
        }

        public Criteria andHousesNumGreaterThan(Integer value) {
            addCriterion("houses_num >", value, "housesNum");
            return (Criteria) this;
        }

        public Criteria andHousesNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("houses_num >=", value, "housesNum");
            return (Criteria) this;
        }

        public Criteria andHousesNumLessThan(Integer value) {
            addCriterion("houses_num <", value, "housesNum");
            return (Criteria) this;
        }

        public Criteria andHousesNumLessThanOrEqualTo(Integer value) {
            addCriterion("houses_num <=", value, "housesNum");
            return (Criteria) this;
        }

        public Criteria andHousesNumIn(List<Integer> values) {
            addCriterion("houses_num in", values, "housesNum");
            return (Criteria) this;
        }

        public Criteria andHousesNumNotIn(List<Integer> values) {
            addCriterion("houses_num not in", values, "housesNum");
            return (Criteria) this;
        }

        public Criteria andHousesNumBetween(Integer value1, Integer value2) {
            addCriterion("houses_num between", value1, value2, "housesNum");
            return (Criteria) this;
        }

        public Criteria andHousesNumNotBetween(Integer value1, Integer value2) {
            addCriterion("houses_num not between", value1, value2, "housesNum");
            return (Criteria) this;
        }

        public Criteria andOrderPricesIsNull() {
            addCriterion("order_prices is null");
            return (Criteria) this;
        }

        public Criteria andOrderPricesIsNotNull() {
            addCriterion("order_prices is not null");
            return (Criteria) this;
        }

        public Criteria andOrderPricesEqualTo(Integer value) {
            addCriterion("order_prices =", value, "orderPrices");
            return (Criteria) this;
        }

        public Criteria andOrderPricesNotEqualTo(Integer value) {
            addCriterion("order_prices <>", value, "orderPrices");
            return (Criteria) this;
        }

        public Criteria andOrderPricesGreaterThan(Integer value) {
            addCriterion("order_prices >", value, "orderPrices");
            return (Criteria) this;
        }

        public Criteria andOrderPricesGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_prices >=", value, "orderPrices");
            return (Criteria) this;
        }

        public Criteria andOrderPricesLessThan(Integer value) {
            addCriterion("order_prices <", value, "orderPrices");
            return (Criteria) this;
        }

        public Criteria andOrderPricesLessThanOrEqualTo(Integer value) {
            addCriterion("order_prices <=", value, "orderPrices");
            return (Criteria) this;
        }

        public Criteria andOrderPricesIn(List<Integer> values) {
            addCriterion("order_prices in", values, "orderPrices");
            return (Criteria) this;
        }

        public Criteria andOrderPricesNotIn(List<Integer> values) {
            addCriterion("order_prices not in", values, "orderPrices");
            return (Criteria) this;
        }

        public Criteria andOrderPricesBetween(Integer value1, Integer value2) {
            addCriterion("order_prices between", value1, value2, "orderPrices");
            return (Criteria) this;
        }

        public Criteria andOrderPricesNotBetween(Integer value1, Integer value2) {
            addCriterion("order_prices not between", value1, value2, "orderPrices");
            return (Criteria) this;
        }

        public Criteria andHousesInIsNull() {
            addCriterion("houses_in is null");
            return (Criteria) this;
        }

        public Criteria andHousesInIsNotNull() {
            addCriterion("houses_in is not null");
            return (Criteria) this;
        }

        public Criteria andHousesInEqualTo(String value) {
            addCriterion("houses_in =", value, "housesIn");
            return (Criteria) this;
        }

        public Criteria andHousesInNotEqualTo(String value) {
            addCriterion("houses_in <>", value, "housesIn");
            return (Criteria) this;
        }

        public Criteria andHousesInGreaterThan(String value) {
            addCriterion("houses_in >", value, "housesIn");
            return (Criteria) this;
        }

        public Criteria andHousesInGreaterThanOrEqualTo(String value) {
            addCriterion("houses_in >=", value, "housesIn");
            return (Criteria) this;
        }

        public Criteria andHousesInLessThan(String value) {
            addCriterion("houses_in <", value, "housesIn");
            return (Criteria) this;
        }

        public Criteria andHousesInLessThanOrEqualTo(String value) {
            addCriterion("houses_in <=", value, "housesIn");
            return (Criteria) this;
        }

        public Criteria andHousesInLike(String value) {
            addCriterion("houses_in like", value, "housesIn");
            return (Criteria) this;
        }

        public Criteria andHousesInNotLike(String value) {
            addCriterion("houses_in not like", value, "housesIn");
            return (Criteria) this;
        }

        public Criteria andHousesInIn(List<String> values) {
            addCriterion("houses_in in", values, "housesIn");
            return (Criteria) this;
        }

        public Criteria andHousesInNotIn(List<String> values) {
            addCriterion("houses_in not in", values, "housesIn");
            return (Criteria) this;
        }

        public Criteria andHousesInBetween(String value1, String value2) {
            addCriterion("houses_in between", value1, value2, "housesIn");
            return (Criteria) this;
        }

        public Criteria andHousesInNotBetween(String value1, String value2) {
            addCriterion("houses_in not between", value1, value2, "housesIn");
            return (Criteria) this;
        }

        public Criteria andOrderPayIsNull() {
            addCriterion("order_pay is null");
            return (Criteria) this;
        }

        public Criteria andOrderPayIsNotNull() {
            addCriterion("order_pay is not null");
            return (Criteria) this;
        }

        public Criteria andOrderPayEqualTo(String value) {
            addCriterion("order_pay =", value, "orderPay");
            return (Criteria) this;
        }

        public Criteria andOrderPayNotEqualTo(String value) {
            addCriterion("order_pay <>", value, "orderPay");
            return (Criteria) this;
        }

        public Criteria andOrderPayGreaterThan(String value) {
            addCriterion("order_pay >", value, "orderPay");
            return (Criteria) this;
        }

        public Criteria andOrderPayGreaterThanOrEqualTo(String value) {
            addCriterion("order_pay >=", value, "orderPay");
            return (Criteria) this;
        }

        public Criteria andOrderPayLessThan(String value) {
            addCriterion("order_pay <", value, "orderPay");
            return (Criteria) this;
        }

        public Criteria andOrderPayLessThanOrEqualTo(String value) {
            addCriterion("order_pay <=", value, "orderPay");
            return (Criteria) this;
        }

        public Criteria andOrderPayLike(String value) {
            addCriterion("order_pay like", value, "orderPay");
            return (Criteria) this;
        }

        public Criteria andOrderPayNotLike(String value) {
            addCriterion("order_pay not like", value, "orderPay");
            return (Criteria) this;
        }

        public Criteria andOrderPayIn(List<String> values) {
            addCriterion("order_pay in", values, "orderPay");
            return (Criteria) this;
        }

        public Criteria andOrderPayNotIn(List<String> values) {
            addCriterion("order_pay not in", values, "orderPay");
            return (Criteria) this;
        }

        public Criteria andOrderPayBetween(String value1, String value2) {
            addCriterion("order_pay between", value1, value2, "orderPay");
            return (Criteria) this;
        }

        public Criteria andOrderPayNotBetween(String value1, String value2) {
            addCriterion("order_pay not between", value1, value2, "orderPay");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andOrderFalgsIsNull() {
            addCriterion("order_falgs is null");
            return (Criteria) this;
        }

        public Criteria andOrderFalgsIsNotNull() {
            addCriterion("order_falgs is not null");
            return (Criteria) this;
        }

        public Criteria andOrderFalgsEqualTo(String value) {
            addCriterion("order_falgs =", value, "orderFalgs");
            return (Criteria) this;
        }

        public Criteria andOrderFalgsNotEqualTo(String value) {
            addCriterion("order_falgs <>", value, "orderFalgs");
            return (Criteria) this;
        }

        public Criteria andOrderFalgsGreaterThan(String value) {
            addCriterion("order_falgs >", value, "orderFalgs");
            return (Criteria) this;
        }

        public Criteria andOrderFalgsGreaterThanOrEqualTo(String value) {
            addCriterion("order_falgs >=", value, "orderFalgs");
            return (Criteria) this;
        }

        public Criteria andOrderFalgsLessThan(String value) {
            addCriterion("order_falgs <", value, "orderFalgs");
            return (Criteria) this;
        }

        public Criteria andOrderFalgsLessThanOrEqualTo(String value) {
            addCriterion("order_falgs <=", value, "orderFalgs");
            return (Criteria) this;
        }

        public Criteria andOrderFalgsLike(String value) {
            addCriterion("order_falgs like", value, "orderFalgs");
            return (Criteria) this;
        }

        public Criteria andOrderFalgsNotLike(String value) {
            addCriterion("order_falgs not like", value, "orderFalgs");
            return (Criteria) this;
        }

        public Criteria andOrderFalgsIn(List<String> values) {
            addCriterion("order_falgs in", values, "orderFalgs");
            return (Criteria) this;
        }

        public Criteria andOrderFalgsNotIn(List<String> values) {
            addCriterion("order_falgs not in", values, "orderFalgs");
            return (Criteria) this;
        }

        public Criteria andOrderFalgsBetween(String value1, String value2) {
            addCriterion("order_falgs between", value1, value2, "orderFalgs");
            return (Criteria) this;
        }

        public Criteria andOrderFalgsNotBetween(String value1, String value2) {
            addCriterion("order_falgs not between", value1, value2, "orderFalgs");
            return (Criteria) this;
        }

        public Criteria andOrderBackupIsNull() {
            addCriterion("order_backup is null");
            return (Criteria) this;
        }

        public Criteria andOrderBackupIsNotNull() {
            addCriterion("order_backup is not null");
            return (Criteria) this;
        }

        public Criteria andOrderBackupEqualTo(String value) {
            addCriterion("order_backup =", value, "orderBackup");
            return (Criteria) this;
        }

        public Criteria andOrderBackupNotEqualTo(String value) {
            addCriterion("order_backup <>", value, "orderBackup");
            return (Criteria) this;
        }

        public Criteria andOrderBackupGreaterThan(String value) {
            addCriterion("order_backup >", value, "orderBackup");
            return (Criteria) this;
        }

        public Criteria andOrderBackupGreaterThanOrEqualTo(String value) {
            addCriterion("order_backup >=", value, "orderBackup");
            return (Criteria) this;
        }

        public Criteria andOrderBackupLessThan(String value) {
            addCriterion("order_backup <", value, "orderBackup");
            return (Criteria) this;
        }

        public Criteria andOrderBackupLessThanOrEqualTo(String value) {
            addCriterion("order_backup <=", value, "orderBackup");
            return (Criteria) this;
        }

        public Criteria andOrderBackupLike(String value) {
            addCriterion("order_backup like", value, "orderBackup");
            return (Criteria) this;
        }

        public Criteria andOrderBackupNotLike(String value) {
            addCriterion("order_backup not like", value, "orderBackup");
            return (Criteria) this;
        }

        public Criteria andOrderBackupIn(List<String> values) {
            addCriterion("order_backup in", values, "orderBackup");
            return (Criteria) this;
        }

        public Criteria andOrderBackupNotIn(List<String> values) {
            addCriterion("order_backup not in", values, "orderBackup");
            return (Criteria) this;
        }

        public Criteria andOrderBackupBetween(String value1, String value2) {
            addCriterion("order_backup between", value1, value2, "orderBackup");
            return (Criteria) this;
        }

        public Criteria andOrderBackupNotBetween(String value1, String value2) {
            addCriterion("order_backup not between", value1, value2, "orderBackup");
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