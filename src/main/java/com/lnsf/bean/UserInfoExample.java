package com.lnsf.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class UserInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserInfoExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
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

        public Criteria andRealNameIsNull() {
            addCriterion("real_name is null");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNotNull() {
            addCriterion("real_name is not null");
            return (Criteria) this;
        }

        public Criteria andRealNameEqualTo(String value) {
            addCriterion("real_name =", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotEqualTo(String value) {
            addCriterion("real_name <>", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThan(String value) {
            addCriterion("real_name >", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThanOrEqualTo(String value) {
            addCriterion("real_name >=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThan(String value) {
            addCriterion("real_name <", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThanOrEqualTo(String value) {
            addCriterion("real_name <=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLike(String value) {
            addCriterion("real_name like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotLike(String value) {
            addCriterion("real_name not like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameIn(List<String> values) {
            addCriterion("real_name in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotIn(List<String> values) {
            addCriterion("real_name not in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameBetween(String value1, String value2) {
            addCriterion("real_name between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotBetween(String value1, String value2) {
            addCriterion("real_name not between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andUserTelIsNull() {
            addCriterion("user_tel is null");
            return (Criteria) this;
        }

        public Criteria andUserTelIsNotNull() {
            addCriterion("user_tel is not null");
            return (Criteria) this;
        }

        public Criteria andUserTelEqualTo(String value) {
            addCriterion("user_tel =", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelNotEqualTo(String value) {
            addCriterion("user_tel <>", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelGreaterThan(String value) {
            addCriterion("user_tel >", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelGreaterThanOrEqualTo(String value) {
            addCriterion("user_tel >=", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelLessThan(String value) {
            addCriterion("user_tel <", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelLessThanOrEqualTo(String value) {
            addCriterion("user_tel <=", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelLike(String value) {
            addCriterion("user_tel like", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelNotLike(String value) {
            addCriterion("user_tel not like", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelIn(List<String> values) {
            addCriterion("user_tel in", values, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelNotIn(List<String> values) {
            addCriterion("user_tel not in", values, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelBetween(String value1, String value2) {
            addCriterion("user_tel between", value1, value2, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelNotBetween(String value1, String value2) {
            addCriterion("user_tel not between", value1, value2, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserEmilIsNull() {
            addCriterion("user_emil is null");
            return (Criteria) this;
        }

        public Criteria andUserEmilIsNotNull() {
            addCriterion("user_emil is not null");
            return (Criteria) this;
        }

        public Criteria andUserEmilEqualTo(String value) {
            addCriterion("user_emil =", value, "userEmil");
            return (Criteria) this;
        }

        public Criteria andUserEmilNotEqualTo(String value) {
            addCriterion("user_emil <>", value, "userEmil");
            return (Criteria) this;
        }

        public Criteria andUserEmilGreaterThan(String value) {
            addCriterion("user_emil >", value, "userEmil");
            return (Criteria) this;
        }

        public Criteria andUserEmilGreaterThanOrEqualTo(String value) {
            addCriterion("user_emil >=", value, "userEmil");
            return (Criteria) this;
        }

        public Criteria andUserEmilLessThan(String value) {
            addCriterion("user_emil <", value, "userEmil");
            return (Criteria) this;
        }

        public Criteria andUserEmilLessThanOrEqualTo(String value) {
            addCriterion("user_emil <=", value, "userEmil");
            return (Criteria) this;
        }

        public Criteria andUserEmilLike(String value) {
            addCriterion("user_emil like", value, "userEmil");
            return (Criteria) this;
        }

        public Criteria andUserEmilNotLike(String value) {
            addCriterion("user_emil not like", value, "userEmil");
            return (Criteria) this;
        }

        public Criteria andUserEmilIn(List<String> values) {
            addCriterion("user_emil in", values, "userEmil");
            return (Criteria) this;
        }

        public Criteria andUserEmilNotIn(List<String> values) {
            addCriterion("user_emil not in", values, "userEmil");
            return (Criteria) this;
        }

        public Criteria andUserEmilBetween(String value1, String value2) {
            addCriterion("user_emil between", value1, value2, "userEmil");
            return (Criteria) this;
        }

        public Criteria andUserEmilNotBetween(String value1, String value2) {
            addCriterion("user_emil not between", value1, value2, "userEmil");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andUserPowerIsNull() {
            addCriterion("user_power is null");
            return (Criteria) this;
        }

        public Criteria andUserPowerIsNotNull() {
            addCriterion("user_power is not null");
            return (Criteria) this;
        }

        public Criteria andUserPowerEqualTo(String value) {
            addCriterion("user_power =", value, "userPower");
            return (Criteria) this;
        }

        public Criteria andUserPowerNotEqualTo(String value) {
            addCriterion("user_power <>", value, "userPower");
            return (Criteria) this;
        }

        public Criteria andUserPowerGreaterThan(String value) {
            addCriterion("user_power >", value, "userPower");
            return (Criteria) this;
        }

        public Criteria andUserPowerGreaterThanOrEqualTo(String value) {
            addCriterion("user_power >=", value, "userPower");
            return (Criteria) this;
        }

        public Criteria andUserPowerLessThan(String value) {
            addCriterion("user_power <", value, "userPower");
            return (Criteria) this;
        }

        public Criteria andUserPowerLessThanOrEqualTo(String value) {
            addCriterion("user_power <=", value, "userPower");
            return (Criteria) this;
        }

        public Criteria andUserPowerLike(String value) {
            addCriterion("user_power like", value, "userPower");
            return (Criteria) this;
        }

        public Criteria andUserPowerNotLike(String value) {
            addCriterion("user_power not like", value, "userPower");
            return (Criteria) this;
        }

        public Criteria andUserPowerIn(List<String> values) {
            addCriterion("user_power in", values, "userPower");
            return (Criteria) this;
        }

        public Criteria andUserPowerNotIn(List<String> values) {
            addCriterion("user_power not in", values, "userPower");
            return (Criteria) this;
        }

        public Criteria andUserPowerBetween(String value1, String value2) {
            addCriterion("user_power between", value1, value2, "userPower");
            return (Criteria) this;
        }

        public Criteria andUserPowerNotBetween(String value1, String value2) {
            addCriterion("user_power not between", value1, value2, "userPower");
            return (Criteria) this;
        }

        public Criteria andUserStatusIsNull() {
            addCriterion("user_status is null");
            return (Criteria) this;
        }

        public Criteria andUserStatusIsNotNull() {
            addCriterion("user_status is not null");
            return (Criteria) this;
        }

        public Criteria andUserStatusEqualTo(String value) {
            addCriterion("user_status =", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusNotEqualTo(String value) {
            addCriterion("user_status <>", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusGreaterThan(String value) {
            addCriterion("user_status >", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusGreaterThanOrEqualTo(String value) {
            addCriterion("user_status >=", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusLessThan(String value) {
            addCriterion("user_status <", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusLessThanOrEqualTo(String value) {
            addCriterion("user_status <=", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusLike(String value) {
            addCriterion("user_status like", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusNotLike(String value) {
            addCriterion("user_status not like", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusIn(List<String> values) {
            addCriterion("user_status in", values, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusNotIn(List<String> values) {
            addCriterion("user_status not in", values, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusBetween(String value1, String value2) {
            addCriterion("user_status between", value1, value2, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusNotBetween(String value1, String value2) {
            addCriterion("user_status not between", value1, value2, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserLogintimeIsNull() {
            addCriterion("user_logintime is null");
            return (Criteria) this;
        }

        public Criteria andUserLogintimeIsNotNull() {
            addCriterion("user_logintime is not null");
            return (Criteria) this;
        }

        public Criteria andUserLogintimeEqualTo(Date value) {
            addCriterionForJDBCDate("user_logintime =", value, "userLogintime");
            return (Criteria) this;
        }

        public Criteria andUserLogintimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("user_logintime <>", value, "userLogintime");
            return (Criteria) this;
        }

        public Criteria andUserLogintimeGreaterThan(Date value) {
            addCriterionForJDBCDate("user_logintime >", value, "userLogintime");
            return (Criteria) this;
        }

        public Criteria andUserLogintimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("user_logintime >=", value, "userLogintime");
            return (Criteria) this;
        }

        public Criteria andUserLogintimeLessThan(Date value) {
            addCriterionForJDBCDate("user_logintime <", value, "userLogintime");
            return (Criteria) this;
        }

        public Criteria andUserLogintimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("user_logintime <=", value, "userLogintime");
            return (Criteria) this;
        }

        public Criteria andUserLogintimeIn(List<Date> values) {
            addCriterionForJDBCDate("user_logintime in", values, "userLogintime");
            return (Criteria) this;
        }

        public Criteria andUserLogintimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("user_logintime not in", values, "userLogintime");
            return (Criteria) this;
        }

        public Criteria andUserLogintimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("user_logintime between", value1, value2, "userLogintime");
            return (Criteria) this;
        }

        public Criteria andUserLogintimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("user_logintime not between", value1, value2, "userLogintime");
            return (Criteria) this;
        }

        public Criteria andUserLoginouttimeIsNull() {
            addCriterion("user_loginouttime is null");
            return (Criteria) this;
        }

        public Criteria andUserLoginouttimeIsNotNull() {
            addCriterion("user_loginouttime is not null");
            return (Criteria) this;
        }

        public Criteria andUserLoginouttimeEqualTo(Date value) {
            addCriterionForJDBCDate("user_loginouttime =", value, "userLoginouttime");
            return (Criteria) this;
        }

        public Criteria andUserLoginouttimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("user_loginouttime <>", value, "userLoginouttime");
            return (Criteria) this;
        }

        public Criteria andUserLoginouttimeGreaterThan(Date value) {
            addCriterionForJDBCDate("user_loginouttime >", value, "userLoginouttime");
            return (Criteria) this;
        }

        public Criteria andUserLoginouttimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("user_loginouttime >=", value, "userLoginouttime");
            return (Criteria) this;
        }

        public Criteria andUserLoginouttimeLessThan(Date value) {
            addCriterionForJDBCDate("user_loginouttime <", value, "userLoginouttime");
            return (Criteria) this;
        }

        public Criteria andUserLoginouttimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("user_loginouttime <=", value, "userLoginouttime");
            return (Criteria) this;
        }

        public Criteria andUserLoginouttimeIn(List<Date> values) {
            addCriterionForJDBCDate("user_loginouttime in", values, "userLoginouttime");
            return (Criteria) this;
        }

        public Criteria andUserLoginouttimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("user_loginouttime not in", values, "userLoginouttime");
            return (Criteria) this;
        }

        public Criteria andUserLoginouttimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("user_loginouttime between", value1, value2, "userLoginouttime");
            return (Criteria) this;
        }

        public Criteria andUserLoginouttimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("user_loginouttime not between", value1, value2, "userLoginouttime");
            return (Criteria) this;
        }

        public Criteria andUserNumIsNull() {
            addCriterion("user_num is null");
            return (Criteria) this;
        }

        public Criteria andUserNumIsNotNull() {
            addCriterion("user_num is not null");
            return (Criteria) this;
        }

        public Criteria andUserNumEqualTo(Integer value) {
            addCriterion("user_num =", value, "userNum");
            return (Criteria) this;
        }

        public Criteria andUserNumNotEqualTo(Integer value) {
            addCriterion("user_num <>", value, "userNum");
            return (Criteria) this;
        }

        public Criteria andUserNumGreaterThan(Integer value) {
            addCriterion("user_num >", value, "userNum");
            return (Criteria) this;
        }

        public Criteria andUserNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_num >=", value, "userNum");
            return (Criteria) this;
        }

        public Criteria andUserNumLessThan(Integer value) {
            addCriterion("user_num <", value, "userNum");
            return (Criteria) this;
        }

        public Criteria andUserNumLessThanOrEqualTo(Integer value) {
            addCriterion("user_num <=", value, "userNum");
            return (Criteria) this;
        }

        public Criteria andUserNumIn(List<Integer> values) {
            addCriterion("user_num in", values, "userNum");
            return (Criteria) this;
        }

        public Criteria andUserNumNotIn(List<Integer> values) {
            addCriterion("user_num not in", values, "userNum");
            return (Criteria) this;
        }

        public Criteria andUserNumBetween(Integer value1, Integer value2) {
            addCriterion("user_num between", value1, value2, "userNum");
            return (Criteria) this;
        }

        public Criteria andUserNumNotBetween(Integer value1, Integer value2) {
            addCriterion("user_num not between", value1, value2, "userNum");
            return (Criteria) this;
        }

        public Criteria andUserBackup1IsNull() {
            addCriterion("user_backup1 is null");
            return (Criteria) this;
        }

        public Criteria andUserBackup1IsNotNull() {
            addCriterion("user_backup1 is not null");
            return (Criteria) this;
        }

        public Criteria andUserBackup1EqualTo(String value) {
            addCriterion("user_backup1 =", value, "userBackup1");
            return (Criteria) this;
        }

        public Criteria andUserBackup1NotEqualTo(String value) {
            addCriterion("user_backup1 <>", value, "userBackup1");
            return (Criteria) this;
        }

        public Criteria andUserBackup1GreaterThan(String value) {
            addCriterion("user_backup1 >", value, "userBackup1");
            return (Criteria) this;
        }

        public Criteria andUserBackup1GreaterThanOrEqualTo(String value) {
            addCriterion("user_backup1 >=", value, "userBackup1");
            return (Criteria) this;
        }

        public Criteria andUserBackup1LessThan(String value) {
            addCriterion("user_backup1 <", value, "userBackup1");
            return (Criteria) this;
        }

        public Criteria andUserBackup1LessThanOrEqualTo(String value) {
            addCriterion("user_backup1 <=", value, "userBackup1");
            return (Criteria) this;
        }

        public Criteria andUserBackup1Like(String value) {
            addCriterion("user_backup1 like", value, "userBackup1");
            return (Criteria) this;
        }

        public Criteria andUserBackup1NotLike(String value) {
            addCriterion("user_backup1 not like", value, "userBackup1");
            return (Criteria) this;
        }

        public Criteria andUserBackup1In(List<String> values) {
            addCriterion("user_backup1 in", values, "userBackup1");
            return (Criteria) this;
        }

        public Criteria andUserBackup1NotIn(List<String> values) {
            addCriterion("user_backup1 not in", values, "userBackup1");
            return (Criteria) this;
        }

        public Criteria andUserBackup1Between(String value1, String value2) {
            addCriterion("user_backup1 between", value1, value2, "userBackup1");
            return (Criteria) this;
        }

        public Criteria andUserBackup1NotBetween(String value1, String value2) {
            addCriterion("user_backup1 not between", value1, value2, "userBackup1");
            return (Criteria) this;
        }

        public Criteria andUserBackup2IsNull() {
            addCriterion("user_backup2 is null");
            return (Criteria) this;
        }

        public Criteria andUserBackup2IsNotNull() {
            addCriterion("user_backup2 is not null");
            return (Criteria) this;
        }

        public Criteria andUserBackup2EqualTo(String value) {
            addCriterion("user_backup2 =", value, "userBackup2");
            return (Criteria) this;
        }

        public Criteria andUserBackup2NotEqualTo(String value) {
            addCriterion("user_backup2 <>", value, "userBackup2");
            return (Criteria) this;
        }

        public Criteria andUserBackup2GreaterThan(String value) {
            addCriterion("user_backup2 >", value, "userBackup2");
            return (Criteria) this;
        }

        public Criteria andUserBackup2GreaterThanOrEqualTo(String value) {
            addCriterion("user_backup2 >=", value, "userBackup2");
            return (Criteria) this;
        }

        public Criteria andUserBackup2LessThan(String value) {
            addCriterion("user_backup2 <", value, "userBackup2");
            return (Criteria) this;
        }

        public Criteria andUserBackup2LessThanOrEqualTo(String value) {
            addCriterion("user_backup2 <=", value, "userBackup2");
            return (Criteria) this;
        }

        public Criteria andUserBackup2Like(String value) {
            addCriterion("user_backup2 like", value, "userBackup2");
            return (Criteria) this;
        }

        public Criteria andUserBackup2NotLike(String value) {
            addCriterion("user_backup2 not like", value, "userBackup2");
            return (Criteria) this;
        }

        public Criteria andUserBackup2In(List<String> values) {
            addCriterion("user_backup2 in", values, "userBackup2");
            return (Criteria) this;
        }

        public Criteria andUserBackup2NotIn(List<String> values) {
            addCriterion("user_backup2 not in", values, "userBackup2");
            return (Criteria) this;
        }

        public Criteria andUserBackup2Between(String value1, String value2) {
            addCriterion("user_backup2 between", value1, value2, "userBackup2");
            return (Criteria) this;
        }

        public Criteria andUserBackup2NotBetween(String value1, String value2) {
            addCriterion("user_backup2 not between", value1, value2, "userBackup2");
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