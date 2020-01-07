package com.lnsf.bean;

import java.util.ArrayList;
import java.util.List;

public class HousesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HousesExample() {
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

        public Criteria andHousesPhotoIsNull() {
            addCriterion("houses_photo is null");
            return (Criteria) this;
        }

        public Criteria andHousesPhotoIsNotNull() {
            addCriterion("houses_photo is not null");
            return (Criteria) this;
        }

        public Criteria andHousesPhotoEqualTo(String value) {
            addCriterion("houses_photo =", value, "housesPhoto");
            return (Criteria) this;
        }

        public Criteria andHousesPhotoNotEqualTo(String value) {
            addCriterion("houses_photo <>", value, "housesPhoto");
            return (Criteria) this;
        }

        public Criteria andHousesPhotoGreaterThan(String value) {
            addCriterion("houses_photo >", value, "housesPhoto");
            return (Criteria) this;
        }

        public Criteria andHousesPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("houses_photo >=", value, "housesPhoto");
            return (Criteria) this;
        }

        public Criteria andHousesPhotoLessThan(String value) {
            addCriterion("houses_photo <", value, "housesPhoto");
            return (Criteria) this;
        }

        public Criteria andHousesPhotoLessThanOrEqualTo(String value) {
            addCriterion("houses_photo <=", value, "housesPhoto");
            return (Criteria) this;
        }

        public Criteria andHousesPhotoLike(String value) {
            addCriterion("houses_photo like", value, "housesPhoto");
            return (Criteria) this;
        }

        public Criteria andHousesPhotoNotLike(String value) {
            addCriterion("houses_photo not like", value, "housesPhoto");
            return (Criteria) this;
        }

        public Criteria andHousesPhotoIn(List<String> values) {
            addCriterion("houses_photo in", values, "housesPhoto");
            return (Criteria) this;
        }

        public Criteria andHousesPhotoNotIn(List<String> values) {
            addCriterion("houses_photo not in", values, "housesPhoto");
            return (Criteria) this;
        }

        public Criteria andHousesPhotoBetween(String value1, String value2) {
            addCriterion("houses_photo between", value1, value2, "housesPhoto");
            return (Criteria) this;
        }

        public Criteria andHousesPhotoNotBetween(String value1, String value2) {
            addCriterion("houses_photo not between", value1, value2, "housesPhoto");
            return (Criteria) this;
        }

        public Criteria andHousesTitleIsNull() {
            addCriterion("houses_title is null");
            return (Criteria) this;
        }

        public Criteria andHousesTitleIsNotNull() {
            addCriterion("houses_title is not null");
            return (Criteria) this;
        }

        public Criteria andHousesTitleEqualTo(String value) {
            addCriterion("houses_title =", value, "housesTitle");
            return (Criteria) this;
        }

        public Criteria andHousesTitleNotEqualTo(String value) {
            addCriterion("houses_title <>", value, "housesTitle");
            return (Criteria) this;
        }

        public Criteria andHousesTitleGreaterThan(String value) {
            addCriterion("houses_title >", value, "housesTitle");
            return (Criteria) this;
        }

        public Criteria andHousesTitleGreaterThanOrEqualTo(String value) {
            addCriterion("houses_title >=", value, "housesTitle");
            return (Criteria) this;
        }

        public Criteria andHousesTitleLessThan(String value) {
            addCriterion("houses_title <", value, "housesTitle");
            return (Criteria) this;
        }

        public Criteria andHousesTitleLessThanOrEqualTo(String value) {
            addCriterion("houses_title <=", value, "housesTitle");
            return (Criteria) this;
        }

        public Criteria andHousesTitleLike(String value) {
            addCriterion("houses_title like", value, "housesTitle");
            return (Criteria) this;
        }

        public Criteria andHousesTitleNotLike(String value) {
            addCriterion("houses_title not like", value, "housesTitle");
            return (Criteria) this;
        }

        public Criteria andHousesTitleIn(List<String> values) {
            addCriterion("houses_title in", values, "housesTitle");
            return (Criteria) this;
        }

        public Criteria andHousesTitleNotIn(List<String> values) {
            addCriterion("houses_title not in", values, "housesTitle");
            return (Criteria) this;
        }

        public Criteria andHousesTitleBetween(String value1, String value2) {
            addCriterion("houses_title between", value1, value2, "housesTitle");
            return (Criteria) this;
        }

        public Criteria andHousesTitleNotBetween(String value1, String value2) {
            addCriterion("houses_title not between", value1, value2, "housesTitle");
            return (Criteria) this;
        }

        public Criteria andHousesCountIsNull() {
            addCriterion("houses_count is null");
            return (Criteria) this;
        }

        public Criteria andHousesCountIsNotNull() {
            addCriterion("houses_count is not null");
            return (Criteria) this;
        }

        public Criteria andHousesCountEqualTo(Integer value) {
            addCriterion("houses_count =", value, "housesCount");
            return (Criteria) this;
        }

        public Criteria andHousesCountNotEqualTo(Integer value) {
            addCriterion("houses_count <>", value, "housesCount");
            return (Criteria) this;
        }

        public Criteria andHousesCountGreaterThan(Integer value) {
            addCriterion("houses_count >", value, "housesCount");
            return (Criteria) this;
        }

        public Criteria andHousesCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("houses_count >=", value, "housesCount");
            return (Criteria) this;
        }

        public Criteria andHousesCountLessThan(Integer value) {
            addCriterion("houses_count <", value, "housesCount");
            return (Criteria) this;
        }

        public Criteria andHousesCountLessThanOrEqualTo(Integer value) {
            addCriterion("houses_count <=", value, "housesCount");
            return (Criteria) this;
        }

        public Criteria andHousesCountIn(List<Integer> values) {
            addCriterion("houses_count in", values, "housesCount");
            return (Criteria) this;
        }

        public Criteria andHousesCountNotIn(List<Integer> values) {
            addCriterion("houses_count not in", values, "housesCount");
            return (Criteria) this;
        }

        public Criteria andHousesCountBetween(Integer value1, Integer value2) {
            addCriterion("houses_count between", value1, value2, "housesCount");
            return (Criteria) this;
        }

        public Criteria andHousesCountNotBetween(Integer value1, Integer value2) {
            addCriterion("houses_count not between", value1, value2, "housesCount");
            return (Criteria) this;
        }

        public Criteria andHousesFocusIsNull() {
            addCriterion("houses_focus is null");
            return (Criteria) this;
        }

        public Criteria andHousesFocusIsNotNull() {
            addCriterion("houses_focus is not null");
            return (Criteria) this;
        }

        public Criteria andHousesFocusEqualTo(Integer value) {
            addCriterion("houses_focus =", value, "housesFocus");
            return (Criteria) this;
        }

        public Criteria andHousesFocusNotEqualTo(Integer value) {
            addCriterion("houses_focus <>", value, "housesFocus");
            return (Criteria) this;
        }

        public Criteria andHousesFocusGreaterThan(Integer value) {
            addCriterion("houses_focus >", value, "housesFocus");
            return (Criteria) this;
        }

        public Criteria andHousesFocusGreaterThanOrEqualTo(Integer value) {
            addCriterion("houses_focus >=", value, "housesFocus");
            return (Criteria) this;
        }

        public Criteria andHousesFocusLessThan(Integer value) {
            addCriterion("houses_focus <", value, "housesFocus");
            return (Criteria) this;
        }

        public Criteria andHousesFocusLessThanOrEqualTo(Integer value) {
            addCriterion("houses_focus <=", value, "housesFocus");
            return (Criteria) this;
        }

        public Criteria andHousesFocusIn(List<Integer> values) {
            addCriterion("houses_focus in", values, "housesFocus");
            return (Criteria) this;
        }

        public Criteria andHousesFocusNotIn(List<Integer> values) {
            addCriterion("houses_focus not in", values, "housesFocus");
            return (Criteria) this;
        }

        public Criteria andHousesFocusBetween(Integer value1, Integer value2) {
            addCriterion("houses_focus between", value1, value2, "housesFocus");
            return (Criteria) this;
        }

        public Criteria andHousesFocusNotBetween(Integer value1, Integer value2) {
            addCriterion("houses_focus not between", value1, value2, "housesFocus");
            return (Criteria) this;
        }

        public Criteria andHousesViewIsNull() {
            addCriterion("houses_view is null");
            return (Criteria) this;
        }

        public Criteria andHousesViewIsNotNull() {
            addCriterion("houses_view is not null");
            return (Criteria) this;
        }

        public Criteria andHousesViewEqualTo(Integer value) {
            addCriterion("houses_view =", value, "housesView");
            return (Criteria) this;
        }

        public Criteria andHousesViewNotEqualTo(Integer value) {
            addCriterion("houses_view <>", value, "housesView");
            return (Criteria) this;
        }

        public Criteria andHousesViewGreaterThan(Integer value) {
            addCriterion("houses_view >", value, "housesView");
            return (Criteria) this;
        }

        public Criteria andHousesViewGreaterThanOrEqualTo(Integer value) {
            addCriterion("houses_view >=", value, "housesView");
            return (Criteria) this;
        }

        public Criteria andHousesViewLessThan(Integer value) {
            addCriterion("houses_view <", value, "housesView");
            return (Criteria) this;
        }

        public Criteria andHousesViewLessThanOrEqualTo(Integer value) {
            addCriterion("houses_view <=", value, "housesView");
            return (Criteria) this;
        }

        public Criteria andHousesViewIn(List<Integer> values) {
            addCriterion("houses_view in", values, "housesView");
            return (Criteria) this;
        }

        public Criteria andHousesViewNotIn(List<Integer> values) {
            addCriterion("houses_view not in", values, "housesView");
            return (Criteria) this;
        }

        public Criteria andHousesViewBetween(Integer value1, Integer value2) {
            addCriterion("houses_view between", value1, value2, "housesView");
            return (Criteria) this;
        }

        public Criteria andHousesViewNotBetween(Integer value1, Integer value2) {
            addCriterion("houses_view not between", value1, value2, "housesView");
            return (Criteria) this;
        }

        public Criteria andHousesPricesIsNull() {
            addCriterion("houses_prices is null");
            return (Criteria) this;
        }

        public Criteria andHousesPricesIsNotNull() {
            addCriterion("houses_prices is not null");
            return (Criteria) this;
        }

        public Criteria andHousesPricesEqualTo(Integer value) {
            addCriterion("houses_prices =", value, "housesPrices");
            return (Criteria) this;
        }

        public Criteria andHousesPricesNotEqualTo(Integer value) {
            addCriterion("houses_prices <>", value, "housesPrices");
            return (Criteria) this;
        }

        public Criteria andHousesPricesGreaterThan(Integer value) {
            addCriterion("houses_prices >", value, "housesPrices");
            return (Criteria) this;
        }

        public Criteria andHousesPricesGreaterThanOrEqualTo(Integer value) {
            addCriterion("houses_prices >=", value, "housesPrices");
            return (Criteria) this;
        }

        public Criteria andHousesPricesLessThan(Integer value) {
            addCriterion("houses_prices <", value, "housesPrices");
            return (Criteria) this;
        }

        public Criteria andHousesPricesLessThanOrEqualTo(Integer value) {
            addCriterion("houses_prices <=", value, "housesPrices");
            return (Criteria) this;
        }

        public Criteria andHousesPricesIn(List<Integer> values) {
            addCriterion("houses_prices in", values, "housesPrices");
            return (Criteria) this;
        }

        public Criteria andHousesPricesNotIn(List<Integer> values) {
            addCriterion("houses_prices not in", values, "housesPrices");
            return (Criteria) this;
        }

        public Criteria andHousesPricesBetween(Integer value1, Integer value2) {
            addCriterion("houses_prices between", value1, value2, "housesPrices");
            return (Criteria) this;
        }

        public Criteria andHousesPricesNotBetween(Integer value1, Integer value2) {
            addCriterion("houses_prices not between", value1, value2, "housesPrices");
            return (Criteria) this;
        }

        public Criteria andHousesAddressIsNull() {
            addCriterion("houses_address is null");
            return (Criteria) this;
        }

        public Criteria andHousesAddressIsNotNull() {
            addCriterion("houses_address is not null");
            return (Criteria) this;
        }

        public Criteria andHousesAddressEqualTo(String value) {
            addCriterion("houses_address =", value, "housesAddress");
            return (Criteria) this;
        }

        public Criteria andHousesAddressNotEqualTo(String value) {
            addCriterion("houses_address <>", value, "housesAddress");
            return (Criteria) this;
        }

        public Criteria andHousesAddressGreaterThan(String value) {
            addCriterion("houses_address >", value, "housesAddress");
            return (Criteria) this;
        }

        public Criteria andHousesAddressGreaterThanOrEqualTo(String value) {
            addCriterion("houses_address >=", value, "housesAddress");
            return (Criteria) this;
        }

        public Criteria andHousesAddressLessThan(String value) {
            addCriterion("houses_address <", value, "housesAddress");
            return (Criteria) this;
        }

        public Criteria andHousesAddressLessThanOrEqualTo(String value) {
            addCriterion("houses_address <=", value, "housesAddress");
            return (Criteria) this;
        }

        public Criteria andHousesAddressLike(String value) {
            addCriterion("houses_address like", value, "housesAddress");
            return (Criteria) this;
        }

        public Criteria andHousesAddressNotLike(String value) {
            addCriterion("houses_address not like", value, "housesAddress");
            return (Criteria) this;
        }

        public Criteria andHousesAddressIn(List<String> values) {
            addCriterion("houses_address in", values, "housesAddress");
            return (Criteria) this;
        }

        public Criteria andHousesAddressNotIn(List<String> values) {
            addCriterion("houses_address not in", values, "housesAddress");
            return (Criteria) this;
        }

        public Criteria andHousesAddressBetween(String value1, String value2) {
            addCriterion("houses_address between", value1, value2, "housesAddress");
            return (Criteria) this;
        }

        public Criteria andHousesAddressNotBetween(String value1, String value2) {
            addCriterion("houses_address not between", value1, value2, "housesAddress");
            return (Criteria) this;
        }

        public Criteria andHousesFalgsIsNull() {
            addCriterion("houses_falgs is null");
            return (Criteria) this;
        }

        public Criteria andHousesFalgsIsNotNull() {
            addCriterion("houses_falgs is not null");
            return (Criteria) this;
        }

        public Criteria andHousesFalgsEqualTo(String value) {
            addCriterion("houses_falgs =", value, "housesFalgs");
            return (Criteria) this;
        }

        public Criteria andHousesFalgsNotEqualTo(String value) {
            addCriterion("houses_falgs <>", value, "housesFalgs");
            return (Criteria) this;
        }

        public Criteria andHousesFalgsGreaterThan(String value) {
            addCriterion("houses_falgs >", value, "housesFalgs");
            return (Criteria) this;
        }

        public Criteria andHousesFalgsGreaterThanOrEqualTo(String value) {
            addCriterion("houses_falgs >=", value, "housesFalgs");
            return (Criteria) this;
        }

        public Criteria andHousesFalgsLessThan(String value) {
            addCriterion("houses_falgs <", value, "housesFalgs");
            return (Criteria) this;
        }

        public Criteria andHousesFalgsLessThanOrEqualTo(String value) {
            addCriterion("houses_falgs <=", value, "housesFalgs");
            return (Criteria) this;
        }

        public Criteria andHousesFalgsLike(String value) {
            addCriterion("houses_falgs like", value, "housesFalgs");
            return (Criteria) this;
        }

        public Criteria andHousesFalgsNotLike(String value) {
            addCriterion("houses_falgs not like", value, "housesFalgs");
            return (Criteria) this;
        }

        public Criteria andHousesFalgsIn(List<String> values) {
            addCriterion("houses_falgs in", values, "housesFalgs");
            return (Criteria) this;
        }

        public Criteria andHousesFalgsNotIn(List<String> values) {
            addCriterion("houses_falgs not in", values, "housesFalgs");
            return (Criteria) this;
        }

        public Criteria andHousesFalgsBetween(String value1, String value2) {
            addCriterion("houses_falgs between", value1, value2, "housesFalgs");
            return (Criteria) this;
        }

        public Criteria andHousesFalgsNotBetween(String value1, String value2) {
            addCriterion("houses_falgs not between", value1, value2, "housesFalgs");
            return (Criteria) this;
        }

        public Criteria andHousesBackupIsNull() {
            addCriterion("houses_backup is null");
            return (Criteria) this;
        }

        public Criteria andHousesBackupIsNotNull() {
            addCriterion("houses_backup is not null");
            return (Criteria) this;
        }

        public Criteria andHousesBackupEqualTo(String value) {
            addCriterion("houses_backup =", value, "housesBackup");
            return (Criteria) this;
        }

        public Criteria andHousesBackupNotEqualTo(String value) {
            addCriterion("houses_backup <>", value, "housesBackup");
            return (Criteria) this;
        }

        public Criteria andHousesBackupGreaterThan(String value) {
            addCriterion("houses_backup >", value, "housesBackup");
            return (Criteria) this;
        }

        public Criteria andHousesBackupGreaterThanOrEqualTo(String value) {
            addCriterion("houses_backup >=", value, "housesBackup");
            return (Criteria) this;
        }

        public Criteria andHousesBackupLessThan(String value) {
            addCriterion("houses_backup <", value, "housesBackup");
            return (Criteria) this;
        }

        public Criteria andHousesBackupLessThanOrEqualTo(String value) {
            addCriterion("houses_backup <=", value, "housesBackup");
            return (Criteria) this;
        }

        public Criteria andHousesBackupLike(String value) {
            addCriterion("houses_backup like", value, "housesBackup");
            return (Criteria) this;
        }

        public Criteria andHousesBackupNotLike(String value) {
            addCriterion("houses_backup not like", value, "housesBackup");
            return (Criteria) this;
        }

        public Criteria andHousesBackupIn(List<String> values) {
            addCriterion("houses_backup in", values, "housesBackup");
            return (Criteria) this;
        }

        public Criteria andHousesBackupNotIn(List<String> values) {
            addCriterion("houses_backup not in", values, "housesBackup");
            return (Criteria) this;
        }

        public Criteria andHousesBackupBetween(String value1, String value2) {
            addCriterion("houses_backup between", value1, value2, "housesBackup");
            return (Criteria) this;
        }

        public Criteria andHousesBackupNotBetween(String value1, String value2) {
            addCriterion("houses_backup not between", value1, value2, "housesBackup");
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