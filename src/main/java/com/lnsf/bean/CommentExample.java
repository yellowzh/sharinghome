package com.lnsf.bean;

import java.util.ArrayList;
import java.util.List;

public class CommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommentExample() {
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

        public Criteria andTidIsNull() {
            addCriterion("tid is null");
            return (Criteria) this;
        }

        public Criteria andTidIsNotNull() {
            addCriterion("tid is not null");
            return (Criteria) this;
        }

        public Criteria andTidEqualTo(Integer value) {
            addCriterion("tid =", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotEqualTo(Integer value) {
            addCriterion("tid <>", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThan(Integer value) {
            addCriterion("tid >", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThanOrEqualTo(Integer value) {
            addCriterion("tid >=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThan(Integer value) {
            addCriterion("tid <", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThanOrEqualTo(Integer value) {
            addCriterion("tid <=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidIn(List<Integer> values) {
            addCriterion("tid in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotIn(List<Integer> values) {
            addCriterion("tid not in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidBetween(Integer value1, Integer value2) {
            addCriterion("tid between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotBetween(Integer value1, Integer value2) {
            addCriterion("tid not between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andTopicIdIsNull() {
            addCriterion("topic_id is null");
            return (Criteria) this;
        }

        public Criteria andTopicIdIsNotNull() {
            addCriterion("topic_id is not null");
            return (Criteria) this;
        }

        public Criteria andTopicIdEqualTo(Integer value) {
            addCriterion("topic_id =", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdNotEqualTo(Integer value) {
            addCriterion("topic_id <>", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdGreaterThan(Integer value) {
            addCriterion("topic_id >", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("topic_id >=", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdLessThan(Integer value) {
            addCriterion("topic_id <", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdLessThanOrEqualTo(Integer value) {
            addCriterion("topic_id <=", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdIn(List<Integer> values) {
            addCriterion("topic_id in", values, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdNotIn(List<Integer> values) {
            addCriterion("topic_id not in", values, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdBetween(Integer value1, Integer value2) {
            addCriterion("topic_id between", value1, value2, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdNotBetween(Integer value1, Integer value2) {
            addCriterion("topic_id not between", value1, value2, "topicId");
            return (Criteria) this;
        }

        public Criteria andComContentIsNull() {
            addCriterion("com_content is null");
            return (Criteria) this;
        }

        public Criteria andComContentIsNotNull() {
            addCriterion("com_content is not null");
            return (Criteria) this;
        }

        public Criteria andComContentEqualTo(String value) {
            addCriterion("com_content =", value, "comContent");
            return (Criteria) this;
        }

        public Criteria andComContentNotEqualTo(String value) {
            addCriterion("com_content <>", value, "comContent");
            return (Criteria) this;
        }

        public Criteria andComContentGreaterThan(String value) {
            addCriterion("com_content >", value, "comContent");
            return (Criteria) this;
        }

        public Criteria andComContentGreaterThanOrEqualTo(String value) {
            addCriterion("com_content >=", value, "comContent");
            return (Criteria) this;
        }

        public Criteria andComContentLessThan(String value) {
            addCriterion("com_content <", value, "comContent");
            return (Criteria) this;
        }

        public Criteria andComContentLessThanOrEqualTo(String value) {
            addCriterion("com_content <=", value, "comContent");
            return (Criteria) this;
        }

        public Criteria andComContentLike(String value) {
            addCriterion("com_content like", value, "comContent");
            return (Criteria) this;
        }

        public Criteria andComContentNotLike(String value) {
            addCriterion("com_content not like", value, "comContent");
            return (Criteria) this;
        }

        public Criteria andComContentIn(List<String> values) {
            addCriterion("com_content in", values, "comContent");
            return (Criteria) this;
        }

        public Criteria andComContentNotIn(List<String> values) {
            addCriterion("com_content not in", values, "comContent");
            return (Criteria) this;
        }

        public Criteria andComContentBetween(String value1, String value2) {
            addCriterion("com_content between", value1, value2, "comContent");
            return (Criteria) this;
        }

        public Criteria andComContentNotBetween(String value1, String value2) {
            addCriterion("com_content not between", value1, value2, "comContent");
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

        public Criteria andTphotoIsNull() {
            addCriterion("tphoto is null");
            return (Criteria) this;
        }

        public Criteria andTphotoIsNotNull() {
            addCriterion("tphoto is not null");
            return (Criteria) this;
        }

        public Criteria andTphotoEqualTo(String value) {
            addCriterion("tphoto =", value, "tphoto");
            return (Criteria) this;
        }

        public Criteria andTphotoNotEqualTo(String value) {
            addCriterion("tphoto <>", value, "tphoto");
            return (Criteria) this;
        }

        public Criteria andTphotoGreaterThan(String value) {
            addCriterion("tphoto >", value, "tphoto");
            return (Criteria) this;
        }

        public Criteria andTphotoGreaterThanOrEqualTo(String value) {
            addCriterion("tphoto >=", value, "tphoto");
            return (Criteria) this;
        }

        public Criteria andTphotoLessThan(String value) {
            addCriterion("tphoto <", value, "tphoto");
            return (Criteria) this;
        }

        public Criteria andTphotoLessThanOrEqualTo(String value) {
            addCriterion("tphoto <=", value, "tphoto");
            return (Criteria) this;
        }

        public Criteria andTphotoLike(String value) {
            addCriterion("tphoto like", value, "tphoto");
            return (Criteria) this;
        }

        public Criteria andTphotoNotLike(String value) {
            addCriterion("tphoto not like", value, "tphoto");
            return (Criteria) this;
        }

        public Criteria andTphotoIn(List<String> values) {
            addCriterion("tphoto in", values, "tphoto");
            return (Criteria) this;
        }

        public Criteria andTphotoNotIn(List<String> values) {
            addCriterion("tphoto not in", values, "tphoto");
            return (Criteria) this;
        }

        public Criteria andTphotoBetween(String value1, String value2) {
            addCriterion("tphoto between", value1, value2, "tphoto");
            return (Criteria) this;
        }

        public Criteria andTphotoNotBetween(String value1, String value2) {
            addCriterion("tphoto not between", value1, value2, "tphoto");
            return (Criteria) this;
        }

        public Criteria andTpowerIsNull() {
            addCriterion("tpower is null");
            return (Criteria) this;
        }

        public Criteria andTpowerIsNotNull() {
            addCriterion("tpower is not null");
            return (Criteria) this;
        }

        public Criteria andTpowerEqualTo(String value) {
            addCriterion("tpower =", value, "tpower");
            return (Criteria) this;
        }

        public Criteria andTpowerNotEqualTo(String value) {
            addCriterion("tpower <>", value, "tpower");
            return (Criteria) this;
        }

        public Criteria andTpowerGreaterThan(String value) {
            addCriterion("tpower >", value, "tpower");
            return (Criteria) this;
        }

        public Criteria andTpowerGreaterThanOrEqualTo(String value) {
            addCriterion("tpower >=", value, "tpower");
            return (Criteria) this;
        }

        public Criteria andTpowerLessThan(String value) {
            addCriterion("tpower <", value, "tpower");
            return (Criteria) this;
        }

        public Criteria andTpowerLessThanOrEqualTo(String value) {
            addCriterion("tpower <=", value, "tpower");
            return (Criteria) this;
        }

        public Criteria andTpowerLike(String value) {
            addCriterion("tpower like", value, "tpower");
            return (Criteria) this;
        }

        public Criteria andTpowerNotLike(String value) {
            addCriterion("tpower not like", value, "tpower");
            return (Criteria) this;
        }

        public Criteria andTpowerIn(List<String> values) {
            addCriterion("tpower in", values, "tpower");
            return (Criteria) this;
        }

        public Criteria andTpowerNotIn(List<String> values) {
            addCriterion("tpower not in", values, "tpower");
            return (Criteria) this;
        }

        public Criteria andTpowerBetween(String value1, String value2) {
            addCriterion("tpower between", value1, value2, "tpower");
            return (Criteria) this;
        }

        public Criteria andTpowerNotBetween(String value1, String value2) {
            addCriterion("tpower not between", value1, value2, "tpower");
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