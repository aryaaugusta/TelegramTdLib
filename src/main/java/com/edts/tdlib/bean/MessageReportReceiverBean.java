package com.edts.tdlib.bean;

import java.util.Comparator;
import java.util.Date;

public class MessageReportReceiverBean {

    private String name;
    private String status;
    private Date sendDate;

    public MessageReportReceiverBean(String name, String status, Date sendDate) {
        this.name = name;
        this.status = status;
        this.sendDate = sendDate;
    }


    public static Comparator<MessageReportReceiverBean> NameComparatorASC = new Comparator<MessageReportReceiverBean>() {

        public int compare(MessageReportReceiverBean s1, MessageReportReceiverBean s2) {
            String recipient1 = s1.getName().toUpperCase();
            String recipient2 = s2.getName().toUpperCase();

            //ascending order
            return recipient1.compareTo(recipient2);

            //descending order
            //return StudentName2.compareTo(StudentName1);
        }
    };

    public static Comparator<MessageReportReceiverBean> NameComparatorDESC = new Comparator<MessageReportReceiverBean>() {

        public int compare(MessageReportReceiverBean s1, MessageReportReceiverBean s2) {
            String recipient1 = s1.getName().toUpperCase();
            String recipient2 = s2.getName().toUpperCase();

            //ascending order
            //return recipient1.compareTo(recipient2);

            //descending order
            return recipient2.compareTo(recipient1);
        }
    };


    public static Comparator<MessageReportReceiverBean> StatusComparatorASC = new Comparator<MessageReportReceiverBean>() {

        public int compare(MessageReportReceiverBean s1, MessageReportReceiverBean s2) {
            String recipient1 = s1.getStatus().toUpperCase();
            String recipient2 = s2.getStatus().toUpperCase();

            //ascending order
            return recipient1.compareTo(recipient2);

            //descending order
            //return StudentName2.compareTo(StudentName1);
        }
    };

    public static Comparator<MessageReportReceiverBean> StatusComparatorDESC = new Comparator<MessageReportReceiverBean>() {

        public int compare(MessageReportReceiverBean s1, MessageReportReceiverBean s2) {
            String recipient1 = s1.getStatus().toUpperCase();
            String recipient2 = s2.getStatus().toUpperCase();

            //ascending order
            //return recipient1.compareTo(recipient2);

            //descending order
            return recipient2.compareTo(recipient1);
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }
}
