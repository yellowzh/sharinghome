package com.lnsf.schedule;

import com.lnsf.dto.CommentDTO;
import com.lnsf.entity.OrderListEntity;
import com.lnsf.service.CommentService;
import com.lnsf.service.OrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class Schedule {
    @Autowired
    private OrderListService orderListService;
    @Autowired
    private CommentService commentService;

//    @Scheduled(cron = "* 0/15 * * * ?")
    public void ScheduleJob() {
        long begin = System.currentTimeMillis();
        double n = 0;
        /*查找出未支付的订单*/
        List<OrderListEntity> orderListEntities = orderListService.scheduleGetNotPayList();
        for (OrderListEntity o:orderListEntities) {
            long t1 = o.getCreateTime().getTime();
            long t2=System.currentTimeMillis();
            /*计算天数*/
            n = (double)(t2 - t1)/(24 * 60 * 60 * 1000);
            if (n>=1){
                /*删除订单*/
                orderListService.deleteOrder(o.getOrderId());
            }
            System.out.println("下单时间："+o.getCreateTime()+"--转换后的："+o.getCreateTime().getTime()+"--相减后的："+n);
        }

        long end = System.currentTimeMillis();
        System.out.println("定时任务1执行！！！！本次任务执行了"+(end-begin)+"秒");
    }
    @Scheduled(cron = "* 30 9 * * ?")
    public void ScheduleJob2() {
        long begin = System.currentTimeMillis();
        double n = 0;
        /*查找出未支付的订单*/
        List<OrderListEntity> orderListEntities = orderListService.scheduleGetNotCommentList();
        for (OrderListEntity o:orderListEntities) {
            long t1 = o.getEndTime().getTime();
            long t2=System.currentTimeMillis();
            /*计算天数*/
            n = (double)(t2 - t1)/(24 * 60 * 60 * 1000);
            if (n>=7){
                /*评价表添加默认评价*/
                CommentDTO commentDTO = new CommentDTO();
                commentDTO.setUserId(o.getPassengerId());
                commentDTO.setCommentContent("该用户暂无评价");
                commentDTO.setHouseId(o.getHousesId());
                commentDTO.setOrderId(o.getOrderId());
                commentDTO.setCommentType("定时任务默认评价");
                commentDTO.setCommentPower(5);
                commentService.create(commentDTO);
            }
            System.out.println("结束时间："+o.getEndTime()+"--转换后的："+o.getEndTime().getTime()+"--相减后的："+n);
        }

        long end = System.currentTimeMillis();
        System.out.println("定时任务2执行！！！！本次任务执行了"+(end-begin)+"秒");
    }
}
