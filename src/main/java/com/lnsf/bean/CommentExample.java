package com.lnsf.bean;

import java.util.ArrayList;
import java.util.Date;
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

        public Criteria andCommentIdIsNull() {
            addCriterion("comment_id is null");
            return (Criteria) this;
        }

        public Criteria andCommentIdIsNotNull() {
            addCriterion("comment_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommentIdEqualTo(Integer value) {
            addCriterion("comment_id =", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotEqualTo(Integer value) {
            addCriterion("comment_id <>", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThan(Integer value) {
            addCriterion("comment_id >", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_id >=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThan(Integer value) {
            addCriterion("comment_id <", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThanOrEqualTo(Integer value) {
            addCriterion("comment_id <=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdIn(List<Integer> values) {
            addCriterion("comment_id in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotIn(List<Integer> values) {
            addCriterion("comment_id not in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdBetween(Integer value1, Integer value2) {
            addCriterion("comment_id between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_id not between", value1, value2, "commentId");
            return (Criteria) this;
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

        public Criteria andCommentTypeIsNull() {
            addCriterion("comment_type is null");
            return (Criteria) this;
        }

        public Criteria andCommentTypeIsNotNull() {
            addCriterion("comment_type is not null");
            return (Criteria) this;
        }

        public Criteria andCommentTypeEqualTo(String value) {
            addCriterion("comment_type =", value, "commentType");
            return (Criteria) this;
        }

        public Criteria andCommentTypeNotEqualTo(String value) {
            addCriterion("comment_type <>", value, "commentType");
            return (Criteria) this;
        }

        public Criteria andCommentTypeGreaterThan(String value) {
            addCriterion("comment_type >", value, "commentType");
            return (Criteria) this;
        }

        public Criteria andCommentTypeGreaterThanOrEqualTo(String value) {
            addCriterion("comment_type >=", value, "commentType");
            return (Criteria) this;
        }

        public Criteria andCommentTypeLessThan(String value) {
            addCriterion("comment_type <", value, "commentType");
            return (Criteria) this;
        }

        public Criteria andCommentTypeLessThanOrEqualTo(String value) {
            addCriterion("comment_type <=", value, "commentType");
            return (Criteria) this;
        }

        public Criteria andCommentTypeLike(String value) {
            addCriterion("comment_type like", value, "commentType");
            return (Criteria) this;
        }

        public Criteria andCommentTypeNotLike(String value) {
            addCriterion("comment_type not like", value, "commentType");
            return (Criteria) this;
        }

        public Criteria andCommentTypeIn(List<String> values) {
            addCriterion("comment_type in", values, "commentType");
            return (Criteria) this;
        }

        public Criteria andCommentTypeNotIn(List<String> values) {
            addCriterion("comment_type not in", values, "commentType");
            return (Criteria) this;
        }

        public Criteria andCommentTypeBetween(String value1, String value2) {
            addCriterion("comment_type between", value1, value2, "commentType");
            return (Criteria) this;
        }

        public Criteria andCommentTypeNotBetween(String value1, String value2) {
            addCriterion("comment_type not between", value1, value2, "commentType");
            return (Criteria) this;
        }

        public Criteria andCommentContentIsNull() {
            addCriterion("comment_content is null");
            return (Criteria) this;
        }

        public Criteria andCommentContentIsNotNull() {
            addCriterion("comment_content is not null");
            return (Criteria) this;
        }

        public Criteria andCommentContentEqualTo(String value) {
            addCriterion("comment_content =", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentNotEqualTo(String value) {
            addCriterion("comment_content <>", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentGreaterThan(String value) {
            addCriterion("comment_content >", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentGreaterThanOrEqualTo(String value) {
            addCriterion("comment_content >=", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentLessThan(String value) {
            addCriterion("comment_content <", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentLessThanOrEqualTo(String value) {
            addCriterion("comment_content <=", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentLike(String value) {
            addCriterion("comment_content like", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentNotLike(String value) {
            addCriterion("comment_content not like", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentIn(List<String> values) {
            addCriterion("comment_content in", values, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentNotIn(List<String> values) {
            addCriterion("comment_content not in", values, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentBetween(String value1, String value2) {
            addCriterion("comment_content between", value1, value2, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentNotBetween(String value1, String value2) {
            addCriterion("comment_content not between", value1, value2, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentPhotoIsNull() {
            addCriterion("comment_photo is null");
            return (Criteria) this;
        }

        public Criteria andCommentPhotoIsNotNull() {
            addCriterion("comment_photo is not null");
            return (Criteria) this;
        }

        public Criteria andCommentPhotoEqualTo(String value) {
            addCriterion("comment_photo =", value, "commentPhoto");
            return (Criteria) this;
        }

        public Criteria andCommentPhotoNotEqualTo(String value) {
            addCriterion("comment_photo <>", value, "commentPhoto");
            return (Criteria) this;
        }

        public Criteria andCommentPhotoGreaterThan(String value) {
            addCriterion("comment_photo >", value, "commentPhoto");
            return (Criteria) this;
        }

        public Criteria andCommentPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("comment_photo >=", value, "commentPhoto");
            return (Criteria) this;
        }

        public Criteria andCommentPhotoLessThan(String value) {
            addCriterion("comment_photo <", value, "commentPhoto");
            return (Criteria) this;
        }

        public Criteria andCommentPhotoLessThanOrEqualTo(String value) {
            addCriterion("comment_photo <=", value, "commentPhoto");
            return (Criteria) this;
        }

        public Criteria andCommentPhotoLike(String value) {
            addCriterion("comment_photo like", value, "commentPhoto");
            return (Criteria) this;
        }

        public Criteria andCommentPhotoNotLike(String value) {
            addCriterion("comment_photo not like", value, "commentPhoto");
            return (Criteria) this;
        }

        public Criteria andCommentPhotoIn(List<String> values) {
            addCriterion("comment_photo in", values, "commentPhoto");
            return (Criteria) this;
        }

        public Criteria andCommentPhotoNotIn(List<String> values) {
            addCriterion("comment_photo not in", values, "commentPhoto");
            return (Criteria) this;
        }

        public Criteria andCommentPhotoBetween(String value1, String value2) {
            addCriterion("comment_photo between", value1, value2, "commentPhoto");
            return (Criteria) this;
        }

        public Criteria andCommentPhotoNotBetween(String value1, String value2) {
            addCriterion("comment_photo not between", value1, value2, "commentPhoto");
            return (Criteria) this;
        }

        public Criteria andCommentPowerIsNull() {
            addCriterion("comment_power is null");
            return (Criteria) this;
        }

        public Criteria andCommentPowerIsNotNull() {
            addCriterion("comment_power is not null");
            return (Criteria) this;
        }

        public Criteria andCommentPowerEqualTo(String value) {
            addCriterion("comment_power =", value, "commentPower");
            return (Criteria) this;
        }

        public Criteria andCommentPowerNotEqualTo(String value) {
            addCriterion("comment_power <>", value, "commentPower");
            return (Criteria) this;
        }

        public Criteria andCommentPowerGreaterThan(String value) {
            addCriterion("comment_power >", value, "commentPower");
            return (Criteria) this;
        }

        public Criteria andCommentPowerGreaterThanOrEqualTo(String value) {
            addCriterion("comment_power >=", value, "commentPower");
            return (Criteria) this;
        }

        public Criteria andCommentPowerLessThan(String value) {
            addCriterion("comment_power <", value, "commentPower");
            return (Criteria) this;
        }

        public Criteria andCommentPowerLessThanOrEqualTo(String value) {
            addCriterion("comment_power <=", value, "commentPower");
            return (Criteria) this;
        }

        public Criteria andCommentPowerLike(String value) {
            addCriterion("comment_power like", value, "commentPower");
            return (Criteria) this;
        }

        public Criteria andCommentPowerNotLike(String value) {
            addCriterion("comment_power not like", value, "commentPower");
            return (Criteria) this;
        }

        public Criteria andCommentPowerIn(List<String> values) {
            addCriterion("comment_power in", values, "commentPower");
            return (Criteria) this;
        }

        public Criteria andCommentPowerNotIn(List<String> values) {
            addCriterion("comment_power not in", values, "commentPower");
            return (Criteria) this;
        }

        public Criteria andCommentPowerBetween(String value1, String value2) {
            addCriterion("comment_power between", value1, value2, "commentPower");
            return (Criteria) this;
        }

        public Criteria andCommentPowerNotBetween(String value1, String value2) {
            addCriterion("comment_power not between", value1, value2, "commentPower");
            return (Criteria) this;
        }

        public Criteria andReplyIdIsNull() {
            addCriterion("reply_id is null");
            return (Criteria) this;
        }

        public Criteria andReplyIdIsNotNull() {
            addCriterion("reply_id is not null");
            return (Criteria) this;
        }

        public Criteria andReplyIdEqualTo(Integer value) {
            addCriterion("reply_id =", value, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdNotEqualTo(Integer value) {
            addCriterion("reply_id <>", value, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdGreaterThan(Integer value) {
            addCriterion("reply_id >", value, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("reply_id >=", value, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdLessThan(Integer value) {
            addCriterion("reply_id <", value, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdLessThanOrEqualTo(Integer value) {
            addCriterion("reply_id <=", value, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdIn(List<Integer> values) {
            addCriterion("reply_id in", values, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdNotIn(List<Integer> values) {
            addCriterion("reply_id not in", values, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdBetween(Integer value1, Integer value2) {
            addCriterion("reply_id between", value1, value2, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("reply_id not between", value1, value2, "replyId");
            return (Criteria) this;
        }

        public Criteria andCommentFalgsIsNull() {
            addCriterion("comment_falgs is null");
            return (Criteria) this;
        }

        public Criteria andCommentFalgsIsNotNull() {
            addCriterion("comment_falgs is not null");
            return (Criteria) this;
        }

        public Criteria andCommentFalgsEqualTo(String value) {
            addCriterion("comment_falgs =", value, "commentFalgs");
            return (Criteria) this;
        }

        public Criteria andCommentFalgsNotEqualTo(String value) {
            addCriterion("comment_falgs <>", value, "commentFalgs");
            return (Criteria) this;
        }

        public Criteria andCommentFalgsGreaterThan(String value) {
            addCriterion("comment_falgs >", value, "commentFalgs");
            return (Criteria) this;
        }

        public Criteria andCommentFalgsGreaterThanOrEqualTo(String value) {
            addCriterion("comment_falgs >=", value, "commentFalgs");
            return (Criteria) this;
        }

        public Criteria andCommentFalgsLessThan(String value) {
            addCriterion("comment_falgs <", value, "commentFalgs");
            return (Criteria) this;
        }

        public Criteria andCommentFalgsLessThanOrEqualTo(String value) {
            addCriterion("comment_falgs <=", value, "commentFalgs");
            return (Criteria) this;
        }

        public Criteria andCommentFalgsLike(String value) {
            addCriterion("comment_falgs like", value, "commentFalgs");
            return (Criteria) this;
        }

        public Criteria andCommentFalgsNotLike(String value) {
            addCriterion("comment_falgs not like", value, "commentFalgs");
            return (Criteria) this;
        }

        public Criteria andCommentFalgsIn(List<String> values) {
            addCriterion("comment_falgs in", values, "commentFalgs");
            return (Criteria) this;
        }

        public Criteria andCommentFalgsNotIn(List<String> values) {
            addCriterion("comment_falgs not in", values, "commentFalgs");
            return (Criteria) this;
        }

        public Criteria andCommentFalgsBetween(String value1, String value2) {
            addCriterion("comment_falgs between", value1, value2, "commentFalgs");
            return (Criteria) this;
        }

        public Criteria andCommentFalgsNotBetween(String value1, String value2) {
            addCriterion("comment_falgs not between", value1, value2, "commentFalgs");
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

        public Criteria andCommentBackupIsNull() {
            addCriterion("comment_backup is null");
            return (Criteria) this;
        }

        public Criteria andCommentBackupIsNotNull() {
            addCriterion("comment_backup is not null");
            return (Criteria) this;
        }

        public Criteria andCommentBackupEqualTo(String value) {
            addCriterion("comment_backup =", value, "commentBackup");
            return (Criteria) this;
        }

        public Criteria andCommentBackupNotEqualTo(String value) {
            addCriterion("comment_backup <>", value, "commentBackup");
            return (Criteria) this;
        }

        public Criteria andCommentBackupGreaterThan(String value) {
            addCriterion("comment_backup >", value, "commentBackup");
            return (Criteria) this;
        }

        public Criteria andCommentBackupGreaterThanOrEqualTo(String value) {
            addCriterion("comment_backup >=", value, "commentBackup");
            return (Criteria) this;
        }

        public Criteria andCommentBackupLessThan(String value) {
            addCriterion("comment_backup <", value, "commentBackup");
            return (Criteria) this;
        }

        public Criteria andCommentBackupLessThanOrEqualTo(String value) {
            addCriterion("comment_backup <=", value, "commentBackup");
            return (Criteria) this;
        }

        public Criteria andCommentBackupLike(String value) {
            addCriterion("comment_backup like", value, "commentBackup");
            return (Criteria) this;
        }

        public Criteria andCommentBackupNotLike(String value) {
            addCriterion("comment_backup not like", value, "commentBackup");
            return (Criteria) this;
        }

        public Criteria andCommentBackupIn(List<String> values) {
            addCriterion("comment_backup in", values, "commentBackup");
            return (Criteria) this;
        }

        public Criteria andCommentBackupNotIn(List<String> values) {
            addCriterion("comment_backup not in", values, "commentBackup");
            return (Criteria) this;
        }

        public Criteria andCommentBackupBetween(String value1, String value2) {
            addCriterion("comment_backup between", value1, value2, "commentBackup");
            return (Criteria) this;
        }

        public Criteria andCommentBackupNotBetween(String value1, String value2) {
            addCriterion("comment_backup not between", value1, value2, "commentBackup");
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