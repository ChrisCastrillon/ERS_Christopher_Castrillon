package com.revature.models;

import java.sql.Timestamp;
import java.util.Arrays;

public class Reimbursement {
    private int reimbId;
    private double reimbAmount;
    private Timestamp submitTimeStamp; //use the toString method
    private Timestamp resolveTimeStamp;
    private String description;
    private byte[] receipt;
    private int author;
    private int resolver;
    private int statusId;
    private int type;
    
    public Reimbursement() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Reimbursement(int reimbId, double reimbAmount, Timestamp submitTimeStamp,
            Timestamp resolveTimeStamp, String description, byte[] receipt, int author, int resolver, int statusId,
            int type) {
        super();
        this.reimbId = reimbId;
        this.reimbAmount = reimbAmount;
        this.submitTimeStamp = submitTimeStamp;
        this.resolveTimeStamp = resolveTimeStamp;
        this.description = description;
        this.receipt = receipt;
        this.author = author;
        this.resolver = resolver;
        this.statusId = statusId;
        this.type = type;
    }
    public int getReimbId() {
        return reimbId;
    }

    public void setReimbId(int reimbId) {
        this.reimbId = reimbId;
    }

    public double getReimbAmount() {
        return reimbAmount;
    }

    public void setReimbAmount(double reimbAmount) {
        this.reimbAmount = reimbAmount;
    }
    public Timestamp getSubmitTimeStamp() {
        return submitTimeStamp;
    }

    public void setSubmitTimeStamp(Timestamp submitTimeStamp) {
        this.submitTimeStamp = submitTimeStamp;
    }

    public Timestamp getResolveTimeStamp() {
        return resolveTimeStamp;
    }

    public void setResolveTimeStamp(Timestamp resolveTimeStamp) {
        this.resolveTimeStamp = resolveTimeStamp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getReceipt() {
        return receipt;
    }

    public void setReceipt(byte[] receipt) {
        this.receipt = receipt;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public int getResolver() {
        return resolver;
    }

    public void setResolver(int resolver) {
        this.resolver = resolver;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Reimbursement [reimbId=" + reimbId + ", reimbAmount=" + reimbAmount
                + ", submitTimeStamp=" + submitTimeStamp + ", resolveTimeStamp=" + resolveTimeStamp + ", description="
                + description + ", receipt=" + Arrays.toString(receipt) + ", author=" + author + ", resolver="
                + resolver + ", statusId=" + statusId + ", type=" + type + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + author;
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + Arrays.hashCode(receipt);
        long temp;
        temp = Double.doubleToLongBits(reimbAmount);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + reimbId;
        result = prime * result + ((resolveTimeStamp == null) ? 0 : resolveTimeStamp.hashCode());
        result = prime * result + resolver;
        result = prime * result + statusId;
        result = prime * result + ((submitTimeStamp == null) ? 0 : submitTimeStamp.hashCode());
        result = prime * result + type;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Reimbursement)) {
            return false;
        }
        Reimbursement other = (Reimbursement) obj;
        if (author != other.author) {
            return false;
        }
        if (description == null) {
            if (other.description != null) {
                return false;
            }
        } else if (!description.equals(other.description)) {
            return false;
        }
        if (!Arrays.equals(receipt, other.receipt)) {
            return false;
        }
        if (Double.doubleToLongBits(reimbAmount) != Double.doubleToLongBits(other.reimbAmount)) {
            return false;
        }
        if (reimbId != other.reimbId) {
            return false;
        }
        if (resolveTimeStamp == null) {
            if (other.resolveTimeStamp != null) {
                return false;
            }
        } else if (!resolveTimeStamp.equals(other.resolveTimeStamp)) {
            return false;
        }
        if (resolver != other.resolver) {
            return false;
        }
        if (statusId != other.statusId) {
            return false;
        }
        if (submitTimeStamp == null) {
            if (other.submitTimeStamp != null) {
                return false;
            }
        } else if (!submitTimeStamp.equals(other.submitTimeStamp)) {
            return false;
        }
        if (type != other.type) {
            return false;
        }
        return true;
    }
}
