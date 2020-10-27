package com.revature.templates;

import java.util.Arrays;

public class ReimbursementTemplate {
    private String subType;
    private String firstName;
    private String lastName;
    private String eid;
    private String email;
    private String description;
    private String amount;
    private byte[] receipt;
    public ReimbursementTemplate() {
        super();
        // TODO Auto-generated constructor stub
    }
    public ReimbursementTemplate(String subType, String firstName, String lastName, String eid, String email,
            String description, String amount, byte[] receipt) {
        super();
        this.subType = subType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.eid = eid;
        this.email = email;
        this.description = description;
        this.amount = amount;
        this.receipt = receipt;
    }
    public String getSubType() {
        return subType;
    }
    public void setSubType(String subType) {
        this.subType = subType;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEid() {
        return eid;
    }
    public void setEid(String eid) {
        this.eid = eid;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getAmount() {
        return amount;
    }
    public void setAmount(String amount) {
        this.amount = amount;
    }
    public byte[] getReceipt() {
        return receipt;
    }
    public void setReceipt(byte[] receipt) {
        this.receipt = receipt;
    }
    @Override
    public String toString() {
        return "ReimbursementTemplate [subType=" + subType + ", firstName=" + firstName + ", lastName=" + lastName
                + ", eid=" + eid + ", email=" + email + ", description=" + description + ", amount=" + amount
                + ", receipt=" + Arrays.toString(receipt) + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((amount == null) ? 0 : amount.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((eid == null) ? 0 : eid.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + Arrays.hashCode(receipt);
        result = prime * result + ((subType == null) ? 0 : subType.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ReimbursementTemplate other = (ReimbursementTemplate) obj;
        if (amount == null) {
            if (other.amount != null)
                return false;
        } else if (!amount.equals(other.amount))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (eid == null) {
            if (other.eid != null)
                return false;
        } else if (!eid.equals(other.eid))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        if (!Arrays.equals(receipt, other.receipt))
            return false;
        if (subType == null) {
            if (other.subType != null)
                return false;
        } else if (!subType.equals(other.subType))
            return false;
        return true;
    }
}
